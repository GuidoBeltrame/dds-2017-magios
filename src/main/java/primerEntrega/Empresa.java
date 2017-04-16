package primerEntrega;
import java.util.ArrayList;

public class Empresa {
	
	private String nombreEmpresa;
	private ArrayList <Cuenta> listaCuentas;
	
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}
	public ArrayList <Cuenta> getListaCuentas() {
		return listaCuentas;
	}
	public void agregarCuentas(Cuenta cuenta) {
		this.listaCuentas.add(cuenta);
	}
	
	
}
