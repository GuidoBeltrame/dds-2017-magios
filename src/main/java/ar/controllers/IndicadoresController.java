package ar.controllers;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.entidades.Indicador;
import ar.repositorio.IndicadoresRepositorio;

@Controller
public class IndicadoresController {

	private static final String PERSISTENCE_UNIT_NAME = "DB_MAGIOS";
	private EntityManagerFactory emFactory;
	private IndicadoresRepositorio indicadoresRepositorio;
	
	public IndicadoresController() 
	{
		emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		indicadoresRepositorio = new IndicadoresRepositorio(emFactory.createEntityManager());
	}
	
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
		
		//Concateno i_ y elimino los espacios
		String identificador = "i_"+ nombre.replace(" ", "");

		Indicador indicador = new Indicador();
		indicador.setNombre(nombre);
		indicador.setFormula(formula);
		indicador.setIdentificador(identificador);
		
		try {
			indicador.validarFormula();
			GuardarIndicador(indicador);
			mv.addObject("ok", "Indicador creado con éxito!");
		}
		catch (ServiceException ex)
		{
			mv.addObject("error", "Error al conectar BD!");	 
		}
		catch (Exception ex)
		{
			mv.addObject("error", "Fórmula no Válida!");
		}
		
		return mv;
	}
	
	private void GuardarIndicador(Indicador indicador) {
		
		//emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		//indicadoresRepositorio = new IndicadoresRepositorio(emFactory.createEntityManager());
		
		indicadoresRepositorio.persistir(indicador);
		
		//indicadoresRepositorio.cerrar();
		//emFactory.close();
	}
	
	@RequestMapping(value = { "/indicadores" }, method = RequestMethod.GET)
	public ModelAndView getIndicadores() {

	    List<Indicador> lista = indicadoresRepositorio.getIndicadores();
	    ModelAndView mv = new ModelAndView("indicadores");
	    
	    mv.addObject("listaIndicadores", lista);

	    return mv;
	}
}
