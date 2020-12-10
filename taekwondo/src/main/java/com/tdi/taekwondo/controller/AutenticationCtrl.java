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
import org.springframework.web.bind.annotation.RestController;

import com.tdi.taekwondo.service.AlumnoServiceImp;
import com.tdi.taekwondo.model.Administrador;
import com.tdi.taekwondo.model.Alumno;
import com.tdi.taekwondo.config.JwtTokenProvider;
import com.tdi.taekwondo.model.AutenticacionBody;
import com.tdi.taekwondo.repository.AdministratorRepository;
import com.tdi.taekwondo.repository.AlumnoRepository;

@RestController
public class AutenticationCtrl {
	
	@Autowired
	AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;
	
	@Autowired
	AlumnoRepository users;
	
	@Autowired
	AdministratorRepository adminRep;
	
	@Autowired
	AlumnoServiceImp usuarios;
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/auth/alumno/login")
	public ResponseEntity login(@RequestBody AutenticacionBody datos) {
		try {
			String email = datos.getEmail();
			
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
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/auth/admin/login")
	public ResponseEntity loginAdmin(@RequestBody AutenticacionBody datos) {
		try {
			
			String email = datos.getEmail();
			System.out.println(email);
			Administrador usuario = this.adminRep.findByEmail(email);
			System.out.println(usuario.getPassword());
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, datos.getPassword()));
			System.out.println(email);
			System.out.println(datos.getPassword());
			System.out.println("System.out.println(datos.getPassword());");
			String token = jwtTokenProvider.createToken(email);


			Map<Object, Object> modelo = new HashMap<>();
            modelo.put("token", token);
            
			return ok(modelo);
		}catch (AuthenticationException e) {
			System.out.println(e);
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Credenciales inválidas. Verifica la información");
		}		
	}

}
