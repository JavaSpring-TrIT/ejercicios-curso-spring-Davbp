package com.curso.service;

import java.util.List;

import com.curso.model.Curso;
import com.curso.model.Formacion;

public interface FormacionesService {
	List<Curso> formaciones();	
	List<Curso> altaFormacion(Formacion formacion);
}
