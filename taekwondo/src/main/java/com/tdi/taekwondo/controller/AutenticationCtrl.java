package com.tdi.taekwondo.controller;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.tdi.taekwondo.service.AlumnoServiceImp;
import com.tdi.taekwondo.model.Alumno;
import com.tdi.taekwondo.config.JwtTokenProvider;
import com.tdi.taekwondo.model.AutenticacionBody;
import com.tdi.taekwondo.repository.AlumnoRepository;

@RequestMapping("/auth/alumno")
public class AutenticationCtrl {
	
	@Autowired
	AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;
	
	@Autowired
	AlumnoRepository users;
	
	@Autowired
	AlumnoServiceImp usuarios;
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/login")
	public ResponseEntity login(@RequestBody AutenticacionBody datos) {
		System.out.println(datos);
		try {
			String email = datos.getEmail();
			Alumno usuario = this.users.findByEmail(email);
			
			System.out.println(datos);
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, datos.getPassword()));
			String token = jwtTokenProvider.createToken(email);
			
			Map<Object, Object> modelo = new HashMap<>();
            modelo.put("token", token);
            
			return ok(modelo);
		}catch (AuthenticationException e) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Credenciales inválidas. Verifica la información");
		}		
	}

}