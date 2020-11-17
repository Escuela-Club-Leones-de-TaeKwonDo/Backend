package com.tdi.taekwondo.service;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.tdi.taekwondo.model.*;

public interface AlumnoService {
	
	public abstract List<Alumno> getAlumnos();
	public abstract Alumno getAlumno(int id);
	public abstract ResponseEntity<Object> createAlumno(Alumno alumno);
	public abstract void updateAlumno(int id, Alumno alumno);
	public abstract void updateCertificado(int id, byte [] certificado_medico);
	public abstract void updateCarta(int id, byte [] carta_responsiva);
	public abstract void updateFotografia(int id, byte [] fotografia);
	public abstract void deleteAlumno(int id);
}
