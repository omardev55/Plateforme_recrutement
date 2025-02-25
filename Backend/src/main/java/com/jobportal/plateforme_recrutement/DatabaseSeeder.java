package com.jobportal.plateforme_recrutement;

import com.jobportal.plateforme_recrutement.model.*;
import com.jobportal.plateforme_recrutement.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final AnnonceRepository annonceRepository;

    public DatabaseSeeder(UserRepository userRepository, RoleRepository roleRepository, AnnonceRepository annonceRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.annonceRepository = annonceRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // 📌 Vérifier si les données existent déjà
        if (userRepository.count() > 50 || annonceRepository.count() > 50) {
            System.out.println("✅ Les données existent déjà. Pas de nouvel enregistrement.");
            return;
        }

        // 🔹 Insérer les rôles s'ils n'existent pas
        if (roleRepository.count() == 0) {
            System.out.println("ℹ️ Aucun rôle trouvé en base. Insertion des rôles...");
            roleRepository.save(new Role(null, RoleName.ROLE_ADMIN));
            roleRepository.save(new Role(null, RoleName.ROLE_RECRUTEUR));
            roleRepository.save(new Role(null, RoleName.ROLE_CANDIDAT));
            System.out.println("✅ Rôles insérés en base de données !");
        } else {
            System.out.println("ℹ️ Les rôles existent déjà en base.");
        }

        // 🔹 Récupération des rôles
        Role roleRecruteur = roleRepository.findByName(RoleName.ROLE_RECRUTEUR)
                .orElseThrow(() -> new RuntimeException("❌ Le rôle RECRUTEUR n'existe pas en base !"));
        Role roleCandidat = roleRepository.findByName(RoleName.ROLE_CANDIDAT)
                .orElseThrow(() -> new RuntimeException("❌ Le rôle CANDIDAT n'existe pas en base !"));

        System.out.println("✅ Rôle RECRUTEUR récupéré : " + roleRecruteur.getName());
        System.out.println("✅ Rôle CANDIDAT récupéré : " + roleCandidat.getName());

        // 🔹 Création d'un recruteur avec son rôle
        Set<Role> rolesRecruteur = new HashSet<>();
        rolesRecruteur.add(roleRecruteur);
        Recruteur recruteur = new Recruteur(
                "recruteu8",
                "recruteur8_demo@entreprise.com",
                "password123",
                "Mohamed",
                "Benali",
                rolesRecruteur,
                "Entreprise ABC"
        );
        userRepository.save(recruteur);
        System.out.println("✅ Recruteur inséré avec succès : " + recruteur.getEmail());

        // 🔹 Création d'une annonce associée au recruteur
        Annonce annonce = new Annonce();
        annonce.setTitre("Offre de stage en Data Science");
        annonce.setType(TypeAnnonce.STAGE);
        annonce.setDescription("Nous recherchons un stagiaire en Data Science motivé.");
        annonce.setDatePublication(LocalDateTime.now());
        annonce.setRecruteur(recruteur);
        annonceRepository.save(annonce);
        System.out.println("✅ Annonce créée avec succès pour le recruteur : " + recruteur.getEmail());

        // 🔹 Création d'un candidat avec son rôle
        Set<Role> rolesCandidat = new HashSet<>();
        rolesCandidat.add(roleCandidat);
        Candidat candidat = new Candidat(
                "candidat8_demo",
                "candidat8_demo@jobseekers.com",
                "password123",
                "Sarah",
                "El Mehdi",
                rolesCandidat,
                23
        );
        userRepository.save(candidat);
        System.out.println("✅ Candidat inséré avec succès : " + candidat.getEmail());

        // ✅ Affichage dans la console pour vérification
        System.out.println("🎉 Données de test insérées avec succès !");
    }
}
