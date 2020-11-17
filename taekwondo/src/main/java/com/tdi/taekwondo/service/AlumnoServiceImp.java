package com.tdi.taekwondo.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


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
	public Alumno getAlumno(int id) {
		// TODO Auto-generated method stub
		return almnRep.findById(id);
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

	@Override
	public void updateCertificado(int id, byte[] certificado_medico) {
		// TODO Auto-generated method stub
		Alumno alumno = this.getAlumno(id);
		alumno.setCertificado_medico(certificado_medico);
		almnRep.save(alumno);
	}

	@Override
	public void updateCarta(int id, byte[] carta_responsiva) {
		// TODO Auto-generated method stub
		Alumno alumno = this.getAlumno(id);
		alumno.setCarta_responsiva(carta_responsiva);
		almnRep.save(alumno);
	}

	@Override
	public void updateFotografia(int id, byte[] fotografia) {
		// TODO Auto-generated method stub
		Alumno alumno = this.getAlumno(id);
		alumno.setFotografia(fotografia);
		almnRep.save(alumno);
	}

}
