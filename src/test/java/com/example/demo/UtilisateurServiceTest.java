package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.example.demo.dto.UtilisateursDto;
import com.example.demo.entity.Utilisateurs;
import com.example.demo.repository.UtilisateursRepository;
import com.example.demo.service.UtilisateursService;
import com.example.demo.service.impl.UtilisateursServiceImpl;

public class UtilisateurServiceTest {

	@InjectMocks
	UtilisateursService utilisateurService;

	@Mock
	UtilisateursRepository utilisateursRepository;

	@Test
	void testGetUsers() {

		Utilisateurs utilisateur = Utilisateurs.builder().nom("Khalifa").dateNaissance(LocalDate.of(1993, 9, 18))
				.paysResidence("French").genre("Male").telephone("775431329").email("khalifa@gmail.com").build();

		Utilisateurs utilisateur1 = Utilisateurs.builder().nom("Awa").dateNaissance(LocalDate.of(1993, 9, 18))
				.paysResidence("French").genre("Female").telephone("775431329").email("awa@gmail.com").build();

		utilisateursRepository = mock(UtilisateursRepository.class);
		utilisateurService = new UtilisateursServiceImpl(utilisateursRepository);

		Mockito.when(utilisateursRepository.findAll()).thenReturn(Arrays.asList(utilisateur, utilisateur1));

		List<UtilisateursDto> users = utilisateurService.getAllUtilisateurs();
		assertEquals(2, users.size());
		verify(utilisateursRepository, times(1)).findAll();
	}
}
