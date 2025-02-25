package com.jobportal.plateforme_recrutement.service;

import com.jobportal.plateforme_recrutement.dto.CandidatureDto;
import com.jobportal.plateforme_recrutement.exception.ResourceNotFoundException;
import com.jobportal.plateforme_recrutement.model.Candidature;
import com.jobportal.plateforme_recrutement.repository.CandidatureRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CandidatureService {
    private final CandidatureRepository candidatureRepository;

    public CandidatureService(CandidatureRepository candidatureRepository) {
        this.candidatureRepository = candidatureRepository;
    }

    // ✅ Récupérer toutes les candidatures et convertir en DTO
    public List<CandidatureDto> getAllCandidatures() {
        return candidatureRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    // ✅ Récupérer une candidature par ID et convertir en DTO
    public CandidatureDto getCandidatureById(int id) {
        Candidature candidature = candidatureRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Candidature non trouvée avec l'ID : " + id));
        return convertToDto(candidature);
    }

    // ✅ Ajouter une nouvelle candidature (convertir DTO → Entity)
    public CandidatureDto ajouterCandidature(CandidatureDto candidatureDto) {
        Candidature candidature = convertToEntity(candidatureDto);
        Candidature savedCandidature = candidatureRepository.save(candidature);
        return convertToDto(savedCandidature);
    }

    // ✅ Modifier une candidature (convertir DTO → Entity)
    public CandidatureDto mettreAJourCandidature(int id, CandidatureDto candidatureDto) {
        Candidature existingCandidature = candidatureRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Candidature non trouvée avec l'ID : " + id));

        existingCandidature.setStatut(candidatureDto.getStatut()); // Mettre à jour les champs
        existingCandidature.setDateSoumission(candidatureDto.getDateSoumission());

        Candidature updatedCandidature = candidatureRepository.save(existingCandidature);
        return convertToDto(updatedCandidature);
    }

    // ✅ Supprimer une candidature avec gestion d'erreur
    public void supprimerCandidature(int id) {
        if (!candidatureRepository.existsById(id)) {
            throw new ResourceNotFoundException("Impossible de supprimer : Candidature non trouvée avec l'ID " + id);
        }
        candidatureRepository.deleteById(id);
    }

    // ✅ Convertir une entité `Candidature` en DTO `CandidatureDto`
    private CandidatureDto convertToDto(Candidature candidature) {
        return new CandidatureDto(
                candidature.getIdCandidature(),
                candidature.getStatut(),
                candidature.getDateSoumission()
        );
    }

    // ✅ Convertir un DTO `CandidatureDto` en entité `Candidature`
    private Candidature convertToEntity(CandidatureDto dto) {
        Candidature candidature = new Candidature();
        candidature.setStatut(dto.getStatut());
        candidature.setDateSoumission(dto.getDateSoumission());
        return candidature;
    }
}
