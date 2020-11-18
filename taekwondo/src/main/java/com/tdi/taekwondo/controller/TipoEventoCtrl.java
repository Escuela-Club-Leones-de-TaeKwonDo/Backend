package com.tdi.taekwondo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import com.tdi.taekwondo.service.TipoEventoService;
import com.tdi.taekwondo.model.TipoEvento;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class TipoEventoCtrl {
	@Autowired
	private TipoEventoService tipoEventoService;
	
	@GetMapping("/tipo_evento")
	public List<TipoEvento> getTiposEventos(){
		return tipoEventoService.getTiposEventos();
	}
	
	@GetMapping("/tipo_evento/{id}")
	public ResponseEntity<Object> getTipoEvento(@PathVariable int id){
		return tipoEventoService.getTipoEvento(id);
	}
	
	@PostMapping("/tipo_evento")
	public ResponseEntity<Object> createTipoEvento(@Valid @RequestBody TipoEvento te){
		ResponseEntity<Object> savedTipoEvento = tipoEventoService.createTipoEvento(te);
		
		return null;
	}
	
	@PutMapping("/tipo_evento/{id}")
	public void updateipoEvento(@Valid @RequestBody TipoEvento te, @PathVariable int id) {
		tipoEventoService.updateTipoEvento(id, te);
	}
	
	@DeleteMapping("/tipo_evento/{id}")
	public void deleteAlumno(@PathVariable int id) {
		tipoEventoService.deleteTipoEvento(id);
	}
	
}
