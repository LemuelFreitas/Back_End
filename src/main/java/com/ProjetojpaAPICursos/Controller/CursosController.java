package com.ProjetojpaAPICursos.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProjetojpaAPICursos.Service.CursosServices;
import com.ProjetojpaAPICursos.entities.Cursos;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Cursos", description = "API REST DE GERENCIAMENTO DE Cursos")
@RestController
@RequestMapping("/cursos")
@CrossOrigin(origins = "*")
public class CursosController {

	private final CursosServices cursosService;

	@Autowired
	public CursosController(CursosServices cursosservice) {
		this.cursosService = cursosservice;
	}

	@GetMapping("/{id}")
	@Operation(summary = "Localiza Cursos por ID")
	public ResponseEntity<Cursos> buscaCursosControlId(@PathVariable Long id) {
		Cursos cursos = cursosService.buscaCursosId(id);
		if (cursos != null) {
			return ResponseEntity.ok(cursos);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping
	@Operation(summary = "Apresenta todos os Cursos")
	public ResponseEntity<List<Cursos>> buscaTodosCursosControl() {
		List<Cursos> Cursos = cursosService.buscaTodosCursos();
		return ResponseEntity.ok(Cursos);
	}

	@PostMapping
	@Operation(summary = "Cadastra um Curso")
	public ResponseEntity<Cursos> salvaCursosControl(@RequestBody Cursos cursos) {
		Cursos salvaCursos = cursosService.salvaCursos(cursos);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaCursos);
	}

	@PutMapping("/{id}")
	@Operation(summary = "Altera um Curso")
	public ResponseEntity<Cursos> alteraCursosControl(@PathVariable Long id, @RequestBody @Valid Cursos cursos) {
		Cursos alteraCursos = cursosService.alterarCursos(id, cursos);
		if (alteraCursos != null) {
			return ResponseEntity.ok(cursos);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Exclui um Curso")
	public ResponseEntity<Cursos> apagaCursosControl(@PathVariable Long id) {
		boolean apagar = cursosService.apagarCursos(id);
		if (apagar) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}