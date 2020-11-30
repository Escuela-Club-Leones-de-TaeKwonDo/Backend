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
	private EventoRepository erep;
	
	@Override
	public List<Evento> getEventos() {
		return erep.getEventos();
	}

	@Override
	public Evento getEvento(int id){
		return erep.findById(id);
	}

	@Override
	public void createEvento(Evento evento) {
		erep.save(evento);
	}

	@Override
	public void updateEvento(Evento evento) {
		erep.save(evento);
	}

	@Override
	public void deleteEvento(int id) {
		erep.deleteById(id);
	}

	@Override
	public List<Evento> getEventoTipoEvento(int id_tipo_evento) {
		return erep.getEventoTipoEvento(id_tipo_evento);
	}
	
	
}
