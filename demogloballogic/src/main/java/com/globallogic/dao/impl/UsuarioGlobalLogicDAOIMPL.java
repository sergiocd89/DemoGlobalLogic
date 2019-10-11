package com.globallogic.dao.impl;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import com.globallogic.dao.UsuarioGlobalLogicDAO;
import com.globallogic.model.UsuarioRequest;
import com.globallogic.model.UsuarioResponse;

@Component
public class UsuarioGlobalLogicDAOIMPL implements UsuarioGlobalLogicDAO {

	/*
	 * Metodo Encargado de la creacion de un usuario
	 * */
	public UsuarioResponse crearUsuario(UsuarioRequest usuario){
		System.out.println("***** [UsuarioGlobalLogicDAOIMPL] crearUsuario [INICIO] usuario["+usuario.toString()+"]");
		UsuarioResponse response = new UsuarioResponse();
		SessionFactory sessionFactory = buildSessionFactory(UsuarioRequest.class);
		Session session = sessionFactory.openSession();
		try {
			if (existeMail(usuario)) {
				response.setMensaje("El correo ya esta registrado");
				return response;
			}
			else {
				Date fecha = new Date();
				DateFormat formatoFechaHora = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
				String fechaFormateada = formatoFechaHora.format(fecha);

				usuario.setCreated(fechaFormateada);
				usuario.setModified(fechaFormateada);
				usuario.setLastLogin(fechaFormateada);
				usuario.setToken(UUID.randomUUID());
				usuario.setIsActive("Activo");
				Serializable resultado = session.save(usuario);
				System.out.println("***** [UsuarioGlobalLogicDAOIMPL] crearUsuario resultado["+resultado+"]");

				UsuarioRequest saveUsuario = session.get(UsuarioRequest.class, resultado);

				System.out.println("***** [UsuarioGlobalLogicDAOIMPL] crearUsuario saveUsuario["+saveUsuario.toString()+"]");

				response.setId(saveUsuario.getId());
				response.setCreated(saveUsuario.getCreated());
				response.setModified(saveUsuario.getModified());
				response.setLastLogin(saveUsuario.getLastLogin());
				response.setToken(saveUsuario.getToken());
				response.setIsActive(saveUsuario.getIsActive());
				response.setMensaje("Registro creado correctamente");
			}
		} 
		catch (Exception e) {
			System.out.println("***** ex ["+ e.getMessage() + "]");
			response.setMensaje("Excepcion " + e.getMessage());
		}
		session.close();
		sessionFactory.close();
		System.out.println("***** [UsuarioGlobalLogicDAOIMPL] crearUsuario [FIN] response["+response.toString()+"]");
		return response;
	}

	/*
	 * Metodo Encargado de la consulta de un usuario
	 * */
	public UsuarioResponse consultaUsuario(UUID usuario){
		System.out.println("***** [UsuarioGlobalLogicDAOIMPL] consultaUsuario [INICIO] usuario["+usuario+"]");
		UsuarioResponse response = new UsuarioResponse();
		SessionFactory sessionFactory = buildSessionFactory(UsuarioRequest.class);
		Session session = sessionFactory.openSession();
		try {
			UsuarioRequest saveUsuario = session.get(UsuarioRequest.class, usuario);

			System.out.println("***** [UsuarioGlobalLogicDAOIMPL] consultaUsuario saveUsuario["+saveUsuario.toString()+"]");

			response.setId(saveUsuario.getId());
			response.setName(saveUsuario.getName());
			response.setPassword(saveUsuario.getPassword());
			response.setEmail(saveUsuario.getEmail());
			response.setCreated(saveUsuario.getCreated());
			response.setModified(saveUsuario.getModified());
			response.setLastLogin(saveUsuario.getLastLogin());
			response.setToken(saveUsuario.getToken());
			response.setIsActive(saveUsuario.getIsActive());
			response.setMensaje("Consulta realizada correctamente");
		} 
		catch (Exception e) {
			System.out.println("***** ex ["+ e.getMessage() + "]");
			response.setMensaje("Excepcion " + e.getMessage());
		}
		session.close();
		sessionFactory.close();
		System.out.println("***** [UsuarioGlobalLogicDAOIMPL] consultaUsuario [FIN] response["+response.toString()+"]");
		return response;
	}

	/*
	 * Metodo Encargado de la actualizacion de un usuario
	 * */
	@Override
	public void editarUsuario(UsuarioRequest usuarioRequest) {
		// TODO Auto-generated method stub

	}

	/*
	 * Metodo Encargado de la eliminacion de un usuario
	 * */
	@Override
	public UsuarioResponse eliminarUsuario(UUID usuarioID) {
		UsuarioResponse response = new UsuarioResponse();
		response.setMensaje("Eliminacion realizada con exito");
		return response;
	}

	/*
	 * Metodo Encargado de listar todos los usuarios
	 * */
	@Override
	public List listarUsuario() {
		List<UsuarioResponse> responseLista = new ArrayList<UsuarioResponse>();
		return responseLista;
	}

	/*
	 * Metodo Encargado de la existencia de un usuario
	 * */
	public boolean existeMail(UsuarioRequest usuario){
		System.out.println("***** [UsuarioGlobalLogicDAOIMPL] existeUsuario [INICIO] usuario["+usuario.toString()+"]");
		SessionFactory sessionFactory = buildSessionFactory(UsuarioRequest.class);
		Session session = sessionFactory.openSession();
		try {
			UsuarioRequest resultado = session.find(UsuarioRequest.class, usuario.getEmail());
			System.out.println("***** [UsuarioGlobalLogicDAOIMPL] consultaUsuario resultado["+resultado+"]");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		boolean respuesta = false;
		session.close();
		sessionFactory.close();
		System.out.println("***** [UsuarioGlobalLogicDAOIMPL] existeUsuario [FIN] respuesta["+respuesta+"]");
		return respuesta;
	}
	
	/*
	 * Metodo Encargado de la creacion de la session
	 * 
	 * https://www.youtube.com/watch?v=MA4tM17H6_M
	 * */
	private static SessionFactory buildSessionFactory(Class<UsuarioRequest> clase) {
		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(clase).buildSessionFactory();
		return sessionFactory;
	}
}