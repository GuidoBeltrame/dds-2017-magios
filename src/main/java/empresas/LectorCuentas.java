package empresas;
import java.io.FileReader;
import com.opencsv.CSVReader;
import empresas.RepoEmpresas;

public class LectorCuentas {
	
	public static final char SEPARATOR = ',';
	CSVReader reader = null;
	RepoEmpresas repo = RepoEmpresas.getInstance();
	
	public void leerArchivo() throws Exception{
		
		try{
			reader = new CSVReader(new FileReader("c:\\CargaArchivos.txt"),SEPARATOR);
			String [] nextLine = null;
			
		while ((nextLine = reader.readNext()) != null){
			String nombreEmpresa = nextLine[0];
			if(repo.existe(nombreEmpresa)){
				
				//Falta codear aca.				
				
			}
			
		}
		}catch(Exception e){
			throw e;
		}finally {
			if(null != reader){
				reader.close();
			}
		}
		
		
	}
		

}
