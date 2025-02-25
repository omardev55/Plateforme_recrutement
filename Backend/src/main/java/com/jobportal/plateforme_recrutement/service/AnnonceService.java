package com.jobportal.plateforme_recrutement.service;

import com.jobportal.plateforme_recrutement.dto.AnnonceDto;
import com.jobportal.plateforme_recrutement.exception.ResourceNotFoundException;
import com.jobportal.plateforme_recrutement.model.Annonce;
import com.jobportal.plateforme_recrutement.model.Recruteur;
import com.jobportal.plateforme_recrutement.model.TypeAnnonce;
import com.jobportal.plateforme_recrutement.repository.AnnonceRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnnonceService {
    private final AnnonceRepository annonceRepository;

    public AnnonceService(AnnonceRepository annonceRepository) {
        this.annonceRepository = annonceRepository;
    }

    // Récupérer toutes les annonces (converties en DTO)
    public List<AnnonceDto> getAllAnnonces() {
        return annonceRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    // Récupérer une annonce par ID (convertie en DTO)
    public AnnonceDto getAnnonceById(int idAnnonce) {
        Annonce annonce = annonceRepository.findById(idAnnonce)
                .orElseThrow(() -> new ResourceNotFoundException("Annonce non trouvée avec l'ID : " + idAnnonce));
        return convertToDto(annonce);
    }

    // Ajouter une nouvelle annonce
    public AnnonceDto ajouterAnnonce(Annonce annonce, Recruteur recruteur) {
        System.out.println("Données reçues : " + annonce); // Log pour déboguer
        annonce.setRecruteur(recruteur);
        annonce.setDatePublication(LocalDateTime.now());
        annonce.setType(TypeAnnonce.valueOf(annonce.getType().name()));
        Annonce savedAnnonce = annonceRepository.save(annonce);
        return convertToDto(savedAnnonce);
    }
    // Mettre à jour une annonce
    @Transactional
    public AnnonceDto mettreAJourAnnonce(int idAnnonce, Annonce updatedAnnonce) {
        Annonce annonceExistante = annonceRepository.findById(idAnnonce)
                .orElseThrow(() -> new ResourceNotFoundException("Annonce non trouvée avec l'ID : " + idAnnonce));
        annonceExistante.setTitre(updatedAnnonce.getTitre());
        annonceExistante.setDescription(updatedAnnonce.getDescription());
        annonceExistante.setType(updatedAnnonce.getType());
        annonceExistante.setDatePublication(updatedAnnonce.getDatePublication());
        return convertToDto(annonceRepository.save(annonceExistante));
    }

    // Supprimer une annonce après vérification
    public void supprimerAnnonce(int idAnnonce) {
        if (!annonceRepository.existsById(idAnnonce)) {
            throw new ResourceNotFoundException("Impossible de supprimer : annonce non trouvée avec l'ID " + idAnnonce);
        }
        annonceRepository.deleteById(idAnnonce);
    }

    // Convertir une entité en DTO
    private AnnonceDto convertToDto(Annonce annonce) {
        return new AnnonceDto(
                annonce.getIdAnnonce(),
                annonce.getTitre(),
                annonce.getType().name(),  // Utiliser le nom de l'enum pour la conversion
                annonce.getDescription(),
                annonce.getDatePublication(),
                annonce.getRecruteur().getUsername()
        );
    }
}