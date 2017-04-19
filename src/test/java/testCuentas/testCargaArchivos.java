package testCuentas;

import static org.junit.Assert.*;
import org.junit.Test;
import empresas.LectorCuentas;

public class testCargaArchivos {
	

	@Test
	public void testCantidadDeCuentas() throws Exception {
		
		LectorCuentas lector = new LectorCuentas();
		int cantidad = lector.cantidadDeCuentas("c:\\CargaArchivos.txt");
		assertEquals(2,cantidad);
			
		}
	
	
	@Test(expected = Exception.class)
	public void testArchivoNoEncontrado() throws Exception{
		
		LectorCuentas lector = new LectorCuentas();
		lector.mostrarCuentas("Path con error");
		
		
	}
		
		
	}


