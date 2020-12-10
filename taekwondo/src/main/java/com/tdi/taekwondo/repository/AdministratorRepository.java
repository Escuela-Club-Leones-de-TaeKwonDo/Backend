package com.tdi.taekwondo.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tdi.taekwondo.model.Administrador;

@EntityScan(basePackages = {"com.tdi.taekwondo.entity"})
@Repository
public interface AdministratorRepository extends JpaRepository<Administrador, Integer>{
	Administrador findById(int id);
	Administrador findByEmail(String email);
	
	@Query(value="SELECT * FROM administrador", nativeQuery=true)
	List<Administrador> getAdministradores();
}
