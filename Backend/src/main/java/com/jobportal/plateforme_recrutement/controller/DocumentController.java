package com.jobportal.plateforme_recrutement.controller;

import com.jobportal.plateforme_recrutement.dto.DocumentDto;
import com.jobportal.plateforme_recrutement.exception.ResourceNotFoundException;
import com.jobportal.plateforme_recrutement.model.Document;
import com.jobportal.plateforme_recrutement.service.DocumentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/documents")
@CrossOrigin("*")
public class DocumentController {
    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    // ✅ Récupérer tous les documents
    @GetMapping
    public ResponseEntity<List<DocumentDto>> getAllDocuments() {
        List<DocumentDto> documents = documentService.getAllDocuments();
        return ResponseEntity.ok(documents);
    }

    // ✅ Récupérer un document par ID
    @GetMapping("/{id}")
    public ResponseEntity<DocumentDto> getDocumentById(@PathVariable int id) {
        DocumentDto document = documentService.getDocumentById(id);
        return ResponseEntity.ok(document);
    }

    // ✅ Ajouter un document
    @PostMapping
    public ResponseEntity<Document> ajouterDocument(@RequestBody Document document) {
        Document savedDocument = documentService.ajouterDocument(document);
        return new ResponseEntity<>(savedDocument, HttpStatus.CREATED);
    }

    // ✅ Modifier un document
    @PutMapping("/{id}")
    public ResponseEntity<Document> mettreAJourDocument(@PathVariable int id, @RequestBody Document document) {
        Document updatedDocument = documentService.mettreAJourDocument(id, document);
        return ResponseEntity.ok(updatedDocument);
    }

    // ✅ Supprimer un document
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerDocument(@PathVariable int id) {
        documentService.supprimerDocument(id);
        return ResponseEntity.noContent().build();
    }

    // ✅ Gestion des erreurs pour les documents non trouvés
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
