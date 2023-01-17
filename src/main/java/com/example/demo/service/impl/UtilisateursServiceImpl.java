package com.example.demo.service.impl;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.aop.LogEntryExit;
import com.example.demo.dto.UtilisateursDto;
import com.example.demo.entity.Utilisateurs;
import com.example.demo.exception.EmailAlreadyExistsException;
import com.example.demo.exception.IllegalArgumentException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.UtilisateursMapper;
import com.example.demo.repository.UtilisateursRepository;
import com.example.demo.service.UtilisateursService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UtilisateursServiceImpl implements UtilisateursService {

	private UtilisateursRepository repository;

	@LogEntryExit(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
	@Override
	public UtilisateursDto saveUtilisateur(UtilisateursDto utilisateursDto) {

		Period periode = Period.between(LocalDate.parse(utilisateursDto.getDateNaissance().toString()),
				LocalDate.now());

		if (periode.getYears() < 18) {
			throw new IllegalArgumentException("Only adults are allowed to register.");
		}

		if (!utilisateursDto.getPaysResidence().equalsIgnoreCase("French")) {
			throw new IllegalArgumentException("Only French residents are allowed to register.");
		}

		Optional<Utilisateurs> optionalUser = repository.findByEmail(utilisateursDto.getEmail());

		if (optionalUser.isPresent()) {
			throw new EmailAlreadyExistsException("Email Already Exists for User");
		}

		Utilisateurs utilisateur = UtilisateursMapper.MAPPER.mapToUtilisateursEntity(utilisateursDto);

		return UtilisateursMapper.MAPPER.mapToUtilisateursDto(repository.save(utilisateur));
	}

	@LogEntryExit(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
	@Override
	public UtilisateursDto getUtilisateurById(Long idUser) {

		Utilisateurs utilisateur = repository.findById(idUser)
				.orElseThrow(() -> new ResourceNotFoundException("Utilisateur", "id", idUser));

		return UtilisateursMapper.MAPPER.mapToUtilisateursDto(utilisateur);
	}

	@LogEntryExit(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
	@Override
	public List<UtilisateursDto> getAllUtilisateurs() {

		List<Utilisateurs> utilisateurs = repository.findAll();

		return utilisateurs.stream().map(UtilisateursMapper.MAPPER::mapToUtilisateursDto).collect(Collectors.toList());
	}

	@LogEntryExit(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
	@Override
	public UtilisateursDto updateUtilisateur(UtilisateursDto utilisateursDto) {

		Utilisateurs existUtilisateur = repository.findById(utilisateursDto.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Utilisateur", "id", utilisateursDto.getId()));

		existUtilisateur.setNom(utilisateursDto.getNom());
		existUtilisateur.setDateNaissance(utilisateursDto.getDateNaissance());
		existUtilisateur.setPaysResidence(utilisateursDto.getPaysResidence());
		existUtilisateur.setTelephone(utilisateursDto.getTelephone());
		existUtilisateur.setGenre(utilisateursDto.getGenre());
		existUtilisateur.setEmail(utilisateursDto.getEmail());

		Utilisateurs updateUtilisateur = repository.save(existUtilisateur);

		return UtilisateursMapper.MAPPER.mapToUtilisateursDto(updateUtilisateur);
	}

	@LogEntryExit(showArgs = true, showResult = true, unit = ChronoUnit.MILLIS)
	@Override
	public void deleteUtilisateur(Long idUser) {

		Utilisateurs existUtilisateur = repository.findById(idUser)
				.orElseThrow(() -> new ResourceNotFoundException("Utilisateur", "id", idUser));

		repository.delete(existUtilisateur);

	}

}
