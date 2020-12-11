package com.tdi.taekwondo.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import javax.validation.constraints.Email;

@Entity
public class Alumno {
	
	public Alumno() {
		super();
	}
	
	public Alumno(Integer id,
			@Size(min = 2, message = "El nombre de la persona debe tener al menos 2 letras") String nombre,
			@Size(min = 2, message = "Los apellidos de la persona deben tener al menos 2 letras") String apellidos,
			@Past Date fecha_nacimiento, @Size(min = 2) String fotografia, @Size(min = 2) String grado,
			@Size(min = 2) String seguro_medico, @Size(min = 2) String certificado_medico,
			@Size(min = 2) String carta_responsiva, String password, @Email String email) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fecha_nacimiento = fecha_nacimiento;
		this.fotografia = fotografia;
		this.grado = grado;
		this.seguro_medico = seguro_medico;
		this.certificado_medico = certificado_medico;
		this.carta_responsiva = carta_responsiva;
		this.password = password;
		this.email = email;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Size(min=2, message="El nombre de la persona debe tener al menos 2 letras")
	private String nombre;
	
	@Size(min=2, message="Los apellidos de la persona deben tener al menos 2 letras")
	private String apellidos;
    
    public Alumno(Integer id,
			@Size(min = 2, message = "El nombre de la persona debe tener al menos 2 letras") String nombre,
			@Size(min = 2, message = "Los apellidos de la persona deben tener al menos 2 letras") String apellidos,
			String actividad_marcial, @Past Date fecha_nacimiento, @Size(min = 2) String fotografia,
			@Size(min = 2) String grado, @Size(min = 2) String seguro_medico, @Size(min = 2) String certificado_medico,
			@Size(min = 2) String carta_responsiva, String password, @Email String email, Set<Examen> examenes) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.actividad_marcial = actividad_marcial;
		this.fecha_nacimiento = fecha_nacimiento;
		this.fotografia = fotografia;
		this.grado = grado;
		this.seguro_medico = seguro_medico;
		this.certificado_medico = certificado_medico;
		this.carta_responsiva = carta_responsiva;
		this.password = password;
		this.email = email;
		this.examenes = examenes;
	}

	private String actividad_marcial;
	
	public String getActividad_marcial() {
		return actividad_marcial;
	}

	public void setActividad_marcial(String actividad_marcial) {
		this.actividad_marcial = actividad_marcial;
	}

	@Past
	private Date fecha_nacimiento;
	
	@Size(min=2)
	private String fotografia;
	
	@Size(min=2)
	private String grado;
	
	@Size(min=2)
	private String seguro_medico;
	
	@Size(min=2)
	private String certificado_medico;
	
	@Size(min=2)
	private String carta_responsiva;
	
	private String password;
	
	@Email
	private String email;
	
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
    		  name = "ExamenAlumno", 
    		  joinColumns = @JoinColumn(name = "id_alumno"), 
    		  inverseJoinColumns = @JoinColumn(name = "id_examen"))
    Set<Examen> examenes;

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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getFotografia() {
		return fotografia;
	}

	public void setFotografia(String fotografia) {
		this.fotografia = fotografia;
	}

	public String getGrado() {
		return grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}

	public String getSeguro_medico() {
		return seguro_medico;
	}

	public void setSeguro_medico(String seguro_medico) {
		this.seguro_medico = seguro_medico;
	}

	public String getCertificado_medico() {
		return certificado_medico;
	}

	public void setCertificado_medico(String certificado_medico) {
		this.certificado_medico = certificado_medico;
	}

	public String getCarta_responsiva() {
		return carta_responsiva;
	}

	public void setCarta_responsiva(String carta_responsiva) {
		this.carta_responsiva = carta_responsiva;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Alumno [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", actividad_marcial="
				+ actividad_marcial + ", fecha_nacimiento=" + fecha_nacimiento + ", fotografia=" + fotografia
				+ ", grado=" + grado + ", seguro_medico=" + seguro_medico + ", certificado_medico=" + certificado_medico
				+ ", carta_responsiva=" + carta_responsiva + ", password=" + password + ", email=" + email
				+ ", examenes=" + examenes + "]";
	}
}
