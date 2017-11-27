package ar.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PROCESO")
public class Proceso implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProceso;
	private String nombreArchivo;
	private Date fechaDeProceso;
	
	@Column(name = "idProceso")
	public Long getIdProceso() {
		return idProceso;
	}
	
	public void setIdProceso(Long idProceso) {
		this.idProceso = idProceso;
	}
	
	@Column(name = "nombreArchivo")
	public String getNombreArchivo() {
		return nombreArchivo;
	}
	
	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
	
	@Column(name = "fechaProceso")
	public Date getFechaDeProceso() {
		return fechaDeProceso;
	}
	
	public void setFechaDeProceso(Date fechaDeProceso) {
		this.fechaDeProceso = fechaDeProceso;
	}
	
}
