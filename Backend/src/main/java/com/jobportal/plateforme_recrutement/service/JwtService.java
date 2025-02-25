package com.jobportal.plateforme_recrutement.service;

import com.jobportal.plateforme_recrutement.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class JwtService {

    private static final String SECRET_KEY = "hG7Jd9kLpN2vY5rXzW1tA3sM8qP4fV2cK6jR3lU0bN8pQ2eF1uW7tG5mX9nV3yZ6";
    private static final long EXPIRATION_TIME = 86400000; // 1 jour

    private final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

    // ✅ Générer un JWT en incluant le rôle de l'utilisateur
    public String generateToken(User user) {
        return Jwts.builder()
                .setSubject(user.getUsername()) // Username dans le token
                .claim("roles", user.getRoles().stream().map(role -> role.getName().name()).collect(Collectors.toList()))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // ✅ Extraire le username à partir du token
    public String extractUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // ✅ Vérifier si le token est valide pour un utilisateur donné
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    // ✅ Vérifier si le token a expiré
    private boolean isTokenExpired(String token) {
        return extractClaim(token, claims -> claims.getExpiration()).before(new Date());
    }

    // ✅ Extraire un claim spécifique du token
    private <T> T extractClaim(String token, Function<io.jsonwebtoken.Claims, T> claimsResolver) {
        return claimsResolver.apply(
                Jwts.parserBuilder()
                        .setSigningKey(key)
                        .build()
                        .parseClaimsJws(token)
                        .getBody()
        );
    }
}
