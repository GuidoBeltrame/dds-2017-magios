package ar.indicadores;

import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import ar.indicadores.antlr.VisitorExp;

@SuppressWarnings("deprecation")
public class Indicador implements IExpresion {

	private String nombre;
	private String formula;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public double getResultado() {

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
		VisitorExp visitor = new VisitorExp();

		// Obtengo la expresion a partir del visitor
		IExpresion expresion = visitor.visit(tree);

		return expresion.getResultado();

	}

}
