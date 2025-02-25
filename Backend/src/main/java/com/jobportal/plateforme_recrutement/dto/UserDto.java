package com.jobportal.plateforme_recrutement.dto;

import lombok.Data;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class UserDto {
    private int idUser;
    private String username;
    private String email;
    private String nom;
    private String prenom;
    private Set<String> roles; // On renvoie seulement les noms des rôles, pas les entités

    public UserDto(int idUser, String username, String email, String nom, String prenom, Set<String> roles) {
        this.idUser = idUser;
        this.username = username;
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.roles = roles;
    }

    // ✅ Méthode statique pour convertir un User en UserDto
    public static UserDto fromEntity(com.jobportal.plateforme_recrutement.model.User user) {
        return new UserDto(
                user.getIdUser(),
                user.getUsername(),
                user.getEmail(),
                user.getNom(),
                user.getPrenom(),
                user.getRoles().stream().map(role -> role.getName().name()).collect(Collectors.toSet()) // Convertit les rôles en String
        );
    }
}
