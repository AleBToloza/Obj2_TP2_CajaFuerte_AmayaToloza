package ar.edu.unahur.cajafuerte;

public class CajaFuerte {
	private Boolean puertaAbierta = Boolean.TRUE;
	private Integer contraseña;
	public Integer cantdIntentos = 0;


	public Boolean cajaFuerteEstaBloqueada() {return this.cantdIntentos >= 3;}
	
	public Boolean getPuertaAbierta() { 
		Boolean puertaAbierta = this.puertaAbierta;
		return puertaAbierta;
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
	
	public void intentarAbrirConContraseña_(Integer contraseña) {
		if ((this.contraseña == contraseña) && (!cajaFuerteEstaBloqueada()) ) {
			this.cantdIntentos = 0;
			this.puertaAbierta = Boolean.TRUE;
		}
		else { cantdIntentos++;}
	}
	
	
	//Modelando La Realidad
	
	public void usarLlaveMaestra() { this.puertaAbierta = Boolean.TRUE;	}
}
