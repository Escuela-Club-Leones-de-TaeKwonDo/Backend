package com.tdi.taekwondo.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;
import javax.validation.constraints.FutureOrPresent;

@Entity
public class Examen {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Size(min=2, message="El nombre del examen debe tener al menos 2 letras")
	private String nombre;
    
    private String tipo_examen;
    
	@FutureOrPresent
	private Date fecha;
	
	@Size(min=2, max=5, message="La hora debe tener exactamente 5 caracteres")
	private String horario;
	
	@Size(min=2, message="El enlace a facebook debe tener al menos 2 letras")
	private String enlace_facebook;
	
	private int costo;
	
	private String solicitud_examen;
	
	@ManyToMany(mappedBy = "examenes")
    Set<Alumno> alumnos;
	
	public Examen() {
		
	}

	public Examen(Integer id,
			@Size(min = 2, message = "El nombre del examen debe tener al menos 2 letras") String nombre,
			String tipo_examen, int costo, @FutureOrPresent Date fecha,
			@Size(min = 2, max = 5, message = "La hora debe tener exactamente 5 caracteres") String horario,
			String solicitud_examen,
			@Size(min = 2, message = "El enlace a facebook debe tener al menos 2 letras") String enlace_facebook) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tipo_examen = tipo_examen;
		this.costo = costo;
		this.fecha = fecha;
		this.horario = horario;
		this.solicitud_examen = solicitud_examen;
		this.enlace_facebook = enlace_facebook;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo_examen() {
		return tipo_examen;
	}

	public void setTipo_examen(String tipo_examen) {
		this.tipo_examen = tipo_examen;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getEnlace_facebook() {
		return enlace_facebook;
	}

	public void setEnlace_facebook(String enlace_facebook) {
		this.enlace_facebook = enlace_facebook;
	}

	public String getSolicitud_examen() {
		return solicitud_examen;
	}

	public void setSolicitud_examen(String solicitud_examen) {
		this.solicitud_examen = solicitud_examen;
	}

	@Override
	public String toString() {
		return "Examen [id=" + id + ", nombre=" + nombre + ", tipo_examen=" + tipo_examen + ", fecha=" + fecha
				+ ", horario=" + horario + ", enlace_facebook=" + enlace_facebook + ", costo=" + costo
				+ ", solicitud_examen=" + solicitud_examen + ", alumnos=" + alumnos + "]";
	}  
}
