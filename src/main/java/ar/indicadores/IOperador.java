package ar.indicadores;

public interface IOperador {

    // devuelve el simbolo que lo representa en una expresion (ej: "+", etc)
    public String getSimbolo();

    public double operar(IExpresion expresion1, IExpresion expresion2);

}
