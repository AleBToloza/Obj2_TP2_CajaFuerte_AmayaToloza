package ar.edu.unahur.cajafuerte;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.unahur.cajafuerte.CajaFuerte;

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
		valorObtenido = miCajaFuerte.reseteoDeContraseña(contra);
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
	public void establecerPrimeraContraseñaConPuertaAbierta(){
		//Preparacion
		Integer contra = 1234;
		CajaFuerte miCajaFuerte = new CajaFuerte();
		miCajaFuerte.usarLlaveMaestra();
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
		Boolean valorObtenido = Boolean.FALSE;
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
		Boolean valorObtenido = Boolean.TRUE;
		while (!miCajaFuerte.getEstadoDeBloqueo()) {
			miCajaFuerte.abrirConContraseña_(contraIncorrecta);
		}
		miCajaFuerte.abrirConContraseña_(contra);
		//Ejecucion
		valorObtenido = miCajaFuerte.getPuertaAbierta();
		//Contrastacion o Validacion
		Assert.assertEquals(valorEsperado, valorObtenido);		
	}
	
	@Test
	public void bloquearCajaAlIngresarTresVecesContraseñaIncorrecta(){
		//Preparacion
		Integer contra = 1234;
		Integer contraIncorrecta = 4321;
		CajaFuerte miCajaFuerte = new CajaFuerte();
		miCajaFuerte.usarLlaveMaestra();
		miCajaFuerte.reseteoDeContraseña(contra);
		miCajaFuerte.cerrarPuerta();
		Boolean valorEsperado = Boolean.TRUE;
		Boolean valorObtenido = Boolean.FALSE;
		while (!miCajaFuerte.getEstadoDeBloqueo()) {
			miCajaFuerte.abrirConContraseña_(contraIncorrecta);
		}
		//Ejecucion
		valorObtenido = miCajaFuerte.getEstadoDeBloqueo();
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
