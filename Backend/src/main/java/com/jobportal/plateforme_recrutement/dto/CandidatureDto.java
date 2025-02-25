package com.jobportal.plateforme_recrutement.dto;

import com.jobportal.plateforme_recrutement.model.StatutCandidature;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CandidatureDto {
    private int idCandidature;
    private StatutCandidature statut;
    private LocalDateTime dateSoumission;

    public CandidatureDto(int idCandidature, StatutCandidature statut, LocalDateTime dateSoumission) {
        this.idCandidature = idCandidature;
        this.statut = statut;
        this.dateSoumission = dateSoumission;
    }
}
