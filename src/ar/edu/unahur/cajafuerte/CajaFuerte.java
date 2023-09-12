package ar.edu.unahur.cajafuerte;

public class CajaFuerte {
	private Boolean puertaAbierta = Boolean.FALSE;
	private Integer contraseña;
	private Integer cantdIntentosErroneos = 0;
	private Boolean estadoDeBloqueo = Boolean.TRUE;

	public Boolean getEstadoDeBloqueo() {
		return this.estadoDeBloqueo;
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
	
	private Boolean condicionesDadasParaIngresoDeContraseña(Integer contraseña) {
		return this.puertaAbierta && !this.estadoDeBloqueo && this.correctaCantdDigitos(contraseña);
	}
	
	public Boolean reseteoDeContraseña(Integer contraseña) {
		//se corrobora que la puerta esté abierta y que la cajafuerte no esté bloqueada
		Boolean reseteoCorrecto = Boolean.FALSE;
		if (this.condicionesDadasParaIngresoDeContraseña(contraseña)) {
			this.cantdIntentosErroneos = 0;
			this.contraseña = contraseña;
			reseteoCorrecto = Boolean.TRUE;
		}
		return reseteoCorrecto;
	}
	
	public void cerrarPuerta() {
		this.puertaAbierta = Boolean.FALSE;
	}
	
	public void abrirConContraseña_(Integer contraseña) {
		/*se corrobora que la contraseña sea la correcta y que la caja fuerte no esté bloqueada.
		caso contrario se suma uno a la cantdIntentosErroneos y una vez alcanzada la cantd de Tres
		la caja se bloquea*/
		if ((this.contraseña == contraseña) && !this.estadoDeBloqueo ) {
			this.cantdIntentosErroneos = 0;
			this.puertaAbierta = Boolean.TRUE;
		}
		else { 
			this.cantdIntentosErroneos++;
			if (this.cantdIntentosErroneos == 3) {
				this.estadoDeBloqueo = Boolean.TRUE;
			}
		}
	}
	
	//Modelando La Realidad
	
	public void usarLlaveMaestra() { 
		//al usar la llave maestra: se desbloquea la puerta y se abre, la cantd de ingresos erróneos vuelve a 0
		//y el atributo 'contraseña' pasa a null
		this.puertaAbierta = Boolean.TRUE;	
		this.estadoDeBloqueo = Boolean.FALSE;
		this.cantdIntentosErroneos = 0;
		this.contraseña = null;
	}
}
