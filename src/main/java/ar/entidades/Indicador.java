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

import ar.indicadores.IExpresion;
import ar.indicadores.IndicadoresLexer;
import ar.indicadores.IndicadoresParser;
import ar.indicadores.antlr.FormatoInvalidoErrorListener;
import ar.indicadores.antlr.VisitorExp;
import empresas.Empresa;

@Entity
@Table(name = "INDICADOR")
public class Indicador implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idIndicador;
	private String nombre;
	private String identificador;
	private String formula;

	public Indicador() {
	}

	@Column(name = "idIndicador")
	public Long getIdIndicador() {
		return idIndicador;
	}

	public void setId(Long id) {
		this.idIndicador = id;
	}

	@Column(name = "nombre")
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "identificador")
	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	
	@Column(name = "formula")
	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}
	
//	public String toString() {
//		return getIdIndicador() + "-" + getNombre();
//	}
	
	public void validarFormula() {

		String formula = this.getFormula();

		IndicadoresLexer lexer = new IndicadoresLexer(new ANTLRInputStream(formula));

		CommonTokenStream tokens = new CommonTokenStream(lexer);

		IndicadoresParser parser = new IndicadoresParser(tokens);

		final FormatoInvalidoErrorListener errorListener = new FormatoInvalidoErrorListener();

		lexer.addErrorListener(errorListener);
		parser.addErrorListener(errorListener);

		@SuppressWarnings("unused")
		ParseTree tree = parser.indicador();

		if (!errorListener.getErrorMessage().isEmpty()) {
			throw new ParseCancellationException(errorListener.getErrorMessage());
		}
	}
	
	public double getResultado(Long codEmpresa, int anio) {

		// Tomo el dato de la formula para calcular
		String form = this.formula;

		// Creo el lexer a partir de la formula
		IndicadoresLexer lexer = new IndicadoresLexer(new ANTLRInputStream(form));

		// Creo los tokens a partir del lexer
		CommonTokenStream tokens = new CommonTokenStream(lexer);

		// Creo el parser a partir de los tokens
		IndicadoresParser parser = new IndicadoresParser(tokens);

		// Creo el arbol para el indicador
		ParseTree tree = parser.indicador();

		// Creo el visitor para recorrer
		VisitorExp visitor = new VisitorExp(codEmpresa, anio);

		// Obtengo la expresion a partir del visitor
		IExpresion expresion = visitor.visit(tree);

		return expresion.getResultado();
	}

}