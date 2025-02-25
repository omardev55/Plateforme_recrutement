package com.jobportal.plateforme_recrutement.repository;

import com.jobportal.plateforme_recrutement.model.Candidature;
import org.springframework.data.jpa.repository.JpaRepository;
import com.jobportal.plateforme_recrutement.model.StatutCandidature;

import java.util.List;

public interface CandidatureRepository extends JpaRepository<Candidature, Integer> {
    List<Candidature> findByCandidatIdUser(int candidatId);
    List<Candidature> findByAnnonceIdAnnonce(int annonceId);
    List<Candidature> findByStatut(StatutCandidature statut);
}
