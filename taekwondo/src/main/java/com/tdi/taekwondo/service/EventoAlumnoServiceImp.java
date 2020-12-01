package com.tdi.taekwondo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tdi.taekwondo.model.EventoAlumno;
import com.tdi.taekwondo.repository.EventoAlumnoRepository;

@Service
public class EventoAlumnoServiceImp implements EventoAlumnoService{

	@Autowired
	private EventoAlumnoRepository earep;

	@Override
	public List<EventoAlumno> getEventoAlumnos() {
		return earep.getEventoAlumnos();
	}

	@Override
	public EventoAlumno getEventoAlumno(int id) {
		return earep.findById(id);
	}

	@Override
	public void createEventoAlumno(EventoAlumno eventoAlumno) {
		earep.save(eventoAlumno);
	}

	@Override
	public void updateEventoAlumno(EventoAlumno eventoAlumno) {
		earep.save(eventoAlumno);
	}

	@Override
	public void deleteEventoAlumno(int id) {
		earep.deleteById(id);;
	}

	@Override
	public List<EventoAlumno> getAlumnos(int id_evento) {
		return earep.getAlumnos(id_evento);
	}

	@Override
	public List<EventoAlumno> getEventos(int id_alumno) {
		return earep.getEventos(id_alumno);
	}
}
