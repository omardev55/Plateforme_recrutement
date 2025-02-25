package com.jobportal.plateforme_recrutement.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@DiscriminatorValue("RECRUTEUR")
public class Recruteur extends User {
    private String entreprise;

    @OneToMany(mappedBy = "recruteur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Annonce> annonces = new ArrayList<>();

    // ✅ Constructeur avec tous les paramètres
    public Recruteur(String username, String email, String motDePasse, String nom, String prenom, Set<Role> roles, String entreprise) {
        super(username, email, motDePasse, nom, prenom, roles); // 🔹 Appel du constructeur de `User`
        this.entreprise = entreprise;
    }

    // ✅ Constructeur par défaut requis par JPA
    public Recruteur() {
        super();
    }

    // ✅ Getters et Setters
    public String getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }

    public List<Annonce> getAnnonces() {
        return annonces;
    }

    public void setAnnonces(List<Annonce> annonces) {
        this.annonces = annonces;
    }
}
