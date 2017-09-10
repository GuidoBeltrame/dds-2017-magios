package ar.entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CUENTA")
public class Cuenta implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCuenta;
	private String nombre;
	private long valor;
	private int periodo;

	@OneToMany(mappedBy = "cuenta", cascade = CascadeType.ALL)
	private Set<Balance> balances;
	
	public Cuenta() {
	}

	@Column(name = "idCuenta")
	public Long getIdCuenta() {
		return idCuenta;
	}

	public void setId(Long id) {
		this.idCuenta = id;
	}

	@Column(name = "nombre")
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public long getValor() {
		return valor;
	}

	public void setValor(long valor) {
		this.valor = valor;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}
	
	public String toString() {
		return getIdCuenta() + "-" + getNombre();
	}
	
	public Set<Balance> getBalances() {
		return balances;
	}

	public void setPois(Set<Balance> balances) {
		this.balances = balances;
	}

	public void addBalance(Balance balance) {
		if (balances == null) {
			balances = new HashSet<Balance>();
		}
		balances.add(balance);
	}
}
