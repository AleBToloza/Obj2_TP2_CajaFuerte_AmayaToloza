package ar.edu.unahur.cajafuerte;

public class CajaFuerte {
	private Boolean puertaAbierta = Boolean.TRUE;
	private Integer contraseña;
	private Integer cantdIntentos = 2;
	private Boolean cajaFuerteEstaBloqueada = this.cantdIntentos >= 3;
	
	public Boolean getPuertaAbierta() { 
		Boolean puertaAbierta = this.puertaAbierta;
		return puertaAbierta;
	}
	
	public Boolean getEstaBloqueada() {
		return this.cajaFuerteEstaBloqueada;
	}
	
	public Boolean reseteoDeContraseña(Integer contraseña) {
		Boolean reseteoCorrecto = Boolean.FALSE;
		if (contraseña <= 9999) {
			this.contraseña = contraseña;
			reseteoCorrecto = Boolean.TRUE;
		}
		return reseteoCorrecto;
	}
	
	public Boolean cerrarPuerta() {
		this.puertaAbierta = Boolean.FALSE;
		return Boolean.TRUE;
	}
	
	public Integer intentarAbrirConContraseña_(Integer contraseña) {
		Integer contador = 0;
		if ((this.contraseña == contraseña) && (!this.cajaFuerteEstaBloqueada)) {
			this.cantdIntentos = 0;
			this.puertaAbierta = Boolean.TRUE;
		}
		else { contador =+ 1;
			this.cantdIntentos = contador; 
		}
		
		return contador;
	}
	
	
	//Modelando La Realidad
	
	public void usarLlaveMaestra() { this.puertaAbierta = Boolean.TRUE;	}
}
