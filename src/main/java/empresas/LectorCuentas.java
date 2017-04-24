package empresas;
import java.io.FileReader;
import java.util.Arrays;
import com.opencsv.CSVReader;


public class LectorCuentas {
	
	public static final char SEPARATOR = ',';
	private CSVReader reader = null;
	
	public LectorCuentas(){
			
		
	}
	
	
	public void mostrarCuentas(String path) throws Exception{
		
		try{
			reader = new CSVReader(new FileReader(path),SEPARATOR);
			String [] nextLine = null;
		while ((nextLine = reader.readNext()) != null){
			System.out.println(Arrays.toString(nextLine));
			
		}
		}catch(Exception e){
			throw e;
		}finally {
			if(null != reader){
				reader.close();
			}
		}
		
		
	}



public int cantidadDeCuentas(String path) throws Exception{
	
	int i = 0;
	
	try{
		reader = new CSVReader(new FileReader(path),SEPARATOR);
	while ((reader.readNext()) != null){
		
		i++;
		
	}
		return i;
	}catch(Exception e){
		throw e;
	}finally {
		if(null != reader){
			reader.close();
		}
	}
	
	
}


}

