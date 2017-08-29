package empresas;

import java.util.ArrayList;

import ar.Balances.Balance;

public class Empresa {

	private String nombreEmpresa;
	private ArrayList<Balance> balances;

	public Empresa(String n) {

		this.nombreEmpresa = n;
		this.balances = new ArrayList<Balance>();
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public ArrayList<Balance> getBalances() {
		return balances;
	}

	public void setBalances(ArrayList<Balance> bals) {
		this.balances = bals;
	}

	public void agregarBalance(Balance bal) {
		this.balances.add(bal);
	}

}
