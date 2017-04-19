package empresas;

import java.util.ArrayList;
import java.util.Iterator;

public class RepoEmpresas {

	private static RepoEmpresas repo;
	private ArrayList<Empresa> empresas = new ArrayList<Empresa>();

	private RepoEmpresas() {

	}

	public static RepoEmpresas getInstance() {
		if (repo == null) {
			repo = new RepoEmpresas();
		}
		return repo;
	}

	public void agregarEmpresa(Empresa e) {
		empresas.add(e);

	}

	public Boolean existe(String nombre) {

		Iterator<Empresa> it = empresas.iterator();
		while (it.hasNext()) {
			Empresa emp = it.next();
			if (emp.getNombreEmpresa().equals(nombre)) {
				return true;
			}

		}

		return false;

	}

}
