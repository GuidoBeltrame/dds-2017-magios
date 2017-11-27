package ar.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.entidades.Empresa;
import ar.entidades.Indicador;
import ar.entidades.Metodologia;
import ar.entidades.Reporte;
import ar.repositorio.EmpresasRepositorio;
import ar.repositorio.MetodologiasRepositorio;

@Controller
public class MetodologiaController {

	private static final String PERSISTENCE_UNIT_NAME = "DB_MAGIOS";
	private EntityManagerFactory emFactory;
	private MetodologiasRepositorio metodologiasRepositorio;
	private EmpresasRepositorio empresasRepositorio;
	
	public MetodologiaController() 
	{
		emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		metodologiasRepositorio = new MetodologiasRepositorio(emFactory.createEntityManager());
		empresasRepositorio = new EmpresasRepositorio(emFactory.createEntityManager());
	}
	
	@RequestMapping(value = "/metodologias")
	public ModelAndView metodologias() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("metodologias");

		return mv;
	}
	
	@RequestMapping(value = "/crearMetodologia")
	public ModelAndView crearMetodologia() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("crearMetodologia");

		return mv;
	}
	
	@RequestMapping(value = "/validarMetodologia")
	protected ModelAndView validarMetodologia(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("crearMetodologia");
		
		String nombre = request.getParameter("nombre");
		String formula = request.getParameter("formula");

		Metodologia metodologia = new Metodologia();
		metodologia.setNombre(nombre);
		metodologia.setFormula(formula);
		
		try {
			//metodologia.validarFormula();
			GuardarMetodologia(metodologia);
			mv.addObject("ok", "Metodología creada con éxito!");
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
	
	private void GuardarMetodologia(Metodologia metodologia) {
		
		//emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		//metodologiasRepositorio = new MetodologiasRepositorio(emFactory.createEntityManager());
		
		metodologiasRepositorio.persistir(metodologia);
		
		//metodologiasRepositorio.cerrar();
		//emFactory.close();
	}
	
	@RequestMapping(value = { "/metodologias" }, method = RequestMethod.GET)
	public ModelAndView getMetodologias() {

	    List<Metodologia> lista = metodologiasRepositorio.getMetodologias();
	    ModelAndView mv = new ModelAndView("metodologias");
	    
	    mv.addObject("listaMetodologias", lista);

	    return mv;
	}
	
	@RequestMapping(value = "/aplicarMetodologia")
	public ModelAndView aplicarMetodologia() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("aplicarMetodologia");
		
		List<Metodologia> listaMetodologias = metodologiasRepositorio.getMetodologias();
		mv.addObject("listaMetodologias", listaMetodologias);
		List<Empresa> listaEmpresas = empresasRepositorio.getEmpresas();
		mv.addObject("listaEmpresas", listaEmpresas);
		
		return mv;
	}
	
	@RequestMapping(value = "/aplicacionMetodologia")
	protected ModelAndView aplicacionMetodologia(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idMetodologia = request.getParameter("metodologia");
		String[] empresas = request.getParameterValues("empresas");
		int periodo = Integer.parseInt(request.getParameter("anio"));

		Metodologia metodologia = metodologiasRepositorio.buscarPorId((Long.parseLong(idMetodologia)));

		Indicador indicador = new Indicador();
		indicador.setFormula(metodologia.getFormula());
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("mostrarReporte");
		
		List<Reporte> listaReporte = new ArrayList<Reporte>();
		
		for (int i = 0; i < empresas.length; i++)
		{
			Empresa empresa = empresasRepositorio.buscarPorId((Long.parseLong(empresas[i])));			
			double resultado = indicador.getResultado(Long.parseLong(empresas[i]), 2016);

			Reporte reporte = new Reporte();
			reporte.setEmpresa(empresa.getNombre());
			reporte.setMetodologia(metodologia.getNombre());
			reporte.setPeriodo(periodo);
			reporte.setResultado(resultado);
			
			listaReporte.add(reporte);
		}
		
		mv.addObject("listaReporte", listaReporte);

		return mv;
	}
}
