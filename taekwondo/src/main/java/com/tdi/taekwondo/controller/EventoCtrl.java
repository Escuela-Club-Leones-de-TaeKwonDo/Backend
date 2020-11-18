package com.tdi.taekwondo.controller;

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

import com.tdi.taekwondo.service.EventoService;
import com.tdi.taekwondo.model.Evento;

@RestController
public class EventoCtrl {
	
	@Autowired
	private EventoService eventoService;
	
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
}
