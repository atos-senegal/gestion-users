package com.example.demo.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude
@JsonIgnoreProperties(ignoreUnknown = true)
public class UtilisateursDto {

	private Long id;
	private String nom;
	@JsonProperty(access = Access.AUTO)
	@JsonFormat(pattern = "MM/dd/yyyy")
	private LocalDate dateNaissance;
	private String paysResidence;
	private String telephone;
	private String genre;
	private String email;

}
