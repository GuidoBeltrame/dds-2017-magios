package ar.indicadores;

import java.util.ArrayList;

public class RepoIndicadores {

	private static RepoIndicadores repo;
	private ArrayList<Indicador> indicadores;

	private RepoIndicadores() {

		indicadores = new ArrayList<Indicador>();

	}

	public static RepoIndicadores getInstance() {

		if (repo == null) {

			repo = new RepoIndicadores();

		}

		return repo;

	}

	public void agregarIndicador(Indicador ind) {

		indicadores.add(ind);

	}

	public void quitarIndicador(Indicador ind) {

		indicadores.remove(ind);
	}

}
