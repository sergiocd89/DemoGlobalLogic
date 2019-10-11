package com.globallogic.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.model.UsuarioRequest;
import com.globallogic.model.UsuarioResponse;
import com.globallogic.service.UsuarioGlobalLogicService;
import com.globallogic.util.Utilitario;

@RestController
@RequestMapping(path = "/usuario/globalLogic")
public class UsuarioGlobalLogicController {

	@Autowired
	UsuarioGlobalLogicService usuarioGlobalLogicService;

	@Autowired
	Utilitario utilitario;
	
	/*
	 * Metodo Encargado de la creacion de un usuario
	 * */
	@RequestMapping(
			method = RequestMethod.POST,
			path = "/crearUsuario",
			consumes = "application/json",
			produces = "application/json")
	public @ResponseBody UsuarioResponse crearUsuario(@RequestBody UsuarioRequest request) throws Exception {
		System.out.println("***** [DemoGlobalLogicController] crearUsuario [INICIO] request ["+request.toString()+"]");
		UsuarioResponse response = new UsuarioResponse();
		try {
			String respuestaValidacion = utilitario.validarDataCreacion(request);
			System.out.println("***** [DemoGlobalLogicController] crearUsuario respuestaValidacion ["+ respuestaValidacion+"]");
			if (respuestaValidacion.equals("OK")) {
				response = usuarioGlobalLogicService.crearUsuario(request);
				System.out.println("***** [DemoGlobalLogicController] crearUsuario [FIN] response["+response.toString()+"]");
				return response;
			}
			else {
				response.setMensaje(respuestaValidacion);
				System.out.println("***** [DemoGlobalLogicController] crearUsuario [FIN] response["+response.toString()+"]");
				return response;
			}
		} 
		catch (Exception ex) {
			System.out.println("***** [DemoGlobalLogicController] crearUsuario [FIN] ex ["+ ex.getMessage() + "]");
			response.setMensaje("Excepcion " + ex.getMessage());
			return response;
		}
	}

	/*
	 * Metodo Encargado de la consulta de un usuario
	 * */
	@GetMapping(value = "/consultar/{id}",
			produces = "application/json")
	public @ResponseBody UsuarioResponse consultar(@PathVariable(value="id") String idUsurio) throws Exception {
		System.out.println("***** [DemoGlobalLogicController] consultar [INICIO] request["+idUsurio+"]");
		UsuarioResponse response = new UsuarioResponse();
		try {
			String respuestaValidacion = utilitario.validarDataConsulta(idUsurio);
			System.out.println("***** [DemoGlobalLogicController] consultar respuestaValidacion ["+ respuestaValidacion+"]");
			if (respuestaValidacion.equals("OK")) {
				response = usuarioGlobalLogicService.consultaUsuario(UUID.fromString(idUsurio));
				System.out.println("***** [DemoGlobalLogicController] consultar [FIN] response["+response.toString()+"]");
				return response;
			}
			else {
				response.setMensaje(respuestaValidacion);
				System.out.println("***** [DemoGlobalLogicController] consultar [FIN] response["+response.toString()+"]");
				return response;
			}
		} 
		catch (Exception ex) {
			System.out.println("***** [DemoGlobalLogicController] consultar [FIN] ex ["+ ex.getMessage() + "]");
			response.setMensaje("Excepcion " + ex.getMessage());
			return response;
		}
	}

	/*
	 * Metodo Encargado de la eliminacion de un usuario
	 * */
	@GetMapping(value="/eliminar/{id}",
			produces = "application/json")
	public @ResponseBody UsuarioResponse eliminar(@PathVariable(value="id") String idUsurio)  throws Exception {
		System.out.println("***** [DemoGlobalLogicController] eliminar [INICIO]");
		UsuarioResponse response = new UsuarioResponse();
		try {
			String respuestaValidacion = utilitario.validarDataConsulta(idUsurio);
			System.out.println("***** [DemoGlobalLogicController] eliminar respuestaValidacion ["+ respuestaValidacion+"]");
			if (respuestaValidacion.equals("OK")) {
				response = usuarioGlobalLogicService.eliminarUsuario(UUID.fromString(idUsurio));
				System.out.println("***** [DemoGlobalLogicController] eliminar [FIN] response["+response.toString()+"]");
				return response;
			}
			else {
				response.setMensaje(respuestaValidacion);
				System.out.println("***** [DemoGlobalLogicController] eliminar [FIN] response["+response.toString()+"]");
				return response;
			}
		} 
		catch (Exception ex) {
			System.out.println("***** [DemoGlobalLogicController] eliminar [FIN] ex ["+ ex.getMessage() + "]");
			response.setMensaje("Excepcion " + ex.getMessage());
			return response;
		}
	}

	/*
	 * Metodo Encargado de listar los usuarios
	 * */
	@GetMapping(value = "/lista",
			produces = "application/json")
	public @ResponseBody List<UsuarioResponse> listar()  throws Exception{
		System.out.println("***** [DemoGlobalLogicController] listar [INICIO]");
		List<UsuarioResponse> responseLista = new ArrayList<UsuarioResponse>();
		try {
			responseLista = usuarioGlobalLogicService.listarUsuario();
			System.out.println("***** [DemoGlobalLogicController] listar [FIN] response["+responseLista.toString()+"]");
			return responseLista;
		} 
		catch (Exception ex) {
			System.out.println("***** [DemoGlobalLogicController] listar [FIN] ex ["+ ex.getMessage() + "]");
			UsuarioResponse response = new UsuarioResponse();
			response.setMensaje("Excepcion " + ex.getMessage());
			responseLista.add(response);
			return responseLista;
		}
	}
}