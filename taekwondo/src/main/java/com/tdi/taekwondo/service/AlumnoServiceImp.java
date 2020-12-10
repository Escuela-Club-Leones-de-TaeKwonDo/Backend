package com.tdi.taekwondo.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tdi.taekwondo.model.Alumno;
import com.tdi.taekwondo.repository.AlumnoRepository;

@Service
public class AlumnoServiceImp implements UserDetailsService, AlumnoService {
	
	@Autowired
	private AlumnoRepository repoAlumno;
	
	@Override
	public List<Alumno> getAlumnos() {
		return repoAlumno.getAlumnos();
	}

	@Override
	public ResponseEntity<Object> getAlumno(int id) {
		return new ResponseEntity<>(repoAlumno.findById(id), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> createAlumno(Alumno alumno) {
		return new ResponseEntity<>(repoAlumno.save(alumno), HttpStatus.OK);
	}

	@Override
	public void updateAlumno(int id, Alumno alumno) {
		repoAlumno.save(alumno);
	}

	@Override
	public void deleteAlumno(int id) {	
		repoAlumno.deleteById(id);
	}
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Alumno alumno = repoAlumno.findByEmail(email);
		// Si existe el alumno
		if(alumno != null) {
			List<GrantedAuthority> authorities = getUserAuthority("alumno");
			return buildUserForAuthentication(alumno, authorities);
		}else {
			throw new UsernameNotFoundException("Nombre de usuariuo no encontrado");
		}
	}
	
	private List<GrantedAuthority> getUserAuthority(String nombre_tipo_usuario) {
		Set<GrantedAuthority> roles = new HashSet<>();
		roles.add(new SimpleGrantedAuthority(nombre_tipo_usuario));
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
		
		return grantedAuthorities;
	}
	
	private UserDetails buildUserForAuthentication(Alumno aluumno, List<GrantedAuthority> authorities) {
		return new org.springframework.security.core.userdetails.User(aluumno.getEmail(), aluumno.getPassword(), authorities);
	}
}
