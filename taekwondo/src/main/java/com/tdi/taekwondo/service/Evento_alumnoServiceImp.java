package com.tdi.taekwondo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import javax.persistence.Id;
import com.tdi.taekwondo.model.Evento_alumno;
import com.tdi.taekwondo.model.Ex_al;
import com.tdi.taekwondo.repository.Evento_alumnoRepository;

@Service
public class Evento_alumnoServiceImp implements Evento_alumnoService {
	
	@Autowired
	private Evento_alumnoRepository evento_alumnoRep;
	
	@Override
	public List<Evento_alumno> getAlumnosE() {
		return evento_alumnoRep.getAlumnosE();
	}
	
	@Override
	public ResponseEntity<Object> createEvento_alumno(Evento_alumno reg) {
		return new ResponseEntity<>(evento_alumnoRep.save(reg), HttpStatus.OK);
	}
}