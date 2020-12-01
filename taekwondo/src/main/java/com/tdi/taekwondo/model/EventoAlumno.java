package com.tdi.taekwondo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "evento_alumno")
public class EventoAlumno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name = "id_alumno")
	private int id_alumno;
	
	@Column(name="id_evento")
	private int id_evento;

	public EventoAlumno() {
	}

	public EventoAlumno(Integer id, int id_alumno, int id_evento) {
		super();
		this.id = id;
		this.id_alumno = id_alumno;
		this.id_evento = id_evento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		return "EventoAlumno [id=" + id + ", id_alumno=" + id_alumno + ", id_evento=" + id_evento + "]";
	}
}