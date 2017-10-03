package ar.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

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
			//request.getSession().setAttribute("UserName", "Pepito Perez");
			mv.setViewName("redirect:menu");
			//response.sendRedirect("hello.jsp");
		
		} else {
			mv.addObject("error", "Usuario o Password incorrecta");
			mv.setViewName("login");
		}
		
		return mv;
	}

	private boolean loguear(String user, String pass) {
		
		if (user.equals(pass))
			return true;
		
		return false;
	}
}
