package com.jobportal.plateforme_recrutement.controller;

import com.jobportal.plateforme_recrutement.config.UserDetailsImpl;
import com.jobportal.plateforme_recrutement.dto.AnnonceDto;
import com.jobportal.plateforme_recrutement.exception.ErrorResponseImpl;
import com.jobportal.plateforme_recrutement.model.Annonce;
import com.jobportal.plateforme_recrutement.model.Recruteur;
import com.jobportal.plateforme_recrutement.service.AnnonceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/annonces")
@CrossOrigin("*")
public class AnnonceController {
    private final AnnonceService annonceService;

    public AnnonceController(AnnonceService annonceService) {
        this.annonceService = annonceService;
    }

    @PostMapping
    public ResponseEntity<?> ajouterAnnonce(@RequestBody Annonce annonce, Authentication authentication) {
        try {
            Object principal = authentication.getPrincipal();
            if (!(principal instanceof UserDetailsImpl)) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("L'utilisateur connecté n'est pas reconnu.");
            }

            UserDetailsImpl userDetails = (UserDetailsImpl) principal;
            if (!(userDetails.getUser() instanceof Recruteur)) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Seuls les recruteurs peuvent publier des annonces.");
            }

            Recruteur recruteur = (Recruteur) userDetails.getUser();
            AnnonceDto savedAnnonce = annonceService.ajouterAnnonce(annonce, recruteur);
            return new ResponseEntity<>(savedAnnonce, HttpStatus.CREATED);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorResponseImpl error = new ErrorResponseImpl("Erreur lors de la création de l'annonce", ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }
    @GetMapping
    public ResponseEntity<?> getAllAnnonces() {
        try {
            List<AnnonceDto> annonces = annonceService.getAllAnnonces();
            return ResponseEntity.ok(annonces);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorResponseImpl error = new ErrorResponseImpl("Erreur lors de la récupération des annonces", ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }


}