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

import ar.entidades.Cuenta;
import ar.entidades.Empresa;
import ar.repositorio.EmpresasRepositorio;


@Controller
public class EmpresasController {

	private static final String PERSISTENCE_UNIT_NAME = "DB_MAGIOS";
	private EntityManagerFactory emFactory;
	private EmpresasRepositorio empresasRepositorio;

	public EmpresasController() 
	{
		emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		empresasRepositorio = new EmpresasRepositorio(emFactory.createEntityManager());
	}
	
	@RequestMapping(value = "/empresas")
	public ModelAndView empresas() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("empresas");

		return mv;
	}
	
	@RequestMapping(value = "/crearEmpresa")
	public ModelAndView crearEmpresa() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("crearEmpresa");

		return mv;
	}
	
	@RequestMapping(value = "/validarEmpresa")
	protected ModelAndView validarEmpresa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("crearEmpresa");
		
		String nombre = request.getParameter("nombre");

		Empresa empresa = new Empresa();
		empresa.setNombre(nombre);
		
		try {
			if (!BuscarEmpresa(nombre)) {
				GuardarEmpresa(empresa);
				mv.addObject("ok", "Empresa creada con éxito!");
			}
			else
				mv.addObject("error", "La Empresa ya existe!");			
		}
		catch (ServiceException ex)
		{
			mv.addObject("error", "Error al conectar BD!");	 
		}
		catch (Exception ex)
		{
			mv.addObject("error", "Error al crear Empresa");
		}
		
		return mv;
	}
	
	private void GuardarEmpresa(Empresa empresa) {
		
		empresasRepositorio.persistir(empresa);
		
		//empresasRepositorio.cerrar();
		//emFactory.close();
	}
	
	@RequestMapping(value = { "/empresas" }, method = RequestMethod.GET)
	public ModelAndView getEmpresas() {

	    List<Empresa> lista = empresasRepositorio.getEmpresas();
	    ModelAndView mv = new ModelAndView("empresas");
	    
	    mv.addObject("listaEmpresas", lista);

	    return mv;
	}
	
	private boolean BuscarEmpresa(String nombre) {
		
		Empresa empresa = empresasRepositorio.buscarPorNombre(nombre);

		if (empresa != null)
			return true;
		
		return false;
	}
}
