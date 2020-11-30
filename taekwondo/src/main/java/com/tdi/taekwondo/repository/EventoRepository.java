package com.tdi.taekwondo.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tdi.taekwondo.model.Evento;

@EntityScan(basePackages = {"com.tdi.taekwondo.entity"})
@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer> {
	Evento findById(int id);
	
	@Query(value="SELECT * FROM evento", nativeQuery=true)
	List<Evento> getEventos();
	
	@Query(value="SELECT * FROM evento WHERE id_tipo_evento = :id_tipo_evento", nativeQuery = true)
	List<Evento> getEventoTipoEvento(int id_tipo_evento);
}
