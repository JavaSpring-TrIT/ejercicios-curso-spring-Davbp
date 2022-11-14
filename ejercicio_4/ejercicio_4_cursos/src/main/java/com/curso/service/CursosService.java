package com.curso.service;

import java.util.List;

import com.curso.model.Curso;

public interface CursosService {
	List<Curso> cursos();	
	List<Curso> altaCurso(Curso libro);
	Curso buscarCurso(String curso);	
	void actualizarCurso(Curso libro);
	List<Curso> eliminarCurso(String curso);
	void actualizarDuracionCurso(String codigo, int duracion);
	List<Curso> cursos(float precioMin, float precioMax);
}
