package com.ProjetojpaAPICursos.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjetojpaAPICursos.entities.Cursos;
import com.ProjetojpaAPICursos.repository.CursosRepository;
@Service
public class CursosServices {

	private final CursosRepository cursosRepository;

	@Autowired
	public CursosServices(CursosRepository cursosRepository) {
		this.cursosRepository = cursosRepository;
	}
	public List<Cursos> buscaTodosCursos(){
		return cursosRepository.findAll();
	}
	public Cursos buscaCursosId(Long id) {
		Optional <Cursos> Cursos = cursosRepository.findById(id);
		return Cursos.orElse(null);
	}
	public Cursos salvaCursos(Cursos Cursos) {
		return cursosRepository.save(Cursos);
	}
	public Cursos alterarCursos(Long id, Cursos alterarC) {
		Optional <Cursos> existeCursos = cursosRepository.findById(id);
		if(existeCursos.isPresent()) {
			alterarC.setId(id);
			return cursosRepository.save(alterarC);
		}
		return null;
	}
	public boolean apagarCursos(Long id) {
		Optional <Cursos> existeCursos = cursosRepository.findById(id);
		if (existeCursos.isPresent()) {
			cursosRepository.deleteById(id);
			return true;
		}
		return false;
		}
}
