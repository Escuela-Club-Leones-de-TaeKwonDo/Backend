package com.tdi.taekwondo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import javax.persistence.Id;

import com.tdi.taekwondo.model.Ex_al;


public interface Ex_alService {
	public abstract List<Ex_al> getAlumnosEx();
}
