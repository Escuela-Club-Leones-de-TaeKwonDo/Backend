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

import com.tdi.taekwondo.service.AlumnoService;
//import com.tdi.taekwondo.service.EmailService;
import com.tdi.taekwondo.model.Alumno;
import com.tdi.taekwondo.service.PasswordGeneratorService;

@RestController
public class AlmunoCtrl {
	
	@Autowired
	private AlumnoService alumnoService;
	
//	@Autowired
//	private EmailService emailService;
	
	@GetMapping("/alumno")
	public List<Alumno> getAlumnos(){
		return alumnoService.getAlumnos();
	}
	
	@GetMapping("/alumno/{id}")
	public ResponseEntity<Object> getAlumno(@PathVariable int id){
		return alumnoService.getAlumno(id);
	}
	
	@PostMapping("/alumno")
	public ResponseEntity<Object> createAlumno(@Valid @RequestBody Alumno alumno){
		String sufflePassword = PasswordGeneratorService.generateStrongPassword();
		alumno.setPassword(sufflePassword);
		
		ResponseEntity<Object> savedPersona = alumnoService.createAlumno(alumno);
//		String emailToSend = alumno.getEmail();
//		System.out.println(emailToSend);
//		System.out.println(sufflePassword);
//		System.out.println(emailService);
//		emailService.sendMail("kate@example.com", "Test Subject", "Test mail");
		
		return null;
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
