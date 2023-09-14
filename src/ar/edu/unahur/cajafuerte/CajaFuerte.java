package ar.edu.unahur.cajafuerte;

public class CajaFuerte {
	private Boolean puertaAbierta = Boolean.FALSE;
	private Integer contraseña = null;
	private Integer cantdIntentosErroneos = 0;
	//private Boolean estadoDeBloqueo = Boolean.TRUE;

	public Boolean getEstadoDeBloqueo() {
		return cantdIntentosErroneos > 3;
	}
	
	public Boolean getPuertaAbierta() { 
		Boolean puertaAbierta = this.puertaAbierta;
		return puertaAbierta;
	}
	
	public Boolean correctaCantdDigitos(Integer contraseña) {
		//corrobora que solo se ingresen contraseñas de 4 digitos
		Integer digitosDeContraseña = 0;
		while (contraseña != 0) {
			digitosDeContraseña+=1;
			contraseña /= 10;
		}
		return digitosDeContraseña == 4;
	}
	
	public Boolean condicionesDadasParaIngresoDeContraseña(Integer contraseña) {
		return !this.puertaAbierta && !this.getEstadoDeBloqueo() && this.correctaCantdDigitos(contraseña);
	}
	
	public void reseteoDeContraseña(Integer contraseña) {
		//se corrobora que la puerta esté abierta y que la cajafuerte no esté bloqueada
		if (this.puertaAbierta && !this.getEstadoDeBloqueo() ) {
			this.cantdIntentosErroneos = 0;
			this.contraseña = contraseña;
		}
	}
	
	public void cerrarPuerta() {
		this.puertaAbierta = Boolean.FALSE;
	}
	
	public void abrirConContraseña_(Integer contraseña) {
		/*se corrobora que la contraseña sea la correcta y que la caja fuerte no esté bloqueada.
		caso contrario se suma uno a la cantdIntentosErroneos y una vez alcanzada la cantd de Tres
		la caja se bloquea*/
		if (contraseña == this.contraseña && this.condicionesDadasParaIngresoDeContraseña(contraseña) ) {
			this.cantdIntentosErroneos = 0;
			this.puertaAbierta = Boolean.TRUE;
		}
		else {cantdIntentosErroneos++;}
	}
	
	//Modelando La Realidad
	
	public void usarLlaveMaestra() { 
		//al usar la llave maestra: se desbloquea la puerta y se abre, la cantd de ingresos erróneos vuelve a 0
		//y el atributo 'contraseña' pasa a null
		this.puertaAbierta = Boolean.TRUE;	
		this.cantdIntentosErroneos = 0;
		this.contraseña = null;
	}
}
