package com.tdi.taekwondo.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tdi.taekwondo.service.AlumnoService;
import com.tdi.taekwondo.model.Alumno;

@Controller
@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class AlmunoCtrl {
	
	@Autowired
	private AlumnoService alumnoService;
	
	@GetMapping("/alumno")
	public List<Alumno> getAlumnos(){
		return alumnoService.getAlumnos();
	}
	
	@GetMapping("/alumno/{id}")
	public Alumno getAlumno(@PathVariable int id){
		return alumnoService.getAlumno(id);
	}
	
	@RequestMapping(
			value = {"/alumno"}, 
			method = RequestMethod.POST
			)
	public ResponseEntity<Object> createAlumnos(
			@Valid @RequestBody Alumno alumno

			) {
		ResponseEntity<Object> savedPersona = alumnoService.createAlumno(alumno);
		
		return null;
	}
	
	@RequestMapping(
			value = {"/alumno/fotografia/{id}"}, 
			method = RequestMethod.POST,
			consumes = { "multipart/form-data" }
			)
	public void updateFotografia(
			@PathVariable int id,
			@Valid @RequestParam("fotografia") MultipartFile fotografia
			) throws IOException {
		
		byte [] data = fotografia.getBytes();
		alumnoService.updateFotografia(id, data);
	}
	
	@RequestMapping(
			value = {"/alumno/carta_responsiva/{id}"}, 
			method = RequestMethod.POST,
			consumes = { "multipart/form-data" }
			)
	public void updateCarta(
			@PathVariable int id,
			@Valid @RequestParam("carta_responsiva") MultipartFile carta_responsiva
			) throws IOException {
		
		byte [] data = carta_responsiva.getBytes();
		alumnoService.updateCarta(id, data);
	}
	
	@RequestMapping(
			value = {"/alumno/certificado_medico/{id}"}, 
			method = RequestMethod.POST,
			consumes = { "multipart/form-data" }
			)
	public void updateCertificado(
			@PathVariable int id,
			@Valid @RequestParam("certificado_medico") MultipartFile certificado_medico
			) throws IOException {
		
		byte [] data = certificado_medico.getBytes();
		alumnoService.updateCertificado(id, data);
	}
	
	@PutMapping("/alumno/{id}")
	public void updateAlumno(@Valid @RequestBody Alumno alumno, @PathVariable int id) {
		alumnoService.updateAlumno(id, alumno);
	}
	
	@DeleteMapping("/alumno/{id}")
	public void deleteAlumno(@PathVariable int id) {
		alumnoService.deleteAlumno(id);
	}
}
