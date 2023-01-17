package com.example.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.demo.dto.UtilisateursDto;
import com.example.demo.entity.Utilisateurs;

@Mapper
public interface UtilisateursMapper {

	UtilisateursMapper MAPPER = Mappers.getMapper(UtilisateursMapper.class);

	Utilisateurs mapToUtilisateursEntity(UtilisateursDto utilisateursDto);

	UtilisateursDto mapToUtilisateursDto(Utilisateurs utilisateurs);
}
