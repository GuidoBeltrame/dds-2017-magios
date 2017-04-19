package empresas;
import java.util.ArrayList;

import cuentas.Cuenta;

public class Empresa {
	
	private String nombreEmpresa;
	private ArrayList <Cuenta> listaCuentas;
	
	public Empresa(){
		this.listaCuentas = new ArrayList<Cuenta>();
	}
	
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}
	public ArrayList <Cuenta> getListaCuentas() {
		return listaCuentas;
	}
	
	public void setListaCuentas(ArrayList<Cuenta> listaCuentas) {
		this.listaCuentas = listaCuentas;
	}
	
	public void agregarCuentas(Cuenta cuenta) {
		this.getListaCuentas().add(cuenta);
	}
	
	
}
