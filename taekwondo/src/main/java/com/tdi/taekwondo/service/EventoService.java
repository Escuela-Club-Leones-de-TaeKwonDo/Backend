package com.tdi.taekwondo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.tdi.taekwondo.model.Evento;

public interface EventoService {
	
	public abstract List<Evento> getEventos();
	public abstract Evento getEvento(int id);
	public abstract void createEvento(Evento evento);
	public abstract void updateEvento(Evento evento);
	public abstract void deleteEvento(int id);
	public abstract List<Evento> getEventoTipoEvento(int id_tipo_evento);
}
