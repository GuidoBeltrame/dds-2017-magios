package ar.indicadores;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;

import ar.indicadores.antlr.FormatoInvalidoErrorListener;
import ar.indicadores.antlr.VisitorExp;
import empresas.Empresa;

@SuppressWarnings("deprecation")
public class IndicadorPropio extends Indicador {

	private String formula;

	public IndicadorPropio(String n, String f) {

		super(n);

		this.formula = f;

		validarFormula();

	}

	@Override
	public double getResultado(Empresa empresa, int anio) {

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
		VisitorExp visitor = new VisitorExp(1L, anio);

		// Obtengo la expresion a partir del visitor

		IExpresion expresion = visitor.visit(tree);

		return expresion.getResultado();
	}

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	private void validarFormula() {

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

}
