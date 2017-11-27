package ar.entidades;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "INDICADOREMPRESA")
public class IndicadorEmpresa implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idIndicadorEmpresa;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idIndicador", referencedColumnName = "idIndicador")
	private Indicador indicador;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idEmpresa", referencedColumnName = "idEmpresa")
	private Empresa empresa;
	
	private int periodo;
	
	private double valor;

	@Column(name = "idIndicadorEmpresa")
	public Long getIdIndicadorEmpresa() {
		return idIndicadorEmpresa;
	}

	public void setIdIndicadorEmpresa(Long idIndicadorEmpresa) {
		this.idIndicadorEmpresa = idIndicadorEmpresa;
	}

	public Indicador getIndicador() {
		return indicador;
	}

	public void setIndicador(Indicador indicador) {
		this.indicador = indicador;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
}
