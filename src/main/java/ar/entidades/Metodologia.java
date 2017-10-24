package ar.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;

import ar.indicadores.IndicadoresLexer;
import ar.indicadores.IndicadoresParser;
import ar.indicadores.antlr.FormatoInvalidoErrorListener;

@Entity
@Table(name = "METODOLOGIA")
public class Metodologia implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMetodologia;
	private String nombre;
	private String formula;

	public Metodologia() {
	}

	@Column(name = "idMetodologia")
	public Long getIdMetodologia() {
		return idMetodologia;
	}

	public void setId(Long id) {
		this.idMetodologia = id;
	}

	@Column(name = "nombre")
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "formula")
	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}
}
