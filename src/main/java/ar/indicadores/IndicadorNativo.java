package ar.indicadores;

import empresas.Empresa;

public class IndicadorNativo extends Indicador {

	private double valor;

	public IndicadorNativo(String n, double valor) {

		super(n);

		this.valor = valor;

	}

	@Override
	public double getResultado(Empresa emp, int anio) {

		return valor;
	}

}
