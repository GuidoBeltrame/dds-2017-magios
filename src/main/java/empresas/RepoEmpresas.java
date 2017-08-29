package empresas;

import java.util.ArrayList;

public class RepoEmpresas {

	private static RepoEmpresas repo;
	private ArrayList<Empresa> empresas;

	private RepoEmpresas() {

		empresas = new ArrayList<Empresa>();

	}

	public static RepoEmpresas getInstance() {

		if (repo == null) {

			repo = new RepoEmpresas();

		}

		return repo;

	}

	public void agregarEmpresa(Empresa emp) {

		empresas.add(emp);

	}

	public void quitarEmpresa(Empresa emp) {

		empresas.remove(emp);
	}

}
