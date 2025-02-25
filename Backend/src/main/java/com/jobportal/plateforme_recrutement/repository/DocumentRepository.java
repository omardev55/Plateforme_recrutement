package com.jobportal.plateforme_recrutement.repository;

import com.jobportal.plateforme_recrutement.model.Document;
import com.jobportal.plateforme_recrutement.model.TypeDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DocumentRepository extends JpaRepository<Document, Integer> {
    List<Document> findByCandidatIdUser(int candidatId);
    List<Document> findByType(TypeDocument type);
}
