package com.tdi.taekwondo.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.tdi.taekwondo.model.Administrador;
import com.tdi.taekwondo.repository.AdministratorRepository;

public class AdministradorServiceImp implements UserDetailsService, AdministradorService{

	@Autowired
	private AdministratorRepository adminRep;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Administrador admin = adminRep.findByEmail(email);
		if(admin != null) {
			List<GrantedAuthority> authorities = getUserAuthority("administrador");
			return buildUserForAuthentication(admin, authorities);
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
	
	private UserDetails buildUserForAuthentication(Administrador admin, List<GrantedAuthority> authorities) {
		System.out.println("$$$$$$$$$$$$$$$$$");

		return new org.springframework.security.core.userdetails.User(admin.getEmail(), admin.getPassword(), authorities);
	}
}
