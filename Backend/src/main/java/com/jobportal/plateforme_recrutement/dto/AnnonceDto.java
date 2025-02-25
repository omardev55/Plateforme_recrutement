package com.jobportal.plateforme_recrutement.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AnnonceDto {
    private int idAnnonce;
    private String titre;
    private String type;
    private String description;
    private LocalDateTime datePublication;
    private String recruteurUsername;

    public AnnonceDto(int idAnnonce, String titre, String type, String description, LocalDateTime datePublication, String recruteurUsername) {
        this.idAnnonce = idAnnonce;
        this.titre = titre;
        this.type = type;
        this.description = description;
        this.datePublication = datePublication;
        this.recruteurUsername = recruteurUsername;
    }
}
