package ar.Balances;

import java.util.ArrayList;
import cuentas.Cuenta;
import empresas.Empresa;

public class Balance {
	
	private int anio;
	private Empresa empresa;
	private ArrayList<Cuenta> cuentas;
	
	
	
	public Balance(int anio, Empresa emp){
		
		this.anio = anio;
		this.empresa = emp;
		
		// Cuentas
		Cuenta ebitda = new Cuenta("EBITDA");
		Cuenta ingresoNetoEnOpDiscontinuas = new Cuenta("Ingreso neto en operaciones Discontinuas");
		Cuenta ingresoNetoEnOpContinuas = new Cuenta("Ingreso neto en operaciones Continuas");
		Cuenta freeCashFlow = new Cuenta("Free Cash Flow");
		
	}
	
	
	
	
	
}
