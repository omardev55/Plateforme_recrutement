import com.jobportal.plateforme_recrutement.model.User;
import com.jobportal.plateforme_recrutement.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional  // Pour éviter d'impacter la base de données réelle après le test
public class UserIntegrationTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSaveAndRetrieveUser() {
        // Arrange - Créer un nouvel utilisateur
        User user = new User();
        user.setUsername("integrationtestuser");
        user.setEmail("integrationtest@example.com");
        user.setMotDePasse("securepassword"); // ✅ Correction : utiliser setMotDePasse()

        // Act - Sauvegarde dans la base
        User savedUser = userRepository.save(user);

        // ✅ Correction : Vérifier avec getIdUser()
        assertNotNull(savedUser.getIdUser(), "L'ID de l'utilisateur sauvegardé ne doit pas être null");

        // ✅ Correction : findByUsername retourne Optional<User>, donc on le gère proprement
        Optional<User> foundUser = userRepository.findByUsername("integrationtestuser");

        // Vérifier que l'utilisateur existe et a les bonnes informations
        assertTrue(foundUser.isPresent(), "L'utilisateur doit être trouvé en base");
        assertEquals("integrationtestuser", foundUser.get().getUsername());
        assertEquals("integrationtest@example.com", foundUser.get().getEmail());
    }
}
