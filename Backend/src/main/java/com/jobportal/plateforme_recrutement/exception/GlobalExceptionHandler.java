package com.jobportal.plateforme_recrutement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Gestion des exceptions générales
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseImpl> handleGeneralException(Exception e) {
        ErrorResponseImpl error = new ErrorResponseImpl("Erreur interne", e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Gestion des erreurs spécifiques pour les ressources non trouvées
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseImpl> handleResourceNotFound(ResourceNotFoundException e) {
        ErrorResponseImpl error = new ErrorResponseImpl("Ressource non trouvée", e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // Gestion des erreurs d'argument invalide (par exemple, type d'annonce incorrect)
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponseImpl> handleIllegalArgumentException(IllegalArgumentException e) {
        ErrorResponseImpl error = new ErrorResponseImpl("Argument invalide", e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    // Gestion des erreurs de données nulles
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorResponseImpl> handleNullPointerException(NullPointerException e) {
        ErrorResponseImpl error = new ErrorResponseImpl("Erreur de données", "Une valeur nécessaire est nulle");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
