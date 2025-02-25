package com.jobportal.plateforme_recrutement.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Candidature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCandidature;
    private LocalDateTime dateSoumission;

    @Enumerated(EnumType.STRING)
    private StatutCandidature statut; // Enum: ACCEPTÉ, REFUSÉ, EN_COURS

    private String messageCandidature;

    @ManyToOne
    @JoinColumn(name = "candidat_id", nullable = false)
    private Candidat candidat;

    @ManyToOne
    @JoinColumn(name = "annonce_id", nullable = false)
    private Annonce annonce;

    public Candidature() {}

    public Candidature(LocalDateTime dateSoumission, StatutCandidature statut, String messageCandidature, Candidat candidat, Annonce annonce) {
        this.dateSoumission = dateSoumission;
        this.statut = statut;
        this.messageCandidature = messageCandidature;
        this.candidat = candidat;
        this.annonce = annonce;
    }

    public int getIdCandidature() {
        return idCandidature;
    }

    public void setIdCandidature(int idCandidature) {
        this.idCandidature = idCandidature;
    }

    public LocalDateTime getDateSoumission() {
        return dateSoumission;
    }

    public void setDateSoumission(LocalDateTime dateSoumission) {
        this.dateSoumission = dateSoumission;
    }

    public StatutCandidature getStatut() {
        return statut;
    }

    public void setStatut(StatutCandidature statut) {
        this.statut = statut;
    }

    public String getMessageCandidature() {
        return messageCandidature;
    }

    public void setMessageCandidature(String messageCandidature) {
        this.messageCandidature = messageCandidature;
    }

    public Candidat getCandidat() {
        return candidat;
    }

    public void setCandidat(Candidat candidat) {
        this.candidat = candidat;
    }

    public Annonce getAnnonce() {
        return annonce;
    }

    public void setAnnonce(Annonce annonce) {
        this.annonce = annonce;
    }
}

