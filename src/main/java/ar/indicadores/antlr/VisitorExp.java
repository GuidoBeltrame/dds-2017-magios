package ar.indicadores.antlr;

import java.util.HashMap;
import java.util.Map;

import ar.indicadores.*;

public class VisitorExp extends IndicadoresBaseVisitor<IExpresion> {

	private Map<String, IOperador> operadores;
	private IExpresion expresionActual;

	public VisitorExp() {

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
	public IExpresion visitIndicador(IndicadoresParser.IndicadorContext ctx) {

		System.out.println(ctx.getText());
		
		this.expresionActual = this.visit(ctx.expresion());
		
		return this.expresionActual; 
	}

	@Override
    public IExpresion visitOpExpr(IndicadoresParser.OpExprContext ctx) {
		
		System.out.println(ctx.getText());
		
		IExpresion left = visit(ctx.left);;
		IExpresion right = visit(ctx.right);
        String op = ctx.op.getText();

        Expresion expresion = new Expresion(); 
        expresion.setExpresion1(left);
		expresion.setOperador(operadores.get(op));
		expresion.setExpresion2(right);

        return expresion;
    }
	
	@Override 
	public IExpresion visitNegExpr(IndicadoresParser.NegExprContext ctx) {
		System.out.println(ctx.getText());
		
		return new Termino(Double.valueOf(ctx.getText()));
	}
	
	@Override
    public IExpresion visitParenExpr(IndicadoresParser.ParenExprContext ctx) {
		System.out.println(ctx.getText());
		
        return this.visit(ctx.expresion());
    }
	
	@Override
	public IExpresion visitTermino(IndicadoresParser.TerminoContext ctx) { 
		System.out.println(ctx.getText());

		return new Termino(Double.valueOf(ctx.getText()));
	}
	
	@Override
	public IExpresion visitAtomExpr(IndicadoresParser.AtomExprContext ctx) { 
		System.out.println(ctx.getText());
		
		return new Termino(Double.valueOf(ctx.getText()));
	}
}