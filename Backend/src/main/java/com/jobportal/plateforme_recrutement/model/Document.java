package com.jobportal.plateforme_recrutement.model;

import jakarta.persistence.*;

@Entity
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDocument;

    @Enumerated(EnumType.STRING)
    private TypeDocument type; // Enum: CV, LETTRE_MOTIVATION, AUTRE

    private String url;

    @ManyToOne
    @JoinColumn(name = "candidat_id", nullable = false)
    private Candidat candidat;

    public Document() {}

    public Document(TypeDocument type, String url, Candidat candidat) {
        this.type = type;
        this.url = url;
        this.candidat = candidat;
    }

    public int getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(int idDocument) {
        this.idDocument = idDocument;
    }

    public TypeDocument getType() {
        return type;
    }

    public void setType(TypeDocument type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Candidat getCandidat() {
        return candidat;
    }

    public void setCandidat(Candidat candidat) {
        this.candidat = candidat;
    }
}

