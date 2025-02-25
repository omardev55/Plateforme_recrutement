package com.jobportal.plateforme_recrutement.controller;

import com.jobportal.plateforme_recrutement.dto.AuthRequest;
import com.jobportal.plateforme_recrutement.dto.AuthResponse;
import com.jobportal.plateforme_recrutement.dto.RegisterRequest;
import com.jobportal.plateforme_recrutement.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // ✅ Endpoint pour l'inscription
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody @Valid RegisterRequest request) {
        System.out.println("📩 Données reçues: " + request);
        return ResponseEntity.ok(authService.register(request));
    }


    // ✅ Endpoint pour la connexion
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(authService.authenticate(request));
    }
}
