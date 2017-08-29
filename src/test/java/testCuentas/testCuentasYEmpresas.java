package testCuentas;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ar.Balances.Balance;
import cuentas.Cuenta;
import cuentas.RepoCuentas;
import empresas.Empresa;
import empresas.RepoEmpresas;

public class testCuentasYEmpresas {

	RepoCuentas repoCuentas;
	RepoEmpresas repoEmpresas;
	Cuenta ebitda;
	Cuenta ingresoNetoEnOpDiscontinuas;
	Cuenta ingresoNetoEnOpContinuas;
	Cuenta freeCashFlow;
	Empresa pepsico;
	Empresa laSerenisima;
	Balance pepsicoBalance2016;
	Balance laSerenBalance2016;

	@Before
	public void before() {

		// Repositorios
		repoCuentas = RepoCuentas.getInstance();
		repoEmpresas = RepoEmpresas.getInstance();

		// Cuentas
		ebitda = new Cuenta("EBITDA");
		ingresoNetoEnOpDiscontinuas = new Cuenta("Ingreso neto en operaciones Discontinuas");
		ingresoNetoEnOpContinuas = new Cuenta("Ingreso neto en operaciones Continuas");
		freeCashFlow = new Cuenta("Free Cash Flow");

		// Empresas
		pepsico = new Empresa("Pepsico");
		laSerenisima = new Empresa("La Serenisima");

		// Balances
		pepsicoBalance2016 = new Balance(2016, pepsico);
		laSerenBalance2016 = new Balance(2016, laSerenisima);
	}

	@Test
	public void testCantidadDeCuentas() {

		int antes = repoCuentas.cantidadDeCuentas();

		repoCuentas.agregarCuenta(ebitda);

		int despues = repoCuentas.cantidadDeCuentas();

		Assert.assertEquals(antes, 0);
		Assert.assertEquals(despues, 1);

	}

	@Test
	public void testCrearBalanceDeEmpresa() {
		
		

	}

}
