package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.example.demo.dto.UtilisateursDto;
import com.example.demo.entity.Utilisateurs;
import com.example.demo.repository.UtilisateursRepository;
import com.example.demo.service.impl.UtilisateursServiceImpl;

public class UtilisateurServiceTest {

	@InjectMocks
	UtilisateursServiceImpl utilisateurService;

	@Mock
	UtilisateursRepository utilisateursRepository;

	@SuppressWarnings("deprecation")
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testGetUsers() {

		Utilisateurs utilisateur = Utilisateurs.builder().nom("Khalifa").dateNaissance(LocalDate.of(1993, 9, 18))
				.paysResidence("French").genre("Male").telephone("775431329").email("khalifa@gmail.com").build();

		Utilisateurs utilisateur1 = Utilisateurs.builder().nom("Awa").dateNaissance(LocalDate.of(1993, 9, 18))
				.paysResidence("French").genre("Female").telephone("775431329").email("awa@gmail.com").build();

		Mockito.when(utilisateursRepository.findAll()).thenReturn(Arrays.asList(utilisateur, utilisateur1));

		List<UtilisateursDto> users = utilisateurService.getAllUtilisateurs();
		assertEquals(2, users.size());
		verify(utilisateursRepository, times(1)).findAll();
	}

	@Test
	void testGetUserById() {
		Utilisateurs utilisateur = Utilisateurs.builder().id(200L).nom("Khalifa")
				.dateNaissance(LocalDate.of(1993, 9, 18)).paysResidence("French").genre("Male").telephone("775431329")
				.email("khalifa@gmail.com").build();
		utilisateursRepository = mock(UtilisateursRepository.class);
		utilisateurService = new UtilisateursServiceImpl(utilisateursRepository);
		Mockito.when(utilisateursRepository.findById(200L)).thenReturn(java.util.Optional.ofNullable(utilisateur));

		UtilisateursDto utilisateur1 = utilisateurService.getUtilisateurById(200L);

		assertEquals("Khalifa", utilisateur1.getNom());
		assertEquals("French", utilisateur1.getPaysResidence());
		assertEquals("Male", utilisateur1.getGenre());
	}

	/*
	 * @Test void testRegisterUser() { Utilisateurs utilisateur =
	 * Utilisateurs.builder().nom("Khalifa").dateNaissance(LocalDate.of(1993, 9,
	 * 18)) .paysResidence("French").genre("Male").telephone("775431329").email(
	 * "khalifa1@gmail.com").build();
	 * 
	 * utilisateursRepository = mock(UtilisateursRepository.class);
	 * utilisateurService = new UtilisateursServiceImpl(utilisateursRepository);
	 * 
	 * UtilisateursDto utilisateur1 = new UtilisateursDto();
	 * utilisateur1.setNom(utilisateur.getNom());
	 * utilisateur1.setDateNaissance(utilisateur.getDateNaissance());
	 * utilisateur1.setPaysResidence(utilisateur.getPaysResidence());
	 * utilisateur1.setGenre(utilisateur.getGenre());
	 * utilisateur1.setTelephone(utilisateur.getTelephone());
	 * utilisateur1.setEmail(utilisateur.getEmail());
	 * 
	 * utilisateurService.saveUtilisateur(utilisateur1);
	 * verify(utilisateursRepository, times(1)).save(utilisateur); }
	 */
}
