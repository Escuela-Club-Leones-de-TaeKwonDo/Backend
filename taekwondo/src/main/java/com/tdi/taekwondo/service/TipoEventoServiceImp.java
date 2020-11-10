package com.tdi.taekwondo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tdi.taekwondo.model.TipoEvento;
import com.tdi.taekwondo.repository.TipoEventoRepository;

@Service
public class TipoEventoServiceImp implements TipoEventoService {
	
	@Autowired
	private TipoEventoRepository teRep;

	@Override
	public List<TipoEvento> getTiposEventos() {
		// TODO Auto-generated method stub
		return teRep.getTiposEventos();
	}

	@Override
	public ResponseEntity<Object> getTipoEvento(int id) {
		// TODO Auto-generated method stub
		return new ResponseEntity<>(teRep.findById(id), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> createTipoEvento(TipoEvento te) {
		// TODO Auto-generated method stub
		return new ResponseEntity<>(teRep.save(te), HttpStatus.OK);
	}

	@Override
	public void updateTipoEvento(int id, TipoEvento te) {
		// TODO Auto-generated method stub
		teRep.save(te);
	}

	@Override
	public void deleteTipoEvento(int id) {
		// TODO Auto-generated method stub
		teRep.deleteById(id);
	}
	
}
