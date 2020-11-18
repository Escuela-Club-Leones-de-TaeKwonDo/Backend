package com.tdi.taekwondo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tdi.taekwondo.model.Evento;
import com.tdi.taekwondo.repository.EventoRepository;

@Service
public class EventoServiceImp implements EventoService {
	
	@Autowired
	private EventoRepository eventoRep;
	
	@Override
	public List<Evento> getEventos() {
		return eventoRep.getEventos();
	}

	@Override
	public ResponseEntity<Object> getEvento(int id) {
		return new ResponseEntity<>(eventoRep.findById(id), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> createEvento(Evento evento) {
		return new ResponseEntity<>(eventoRep.save(evento), HttpStatus.OK);
	}

	@Override
	public void updateEvento(int id, Evento evento) {
		eventoRep.save(evento);
	}

	@Override
	public void deleteEvento(int id) {
		eventoRep.deleteById(id);
	}
}
