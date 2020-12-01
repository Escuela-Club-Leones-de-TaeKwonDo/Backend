package com.tdi.taekwondo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tdi.taekwondo.model.Examen;
import com.tdi.taekwondo.repository.ExamenRepository;

@Service
public class ExamenServiceImp implements ExamenService {
	
	@Autowired
	private ExamenRepository examenRep;
	
	@Override
	public List<Examen> getExamenes() {
		return examenRep.getExamenes();
	}

	@Override
	public ResponseEntity<Object> getExamen(int id) {
		return new ResponseEntity<>(examenRep.findById(id), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> createExamen(Examen examen) {
		return new ResponseEntity<>(examenRep.save(examen), HttpStatus.OK);
	}

	@Override
	public void updateExamen(int id, Examen examen) {
		examenRep.save(examen);
	}

	@Override
	public void deleteExamen(int id) {
		examenRep.deleteById(id);
	}
}