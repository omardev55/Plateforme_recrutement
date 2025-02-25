package com.jobportal.plateforme_recrutement.controller;

import com.jobportal.plateforme_recrutement.dto.CandidatureDto;
import com.jobportal.plateforme_recrutement.exception.ResourceNotFoundException;
import com.jobportal.plateforme_recrutement.model.Candidature;
import com.jobportal.plateforme_recrutement.service.CandidatureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidatures")
@CrossOrigin("*")
public class CandidatureController {
    private final CandidatureService candidatureService;

    public CandidatureController(CandidatureService candidatureService) {
        this.candidatureService = candidatureService;
    }

    // ✅ Récupérer toutes les candidatures (DTO)
    @GetMapping
    public ResponseEntity<List<CandidatureDto>> getAllCandidatures() {
        List<CandidatureDto> candidatures = candidatureService.getAllCandidatures();
        return ResponseEntity.ok(candidatures);
    }

    // ✅ Récupérer une candidature par ID (DTO)
    @GetMapping("/{id}")
    public ResponseEntity<CandidatureDto> getCandidatureById(@PathVariable int id) {
        CandidatureDto candidature = candidatureService.getCandidatureById(id);
        return ResponseEntity.ok(candidature);
    }

    // ✅ Ajouter une candidature (Utiliser DTO en entrée et en sortie)
    @PostMapping
    public ResponseEntity<CandidatureDto> ajouterCandidature(@RequestBody CandidatureDto candidatureDto) {
        CandidatureDto savedCandidature = candidatureService.ajouterCandidature(candidatureDto);
        return new ResponseEntity<>(savedCandidature, HttpStatus.CREATED);
    }

    // ✅ Modifier une candidature (Utiliser DTO)
    @PutMapping("/{id}")
    public ResponseEntity<CandidatureDto> mettreAJourCandidature(@PathVariable int id, @RequestBody CandidatureDto candidatureDto) {
        CandidatureDto updatedCandidature = candidatureService.mettreAJourCandidature(id, candidatureDto);
        return ResponseEntity.ok(updatedCandidature);
    }

    // ✅ Supprimer une candidature avec vérification
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerCandidature(@PathVariable int id) {
        candidatureService.supprimerCandidature(id);
        return ResponseEntity.noContent().build();
    }

    // ✅ Gestion des erreurs pour les candidatures non trouvées
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    // ✅ Gestion des erreurs générales (ex: email déjà utilisé, statut invalide, etc.)
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
