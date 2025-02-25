package com.jobportal.plateforme_recrutement.service;

import com.jobportal.plateforme_recrutement.dto.UserDto;
import com.jobportal.plateforme_recrutement.exception.ResourceNotFoundException;
import com.jobportal.plateforme_recrutement.model.User;
import com.jobportal.plateforme_recrutement.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // ✅ Ajouter un utilisateur
    public UserDto ajouterUtilisateur(User user) {
        Optional<User> existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser.isPresent()) {
            throw new IllegalArgumentException("Un utilisateur avec ce username existe déjà !");
        }
        return UserDto.fromEntity(userRepository.save(user)); // Convertir en DTO avant de renvoyer
    }

    // ✅ Récupérer tous les utilisateurs
    public List<UserDto> getAllUtilisateurs() {
        return userRepository.findAll().stream()
                .map(UserDto::fromEntity)
                .collect(Collectors.toList());
    }

    // ✅ Récupérer un utilisateur par ID
    public UserDto getUtilisateurParId(int id) {
        return userRepository.findById(id)
                .map(UserDto::fromEntity)
                .orElseThrow(() -> new ResourceNotFoundException("Utilisateur non trouvé avec l'ID : " + id));
    }

    // ✅ Récupérer un utilisateur par username
    public UserDto getUtilisateurParUsername(String username) {
        return userRepository.findByUsername(username)
                .map(UserDto::fromEntity)
                .orElseThrow(() -> new ResourceNotFoundException("Utilisateur non trouvé avec le username : " + username));
    }

    // ✅ Mettre à jour un utilisateur
    @Transactional
    public UserDto mettreAJourUtilisateur(int id, User updatedUser) {
        User utilisateurExistant = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Utilisateur non trouvé avec l'ID : " + id));

        // Mise à jour des champs
        utilisateurExistant.setNom(updatedUser.getNom());
        utilisateurExistant.setPrenom(updatedUser.getPrenom());
        utilisateurExistant.setEmail(updatedUser.getEmail());
        utilisateurExistant.setMotDePasse(updatedUser.getMotDePasse());
        utilisateurExistant.setUsername(updatedUser.getUsername());
        utilisateurExistant.setRoles(updatedUser.getRoles());

        return UserDto.fromEntity(userRepository.save(utilisateurExistant));
    }

    // ✅ Supprimer un utilisateur
    public void supprimerUtilisateur(int id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Utilisateur non trouvé avec l'ID : " + id));
        userRepository.delete(user);
    }
}
