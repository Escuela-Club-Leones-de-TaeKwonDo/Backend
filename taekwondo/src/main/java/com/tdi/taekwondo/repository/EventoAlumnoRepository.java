package com.tdi.taekwondo.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tdi.taekwondo.model.*;

@EntityScan(basePackages = {"com.tdi.taekwondo.entity"})
@Repository
public interface EventoAlumnoRepository extends JpaRepository<EventoAlumno, Integer>{
	
	EventoAlumno findById(int id);
	
	@Query(value="SELECT * FROM evento_alumno", nativeQuery=true)
	List<EventoAlumno> getEventoAlumnos();
	
	@Query(value="SELECT * FROM evento_alumno WHERE id_evento = :id_evento", nativeQuery=true)
	List<EventoAlumno> getAlumnos(int id_evento);
	
	@Query(value="SELECT id_evento FROM evento_alumno WHERE id_alumno = :id_alumno", nativeQuery=true)
	List<EventoAlumno> getEventos(int id_alumno);
}