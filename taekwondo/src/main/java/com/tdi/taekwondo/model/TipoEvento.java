package com.tdi.taekwondo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipo_evento")
public class TipoEvento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	int id;
	
	@Column(name="nombre_tipo_evento")
	private String nombre_tipo_evento;
	
	@Column(name="descripcion")
	private String descripcion;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre_tipo_evento() {
		return nombre_tipo_evento;
	}

	public void setNombre_tipo_evento(String nombre_tipo_evento) {
		this.nombre_tipo_evento = nombre_tipo_evento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}