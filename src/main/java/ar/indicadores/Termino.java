package ar.indicadores;

public class Termino implements IExpresion {

    private double valor;

    public Termino(double valor) {
        this.valor = valor;
    }

    public double getResultado() {
        return valor;
    }
}
