package ar.indicadores;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;

import ar.indicadores.antlr.FormatoInvalidoErrorListener;

@SuppressWarnings("deprecation")
public class Validador {

	public void validarFormula(String formula) throws Exception {

		IndicadoresLexer lexer = new IndicadoresLexer(new ANTLRInputStream(formula));

		CommonTokenStream tokens = new CommonTokenStream(lexer);

		IndicadoresParser parser = new IndicadoresParser(tokens);

		final FormatoInvalidoErrorListener errorListener = new FormatoInvalidoErrorListener();

		lexer.addErrorListener(errorListener);
		parser.addErrorListener(errorListener);

		ParseTree tree = parser.indicador();

		if (!errorListener.getErrorMessage().isEmpty()) {
			throw new ParseCancellationException(errorListener.getErrorMessage());
		}

	}

}
