package com.globallogic;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.globallogic.controller.UsuarioGlobalLogicController;
import com.globallogic.model.UsuarioRequest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemogloballogicApplicationTests {

    @Autowired
    private UsuarioGlobalLogicController usuarioGlobalLogicController;
    
	@Test
	public void contextLoads() {
	}

	@Test
	public void validarDataCreacionOK() {
		UsuarioRequest usuarioRequest = new UsuarioRequest();
		usuarioRequest.setEmail("Sergiocd89@gmail.com");
		usuarioRequest.setPassword("asdS12asd");
		String respuesta = usuarioGlobalLogicController.validarDataCreacion(usuarioRequest);
		String respuestaEsperada = "OK";
		assertEquals(respuestaEsperada , respuesta);
	}
	
	@Test
	public void validarDataCreacionNOKMail() {
		UsuarioRequest usuarioRequest = new UsuarioRequest();
		usuarioRequest.setEmail("Sergiocd89");
		usuarioRequest.setPassword("asdS12asd");
		String respuesta = usuarioGlobalLogicController.validarDataCreacion(usuarioRequest);
		String respuestaEsperada = "Formato de correo Incorrecto";
		assertEquals(respuestaEsperada , respuesta);
	}
	
	@Test
	public void validarDataCreacionNOOKPasword() {
		UsuarioRequest usuarioRequest = new UsuarioRequest();
		usuarioRequest.setEmail("Sergiocd89@gmail.com");
		usuarioRequest.setPassword("asd");
		String respuesta = usuarioGlobalLogicController.validarDataCreacion(usuarioRequest);
		String respuestaEsperada = "Contrasenia no cumple los requisitos minimos (Una Mayuscula, letras minusculas, y dos numeros)";
		assertEquals(respuestaEsperada , respuesta);
	}
	
	@Test
	public void validarCorreoOK() {
		String mail ="Sergiocd89@gmail.com";
		boolean respuesta = usuarioGlobalLogicController.validarCorreo(mail);
		boolean respuestaEsperada = true;
		assertEquals(respuesta , respuestaEsperada);
	}
	
	
	@Test
	public void validarCorreoNOK() {
		String mail ="Sergiocd89";
		boolean respuesta = usuarioGlobalLogicController.validarCorreo(mail);
		boolean respuestaEsperada = false;
		assertEquals(respuesta , respuestaEsperada);
	}
	
	@Test
	public void validarContraseniaOK() {
		String password ="asd12asdF";
		boolean respuesta = usuarioGlobalLogicController.validarContrasenia(password);
		boolean respuestaEsperada = true;
		assertEquals(respuesta , respuestaEsperada);
	}
	
	@Test
	public void validarContraseniaNOK() {
		String password ="asdasdF";
		boolean respuesta = usuarioGlobalLogicController.validarContrasenia(password);
		boolean respuestaEsperada = false;
		assertEquals(respuesta , respuestaEsperada);
	}
}
