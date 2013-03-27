package dominio;

import java.util.ArrayList;

import exceptions.ErrorTerreno;

public class Fila extends ArrayList<Casillero>{
	
	private static final long serialVersionUID = 1L;
	private boolean terrestre;

	public Fila(int len) {
		super();
		this.terrestre = true;
		for(int i=0; i < len; i++) {
			this.add(new Casillero());
		}
	}
		
	public void addPlanta(int index, Planta p) throws ErrorTerreno {
		if(p.esTerrestre() == this.esTerrestre()) {
			this.get(index).plantar(p);			
		} else {
			// TODO: exception?
			//System.out.println("Esta planta no va aca!");
			throw new ErrorTerreno();
		}
		
	}
	
	public Planta getPrimeraPlanta() {
		for(int i=0; i< this.size(); i++) {
			Casillero actual = this.get(i);
			
			if(actual.getPlanta() != null) {
				return actual.getPlanta();
			}
		}
		
		return null;
	}

	public int puntosDeAtaque() {
		int ret = 0;
		
		for(int i=0; i< this.size(); i++) {
			if(this.get(i).getPlanta() != null) {
				ret += this.get(i).getPlanta().getPuntosAtaque();
			}
		}
		
		return ret;
	}

	public void removePlanta(Planta p) {
		//this.casilleros.set(this.casilleros.indexOf(p), null);
		
		// Desplantar la planta muerta
		for(Casillero c : this) {
			if(p.equals(c.getPlanta())) {
				c.desplantar();
			}
		}
	}
	
	public boolean esTerrestre() {
		return this.terrestre;
	}
}
