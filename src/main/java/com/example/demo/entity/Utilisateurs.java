package com.example.demo.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

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
@Entity
@Table(name = "utilisateurs")
public class Utilisateurs {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, insertable = true, updatable = false)
	private Long id;

	@Column(name = "NAME", nullable = false)
	@NotBlank(message = "Name is mandatory")
	private String nom;

	@Column(name = "BIRTHDAY", nullable = false)
	@DateTimeFormat(iso = ISO.DATE)
	@JsonFormat(pattern = "MM/dd/yyyy")
	@NotNull(message = "Birthday is mandatory")
	private LocalDate dateNaissance;

	@Column(name = "RESIDENCE", nullable = false)
	@NotBlank(message = "Country of residence is mandatory")
	private String paysResidence;

	@Column(name = "CALL", nullable = true)
	private String telephone;

	@Column(name = "GENDER", nullable = true)
	private String genre;

	@Column(nullable = false, unique = true)
	@Email(message = "Email should be valid")
	private String email;
}
