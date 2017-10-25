package ar.indicadores.antlr;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ar.entidades.Indicador;
import ar.indicadores.*;
import ar.repositorio.CuentasRepositorio;
import ar.repositorio.IndicadoresRepositorio;
//import empresas.Empresa;

public class VisitorExp extends IndicadoresBaseVisitor<IExpresion> {

	private static final String PERSISTENCE_UNIT_NAME = "DB_MAGIOS";
	private EntityManagerFactory emFactory;
	private IndicadoresRepositorio indicadoresRepositorio;
	private CuentasRepositorio cuentasRepositorio;
	
	private Map<String, IOperador> operadores;
	private IExpresion expresionActual;
	private Long codEmpresa;
	private int periodo;

	public VisitorExp() {
		emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		indicadoresRepositorio = new IndicadoresRepositorio(emFactory.createEntityManager());
		cuentasRepositorio = new CuentasRepositorio(emFactory.createEntityManager());
		this.cargarOperadores();
	}

	public VisitorExp(Long codEmpresa, int periodo) {
		this();
		this.periodo = periodo;
		this.codEmpresa = codEmpresa;
		//this.cargarOperadores();
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

		IExpresion left = visit(ctx.left);
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

		double valor = 0;

		if (ctx.getText().startsWith("-c")) {
			// Es una Cuenta
			valor = (-1) * obtenerValorCuenta(ctx.getText().split("-")[1], codEmpresa, periodo);
		} else {
			if (ctx.getText().startsWith("-i")) {
				// Es un Indicador
				valor = (-1) * obtenerValorIndicador(ctx.getText().split("-")[1], codEmpresa, periodo);
			} else {
				valor = Double.valueOf(ctx.getText());
			}
		}

		return new Termino(valor);
	}

	@Override
	public IExpresion visitParenExpr(IndicadoresParser.ParenExprContext ctx) {
		System.out.println(ctx.getText());

		return this.visit(ctx.expresion());
	}

	@Override
	public IExpresion visitTermino(IndicadoresParser.TerminoContext ctx) {
		System.out.println(ctx.getText());

		double valor = 0;

		if (ctx.getText().startsWith("c")) {
			// Es una Cuenta
			valor = obtenerValorCuenta(ctx.getText(), codEmpresa, periodo);
		} else {
			if (ctx.getText().startsWith("i")) {
				// Es un Indicador
				valor = obtenerValorIndicador(ctx.getText(), codEmpresa, periodo);
			} else {
				valor = Double.valueOf(ctx.getText());
			}
		}

		return new Termino(valor);
	}

	@Override
	public IExpresion visitAtomExpr(IndicadoresParser.AtomExprContext ctx) {
		System.out.println(ctx.getText());

		double valor = 0;

		if (ctx.getText().startsWith("c")) {
			// Es una Cuenta
			valor = obtenerValorCuenta(ctx.getText(), codEmpresa, periodo);
		} else {
			if (ctx.getText().startsWith("i")) {
				// Es un Indicador
				valor = obtenerValorIndicador(ctx.getText(), codEmpresa, periodo);
			} else {
				valor = Double.valueOf(ctx.getText());
			}
		}

		return new Termino(valor);
	}

	private double obtenerValorIndicador(String identificadorIndicador, Long codEmpresa, int anio) {

		// Llamar a persistencia, con codIndicador
		String formula = indicadoresRepositorio.obtenerFormulaIndicador(identificadorIndicador);

		//IndicadorPropio indicador = new IndicadorPropio("Indicador Propio 1", "1+2");
		Indicador indicador = new Indicador();
		indicador.setFormula(formula);
		
		return indicador.getResultado(codEmpresa, anio);
	}

	private double obtenerValorCuenta(String identificadorCuenta, Long codEmpresa, int periodo) {

		// Llamar a persistencia, con codCuenta, condEmpresa y periodo
		 return cuentasRepositorio.obtenerValorCuenta(identificadorCuenta, codEmpresa, periodo);
		//return 6;
	}
}