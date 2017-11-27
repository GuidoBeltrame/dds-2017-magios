package ar.controllers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.print.attribute.standard.DateTimeAtCompleted;
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
import ar.entidades.Indicador;
import ar.entidades.IndicadorEmpresa;
import ar.entidades.Balance;
import ar.entidades.Proceso;
import ar.entidades.Reporte;
import ar.repositorio.Repositorio;

@Controller
public class ProcesosController {

	private String PATH_PROCESOS = "C:\\Procesos\\";
	private static final String PERSISTENCE_UNIT_NAME = "DB_MAGIOS";
	private EntityManagerFactory emFactory;
	private Repositorio repositorio;


	public ProcesosController() 
	{
		emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		repositorio = new Repositorio(emFactory.createEntityManager());
	}
	
	@RequestMapping(value = "/cargaCuentas")
	public ModelAndView cargaCuentas() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("cargaCuentas");

		return mv;
	}
	
	@RequestMapping(value = "/guardarProcesoCuentas")
	public ModelAndView guardarProcesoCuentas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		ModelAndView mv = new ModelAndView();
		mv.setViewName("cargaCuentas");
		
		try {
		
			if (request.getParameter("archivo") == "") {
				mv.addObject("error", "Seleccione un Archivo");
				return mv;
			}
			
			Proceso proceso = repositorio.procesos().buscarPorNombre(request.getParameter("archivo"));
			
			if (proceso == null) {
				
				String archivo = PATH_PROCESOS + request.getParameter("archivo");
				
		        String cadena;
		        FileReader file = new FileReader(archivo);
		        BufferedReader buffer = new BufferedReader(file);
		        while((cadena = buffer.readLine())!=null) {
		            
		        	String[] registro = cadena.split(";");
		        	
		        	CargarRegistro(registro);
		        }
		        
		        buffer.close();
		        
		        proceso = new Proceso();
		        proceso.setNombreArchivo(request.getParameter("archivo"));
		        proceso.setFechaDeProceso(new Date());
		        repositorio.procesos().persistir(proceso);
		        
				mv.addObject("ok", "Archivo procesado con éxito!");
			}
			else {
				mv.addObject("ok", "El archivo ya fué procesado");
			}
		}
		catch (ServiceException ex)
		{
			mv.addObject("error", "Error al conectar BD!");	 
		}
		catch (Exception ex)
		{
			mv.addObject("error", "Error al procesar archivo");
		}
		
		return mv;		
	}
	
	private void CargarRegistro(String[] registro) {
		
		Cuenta cuenta = repositorio.cuentas().buscarPorNombre(registro[0]);

		if (cuenta == null) {
	    	cuenta = new Cuenta();
	    	cuenta.setNombre(registro[0]);
	    	cuenta.setIdentificador("c_"+ registro[0].replace(" ", ""));
	    	
	    	repositorio.cuentas().persistir(cuenta);
		}
		
		Empresa empresa = repositorio.empresas().buscarPorNombre(registro[1]);
		
		if (empresa == null) {
	    	empresa = new Empresa();
	    	empresa.setNombre(registro[1]);
	    	
	    	repositorio.empresas().persistir(empresa);
		}

		Balance balance = repositorio.balances().buscarBalance(cuenta.getIdCuenta(), empresa.getIdEmpresa(), Integer.parseInt(registro[2]));
		
		if (balance == null) {
			balance = new Balance();
			balance.setPeriodo(Integer.parseInt(registro[2]));
			balance.setValor(Long.parseLong(registro[3]));
			balance.setCuenta(cuenta);
			balance.setEmpresa(empresa);
			
			repositorio.balances().persistir(balance);
		}
		else {
			if (Long.parseLong(registro[3]) != balance.getValor()) {
				balance.setValor(Long.parseLong(registro[3]));
				repositorio.balances().update(balance);
			}
		}
	}
	
	@RequestMapping(value = "/calculoIndicadores")
	public ModelAndView calculoIndicadores() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("calculoIndicadores");

		return mv;
	}
	
	@RequestMapping(value = "/guardarProcesoCalculoIndicadores")
	public ModelAndView guardarProcesoCalculoIndicadores(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		ModelAndView mv = new ModelAndView();
		mv.setViewName("calculoIndicadores");
		
		try {
		
			int periodo = Integer.parseInt(request.getParameter("anio"));
			
			if (periodo == 0) {
				mv.addObject("error", "Seleccione un Período");
				return mv;
			}
			
			List<Empresa> empresas = repositorio.empresas().getEmpresas();
			List<Indicador> indicadores = repositorio.indicadores().getIndicadores();
			
			for (Indicador ind : indicadores) {

				for (Empresa emp : empresas) {
					
					double resultado = ind.getResultado(emp.getIdEmpresa(), periodo);
					IndicadorEmpresa indicadorEmpresa = repositorio.indicadoresEmpresas().buscarIndicador(ind.getIdIndicador(), emp.getIdEmpresa(), periodo);
					
					if (indicadorEmpresa == null) {

						indicadorEmpresa = new IndicadorEmpresa();
						indicadorEmpresa.setEmpresa(emp);
						indicadorEmpresa.setIndicador(ind);
						indicadorEmpresa.setPeriodo(periodo);
						indicadorEmpresa.setValor(resultado);
						
						repositorio.indicadoresEmpresas().persistir(indicadorEmpresa);					
					}
					else {
						if (resultado != indicadorEmpresa.getValor()) {
							indicadorEmpresa.setValor(resultado);
							repositorio.indicadoresEmpresas().update(indicadorEmpresa);
						}
					}
				}				
			}
			
			mv.addObject("ok", "Proceso finalizado con éxito!");
		}
		catch (ServiceException ex)
		{
			mv.addObject("error", "Error al conectar BD!");	 
		}
		
		return mv;
	}
}
