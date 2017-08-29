package ar.indicadores;

import empresas.Empresa;

public class Indicador {

	private String nombre;

	public Indicador(String n) {

		this.nombre = n;

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getResultado(Empresa empresa, int anio) {

		throw new RuntimeException("No se puede utilizar este metdo en una clase Indicador");

	}

}
