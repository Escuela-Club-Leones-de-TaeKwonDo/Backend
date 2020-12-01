package com.tdi.taekwondo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;


import com.tdi.taekwondo.model.Examen;


public interface ExamenService {
	
	public abstract List<Examen> getExamenes();
	public abstract ResponseEntity<Object> getExamen(int id);
	public abstract ResponseEntity<Object> createExamen(Examen examen);
	public abstract void updateExamen(int id, Examen examen);
	public abstract void deleteExamen(int id);
}