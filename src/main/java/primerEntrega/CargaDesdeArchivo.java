package primerEntrega;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class CargaDesdeArchivo {

	private String archivoCarga;

	public String getArchivoCarga() {
		return archivoCarga;
	}

	public void setArchivoCarga(String archivoCarga) {
		this.archivoCarga = archivoCarga;
	}

	public void procesoCarga (String archivoCarga) throws FileNotFoundException,IOException{
		String registro;
		FileReader f = new FileReader (archivoCarga);
		BufferedReader b = new BufferedReader (f);
		int regNoProcesados = 0;
		int regProcesados = 0;
		
		while ((registro = b.readLine()) != null){
			StringTokenizer tokens = new StringTokenizer (registro,"#");
			int cantTokens = tokens.countTokens(); 
			int contCampo = 1;
			
				if ((cantTokens <= 0) || (cantTokens > 4)){
					regNoProcesados++;	
				} else {
					Empresa empresa = new Empresa();
					Cuenta cuenta = new Cuenta();
					while (tokens.hasMoreTokens()){
							if (contCampo == 1){
								empresa.setNombreEmpresa(tokens.nextToken());
								contCampo++;
							}else {	
								cuenta.setNombreCuenta(tokens.nextToken());
								cuenta.setPeriodo(Integer.parseInt(tokens.nextToken()));
								cuenta.setValor(Integer.parseInt(tokens.nextToken()));
							}
						
					}
					empresa.agregarCuentas(cuenta);
					regProcesados++;
					
				} 
				
			
		}
		b.close();
		
		
	}
	
	
}
