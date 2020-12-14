package com.tdi.taekwondo.model;
import javax.persistence.Access;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ex_al")
public class Ex_al {
	
	
	@Column(name="id_alumnoE")
	private int id_alumnoE;
	
	@Id
	@Column(name="id_examenE")
	private int id_examenE;
	
	public Ex_al(int id_alumnoE, int id_examenE) {
		this.id_alumnoE=id_alumnoE;
		this.id_examenE=id_examenE;
	}
	
	public Ex_al() {
	}
	
	
	public int getId_alumnoE() {
		return id_alumnoE;
	}



	public void setId_alumnoE(int id_alumnoE) {
		this.id_alumnoE = id_alumnoE;
	}



	public int getId_examenE() {
		return id_examenE;
	}



	public void setId_examenE(int id_examenE) {
		this.id_examenE = id_examenE;
	}



	@Override
	public String toString() {
		return "Ex_al [id_alumnoE=" + id_alumnoE + ", id_examenE=" + id_examenE + "]";
	}
	
	

}	