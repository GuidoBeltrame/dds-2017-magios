grammar Indicadores;

indicador: expresion EOF
         ;
expresion: PARENIZQ expresion PARENDER                    #parenExpr
         | REST expresion                                 #negExpr
         | left=expresion op=(MULT | DIV) right=expresion #opExpr
         | left=expresion op=(REST | SUM) right=expresion #opExpr
         | termino                                        #atomExpr
         ;
termino: NUMERO
       | CONSTANTE
       | EXPALG 
       | INDICADOR
	   ;

// reglas
IGUAL: '=' ;
PARENIZQ: '(' ;
PARENDER: ')' ;
NUMERO: [0-9]+(.[0-9][0-9]?)? ;
CONSTANTE: 'c_'[a-zA-Z]+ ;
EXPALG: 'exp_'[a-zA-Z]+ ;
INDICADOR: 'i_'[a-zA-Z]+ ;
SUM: '+' ;
REST: '-' ;
MULT: '*' ;
DIV: '/' ;
WS: [ \t\r\n]+ -> skip ;