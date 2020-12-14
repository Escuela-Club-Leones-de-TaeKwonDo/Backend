package com.tdi.taekwondo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import javax.persistence.Id;

import com.tdi.taekwondo.model.Evento_alumno;


public interface Evento_alumnoService {
	
	public abstract List<Evento_alumno> getAlumnosE();
	public abstract ResponseEntity<Object> createEvento_alumno(Evento_alumno registro);
}