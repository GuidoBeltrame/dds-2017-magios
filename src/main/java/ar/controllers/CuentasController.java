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
import ar.repositorio.CuentasRepositorio;

@Controller
public class CuentasController {

	private static final String PERSISTENCE_UNIT_NAME = "DB_MAGIOS";
	private EntityManagerFactory emFactory;
	private CuentasRepositorio cuentasRepositorio;

	public CuentasController() 
	{
		emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		cuentasRepositorio = new CuentasRepositorio(emFactory.createEntityManager());
	}
	
	@RequestMapping(value = "/cuentas")
	public ModelAndView cuentas() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("cuentas");

		return mv;
	}
	
	@RequestMapping(value = "/crearCuenta")
	public ModelAndView crearCuenta() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("crearCuenta");

		return mv;
	}
	
	@RequestMapping(value = "/validarCuenta")
	protected ModelAndView validarCuenta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("crearCuenta");
		
		String nombre = request.getParameter("nombre");

		Cuenta cuenta = new Cuenta();
		cuenta.setNombre(nombre);
		
		try {
			if (!BuscarCuenta(nombre)) {
				GuardarCuenta(cuenta);
				mv.addObject("ok", "Cuenta creada con éxito!");
			}
			else
				mv.addObject("error", "La Cuenta ya existe!");			
		}
		catch (ServiceException ex)
		{
			mv.addObject("error", "Error al conectar BD!");	 
		}
		catch (Exception ex)
		{
			mv.addObject("error", "Error al crear Cuenta");
		}
		
		return mv;
	}
	
	private void GuardarCuenta(Cuenta cuenta) {
		
		cuentasRepositorio.persistir(cuenta);
		
		//cuentasRepositorio.cerrar();
		//emFactory.close();
	}
	
	@RequestMapping(value = { "/cuentas" }, method = RequestMethod.GET)
	public ModelAndView getCuentas() {

	    List<Cuenta> lista = cuentasRepositorio.getCuentas();
	    ModelAndView mv = new ModelAndView("cuentas");
	    
	    mv.addObject("listaCuentas", lista);

	    return mv;
	}
	
	private boolean BuscarCuenta(String nombre) {
		
		Cuenta cuenta = cuentasRepositorio.buscarPorNombre(nombre);

		if (cuenta != null)
			return true;
		
		return false;
	}
}
