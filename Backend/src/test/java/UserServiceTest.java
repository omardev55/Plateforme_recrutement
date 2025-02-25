import com.jobportal.plateforme_recrutement.model.User;
import com.jobportal.plateforme_recrutement.repository.UserRepository;
import com.jobportal.plateforme_recrutement.service.UserService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    private final UserRepository userRepository = mock(UserRepository.class);
    private final UserService userService = new UserService(userRepository);

    @Test
    public void testAjouterUtilisateur() {
        // Arrange : Préparer les données de test
        User user = new User();
        user.setUsername("testuser");
        user.setEmail("test@example.com");

        when(userRepository.save(user)).thenReturn(user);

        // Act : Appeler la méthode à tester
        User savedUser = userService.ajouterUtilisateur(user);

        // Assert : Vérifier les résultats attendus
        assertNotNull(savedUser);
        assertEquals("testuser", savedUser.getUsername());
        assertEquals("test@example.com", savedUser.getEmail());
    }

    @Test
    public void testGetUtilisateurParId_UserExists() {
        // Arrange
        User user = new User();
        user.setIdUser(1);
        user.setUsername("existinguser");

        when(userRepository.findById(1)).thenReturn(java.util.Optional.of(user));

        // Act
        User foundUser = userService.getUtilisateurParId(1);

        // Assert
        assertNotNull(foundUser);
        assertEquals(1, foundUser.getIdUser());
        assertEquals("existinguser", foundUser.getUsername());
    }

    @Test
    public void testGetUtilisateurParId_UserNotFound() {
        // Arrange
        when(userRepository.findById(1)).thenReturn(java.util.Optional.empty());

        // Act & Assert
        Exception exception = assertThrows(RuntimeException.class, () -> userService.getUtilisateurParId(1));
        assertEquals("Utilisateur non trouvé avec l'ID : 1", exception.getMessage());
    }
}
