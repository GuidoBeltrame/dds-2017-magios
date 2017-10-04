package ar.controllers;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.entidades.Usuario;
import ar.repositorio.UsuariosRepositorio;

@Controller
public class LoginController {

	private static final String PERSISTENCE_UNIT_NAME = "DB_MAGIOS";
	private EntityManagerFactory emFactory;
	private UsuariosRepositorio usuariosRepositorio;
	
	public LoginController() 
	{
		emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		usuariosRepositorio = new UsuariosRepositorio(emFactory.createEntityManager());
	}
	
	@RequestMapping(value = "/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");

		return mv;
	}

	@RequestMapping(value = "/validarLogin")
	protected ModelAndView validarLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ModelAndView mv = new ModelAndView();
		
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");

		if (loguear(user, pass)) {
			mv.setViewName("redirect:menu");		
		} else {
			mv.addObject("error", "Usuario o Password incorrecta");
			mv.setViewName("login");
		}
		
		return mv;
	}

	private boolean loguear(String user, String pass) {
		
		Usuario usuario = usuariosRepositorio.buscarUsuarioPorUsername(user);
	
		if (usuario == null || !usuario.getPassword().equals(pass))
			return false;
		
		return true;
	}
}
