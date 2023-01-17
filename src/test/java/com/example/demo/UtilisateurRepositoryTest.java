package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.annotation.Rollback;

import com.example.demo.entity.Utilisateurs;
import com.example.demo.repository.UtilisateursRepository;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UtilisateurRepositoryTest {

	@Autowired
	private UtilisateursRepository utilisateursRepository;

	@BeforeEach
	void setUp() {
		Utilisateurs utilisateur1 = Utilisateurs.builder().nom("Khalifa").dateNaissance(LocalDate.of(1993, 9, 18))
				.paysResidence("French").genre("Male").telephone("775431329").email("khalifa1@gmail.com").build();
		/*
		 * Utilisateurs utilisateur2 =
		 * Utilisateurs.builder().nom("Khalifa").dateNaissance(LocalDate.of(1993, 9,
		 * 18)) .paysResidence("French").genre("Male").telephone("775431329").email(
		 * "khalifa2@gmail.com").build(); Utilisateurs utilisateur3 =
		 * Utilisateurs.builder().nom("Khalifa").dateNaissance(LocalDate.of(1993, 9,
		 * 18)) .paysResidence("French").genre("Male").telephone("775431329").email(
		 * "khalifa3@gmail.com").build(); Utilisateurs utilisateur4 =
		 * Utilisateurs.builder().nom("Khalifa").dateNaissance(LocalDate.of(1993, 9,
		 * 18)) .paysResidence("French").genre("Male").telephone("775431329").email(
		 * "khalifa4@gmail.com").build();
		 */
		
		utilisateursRepository.save(utilisateur1);
		/*
		 * utilisateursRepository.save(utilisateur2);
		 * utilisateursRepository.save(utilisateur3);
		 * utilisateursRepository.save(utilisateur4);
		 */
	}
	
	@Test
	@Order(1)
	@Rollback(value = false)
	void saveUtilisateurTest() {
		Utilisateurs utilisateur = Utilisateurs.builder().nom("Khalifa").dateNaissance(LocalDate.of(1993, 9, 18))
				.paysResidence("French").genre("Male").telephone("775431329").email("khalifa@gmail.com").build();

		Utilisateurs registeredUser = utilisateursRepository.save(utilisateur);
		assertThat(registeredUser.getId()).isGreaterThan(0);
	}
	
	@Test
    @Order(2)
    @Rollback(value = false)
    void getUtilisateurByIdTest(){
		Utilisateurs utilisateur = utilisateursRepository.findById(1L).get();
        assertThat(utilisateur.getId()).isEqualTo(1L);
    }
	
	@Test
    @Order(3)
    @Rollback(value = false)
    void getUtilisateurByEmailTest(){
		Utilisateurs utilisateur = utilisateursRepository.findByEmail("khalifa@gmail.com").get();
        assertThat(utilisateur.getEmail()).isEqualTo("khalifa@gmail.com");
    }
}
