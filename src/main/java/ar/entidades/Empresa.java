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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EMPRESA")
public class Empresa implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEmpresa;
	private String nombre;

	@OneToMany(mappedBy = "empresa")
	private Set<Balance> balances;
	
	@OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
	private Set<IndicadorEmpresa> indicadoresEmpresas;
	
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
	
	public Set<Balance> getBalances() {
		return balances;
	}

	public void setBalances(Set<Balance> balances) {
		this.balances = balances;
	}

	public Set<IndicadorEmpresa> getIndicadoresEmpresas() {
		return indicadoresEmpresas;
	}

	public void setIndicadoresEmpresas(Set<IndicadorEmpresa> indicadoresEmpresas) {
		this.indicadoresEmpresas = indicadoresEmpresas;
	}

	public void addBalance(Balance balance) {
		if (balances == null) {
			balances = new HashSet<Balance>();
		}
		balances.add(balance);
	}
}