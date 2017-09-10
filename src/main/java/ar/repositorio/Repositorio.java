package ar.repositorio;

import javax.persistence.EntityManager;

public class Repositorio {

	protected EntityManager em;
	private CuentasRepositorio cuentas;
	private IndicadoresRepositorio indicadores;
	private EmpresasRepositorio empresas;
	private BalancesRepositorio balances;
	
	public Repositorio(EntityManager em) {
		this.em = em;
	}
	
	public CuentasRepositorio cuentas() {
		if (cuentas == null) {
			cuentas = new CuentasRepositorio(em);
		}
		
		return cuentas;
	}
	
	public IndicadoresRepositorio indicadores() {
		if (indicadores == null) {
			indicadores = new IndicadoresRepositorio(em);
		}
		
		return indicadores;
	}
	
	public EmpresasRepositorio empresas() {
		if (empresas == null) {
			empresas = new EmpresasRepositorio(em);
		}
		
		return empresas;
	}
	
	public BalancesRepositorio balances() {
		if (balances == null) {
			balances = new BalancesRepositorio(em);
		}
		
		return balances;
	}
	
	public void cerrar() {
		em.close();
	}
}
