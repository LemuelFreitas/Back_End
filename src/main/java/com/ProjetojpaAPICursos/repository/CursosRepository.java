package com.ProjetojpaAPICursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProjetojpaAPICursos.entities.Cursos;

public interface CursosRepository extends JpaRepository<Cursos, Long> {
	
	// Nenhuma implementação é necessária. Spring Data JPA cuidará disso.
}