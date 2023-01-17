package com.example.demo;

import java.time.LocalDate;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.demo.controller.UtilisateursController;
import com.example.demo.entity.Utilisateurs;
import com.example.demo.service.impl.UtilisateursServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

@WebMvcTest(controllers = UtilisateursController.class)
public class UtilisateurControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UtilisateursServiceImpl utilisateurService;

	@Test
	public void testRegisterUser() throws Exception {
		Utilisateurs utilisateur = Utilisateurs.builder().nom("Khalifa").dateNaissance(LocalDate.of(1993, 9, 18))
				.paysResidence("French").genre("Male").telephone("775431329").email("khalifa@gmail.com").build();

		ObjectMapper mapper = new ObjectMapper();
		mapper.findAndRegisterModules();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJson = ow.writeValueAsString(utilisateur);

		mockMvc.perform(MockMvcRequestBuilders.post("/api/users", utilisateur).content(requestJson))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
