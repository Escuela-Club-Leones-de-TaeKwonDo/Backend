package com.tdi.taekwondo.controller;

import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import com.tdi.taekwondo.service.AlumnoService;
import com.tdi.taekwondo.service.EventoService;
import com.tdi.taekwondo.service.Evento_alumnoService;
import com.tdi.taekwondo.service.Ex_alService;
import com.tdi.taekwondo.model.Evento;
import com.tdi.taekwondo.model.Evento_alumno;
import com.tdi.taekwondo.model.Ex_al;
import com.tdi.taekwondo.model.Alumno;


@RestController
public class EventoCtrl {
	
	@Autowired
	private EventoService esrv;
	
	@Autowired
	private Evento_alumnoService event_alumnServ;
	@Autowired 
	private AlumnoService alumnoService;
	
	@GetMapping("/evento")
	public ResponseEntity<Object> getEventos(){
		return new ResponseEntity<>(esrv.getEventos(), HttpStatus.OK);
	}
	
	@GetMapping("/evento/{id}")
	public ResponseEntity<Object> getEvento(@PathVariable int id){
		return new ResponseEntity<>(esrv.getEvento(id),HttpStatus.OK);
	}
	
	@GetMapping("evento/tipo_evento/{id_tipo_evento}")
	public ResponseEntity<Object> getEventoTipoEvento(@PathVariable int id_tipo_evento){
		return new ResponseEntity<>(esrv.getEventoTipoEvento(id_tipo_evento), HttpStatus.OK);
	}
	
	@PostMapping("/evento/{id_tipo_evento}")
	public ResponseEntity<Object> createEvento(@Valid @RequestBody Evento evento, @PathVariable int id_tipo_evento){
		HashMap<String,String> response = new HashMap<>();
		
		if(evento.getId_tipo_evento() != id_tipo_evento) {
			response.put("status","failure");
			response.put("message","Los ids del tipo evento no coinciden");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		esrv.createEvento(evento);
		
		response.put("status","success");
		response.put("message","Evento creado exitosamente");
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/evento/{id}/{id_tipo_evento}")
	public ResponseEntity<Object> updateEvento(@Valid @RequestBody Evento evento, @PathVariable int id, @PathVariable int id_tipo_evento) {
		HashMap<String,String> response = new HashMap<>();
		
		if(evento.getId() != id) {
			response.put("status","failure");
			response.put("message","Los ids del evento no coinciden");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		
		if(evento.getId_tipo_evento() != id_tipo_evento) {
			response.put("status","failure");
			response.put("message","Los ids del tipo evento no coinciden");
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
		
		esrv.updateEvento(evento);
		response.put("status","success");
		response.put("message","Evento actualizado correctamente");
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@DeleteMapping("/evento/{id}")
	public ResponseEntity<Object> deleteEvento(@PathVariable int id) {
		esrv.deleteEvento(id);
		HashMap<String,String> response = new HashMap<>();
		response.put("status","success");
		response.put("message","Evento eliminado correctamente");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	
	
	@PostMapping("/eventoA")
	public ResponseEntity<Object> createEvento_alumno(@Valid @RequestBody Evento_alumno reg){	
		ResponseEntity<Object> savedPersona = event_alumnServ.createEvento_alumno(reg);
		return savedPersona;
	}
	
	@GetMapping("/eventoA/{id}")
	public ArrayList<Alumno> getAlumnos(@PathVariable int id) {
		List<Evento_alumno> event_alum = event_alumnServ.getAlumnosE();
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		for(Evento_alumno a : event_alum) {
			if(a.getId_evento()==id){
				Alumno aux = (Alumno) alumnoService.getAlumno(a.getId_alumno()).getBody();
				alumnos.add(aux);
			}
		}
		return alumnos;
	}
	
}
