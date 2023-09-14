package ar.edu.unahur.cajafuerte;

import org.junit.Assert;
import org.junit.Test;

public class CajaFuerteTest {

	@Test
	public void alCrearUnaCajaFuerteLaPuertaEstaCerrada() {
		//Preparacion
		CajaFuerte miCajaFuerte = new CajaFuerte();
		Boolean valorEsperado = Boolean.FALSE;
		Boolean valorObtenido = Boolean.TRUE;
		//Ejecucion
		valorObtenido = miCajaFuerte.getPuertaAbierta();
		//Contrastacion o Validacion
		Assert.assertEquals(valorEsperado, valorObtenido);		
	}
	
	@Test
	public void establecerPrimeraContraseñaConPuertaCerrada(){
		//Preparacion
		Integer contra = 1234;
		CajaFuerte miCajaFuerte = new CajaFuerte();
		Boolean valorEsperado = Boolean.FALSE;
		Boolean valorObtenido = Boolean.TRUE;
		//Ejecucion
		miCajaFuerte.reseteoDeContraseña(contra);
		valorObtenido = miCajaFuerte.getPuertaAbierta();
		//Contrastacion o Validacion
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void abrirPorPrimeraVezConLlaveMaestra() {
		//Preparacion
		CajaFuerte miCajaFuerte = new CajaFuerte();
		Boolean valorEsperado = Boolean.TRUE;
		Boolean valorObtenido = Boolean.FALSE;
		miCajaFuerte.usarLlaveMaestra();
		//Ejecucion
		valorObtenido = miCajaFuerte.getPuertaAbierta();
		//Contrastacion o Validacion
		Assert.assertEquals(valorEsperado, valorObtenido);		
	}
	
	@Test
	public void bloquearCajaFuerte(){
		//Preparacion
		CajaFuerte miCajaFuerte = new CajaFuerte();
		Boolean valorEsperado = Boolean.TRUE;
		Boolean valorObtenido;
		Integer contador = 0;
		miCajaFuerte.reseteoDeContraseña(1111);
		
		//ejecución
		while (contador <= 4 ) {
			miCajaFuerte.abrirConContraseña_(1234);
			contador++;
		}
		valorObtenido = miCajaFuerte.getEstadoDeBloqueo();
		//Contrastacion o validacion
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void ingresoIncorrectoDeContraDeCincoDigitos() {
		//Preparacion
		Integer contra = 12345;
		CajaFuerte miCajaFuerte = new CajaFuerte();
		miCajaFuerte.usarLlaveMaestra();
		miCajaFuerte.reseteoDeContraseña(contra);
		miCajaFuerte.cerrarPuerta();
		Boolean valorEsperado = Boolean.FALSE;
		Boolean valorObtenido = Boolean.TRUE;
		valorObtenido = miCajaFuerte.correctaCantdDigitos(contra);
		//Contrastacion o Validacion
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void ingresoIncorrectoDeContraDeTresDigitos() {
		//Preparacion
		Integer contra = 123;
		CajaFuerte miCajaFuerte = new CajaFuerte();
		miCajaFuerte.usarLlaveMaestra();
		miCajaFuerte.reseteoDeContraseña(contra);
		miCajaFuerte.cerrarPuerta();
		Boolean valorEsperado = Boolean.FALSE;
		Boolean valorObtenido = Boolean.TRUE;
		valorObtenido = miCajaFuerte.correctaCantdDigitos(contra);
		//Contrastacion o Validacion
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void establecerPrimeraContraseñaConPuertaAbierta(){
		//Preparacion
		Integer contra = 1234;
		CajaFuerte miCajaFuerte = new CajaFuerte();
		miCajaFuerte.usarLlaveMaestra();
		Boolean valorEsperado = Boolean.TRUE;
		Boolean valorObtenido = Boolean.FALSE;
		//Ejecucion
		miCajaFuerte.reseteoDeContraseña(contra);
		valorObtenido = miCajaFuerte.getPuertaAbierta();
		//Contrastacion o Validacion
		Assert.assertEquals(valorEsperado, valorObtenido);		
	}
	
	@Test
	public void intentarAbrirConContraseñaCorrecta(){
		//Preparacion
		Integer contra = 1234;
		CajaFuerte miCajaFuerte = new CajaFuerte();
		miCajaFuerte.usarLlaveMaestra();
		miCajaFuerte.reseteoDeContraseña(contra);
		miCajaFuerte.cerrarPuerta();
		Boolean valorEsperado = Boolean.TRUE;
		Boolean valorObtenido = Boolean.FALSE;
		miCajaFuerte.abrirConContraseña_(contra);
		//Ejecucion
		valorObtenido = miCajaFuerte.getPuertaAbierta();
		//Contrastacion o Validacion
		Assert.assertEquals(valorEsperado, valorObtenido);		
	}
	
	@Test
	public void intentarAbrirConContraseñaIncorrecta(){
		//Preparacion
		Integer contra = 1234;
		Integer contraIncorrecta = 4321;
		CajaFuerte miCajaFuerte = new CajaFuerte();
		miCajaFuerte.usarLlaveMaestra();
		miCajaFuerte.reseteoDeContraseña(contra);
		miCajaFuerte.cerrarPuerta();
		Boolean valorEsperado = Boolean.FALSE;
		Boolean valorObtenido = Boolean.TRUE;
		miCajaFuerte.abrirConContraseña_(contraIncorrecta);
		//Ejecucion
		valorObtenido = miCajaFuerte.getPuertaAbierta();
		//Contrastacion o Validacion
		Assert.assertEquals(valorEsperado, valorObtenido);		
	}
	
	@Test
	public void abrirCorrectamenteAlTercerIntento(){
		//Preparacion
		Integer contra = 1234;
		Integer contraIncorrecta = 4321;
		CajaFuerte miCajaFuerte = new CajaFuerte();
		miCajaFuerte.usarLlaveMaestra();
		miCajaFuerte.reseteoDeContraseña(contra);
		miCajaFuerte.cerrarPuerta();
		Boolean valorEsperado = Boolean.TRUE;
		Boolean valorObtenido ;
		miCajaFuerte.abrirConContraseña_(contraIncorrecta);
		miCajaFuerte.abrirConContraseña_(contraIncorrecta);
		miCajaFuerte.abrirConContraseña_(contra);
		//Ejecucion
		valorObtenido = miCajaFuerte.getPuertaAbierta();
		//Contrastacion o Validacion
		Assert.assertEquals(valorEsperado, valorObtenido);		
	}
	
	@Test
	public void intentarIngresarContraseñaConPuertaBloqueada(){
		//Preparacion
		Integer contra = 1234;
		Integer contraIncorrecta = 4321;
		CajaFuerte miCajaFuerte = new CajaFuerte();
		miCajaFuerte.usarLlaveMaestra();
		miCajaFuerte.reseteoDeContraseña(contra);
		miCajaFuerte.cerrarPuerta();
		Boolean valorEsperado = Boolean.FALSE;
		Boolean valorObtenido;
		Integer contador = 0;
		while (contador <= 4) {
			miCajaFuerte.abrirConContraseña_(contraIncorrecta);
			contador++;
		}
		miCajaFuerte.abrirConContraseña_(contra);
		//Ejecucion
		valorObtenido = miCajaFuerte.getPuertaAbierta();
		//Contrastacion o Validacion
		Assert.assertEquals(valorEsperado, valorObtenido);		
	}
	
	@Test
	public void desbloquearCajaAlUsarLLaveMaestra() {
		//Preparacion
		Integer contra = 1234;
		Integer contraIncorrecta = 4321;
		CajaFuerte miCajaFuerte = new CajaFuerte();
		miCajaFuerte.usarLlaveMaestra();
		miCajaFuerte.reseteoDeContraseña(contra);
		miCajaFuerte.cerrarPuerta();
		Boolean valorEsperado = Boolean.FALSE;
		Boolean valorObtenido = Boolean.TRUE;
		while (!miCajaFuerte.getEstadoDeBloqueo()) {
			miCajaFuerte.abrirConContraseña_(contraIncorrecta);
		}
		miCajaFuerte.usarLlaveMaestra();
		//Ejecucion
		valorObtenido = miCajaFuerte.getEstadoDeBloqueo();
		//Contrastacion o Validacion
		Assert.assertEquals(valorEsperado, valorObtenido);
	}
	
}
