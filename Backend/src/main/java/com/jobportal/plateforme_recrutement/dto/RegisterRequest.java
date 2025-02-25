package com.jobportal.plateforme_recrutement.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import lombok.Getter;
import lombok.Setter;

@Data // Garde Lombok, mais ajoute manuellement les getters si nécessaire
public class RegisterRequest {
    private String username;

    @NotBlank(message = "L'email est obligatoire")
    @Email(message = "Format email invalide")
    private String email;

    private String password;
    private String nom;
    private String prenom;
    private Integer age;
    private String entreprise;
    private String role;

    // 🔹 Ajoute des Getters au cas où Lombok ne génère pas bien
    public String getEmail() { return email; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public Integer getAge() { return age; }
    public String getEntreprise() { return entreprise; }
    public String getRole() { return role; }
}

