package com.tdi.taekwondo.service;

import java.util.List;


import com.tdi.taekwondo.model.EventoAlumno;

public interface EventoAlumnoService {
	
	public abstract List<EventoAlumno> getEventoAlumnos();
	public abstract EventoAlumno getEventoAlumno(int id);
	public abstract void createEventoAlumno(EventoAlumno eventoAlumno);
	public abstract void updateEventoAlumno(EventoAlumno eventoAlumno);
	public abstract void deleteEventoAlumno(int id);
	public abstract List<EventoAlumno> getAlumnos(int id_evento);
	public abstract List<EventoAlumno> getEventos(int id_alumno);
}
