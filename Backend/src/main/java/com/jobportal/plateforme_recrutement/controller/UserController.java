package com.jobportal.plateforme_recrutement.controller;

import com.jobportal.plateforme_recrutement.dto.UserDto;
import com.jobportal.plateforme_recrutement.exception.ResourceNotFoundException;
import com.jobportal.plateforme_recrutement.model.User;
import com.jobportal.plateforme_recrutement.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("*")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // ✅ Récupérer tous les utilisateurs
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = userService.getAllUtilisateurs();
        return ResponseEntity.ok(users);
    }

    // ✅ Récupérer un utilisateur par ID
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUtilisateurParId(@PathVariable int id) {
        return ResponseEntity.ok(userService.getUtilisateurParId(id));
    }

    // ✅ Récupérer un utilisateur par username
    @GetMapping("/username/{username}")
    public ResponseEntity<UserDto> getUtilisateurParUsername(@PathVariable String username) {
        return ResponseEntity.ok(userService.getUtilisateurParUsername(username));
    }

    // ✅ Ajouter un utilisateur
    @PostMapping
    public ResponseEntity<UserDto> ajouterUtilisateur(@RequestBody User user) {
        UserDto savedUser = userService.ajouterUtilisateur(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    // ✅ Modifier un utilisateur
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> mettreAJourUtilisateur(@PathVariable int id, @RequestBody User user) {
        UserDto updatedUser = userService.mettreAJourUtilisateur(id, user);
        return ResponseEntity.ok(updatedUser);
    }

    // ✅ Supprimer un utilisateur
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerUtilisateur(@PathVariable int id) {
        userService.supprimerUtilisateur(id);
        return ResponseEntity.noContent().build();
    }

    // ✅ Gestion des erreurs
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
