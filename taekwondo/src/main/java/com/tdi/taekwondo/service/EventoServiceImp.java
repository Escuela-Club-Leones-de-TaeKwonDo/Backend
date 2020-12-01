package com.tdi.taekwondo.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tdi.taekwondo.model.Alumno;
import com.tdi.taekwondo.model.Evento;
import com.tdi.taekwondo.model.Evento_alumno;
import com.tdi.taekwondo.repository.AlumnoRepository;
import com.tdi.taekwondo.repository.EventoRepository;
import com.tdi.taekwondo.repository.Evento_alumnoRepository;

@Service
public class EventoServiceImp implements EventoService {
	
	@Autowired
	private EventoRepository eventoRep;
	
	@Override
	public List<Evento> getEventos() {
		return eventoRep.getEventos();
	}

	@Override
	public ResponseEntity<Object> getEvento(int id) {
		return new ResponseEntity<>(eventoRep.findById(id), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> createEvento(Evento evento) {
		return new ResponseEntity<>(eventoRep.save(evento), HttpStatus.OK);
	}

	@Override
	public void updateEvento(int id, Evento evento) {
		eventoRep.save(evento);
	}

	@Override
	public void deleteEvento(int id) {
		eventoRep.deleteById(id);
	}
	
	@Override
	public List<Alumno> getAlumnos(int id) {
		Evento_alumnoService event_alumnServ = new Evento_alumnoServiceImp();
		AlumnoService alumnoS = new AlumnoServiceImp();
		List<Evento_alumno> event_alum = event_alumnServ.getAlumnosE();
		List<Alumno> alumnos = new ArrayList<Alumno>();
		for(Evento_alumno a : event_alum) {
			if(a.getId_evento()==id){
				Alumno aux = (Alumno) alumnoS.getAlumno(a.getId_alumno()).getBody();
				alumnos.add(aux);
			}
		}
		return alumnos;
	}
}
