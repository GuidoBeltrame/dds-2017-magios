package ar.indicadores;

import java.util.ArrayList;
import java.util.List;

public class Expresion implements IExpresion {

    private double valor;
    private IExpresion expresion1;
    private IOperador operador;
    private IExpresion expresion2;
    
    private List<IExpresion> expresiones;
    
    public Expresion() {
    	expresiones = new ArrayList<IExpresion>();
    }
     
    public Expresion(IExpresion expresion1, IOperador operador, IExpresion expresion2) {
    	super();  	
    	this.setExpresion1(expresion1);
        this.setOperador(operador);
        this.setExpresion2(expresion2);
    }
   		
    public Expresion(double valor) {
    	super();
        this.setValor(valor);
    }

    public double getResultado() {    
        if(operador == null) {
            throw new RuntimeException("No hay operador definido");
        }
        return operador.operar(expresion1, expresion2);
    }

	public List<IExpresion> getExpresiones() {
		return expresiones;
	}

	public void setExpresiones(List<IExpresion> expresiones) {
		this.expresiones = expresiones;
	}
	
	public void listaAgregar(IExpresion expresion) {
		expresiones.add(expresion);
	}

	public IExpresion getExpresion2() {
		return expresion2;
	}

	public void setExpresion2(IExpresion expresion2) {
		this.expresion2 = expresion2;
	}

	public IExpresion getExpresion1() {
		return expresion1;
	}

	public void setExpresion1(IExpresion expresion1) {
		this.expresion1 = expresion1;
	}

	public IOperador getOperador() {
		return operador;
	}

	public void setOperador(IOperador operador) {
		this.operador = operador;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
}
