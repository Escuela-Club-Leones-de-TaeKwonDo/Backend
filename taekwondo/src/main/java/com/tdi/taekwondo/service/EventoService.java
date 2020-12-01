package com.tdi.taekwondo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.tdi.taekwondo.model.Alumno;
import com.tdi.taekwondo.model.Evento;

public interface EventoService {
	
	public abstract List<Evento> getEventos();
	public abstract ResponseEntity<Object> getEvento(int id);
	public abstract ResponseEntity<Object> createEvento(Evento evento);
	public abstract void updateEvento(int id, Evento evento);
	public abstract void deleteEvento(int id);
	public abstract List<Alumno> getAlumnos(int id);
}
