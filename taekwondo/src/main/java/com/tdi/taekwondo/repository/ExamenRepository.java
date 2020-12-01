package com.tdi.taekwondo.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tdi.taekwondo.model.Examen;

@EntityScan(basePackages = {"com.tdi.taekwondo.entity"})
@Repository
public interface ExamenRepository extends JpaRepository<Examen, Integer> {
	Examen findById(int id);
	
	@Query(value="SELECT * FROM examen", nativeQuery=true)
	List<Examen> getExamenes();
}