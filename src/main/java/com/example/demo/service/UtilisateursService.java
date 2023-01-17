package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.UtilisateursDto;

public interface UtilisateursService {

	UtilisateursDto saveUtilisateur(UtilisateursDto user);

	UtilisateursDto getUtilisateurById(Long idUser);

	List<UtilisateursDto> getAllUtilisateurs();

	UtilisateursDto updateUtilisateur(UtilisateursDto user);

	void deleteUtilisateur(Long idUser);
}