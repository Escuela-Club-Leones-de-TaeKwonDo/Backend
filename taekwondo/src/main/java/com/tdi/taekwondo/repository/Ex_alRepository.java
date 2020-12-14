package com.tdi.taekwondo.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import javax.persistence.Id;
import com.tdi.taekwondo.model.Ex_al;

@EntityScan(basePackages = {"com.tdi.taekwondo.entity"})
@Repository
public interface Ex_alRepository extends JpaRepository<Ex_al, Integer> {
	Ex_al findById(int id);
	
	@Query(value="SELECT * FROM ex_al", nativeQuery=true)
	List<Ex_al> getAlumnosEx();
	
	
	
	@Modifying
	@Query(
	  value = 
			  "insert into Ex_al values (id_alumnoE,id_examenE)",
	  nativeQuery = true)
	void insertEx_al(@Param("id_alumnoE") int id_alumnoE, @Param("id_examenE")int id_examenE);
}
	
	