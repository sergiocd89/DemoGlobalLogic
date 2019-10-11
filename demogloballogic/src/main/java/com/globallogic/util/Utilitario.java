package com.globallogic.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.globallogic.model.UsuarioRequest;

@Component
public class Utilitario {

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
