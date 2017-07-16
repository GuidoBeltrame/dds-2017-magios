package ar.indicadores;

public class ExpresionCompuesta implements IExpresion {

    private IExpresion expresion1;
    private IOperador operador;
    private IExpresion expresion2;

    public ExpresionCompuesta(IExpresion expresion1, IExpresion expresion2, IOperador operador) {
        this.expresion1 = expresion1;
        this.operador = operador;
        this.expresion2 = expresion2;
    }

    public ExpresionCompuesta() {
    }

    public double getResultado() {
        if(operador == null) {
            throw new RuntimeException("No hay operador definido");
        }
        return operador.operar(expresion1, expresion2);
    }

    public void setExpresion1(IExpresion expresion1) {
        this.expresion1 = expresion1;
    }

    public void setOperador(IOperador operador) {
        this.operador = operador;
    }

    public void setExpresion2(IExpresion expresion2) {
        this.expresion2 = expresion2;
    }

    public IExpresion getExpresion1() {
        return expresion1;
    }

    public IOperador getOperador() {
        return operador;
    }

    public IExpresion getExpresion2() {
        return expresion2;
    }
}
