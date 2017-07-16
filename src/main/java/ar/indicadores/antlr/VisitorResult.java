package ar.indicadores.antlr;

import java.util.HashMap;
import java.util.Map;

import ar.indicadores.*;

public class VisitorResult extends IndicadoresBaseVisitor<Double> {

	private Map<String, IOperador> operadores;
	
	public VisitorResult() {
		super();
		
		this.cargarOperadores();
	}
	
	private void cargarOperadores() {
		IOperador sumar = new OperadorSUM();
		IOperador restar = new OperadorRES();
		IOperador multiplicar = new OperadorMULT();
		IOperador dividir = new OperadorDIV();

		this.operadores = new HashMap<String, IOperador>();
		this.operadores.put(sumar.getSimbolo(), sumar);
		this.operadores.put(restar.getSimbolo(), restar);
		this.operadores.put(multiplicar.getSimbolo(), multiplicar);
		this.operadores.put(dividir.getSimbolo(), dividir);
	}
	
	@Override
	public Double visitIndicador(IndicadoresParser.IndicadorContext ctx) {

		System.out.println(ctx.getText());
		double res = this.visit(ctx.expresion());
		
		return res; 
	}

	@Override
    public Double visitOpExpr(IndicadoresParser.OpExprContext ctx) {
	
		System.out.println(ctx.getText());
		
        double left = visit(ctx.left);
        double right = visit(ctx.right);
        String op = ctx.op.getText();

        switch (op.charAt(0)) {
            case '*': return left * right;
            case '/': return left / right;
            case '+': return left + right;
            case '-': return left - right;
            default: throw new IllegalArgumentException("Unknown operator " + op);
        }
    }
	
	@Override 
	public Double visitNegExpr(IndicadoresParser.NegExprContext ctx) {
		System.out.println(ctx.getText());
		
		return Double.valueOf(ctx.getText());
	}
	
	@Override
    public Double visitParenExpr(IndicadoresParser.ParenExprContext ctx) {
		System.out.println(ctx.getText());
		
        return this.visit(ctx.expresion());
    }
	
	@Override
	public Double visitTermino(IndicadoresParser.TerminoContext ctx) { 
		System.out.println(ctx.getText());

		return Double.valueOf(ctx.getText());
	}
	
	@Override
	public Double visitAtomExpr(IndicadoresParser.AtomExprContext ctx) { 
		System.out.println(ctx.getText());
		
		return Double.valueOf(ctx.getText());
	}
}