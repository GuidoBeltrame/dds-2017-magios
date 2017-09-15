package ar.JPATest;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.Test;

import ar.entidades.Balance;
import ar.entidades.Cuenta;
import ar.entidades.Empresa;
import ar.entidades.Indicador;
import ar.repositorio.Repositorio;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class testJPA {
	private static final String PERSISTENCE_UNIT_NAME = "DB_MAGIOS";
	private EntityManagerFactory emFactory;
	private Repositorio repositorio;

	@Before
	public void setUp() throws Exception {
		emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		repositorio = new Repositorio(emFactory.createEntityManager());
	}

	@Test
	public void aPersistir() {
		Cuenta cuenta = new Cuenta();
		cuenta.setNombre("EBIDTA");
		cuenta.setValor(14870000000L);
		cuenta.setPeriodo(2016);

		repositorio.cuentas().persistir(cuenta);
		
		
		Empresa empresa = new Empresa();
		empresa.setNombre("IBM8");

		repositorio.empresas().persistir(empresa);

		//Empresa empresa2 = repositorio.empresas().buscarPorId(1L);
		
		Indicador indicador = new Indicador();
		indicador.setNombre("Indicador Ejemplo");
		indicador.setFormula("1 * 2 * (4 + -5) + 6 * 7");

		try {
			indicador.validarFormula();
			repositorio.indicadores().persistir(indicador);
		}
		catch (Exception ex)
		{
			System.out.println("Formula no Valida: " + ex.getMessage());	 
		}
			
		Balance balance = new Balance();
		balance.setPeriodo(2016);
		balance.setComuna(cuenta);
		balance.setEmpresa(empresa);
		//balance.setEmpresa(empresa2);
		
		repositorio.balances().persistir(balance);
	}

	@Test
	public void buscarCuentaPorId() {
		Cuenta cuenta = repositorio.cuentas().buscarPorId(1L);
		System.out.println("Cuenta encontrada por ID: " + cuenta.getNombre());
	}

	@After
	public void tearDown() throws Exception {
		repositorio.cerrar();
		emFactory.close();
	}
}
