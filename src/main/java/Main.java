import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Scanner;



import primerEntrega.Cuenta;
import primerEntrega.Empresa;


public class Main {

	public static void main(String[] args)throws FileNotFoundException, IOException {
		
		
		//public void procesoCarga ("c:\\CargaArchivo.txt") 	throws FileNotFoundException,IOException;{
			String registro;
	//		FileReader f = new FileReader ("c:\\CargaArchivo.txt");
			BufferedReader b = null;
			try {
				b = new BufferedReader (new FileReader("c:\\CargaArchivos.txt"));
				
			} catch (FileNotFoundException ex) {
				    ex.printStackTrace();
				} catch (@SuppressWarnings("hiding") IOException ex2) {
				   ex2.printStackTrace();
				}
			int regNoProcesados = 0;
			int regProcesados = 0;
			
			while ((registro = b.readLine()) != null){
				System.out.println(registro);
				StringTokenizer tokens = new StringTokenizer (registro,",");
				int cantTokens = tokens.countTokens(); 
				
					if ((cantTokens <= 0) || (cantTokens > 4)){
						
						regNoProcesados++;
						
					} else {
						System.out.println(cantTokens);
						Empresa empresa = new Empresa();
						Cuenta cuenta = new Cuenta();
						
						while (tokens.hasMoreTokens()){
									empresa.setNombreEmpresa(tokens.nextToken());
									System.out.println(empresa.getNombreEmpresa());
									cuenta.setNombreCuenta(tokens.nextToken());
									System.out.println(cuenta.getNombreCuenta());
									cuenta.setPeriodo(Integer.parseInt(tokens.nextToken()));
									System.out.println(cuenta.getPeriodo());
									cuenta.setValor(Integer.parseInt(tokens.nextToken()));
									System.out.println(cuenta.getValor());
						}
						
						empresa.agregarCuentas(cuenta);
						regProcesados++;
						System.out.println(empresa.getListaCuentas().size());
					} 

					System.out.println(regNoProcesados);
					System.out.println(regProcesados); 
			}	
			b.close();
	}
}
