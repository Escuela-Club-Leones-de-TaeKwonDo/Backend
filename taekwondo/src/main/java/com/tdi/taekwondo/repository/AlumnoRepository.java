package com.tdi.taekwondo.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tdi.taekwondo.model.Alumno;

@EntityScan(basePackages = {"com.tdi.taekwondo.entity"})
@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {
	Alumno findById(int id);
	
	@Query(value="SELECT * FROM alumno", nativeQuery=true)
	List<Alumno> getAlumnos();
}
