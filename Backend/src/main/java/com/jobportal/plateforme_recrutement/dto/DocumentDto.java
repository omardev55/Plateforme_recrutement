package com.jobportal.plateforme_recrutement.dto;

import lombok.Data;

@Data
public class DocumentDto {
    private int idDocument;
    private String type;
    private String url;
    private int candidatId;

    public DocumentDto(int idDocument, String type, String url, int candidatId) {
        this.idDocument = idDocument;
        this.type = type;
        this.url = url;
        this.candidatId = candidatId;
    }
}
