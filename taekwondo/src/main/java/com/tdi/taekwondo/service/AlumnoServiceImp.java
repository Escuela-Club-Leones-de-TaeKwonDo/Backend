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
	private AlumnoRepository almnRep;
	
	@Override
	public List<Alumno> getAlumnos() {
		// TODO Auto-generated method stub
		return almnRep.getAlumnos();
	}

	@Override
	public ResponseEntity<Object> getAlumno(int id) {
		// TODO Auto-generated method stub
		return new ResponseEntity<>(almnRep.findById(id), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> createAlumno(Alumno alumno) {
		return new ResponseEntity<>(almnRep.save(alumno), HttpStatus.OK);
	}

	@Override
	public void updateAlumno(int id, Alumno alumno) {
		// TODO Auto-generated method stub
		almnRep.save(alumno);
	}

	@Override
	public void deleteAlumno(int id) {
		// TODO Auto-generated method stub		
		almnRep.deleteById(id);
		
	}

}
