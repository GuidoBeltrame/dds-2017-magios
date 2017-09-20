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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BALANCE")
public class Balance implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idBalance;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idCuenta", referencedColumnName = "idCuenta")
	private Cuenta cuenta;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idEmpresa", referencedColumnName = "idEmpresa")
	private Empresa empresa;
	
	private int periodo;
	
	private long valor;
	
	public Balance() {
	}

	@Column(name = "idBalance")
	public Long getIdBalance() {
		return idBalance;
	}

	public void setIdBalance(Long id) {
		this.idBalance = id;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setComuna(Cuenta cuenta) {
		this.cuenta = cuenta;
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

	public long getValor() {
		return valor;
	}

	public void setValor(long valor) {
		this.valor = valor;
	}
}