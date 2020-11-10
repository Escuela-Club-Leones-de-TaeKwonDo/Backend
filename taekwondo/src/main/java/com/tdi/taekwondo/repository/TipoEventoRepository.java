package com.tdi.taekwondo.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tdi.taekwondo.model.TipoEvento;

@EntityScan(basePackages = {"com.tdi.taekwondo.entity"})
@Repository
public interface TipoEventoRepository extends JpaRepository<TipoEvento, Integer>  {
	TipoEvento findById(int id);
	
	@Query(value="SELECT * FROM tipo_evento", nativeQuery=true)
	List<TipoEvento> getTiposEventos();
}
