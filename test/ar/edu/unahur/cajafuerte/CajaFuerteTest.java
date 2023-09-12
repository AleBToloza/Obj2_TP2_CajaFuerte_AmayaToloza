package ar.edu.unahur.cajafuerte;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.unahur.cajafuerte.CajaFuerte;

public class CajaFuerteTest {

	@Test
	public void alCrearUnaCajaFuerteLaPuertaEstaAbierta() {
		//Preparacion
		CajaFuerte miCajaFuerte = new CajaFuerte();
		Boolean valorEsperado = Boolean.TRUE;
		Boolean valorObtenido = Boolean.FALSE;
		//Ejecucion
		valorObtenido = miCajaFuerte.puertaEstaAbierta();
		//Contrastacion o Validacion
		Assert.assertEquals(valorEsperado, valorObtenido);		
	}
	
	@Test
	public void establecerPrimeraContraseña(){
		//Preparacion
		Integer contra = 1234;
		CajaFuerte miCajaFuerte = new CajaFuerte();
		Boolean valorEsperado = Boolean.TRUE;
		Boolean valorObtenido = Boolean.FALSE;
		//Ejecucion
		valorObtenido = miCajaFuerte.reseteoDeContraseña(contra);
		//Contrastacion o Validacion
		Assert.assertEquals(valorEsperado, valorObtenido);		
	}
	
	@Test
	public void intentarAbrirConContraseñaCorrecta(){
		//Preparacion
		Integer contra = 1234;
		CajaFuerte miCajaFuerte = new CajaFuerte();
		miCajaFuerte.reseteoDeContraseña(contra);
		miCajaFuerte.cerrarPuerta();
		Boolean valorEsperado = Boolean.TRUE;
		Boolean valorObtenido = Boolean.FALSE;
		miCajaFuerte.intentarAbrirConContraseña_(contra);
		//Ejecucion
		valorObtenido = miCajaFuerte.puertaEstaAbierta();
		//Contrastacion o Validacion
		Assert.assertEquals(valorEsperado, valorObtenido);		
	}
	
	@Test
	public void bloquearCajaAlIngresarTresVecesContraseñaIncorrecta(){
		//Preparacion
		Integer contra = 1234;
		CajaFuerte miCajaFuerte = new CajaFuerte();
		miCajaFuerte.reseteoDeContraseña(contra);
		miCajaFuerte.cerrarPuerta();
		Boolean valorEsperado = Boolean.TRUE;
		Boolean valorObtenido;
		miCajaFuerte.intentarAbrirConContraseña_(1233);
		miCajaFuerte.intentarAbrirConContraseña_(1233);
		miCajaFuerte.intentarAbrirConContraseña_(1233);
		miCajaFuerte.intentarAbrirConContraseña_(1233);
		//Ejecucion
		valorObtenido = miCajaFuerte.cajaFuerteEstaBloqueada();
		//Contrastacion o Validacion
		Assert.assertEquals(valorEsperado, valorObtenido);		
	}
}
