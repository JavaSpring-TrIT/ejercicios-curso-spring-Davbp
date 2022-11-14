package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Curso;
import com.curso.model.Formacion;
import com.curso.service.FormacionesService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
public class FormacionesController {

	@Autowired
	FormacionesService service;
	
	//lista formaciones
	@ApiOperation(value="Devuelve una lista de formaciones")
	@GetMapping(value="formaciones", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> formaciones() {
		return service.formaciones();
	}
	
	//alta formacion
	@ApiOperation(value="Añade una formación nueva recibida en el cuerpo de la petición")
	@PostMapping(value="formacion", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> agregar(@ApiParam(value="JSON con los datos de la formación a añadir")@RequestBody Formacion formacion) {
		return service.altaFormacion(formacion);
	}

}
