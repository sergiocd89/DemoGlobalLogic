package com.globallogic.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@JsonInclude(Include.NON_NULL)	
public class UsuarioResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4985859443274823617L;

	/**
	 * id del usuario
	 */	
	private UUID id;

	/**
	 * nombre del usuario
	 */	
	private String name;

	/**
	 * email del usuario
	 */	
	private String email;

	/**
	 * password del usuario
	 */	
	private String password;

	/**
	 * fecha creacion
	 */	
	private String created;

	/**
	 * fecha ultima modificacion
	 */	
	private String modified;

	/**
	 * fecha ultima autenticacion
	 */	
	private String lastLogin;

	/**
	 * token
	 */	
	private UUID token;

	/**
	 * indicador si usuario está activo
	 */	
	private String isActive;

	/**
	 * mensaje respuesta
	 */	
	private String mensaje;	
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getModified() {
		return modified;
	}

	public void setModified(String modified) {
		this.modified = modified;
	}

	public String getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}

	public UUID getToken() {
		return token;
	}

	public void setToken(UUID token) {
		this.token = token;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	@Override
	public String toString() {
		return "id[" + getId() 
		+ "] name [" + getName() 
		+ "] email[" + getEmail() 
		+ "] password[" + getPassword() 
		+ "] created [" + getCreated() 
		+ "] modified [" + getModified() 
		+ "] lastLogin [" + getLastLogin() 
		+ "] token [" + getToken() 
		+ "] isActive [" + getIsActive() 
		+ "] mensaje [" + getMensaje() + "]";
	}
}
