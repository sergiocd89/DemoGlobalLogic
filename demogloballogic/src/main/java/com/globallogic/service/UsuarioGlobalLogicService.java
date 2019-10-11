package com.globallogic.service;

import java.util.List;
import java.util.UUID;

import com.globallogic.model.UsuarioRequest;
import com.globallogic.model.UsuarioResponse;

/*
 * Interface 
 * @UsuarioGlobalLogicServiceImpl
 * */
public interface UsuarioGlobalLogicService {
	
	public UsuarioResponse crearUsuario(UsuarioRequest usuario);
	
	public void editarUsuario(UsuarioRequest usuarioRequest);

	public UsuarioResponse eliminarUsuario(UUID usuarioID);

	public UsuarioResponse consultaUsuario(UUID usuario);
	
	public List listarUsuario();
	
}