package com.example.demo.controller;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UtilisateursDto;
import com.example.demo.service.UtilisateursService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UtilisateursController {

	private UtilisateursService utilisateursService;

	@Operation(summary = "Register a user")
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UtilisateursDto> createUtilisateur(@Valid @RequestBody UtilisateursDto utilisateursDto) {

		try {
			Period periode = Period.between(LocalDate.parse(utilisateursDto.getDateNaissance().toString()),
					LocalDate.now());

			if (utilisateursDto.getPaysResidence().equalsIgnoreCase("French") && periode.getYears() >= 18) {

				UtilisateursDto savedUtilisateur = utilisateursService.saveUtilisateur(utilisateursDto);
				return new ResponseEntity<>(savedUtilisateur, HttpStatus.CREATED);
			}
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Operation(summary = "Get a user by its id")
	@GetMapping(path = "{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UtilisateursDto> getUtilisateurById(@PathVariable("id") Long idUser) {
		UtilisateursDto utilisateursDto = utilisateursService.getUtilisateurById(idUser);
		return new ResponseEntity<>(utilisateursDto, HttpStatus.OK);
	}

	@Operation(summary = "Get all users")
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<UtilisateursDto>> getAllUtilisateurs() {
		List<UtilisateursDto> utilisateurs = utilisateursService.getAllUtilisateurs();
		return new ResponseEntity<>(utilisateurs, HttpStatus.OK);
	}

	@Operation(summary = "Update a user by its id")
	@PutMapping(path = "{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UtilisateursDto> updateUser(@PathVariable("id") Long idUser,
			@RequestBody UtilisateursDto utilisateursDto) {
		utilisateursDto.setId(idUser);
		UtilisateursDto updatedUtilisateur = utilisateursService.updateUtilisateur(utilisateursDto);
		return new ResponseEntity<>(updatedUtilisateur, HttpStatus.OK);
	}

	@Operation(summary = "Delete a user by its id")
	@DeleteMapping(path = "{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> deleteUtilisateur(@PathVariable("id") Long idUser) {
		utilisateursService.deleteUtilisateur(idUser);
		return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
	}
}
