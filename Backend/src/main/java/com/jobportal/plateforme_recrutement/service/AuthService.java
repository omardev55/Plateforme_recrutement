package com.jobportal.plateforme_recrutement.service;

import com.jobportal.plateforme_recrutement.dto.AuthRequest;
import com.jobportal.plateforme_recrutement.dto.AuthResponse;
import com.jobportal.plateforme_recrutement.dto.RegisterRequest;
import com.jobportal.plateforme_recrutement.model.*;
import com.jobportal.plateforme_recrutement.repository.RoleRepository;
import com.jobportal.plateforme_recrutement.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthService(UserRepository userRepository, RoleRepository roleRepository,
                       PasswordEncoder passwordEncoder, JwtService jwtService,
                       AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    // ✅ Inscription d'un utilisateur avec gestion des rôles (CANDIDAT ou RECRUTEUR)
    public AuthResponse register(RegisterRequest request) {
        System.out.println("📌 Tentative d'inscription avec les données : " + request);

        // 🔹 Vérification des champs obligatoires
        if (request.getEmail() == null || request.getEmail().isBlank()) {
            throw new RuntimeException("❌ L'email est obligatoire !");
        }
        if (request.getPassword() == null || request.getPassword().isBlank()) {
            throw new RuntimeException("❌ Le mot de passe est obligatoire !");
        }

        // 🔹 Vérifier si l'email est déjà utilisé
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("❌ Cet email est déjà utilisé !");
        }

        // 🔹 Vérifier et attribuer le rôle (par défaut : CANDIDAT)
        RoleName roleName = "RECRUTEUR".equalsIgnoreCase(request.getRole()) ? RoleName.ROLE_RECRUTEUR : RoleName.ROLE_CANDIDAT;

        Role userRole = roleRepository.findByName(roleName)
                .orElseThrow(() -> new RuntimeException("❌ Le rôle spécifié n'existe pas !"));

        Set<Role> roles = new HashSet<>(Collections.singleton(userRole));

        // 🔹 Création de l'utilisateur en fonction du rôle
        User user;
        if (roleName == RoleName.ROLE_CANDIDAT) {
            user = new Candidat(
                    request.getUsername(),
                    request.getEmail(),
                    passwordEncoder.encode(request.getPassword()),
                    request.getNom(),
                    request.getPrenom(),
                    roles,
                    request.getAge() != null ? request.getAge() : 18 // Valeur par défaut
            );
        } else {
            user = new Recruteur(
                    request.getUsername(),
                    request.getEmail(),
                    passwordEncoder.encode(request.getPassword()),
                    request.getNom(),
                    request.getPrenom(),
                    roles,
                    request.getEntreprise() != null ? request.getEntreprise() : "Non spécifiée" // Valeur par défaut
            );
        }

        // 🔹 Sauvegarde en base de données
        userRepository.save(user);
        System.out.println("✅ Utilisateur enregistré avec succès : " + user.getEmail());

        // 🔹 Génération du token JWT et retour du `userType`
        String token = jwtService.generateToken(user);
        return new AuthResponse(token, roleName.name()); // 🔹 Ajout du `userType`
    }

    // ✅ Authentification (Login)
    public AuthResponse authenticate(AuthRequest request) {
        System.out.println("🔑 Tentative de connexion pour : " + request.getUsername());

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("❌ Utilisateur non trouvé"));

        System.out.println("✅ Connexion réussie pour : " + user.getUsername());

        // 🔹 Génération du token JWT et ajout du `userType`
        String token = jwtService.generateToken(user);
        return new AuthResponse(token, user instanceof Candidat ? "CANDIDAT" : "RECRUTEUR"); // 🔹 Retourne le type d'utilisateur
    }
}
