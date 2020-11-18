package com.tdi.taekwondo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tdi.taekwondo.model.Alumno;
import com.tdi.taekwondo.repository.AlumnoRepository;

@Service
public class AlumnoServiceImp implements AlumnoService {
	
	@Autowired
	private AlumnoRepository repoAlumno;
	
	@Override
	public List<Alumno> getAlumnos() {
		return repoAlumno.getAlumnos();
	}

	@Override
	public ResponseEntity<Object> getAlumno(int id) {
		return new ResponseEntity<>(repoAlumno.findById(id), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> createAlumno(Alumno alumno) {
		return new ResponseEntity<>(repoAlumno.save(alumno), HttpStatus.OK);
	}

	@Override
	public void updateAlumno(int id, Alumno alumno) {
		repoAlumno.save(alumno);
	}

	@Override
	public void deleteAlumno(int id) {	
		repoAlumno.deleteById(id);
	}
}
