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

import com.tdi.taekwondo.service.Evento_alumnoService;
import com.tdi.taekwondo.model.Evento_alumno;

@RestController
public class Evento_alumnoCtrl {
	@Autowired
	private Evento_alumnoService evento_alumnoService;
	
	@GetMapping("/evento_alumnos")
	public List<Evento_alumno> getAlumnosE(){
		return evento_alumnoService.getAlumnosE();
	}
	
}