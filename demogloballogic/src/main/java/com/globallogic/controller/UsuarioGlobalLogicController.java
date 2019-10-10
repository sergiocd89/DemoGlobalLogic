package com.globallogic.controller;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

@RestController
@RequestMapping(path = "/usuario/globalLogic")
public class UsuarioGlobalLogicController {

	@Autowired
	UsuarioGlobalLogicService usuarioGlobalLogicService;

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
			String respuestaValidacion = validarDataCreacion(request);
			System.out.println("***** [DemoGlobalLogicController] crearUsuario respuestaValidacion ["+ respuestaValidacion+"]");
			if (respuestaValidacion.equals("OK")) {
				response = usuarioGlobalLogicService.crearUsuario(request);
				return response;
			}
			else {
				response.setMensaje(respuestaValidacion);
				return response;
			}
		} 
		catch (Exception ex) {
			System.out.println("***** [DemoGlobalLogicController] crearUsuario ex ["+ ex.getMessage() + "]");
			response.setMensaje("Excepcion " + ex.getMessage());
			return response;
		}
	}

	/*
	 * Metodo Encargado de la consulta de un usuario
	 * */
	@GetMapping("/{id}")
	public @ResponseBody UsuarioResponse consultarUsuario(@PathVariable("id") String id) throws Exception {
		System.out.println("***** [DemoGlobalLogicController] consultarUsuario [INICIO] request["+id+"]");
		UsuarioResponse response = new UsuarioResponse();
		try {
			String respuestaValidacion = validarDataConsulta(id);
			System.out.println("***** [DemoGlobalLogicController] consultarUsuario respuestaValidacion ["+ respuestaValidacion+"]");
			if (respuestaValidacion.equals("OK")) {
				response = usuarioGlobalLogicService.consultaUsuario(UUID.fromString(id));
				return response;
			}
			else {
				response.setMensaje(respuestaValidacion);
				return response;
			}
		} 
		catch (Exception ex) {
			System.out.println("***** [DemoGlobalLogicController] consultarUsuario ex ["+ ex.getMessage() + "]");
			response.setMensaje("Excepcion " + ex.getMessage());
			return response;
		}
	}

	/*
	 * Metodo encargado de la validacion de datos enviados en la creacion de usuarios
	 * */
	public String validarDataCreacion(UsuarioRequest request) {
		boolean respuestaValidaCorreo = validarCorreo(request.getEmail());
		if (respuestaValidaCorreo == false) {
			return "Formato de correo Incorrecto";
		}
		boolean respuestaValidaContrasenia = validarContrasenia(request.getPassword());
		if (respuestaValidaContrasenia == false) {
			return "Contrasenia no cumple los requisitos minimos (Una Mayuscula, letras minusculas, y dos numeros)";
		}
		return "OK";
	}

	/*
	 * Validacion de correo con patron
	 * https://cesarg.cl/validacion-email-java/
	 * */
	public boolean validarCorreo(String mail) {
		Pattern pattern = Pattern.compile("^([0-9a-zA-Z]+[-._+&])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$");
		Matcher matcher = pattern.matcher(mail);
		return matcher.matches();
	}

	/*
	 * La contrasenia debe tener al entre 8 y 16 caracteres, al menos un digito, al menos una minuscula y al menos una mayuscula.
	 * http://w3.unpocodetodo.info/utiles/regex-ejemplos.php?type=psw
	 * */
	public boolean validarContrasenia(String contrasenia) {
		Pattern pattern = Pattern.compile("^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{8,16}$");
		Matcher matcher = pattern.matcher(contrasenia);
		return matcher.matches();
	}

	/*
	 * Metodo encargado de la validacion de datos enviados en la consulta de usuarios
	 * */
	public String validarDataConsulta(String id) {
		if (id == null) {
			return "No existe Id";
		}
		return "OK";
	}
}