package com.tdi.taekwondo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Id;

import com.tdi.taekwondo.model.Alumno;
import com.tdi.taekwondo.model.Evento;
import com.tdi.taekwondo.model.Ex_al;
import com.tdi.taekwondo.repository.Ex_alRepository;

@Service
public class Ex_alServiceImp implements Ex_alService {
	
	@Autowired
	private Ex_alRepository ex_alRep;
	
	@Override
	public List<Ex_al> getAlumnosEx() {
		return ex_alRep.getAlumnosEx();
	}
	
	/*
	@Transactional
	public void insertEx_al(int id_ex, int id_al){
		//((Ex_alRepository) ex_alRep).insertEx_al(id_al,id_ex);
		ex_alRep.insertEx_al(id_al,id_ex);
	}*/
	
	@Override
	public ResponseEntity<Object> createEx_al(Ex_al reg) {
		return new ResponseEntity<>(ex_alRep.save(reg), HttpStatus.OK);
	}
	
	
}