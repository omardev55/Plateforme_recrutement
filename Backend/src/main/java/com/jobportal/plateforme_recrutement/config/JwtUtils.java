package com.jobportal.plateforme_recrutement.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtUtils {
    private final String jwtSecret = "hG7Jd9kLpN2vY5rXzW1tA3sM8qP4fV2cK6jR3lU0bN8pQ2eF1uW7tG5mX9nV3yZ6"; // Remplace par une clé secrète sécurisée
    private final int jwtExpirationMs = 86400000; // Durée de validité du token (24 heures)

    // Générer un token JWT pour un utilisateur
    public String generateJwtToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret.getBytes(StandardCharsets.UTF_8)) // Convertir en bytes
                .compact();
    }

    // Valider un token JWT
    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(jwtSecret.getBytes(StandardCharsets.UTF_8)) // Convertir en bytes
                    .build()
                    .parseClaimsJws(authToken);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Extraire le nom d'utilisateur du token JWT
    public String getUserNameFromJwtToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(jwtSecret.getBytes(StandardCharsets.UTF_8)) // Convertir en bytes
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}