package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.dao.CursosDao;
import com.curso.model.Curso;

@Service
public class CursosServiceImpl implements CursosService {
	@Autowired
	CursosDao dao;
	
	@Override
	public List<Curso> cursos() {
		return dao.findAll();
	}
	
	@Override
	public List<Curso> altaCurso(Curso curso) {
		dao.save(curso);
		return dao.findAll();
	}

	@Override
	public Curso buscarCurso(String codigo) {
		return dao.findById(codigo).orElse(null);
	}

	@Override
	public void actualizarCurso(Curso curso) {
		dao.save(curso);
	}

	@Override
	public List<Curso> eliminarCurso(String curso) {
		dao.deleteById(curso);
		return dao.findAll();
	}
	
	@Override
	public void actualizarDuracionCurso(String codigo, int duracion) {
		Curso c = dao.findById(codigo).orElse(null);
		if(c!=null) {
			c.setDuracion(duracion);			
		}
		dao.save(c);
	}
	
	@Override
	public List<Curso> cursos(float precioMin, float precioMax) {
		return dao.findAll().stream().filter(c->c.getPrecio()>precioMin&&c.getPrecio()<precioMax).toList();
	}

}
