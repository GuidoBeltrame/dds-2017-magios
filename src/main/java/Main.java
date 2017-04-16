import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*	String sTexto = "En un lugar de la mancha de cuyo nombre no quiero acordarme";
		StringTokenizer frase = new StringTokenizer(sTexto);

		while (frase.hasMoreTokens()) {
		 System.out.println(frase.nextToken());
		}*/
		
		String registro = "avila#esta#1234#12";
		StringTokenizer tokens = new StringTokenizer (registro,"#");
		int cantTokens = tokens.countTokens();
		int contCampo = 1;
		int regNoProcesados = 0;
		int regProcesados = 0;
		
		
			if ((cantTokens <= 0) || (cantTokens > 4)){
				regNoProcesados++;	
			} else {
			//	Empresa empresa = new Empresa();
			//	Cuenta cuenta = new Cuenta();
				while (tokens.hasMoreTokens()){
						if (contCampo == 1){
						//	empresa.setNombreEmpresa(tokens.nextToken());
							System.out.println(tokens.nextToken());
							contCampo++;
						}else {	
						//	cuenta.setNombreCuenta(tokens.nextToken());
						//	cuenta.setPeriodo(Integer.parseInt(tokens.nextToken()));
						//	cuenta.setValor(Integer.parseInt(tokens.nextToken()));
							System.out.println(tokens.nextToken());
							System.out.println(tokens.nextToken());
							System.out.println(tokens.nextToken());
						}
					
				}
				regProcesados++;
	}
			System.out.println(regNoProcesados);
			System.out.println(regProcesados); 
}
	
}
