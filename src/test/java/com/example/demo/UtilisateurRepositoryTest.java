/*
 * package com.example.demo;
 * 
 * import static org.assertj.core.api.Assertions.assertThat;
 * 
 * import java.time.LocalDate; import java.util.Optional;
 * 
 * import org.assertj.core.api.Assertions; import
 * org.junit.jupiter.api.BeforeEach; import org.junit.jupiter.api.MethodOrderer;
 * import org.junit.jupiter.api.Test; import
 * org.junit.jupiter.api.TestMethodOrder; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest; import
 * org.springframework.core.annotation.Order; import
 * org.springframework.transaction.annotation.Transactional;
 * 
 * import com.example.demo.entity.Utilisateurs; import
 * com.example.demo.repository.UtilisateursRepository;
 * 
 * @DataJpaTest
 * 
 * @TestMethodOrder(MethodOrderer.OrderAnnotation.class) public class
 * UtilisateurRepositoryTest {
 * 
 * @Autowired private UtilisateursRepository utilisateursRepository;
 * 
 * @BeforeEach void setUp() { Utilisateurs utilisateur1 =
 * Utilisateurs.builder().nom("Khalifa").dateNaissance(LocalDate.of(1993, 9,
 * 18)) .paysResidence("French").genre("Male").telephone("775431329").email(
 * "khalifa1@gmail.com").build(); Utilisateurs utilisateur2 =
 * Utilisateurs.builder().nom("Awa").dateNaissance(LocalDate.of(1993, 9, 18))
 * .paysResidence("French").genre("Female").telephone("775431329").email(
 * "awa@gmail.com").build();
 * 
 * utilisateursRepository.save(utilisateur1);
 * 
 * utilisateursRepository.save(utilisateur2);
 * 
 * }
 * 
 * @Test
 * 
 * @Order(1)
 * 
 * @Transactional void saveUtilisateurTest() { Utilisateurs utilisateur =
 * Utilisateurs.builder().nom("Khalifa").dateNaissance(LocalDate.of(1993, 9,
 * 18)) .paysResidence("French").genre("Male").telephone("775431329").email(
 * "khalifa@gmail.com").build();
 * 
 * Utilisateurs registeredUser = utilisateursRepository.save(utilisateur);
 * assertThat(registeredUser.getId()).isPositive(); }
 * 
 * @Test
 * 
 * @Order(2)
 * 
 * @Transactional void getUtilisateurByIdTest() { Utilisateurs utilisateur =
 * utilisateursRepository.findById(1L).get();
 * assertThat(utilisateur.getId()).isEqualTo(1L); }
 * 
 * @Test
 * 
 * @Order(3)
 * 
 * @Transactional void getUtilisateurByEmailTest() { Utilisateurs utilisateur =
 * utilisateursRepository.findByEmail("awa@gmail.com").get();
 * assertThat(utilisateur.getEmail()).isEqualTo("awa@gmail.com"); }
 * 
 * @Test
 * 
 * @Order(4)
 * 
 * @Transactional void updateUtilisateurByIdTest() { Utilisateurs utilisateur1 =
 * Utilisateurs.builder().nom("Khalifa").dateNaissance(LocalDate.of(1993, 9,
 * 18)) .paysResidence("French").genre("Male").telephone("775431329").email(
 * "khalif@gmail.com").build(); utilisateursRepository.save(utilisateur1);
 * Utilisateurs utilisateur = utilisateursRepository.findById(1L).get();
 * utilisateur.setNom("Mamadou"); Utilisateurs utilisateurUpdate =
 * utilisateursRepository.save(utilisateur);
 * Assertions.assertThat(utilisateurUpdate.getNom()).isEqualTo("Mamadou");
 * 
 * }
 * 
 * @Test
 * 
 * @Order(5)
 * 
 * @Transactional void deleteUtilisateurByIdTest() { Utilisateurs utilisateur =
 * utilisateursRepository.findById(1L).get();
 * utilisateursRepository.delete(utilisateur); Optional<Utilisateurs>
 * optionalUser = utilisateursRepository.findById(1L); if
 * (optionalUser.isPresent()) { utilisateur = optionalUser.get(); }
 * Assertions.assertThat(utilisateur).isNull(); }
 * 
 * }
 */