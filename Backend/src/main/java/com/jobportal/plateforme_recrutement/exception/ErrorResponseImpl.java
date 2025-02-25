package com.jobportal.plateforme_recrutement.exception;

public class ErrorResponseImpl {
    private String message;
    private String description;

    // Constructeur avec deux paramètres
    public ErrorResponseImpl(String message, String description) {
        this.message = message;
        this.description = description;
    }

    // Getters et Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
