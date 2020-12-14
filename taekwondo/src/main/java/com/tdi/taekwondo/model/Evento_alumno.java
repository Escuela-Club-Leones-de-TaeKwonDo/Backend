package com.tdi.taekwondo.model;

import javax.persistence.Access;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "evento_alumno")
public class Evento_alumno {
	
	@Column(name="id_alumno")
	private int id_alumno;
	
	@Id
	@Column(name="id_evento")
	private int id_evento;
	
	public Evento_alumno(int id_alumno, int id_evento) {
		super();
		this.id_alumno = id_alumno;
		this.id_evento = id_evento;	
	}
	
	public Evento_alumno(){

	}

	public int getId_alumno() {
		return id_alumno;
	}

	public void setId_alumno(int id_alumno) {
		this.id_alumno = id_alumno;
	}

	public int getId_evento() {
		return id_evento;
	}

	public void setId_evento(int id_evento) {
		this.id_evento = id_evento;
	}

	@Override
	public String toString() {
		return "Evento_alumno [id_alumno=" + id_alumno + ", id_evento=" + id_evento + "]";
	}
}