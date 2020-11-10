package com.tdi.taekwondo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.tdi.taekwondo.model.TipoEvento;

public interface TipoEventoService {
	
	public abstract List<TipoEvento> getTiposEventos();
	public abstract ResponseEntity<Object> getTipoEvento(int id);
	public abstract ResponseEntity<Object> createTipoEvento(TipoEvento te);
	public abstract void updateTipoEvento(int id, TipoEvento te);
	public abstract void deleteTipoEvento(int id);
}
