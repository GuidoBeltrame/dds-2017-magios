package testCuentas;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import empresas.LectorCuentas;

public class testCargaArchivos {
	
	LectorCuentas lector;
	
	@Before
	public void setUp(){
		
		lector = new LectorCuentas();
		
	}
	

	@Test
	public void testCantidadDeCuentas() throws Exception {
		
		int cantidad = lector.cantidadDeCuentas("src/main/java/cargaArchivos.txt");
		assertEquals(3,cantidad);
		
			
		}
	
	
	@Test(expected = Exception.class)
	public void testArchivoNoEncontrado() throws Exception{
		
		lector.mostrarCuentas("Path con error");
		
	}
		
		
	}


