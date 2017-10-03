package ar.controllers;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.entidades.Indicador;
import ar.repositorio.IndicadoresRepositorio;
import ar.repositorio.Repositorio;

@Controller
public class IndicadoresController {

	private static final String PERSISTENCE_UNIT_NAME = "DB_MAGIOS";
	private EntityManagerFactory emFactory;
	private IndicadoresRepositorio indicadoresRepositorio;
	
	@RequestMapping(value = "/indicadores")
	public ModelAndView indicadores() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("indicadores");

		return mv;
	}
	
	@RequestMapping(value = "/crearIndicador")
	public ModelAndView crearIndicador() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("crearIndicador");

		return mv;
	}
	
	@RequestMapping(value = "/validarIndicador")
	protected ModelAndView validarIndicador(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("crearIndicador");
		
		String nombre = request.getParameter("nombre");
		String formula = request.getParameter("formula");
		
		Indicador indicador = new Indicador();
		indicador.setNombre(nombre);
		indicador.setFormula(formula);
		
		try {
			indicador.validarFormula();
			GuardarIndicador(indicador);
			mv.addObject("ok", "Indicador creado con �xito!");
		}
		catch (ServiceException ex)
		{
			mv.addObject("error", "Error al conectar BD!");	 
		}
		catch (Exception ex)
		{
			mv.addObject("error", "F�rmula no V�lida!");
		}
		
		return mv;
	}
	
	private void GuardarIndicador(Indicador indicador) {
		
		emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		indicadoresRepositorio = new IndicadoresRepositorio(emFactory.createEntityManager());

		indicadoresRepositorio.persistir(indicador);
		
		indicadoresRepositorio.cerrar();
		emFactory.close();
	}
}
