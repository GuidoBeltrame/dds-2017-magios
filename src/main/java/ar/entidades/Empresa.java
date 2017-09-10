package ar.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EMPRESA")
public class Empresa implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEmpresa;
	private String nombre;

	@OneToOne(mappedBy = "empresa")
	private Balance balance;
	
	public Empresa() {
	}

	@Column(name = "idEmpresa")
	public Long getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Long id) {
		this.idEmpresa = id;
	}

	@Column(name = "nombre")
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String toString() {
		return getIdEmpresa() + "-" + getNombre();
	}
	
	public Balance getBalance() {
		return balance;
	}

	public void setBalance(Balance balance) {
		this.balance = balance;
	}
}