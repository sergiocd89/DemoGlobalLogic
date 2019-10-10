package com.globallogic.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIO")
public class UsuarioRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4019338438013692100L;

	/**
	 * id del usuario
	 * https://vladmihalcea.com/hibernate-and-uuid-identifiers/
	 */	
	@Id
	@GeneratedValue
	@Column(name = "ID", columnDefinition = "BINARY(16)")
	private UUID id;

	/**
	 * nombre del usuario
	 */	
	@Column(name = "NAME")
	private String name;

	/**
	 * email del usuario
	 */	
	@Column(name = "EMAIL")
	private String email;

	/**
	 * password del usuario
	 */	
	@Column(name = "PASSWORD")
	private String password;

	/**
	 * fecha creacion
	 */	
	@Column(name = "CREACION")
	private String created;

	/**
	 * fecha ultima modificacion
	 */	
	@Column(name = "ULTIMAMODIFICACION")
	private String modified;

	/**
	 * fecha ultima autenticacion
	 */	
	@Column(name = "ULTIMAMAAUTENTICACION")
	private String lastLogin;

	/**
	 * token
	 */	
	@GeneratedValue
	@Column(name = "TOKEN", columnDefinition = "BINARY(16)")
	private UUID token;

	/**
	 * indicador si usuario está activo
	 */	
	@Column(name = "ESACTIVO")
	private String isActive;

	/**
	 * telefonos del usuario
	 */	
	private ArrayList<UsuarioPhoneRequest> phones;

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

	public List<UsuarioPhoneRequest> getPhones() {
		return phones;
	}

	public void setPhones(ArrayList<UsuarioPhoneRequest> phones) {
		this.phones = phones;
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
		+ "] email [" + getEmail() 
		+ "] password [" + getPassword() 
		+ "] created [" + getCreated() 
		+ "] modified [" + getModified() 
		+ "] lastLogin [" + getLastLogin() 
		+ "] token [" + getToken() 
		+ "] isActive [" + getIsActive() 
		+ "] phones[" + getPhones().toString() 
		+ "] mensaje [" + getMensaje() + "]";
	}
}
