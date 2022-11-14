package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Curso;
import com.curso.service.CursosService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
public class CursosController {

	@Autowired
	CursosService service;
	
	//lista cursos
	@ApiOperation(value="Devuelve una lista de cursos")
	@GetMapping(value="cursos", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> cursos() {
		return service.cursos();
	}
	
	//alta curso
	@ApiOperation(value="Añade un nuevo curso recibido en el cuerpo de la petición")
	@PostMapping(value="curso", consumes=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> agregar(@ApiParam(value="JSON con los datos del curso") @RequestBody Curso curso) {
		return service.altaCurso(curso);
	}
	
	//eliminación curso
	@ApiOperation(value="Elimina un curso por el código")
	@DeleteMapping(value="curso/{codCurso}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> eliminar(@ApiParam(value="Código del curso a eliminar")@PathVariable("codCurso") String codCurso) {
		return service.eliminarCurso(codCurso);		
	}
	
	//actualizacion duracion
	@ApiOperation(value="Actualiza la duración de un curso del cual se proporciona el código")
	@PutMapping(value="curso/{codCurso}/{duracion}")
	public void actualizarDuracion(
			@ApiParam(value="Código del curso a actualizar") @PathVariable("codCurso") String codCurso, 
			@ApiParam(value="Nueva duración del curso") @PathVariable("duracion") int duracion) {
		service.actualizarDuracionCurso(codCurso, duracion);
	}
	
	//buscar curso
	@ApiOperation(value="Busca un curso por su código")
	@GetMapping(value="curso/{codCurso}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Curso buscarCurso(@ApiParam(value="Código del curso a buscar") @PathVariable("codCurso") String codCurso) {
		return service.buscarCurso(codCurso);
	}
	
	//por precio
	@ApiOperation(value="Busca los cursos dentro de un rango de precios")
	@GetMapping(value="cursos/{precioMin}/{precioMax}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> cursos(
			@ApiParam(value="Precio mínimo de la búsqueda") @PathVariable("precioMin") float precioMin, 
			@ApiParam(value="Precio máximo de la búsqueda") @PathVariable("precioMax") float precioMax) {
		return service.cursos(precioMin, precioMax);
	}
	
}
