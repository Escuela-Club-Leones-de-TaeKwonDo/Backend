package com.tdi.taekwondo.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import javax.persistence.Id;
import com.tdi.taekwondo.model.Evento_alumno;
import com.tdi.taekwondo.model.Alumno;

@EntityScan(basePackages = {"com.tdi.taekwondo.entity"})
@Repository
public interface Evento_alumnoRepository extends JpaRepository<Evento_alumno, Integer> {
	
	@Query(value="SELECT * FROM evento_alumno", nativeQuery=true)
	List<Evento_alumno> getAlumnosE();
}