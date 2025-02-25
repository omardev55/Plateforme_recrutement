package com.jobportal.plateforme_recrutement.service;

import com.jobportal.plateforme_recrutement.dto.DocumentDto;
import com.jobportal.plateforme_recrutement.exception.ResourceNotFoundException;
import com.jobportal.plateforme_recrutement.model.Document;
import com.jobportal.plateforme_recrutement.repository.DocumentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocumentService {
    private final DocumentRepository documentRepository;

    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    // ✅ Récupérer tous les documents
    public List<DocumentDto> getAllDocuments() {
        return documentRepository.findAll().stream().map(doc ->
                new DocumentDto(doc.getIdDocument(), doc.getType().name(), doc.getUrl(), doc.getCandidat().getIdUser())
        ).collect(Collectors.toList());
    }

    // ✅ Récupérer un document par ID
    public DocumentDto getDocumentById(int id) {
        Document doc = documentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Document non trouvé avec l'ID : " + id));
        return new DocumentDto(doc.getIdDocument(), doc.getType().name(), doc.getUrl(), doc.getCandidat().getIdUser());
    }

    // ✅ Ajouter un document
    public Document ajouterDocument(Document document) {
        return documentRepository.save(document);
    }

    // ✅ Mettre à jour un document
    public Document mettreAJourDocument(int id, Document updatedDocument) {
        Document docExistant = documentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Document non trouvé avec l'ID : " + id));

        docExistant.setType(updatedDocument.getType());
        docExistant.setUrl(updatedDocument.getUrl());

        return documentRepository.save(docExistant);
    }

    // ✅ Supprimer un document
    public void supprimerDocument(int id) {
        Document doc = documentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Document non trouvé avec l'ID : " + id));
        documentRepository.delete(doc);
    }
}
