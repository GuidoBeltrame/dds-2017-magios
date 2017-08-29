package cuentas;

import java.util.ArrayList;

public class RepoCuentas {

	private static RepoCuentas repo;
	private ArrayList<Cuenta> cuentas;

	private RepoCuentas() {

		cuentas = new ArrayList<Cuenta>();

	}

	public static RepoCuentas getInstance() {

		if (repo == null) {

			repo = new RepoCuentas();

		}

		return repo;

	}

	public void agregarCuenta(Cuenta cuenta) {

		cuentas.add(cuenta);

	}

	public void quitarCuenta(Cuenta cuenta) {

		cuentas.remove(cuenta);
	}

	public ArrayList<Cuenta> getCuentas() {

		return cuentas;
	}

	public int cantidadDeCuentas() {

		return repo.getCuentas().size();
	}

}
