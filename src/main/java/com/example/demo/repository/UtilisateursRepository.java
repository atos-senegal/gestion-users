package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Utilisateurs;

public interface UtilisateursRepository extends JpaRepository<Utilisateurs, Long> {

	Optional<Utilisateurs> findByEmail(String email);

}
