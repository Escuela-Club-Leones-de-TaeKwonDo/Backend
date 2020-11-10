package com.tdi.taekwondo.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Digits;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.DecimalMax;

@Entity
@Table(name = "evento")
public class Evento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne(optional=true, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="id_tipo_evento", insertable=false, updatable=false)
	private TipoEvento tipo_usuario;
	
	@Column(name="id_tipo_evento")
	private String id_tipo_evento;
	

	@Size(min=2, message="El nombre del evento debe tener al menos 2 letras")
	private String nombre;
	
	@Size(min=2, message="La descripción debe tener al menos 1 letra1")
	private String descripcion;
	
	@FutureOrPresent
	private Date fecha_inicio;
	
	@FutureOrPresent
	private Date fecha_fin;
	
	@Digits(fraction = 0, integer = 0)
	@DecimalMin("0")
	@DecimalMax("999999")
	private int costo;
	
	@Size(min=2, message="El enlace a facebook debe tener al menos 2 letras")
	private String enlace_facebook;

	public Evento(int id, TipoEvento tipo_usuario, String id_tipo_evento,
			@Size(min = 2, message = "El nombre del evento debe tener al menos 2 letras") String nombre,
			@Size(min = 2, message = "La descripción debe tener al menos 1 letra1") String descripcion,
			@FutureOrPresent Date fecha_inicio, @FutureOrPresent Date fecha_fin,
			@Digits(fraction = 0, integer = 0) @DecimalMin("0") @DecimalMax("999999") int costo,
			@Size(min = 2, message = "El enlace a facebook debe tener al menos 2 letras") String enlace_facebook) {
		super();
		this.id = id;
		this.tipo_usuario = tipo_usuario;
		this.id_tipo_evento = id_tipo_evento;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.costo = costo;
		this.enlace_facebook = enlace_facebook;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TipoEvento getTipo_usuario() {
		return tipo_usuario;
	}

	public void setTipo_usuario(TipoEvento tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}

	public String getId_tipo_evento() {
		return id_tipo_evento;
	}

	public void setId_tipo_evento(String id_tipo_evento) {
		this.id_tipo_evento = id_tipo_evento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	public String getEnlace_facebook() {
		return enlace_facebook;
	}

	public void setEnlace_facebook(String enlace_facebook) {
		this.enlace_facebook = enlace_facebook;
	}

	@Override
	public String toString() {
		return "Evento [id=" + id + ", tipo_usuario=" + tipo_usuario + ", id_tipo_evento=" + id_tipo_evento
				+ ", nombre=" + nombre + ", descripcion=" + descripcion + ", fecha_inicio=" + fecha_inicio
				+ ", fecha_fin=" + fecha_fin + ", costo=" + costo + ", enlace_facebook=" + enlace_facebook + "]";
	}
	
	
	
}