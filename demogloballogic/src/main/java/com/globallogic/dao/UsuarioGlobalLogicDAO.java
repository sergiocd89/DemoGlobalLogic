package com.globallogic.dao;

import java.util.List;
import java.util.UUID;

import com.globallogic.model.UsuarioRequest;
import com.globallogic.model.UsuarioResponse;

/*
 * Interface 
 * @UsuarioGlobalLogicDAOIMPL
 * */
public interface UsuarioGlobalLogicDAO {
	
	public UsuarioResponse crearUsuario(UsuarioRequest usuario);
	
	public void editarUsuario(UsuarioRequest usuarioRequest);

	public void eliminarUsuario(UUID usuarioID);

	public UsuarioResponse consultaUsuario(UUID usuario);
	
	public List listarUsuario();
	
}