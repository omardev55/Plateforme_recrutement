package com.jobportal.plateforme_recrutement.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("ADMIN")
public class Admin extends User {
    public void consulterUser() {
        System.out.println("Admin consulte les utilisateurs.");
    }

    public void consulterAnnonce() {
        System.out.println("Admin consulte les annonces.");
    }

    public void consulterCandidature() {
        System.out.println("Admin consulte les candidatures.");
    }
}
