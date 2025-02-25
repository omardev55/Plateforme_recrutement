package com.jobportal.plateforme_recrutement.model;

import jakarta.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@DiscriminatorValue("CANDIDAT")
public class Candidat extends User {
    private Integer age;

    @OneToMany(mappedBy = "candidat", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Candidature> candidatures;

    @OneToMany(mappedBy = "candidat", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Document> documents;

    // ✅ Constructeur avec tous les paramètres
    public Candidat(String username, String email, String motDePasse, String nom, String prenom, Set<Role> roles, Integer age) {
        super(username, email, motDePasse, nom, prenom, roles);
        this.age = age;
    }

    // ✅ Constructeur par défaut requis par JPA
    public Candidat() {
        super();
    }

    // ✅ Getters et Setters
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Candidature> getCandidatures() {
        return candidatures;
    }

    public void setCandidatures(List<Candidature> candidatures) {
        this.candidatures = candidatures;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }
}
