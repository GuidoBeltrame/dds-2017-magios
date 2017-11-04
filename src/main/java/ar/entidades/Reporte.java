package ar.entidades;

public class Reporte {
	
	private String empresa;
	private String metodologia;
	private int periodo;
	private double resultado;
	
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getMetodologia() {
		return metodologia;
	}
	public void setMetodologia(String metodologia) {
		this.metodologia = metodologia;
	}
	public int getPeriodo() {
		return periodo;
	}
	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}
	public double getResultado() {
		return resultado;
	}
	public void setResultado(double resultado) {
		this.resultado = resultado;
	}
}
