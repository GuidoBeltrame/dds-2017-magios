package ar.indicadores.antlr;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class FormatoInvalidoErrorListener extends BaseErrorListener {

	public FormatoInvalidoErrorListener() {
	}

	private StringBuilder errorMessage = new StringBuilder();

	public String getErrorMessage() {
		return errorMessage.toString();
	}

	@Override
	public void syntaxError(Recognizer recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg,
			RecognitionException e) {
		
		msg = msg.replaceAll("extraneous input", "entrada extraña");
		msg = msg.replaceAll("expecting", "se esperaba");
		errorMessage = new StringBuilder("");
		errorMessage.append("Linea " + line + ":" + charPositionInLine + " " + msg);
		errorMessage.append(msg);
	}
}
