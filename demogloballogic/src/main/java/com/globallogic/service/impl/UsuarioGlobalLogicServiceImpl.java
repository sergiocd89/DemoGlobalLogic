package com.globallogic.service.impl;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallogic.dao.UsuarioGlobalLogicDAO;
import com.globallogic.model.UsuarioRequest;
import com.globallogic.model.UsuarioResponse;
import com.globallogic.service.UsuarioGlobalLogicService;

/*
 * Clase contenedora de los metodos que invocaran a los del DAO
 * */
@Service
public class UsuarioGlobalLogicServiceImpl implements UsuarioGlobalLogicService {

	@Autowired
	private UsuarioGlobalLogicDAO usuarioGlobalLogicDAO;
	
	@Transactional
	public UsuarioResponse crearUsuario(UsuarioRequest usuario){
		return usuarioGlobalLogicDAO.crearUsuario(usuario);
	}
	
	@Transactional
	public void editarUsuario(UsuarioRequest usuarioRequest){
		usuarioGlobalLogicDAO.editarUsuario(usuarioRequest);
	}

	@Transactional
	public UsuarioResponse eliminarUsuario(UUID usuarioID){
		return usuarioGlobalLogicDAO.eliminarUsuario(usuarioID);
	}

	@Transactional
	public UsuarioResponse consultaUsuario(UUID usuario){
		return usuarioGlobalLogicDAO.consultaUsuario(usuario);
	}
	
	@Transactional
	public List listarUsuario(){
		return usuarioGlobalLogicDAO.listarUsuario();
	}
}