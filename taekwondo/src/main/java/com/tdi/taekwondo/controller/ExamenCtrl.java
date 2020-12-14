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

import com.tdi.taekwondo.model.Alumno;
import com.tdi.taekwondo.model.Examen;
import com.tdi.taekwondo.model.Ex_al;
import com.tdi.taekwondo.service.AlumnoService;
import com.tdi.taekwondo.service.Ex_alService;
import com.tdi.taekwondo.service.ExamenService;
import com.tdi.taekwondo.service.PasswordGeneratorService;


@RestController
public class ExamenCtrl {
	
	@Autowired
	private ExamenService esrv;
	
	@Autowired
	private Ex_alService ex_alService;
	@Autowired 
	private AlumnoService alumnoService;
	
	@GetMapping("/examen")
	public List<Examen> getExamenes(){
		return esrv.getExamenes();
	}
	
	@GetMapping("/examen/{id}")
	public ResponseEntity<Object> getExamen(@PathVariable int id){
		return esrv.getExamen(id);
	}
	
	@PostMapping("/examen")
	public ResponseEntity<Object> createExamen(@Valid @RequestBody Examen examen){
		ResponseEntity<Object> savedExamen = esrv.createExamen(examen);
		return null;
	}
	
	@PutMapping("/examen/{id}")
	public void updateExamen(@Valid @RequestBody Examen examen, @PathVariable int id) {
		esrv.updateExamen(id, examen);
	}
	
	
	
	/*
	@PutMapping("/examenA")
	public void createEx_al( @Valid @RequestBody Ex_al reg){
		int id_examenE = reg.getId_examenE();
		int id_alumnoE = reg.getId_alumnoE();
		System.out.println("****************");
		System.out.println(id_examenE);
		System.out.println(id_alumnoE);
		System.out.println("****************");
		ex_alService.insertEx_al(id_examenE,id_alumnoE);
	}*/
	@PostMapping("/examenA")
	public ResponseEntity<Object> createEx_al(@Valid @RequestBody Ex_al reg){	
		ResponseEntity<Object> savedPersona = ex_alService.createEx_al(reg);
		return savedPersona;
	}
	
	
	
	@DeleteMapping("/examen/{id}")
	public void deleteExamen(@PathVariable int id) {
		esrv.deleteExamen(id);
	}

	/*
	public ExamenCtrl(ExamenService examenService) {
		super();
		this.examenService = examenService;
	}*/

	@GetMapping("/examenA/{id}")
	public List<Alumno> getAlumnos(@PathVariable int id) {
		List<Ex_al> ex_al = ex_alService.getAlumnosEx();
		List<Alumno> alumnos = new ArrayList<Alumno>();
		for(Ex_al a : ex_al) {
			if(a.getId_examenE()==id){
				Alumno aux = (Alumno) alumnoService.getAlumno(a.getId_alumnoE()).getBody();
				alumnos.add(aux);
			}
		}
		return alumnos;
	}
	
	
}