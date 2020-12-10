package com.tdi.taekwondo.service;


import org.springframework.security.core.userdetails.UserDetails;

public interface AdministradorService {

	public abstract UserDetails loadUserByUsername(String email);
}
