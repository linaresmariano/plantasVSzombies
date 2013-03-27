package dominio;

import dominio.Planta;

public class Casillero {
	private Planta planta;

	public Planta getPlanta() {
		return planta;
	}
	
	public void plantar(Planta p){
		this.planta = p;
	}
	
	public void desplantar(){
		this.planta = null;
	}
	
	public boolean ocupado(){
		return this.planta != null;
	}
}
