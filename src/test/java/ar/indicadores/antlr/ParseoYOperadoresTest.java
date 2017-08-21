package ar.indicadores.antlr;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Assert;
import org.junit.Test;
import ar.indicadores.*;

import java.io.IOException;

public class ParseoYOperadoresTest {

	public static final String INPUT_PATH = "/input.txt";

	@Test
	public void testOperadores() {
		IOperador sumar = new OperadorSUM();

		IExpresion termino1 = new Termino(1);
		IExpresion termino2 = new Termino(4);

		/// pruebo el operador SUM
		Assert.assertEquals(5, sumar.operar(termino1, termino2), 0.01);

		IExpresion expresionAuxiliar = new ExpresionCompuesta(termino1, termino2, sumar);
		IExpresion expresionFinal = new ExpresionCompuesta(expresionAuxiliar, new Termino(5), sumar);

		// pruebo expresiones compuestas
		Assert.assertEquals(10, expresionFinal.getResultado(), 0.01);
	}

	@Test
	public void testGramatica() throws IOException {

		String file = this.getInputFilePath();

		// ---- Esto es para evaluar una gramatica y crear expresiones
		IndicadoresLexer lexer = new IndicadoresLexer(new ANTLRFileStream(file));
		
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		IndicadoresParser parser = new IndicadoresParser(tokens);

		// IndicadoresParser.ListaIndicadoresContext indicadorContext =
		// parser.listaIndicadores();
		// IndicadoresParser.IndicadorContext indicadorContext =
		// parser.indicador();
		// for(int i = 0; i < indicadorContext.getChildCount(); i++) {
		//
		// ParseTree child = indicadorContext.getChild(i);
		//
		// String nombre = child.getText().split("=")[0];
		// String formula = child.getText().split("=")[1];
		// System.out.printf("indicador: %s = %s", nombre, formula);
		// }

		//Indicador indicador = new Indicador();		
		ParseTree tree = parser.indicador();

		// VisitorResult visitor = new VisitorResult();
		// double resultado = visitor.visit(tree);

		VisitorExp visitor = new VisitorExp();
		IExpresion expresion = visitor.visit(tree);

		Assert.assertEquals(8, expresion.getResultado(), 0.01);
		
		//indicador.setNombre(tree.getChild(0).getText());
		//indicador.setFormula(tree.getChild(2).getText());
		//indicador.setValor(expresion.getResultado());
	}

	@Test
	public void testGramaticaError() throws IOException {

		IndicadoresLexer lexer = new IndicadoresLexer(new ANTLRInputStream("1 -* 6 * (4 + -5) + 2 * 7"));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		IndicadoresParser parser = new IndicadoresParser(tokens);

		final FormatoInvalidoErrorListener errorListener = new FormatoInvalidoErrorListener();

		lexer.addErrorListener(errorListener);										 
		parser.addErrorListener(errorListener);

		try {
			ParseTree tree = parser.indicador();

			if (!errorListener.getErrorMessage().isEmpty()) {
				throw new ParseCancellationException(errorListener.getErrorMessage());
			}
		}
		catch (ParseCancellationException  e) {
			System.err.printf("ERROR: %s\n", errorListener.getErrorMessage());
		}
	}

	private String getInputFilePath() {
		return this.getClass().getResource(INPUT_PATH).getPath();
	}
}
