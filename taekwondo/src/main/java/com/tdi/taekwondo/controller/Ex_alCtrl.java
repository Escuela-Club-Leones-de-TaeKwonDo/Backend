package com.tdi.taekwondo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tdi.taekwondo.service.Ex_alService;
import com.tdi.taekwondo.model.Ex_al;

@RestController
public class Ex_alCtrl {
	@Autowired
	private Ex_alService ex_alService;
	
	@GetMapping("/ex_al")
	public List<Ex_al> getAlumnosEx(){
		return ex_alService.getAlumnosEx();
	}
	
}
