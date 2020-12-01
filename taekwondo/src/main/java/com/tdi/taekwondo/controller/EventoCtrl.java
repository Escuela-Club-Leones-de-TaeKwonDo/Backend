package com.tdi.taekwondo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tdi.taekwondo.service.AlumnoService;
import com.tdi.taekwondo.service.AlumnoServiceImp;
import com.tdi.taekwondo.service.EventoService;
import com.tdi.taekwondo.service.Evento_alumnoService;
import com.tdi.taekwondo.service.Evento_alumnoServiceImp;
import com.tdi.taekwondo.model.Alumno;
import com.tdi.taekwondo.model.Evento;
import com.tdi.taekwondo.model.Evento_alumno;

@RestController
public class EventoCtrl {
	
	@Autowired
	private EventoService eventoService;
	@Autowired
	private AlumnoService alumnoS;
	@Autowired
	private Evento_alumnoService event_alumnServ;
	
	@GetMapping("/evento")
	public List<Evento> getEventos(){
		return eventoService.getEventos();
	}
	
	@GetMapping("/evento/{id}")
	public ResponseEntity<Object> getEvento(@PathVariable int id){
		return eventoService.getEvento(id);
	}
	
	
	@PostMapping("/evento")
	public ResponseEntity<Object> createEvento(@Valid @RequestBody Evento evento){
		ResponseEntity<Object> savedEvento = eventoService.createEvento(evento);
		return null;
	}
	
	@PutMapping("/evento/{id}")
	public void updateEvento(@Valid @RequestBody Evento evento, @PathVariable int id) {
		eventoService.updateEvento(id, evento);
	}
	
	@DeleteMapping("/evento/{id}")
	public void deleteEvento(@PathVariable int id) {
		eventoService.deleteEvento(id);
	}
	
	
	@GetMapping("/eventoA/{id}")
	public List<Alumno> getAlumnos(@PathVariable int id) {
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
