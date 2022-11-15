package com.curso.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.curso.model.Curso;
import com.curso.model.Formacion;


@Service
public class FormacionesServiceImpl implements FormacionesService {
	@Autowired
	RestTemplate template;

	private String url = "http://localhost:9000/scursos/";
	
	@Override
	public List<Curso> formaciones() {
		return Arrays.asList(template.getForObject(url+"cursos", Curso[].class));
	}
	
	@Override
	public List<Curso> altaFormacion(Formacion formacion) {
		List<Curso> cursos = this.formaciones();
		boolean cursoExistente = false;
		if(cursos!=null && !cursos.isEmpty()) {
			for(Curso c : cursos) {
				if(c.getNombre().equalsIgnoreCase(formacion.getCurso())) {
					cursoExistente = true;
					break;
				}
			}//for
		}//if
		
		if(!cursoExistente) {
			Curso c = new Curso();
			int horas = 25;
			if(formacion.getAsignaturas()>=10) {
				horas = 50;
			}
			StringBuilder sb = new StringBuilder();			
			sb.append(formacion.getCurso().substring(0, 3)).append(horas*10);
			c.setCodCurso(sb.toString());
			c.setDuracion(horas);
			c.setPrecio(formacion.getPrecio());
			c.setNombre(formacion.getCurso());
			template.postForLocation(url+"curso", c);
		}//if
		return this.formaciones();
	}//altaFormacion
	


}
