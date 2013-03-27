package dominio;

import java.util.ArrayList;

import exceptions.ErrorTerreno;

public class Jardin extends ArrayList<Fila>{

	private static final long serialVersionUID = 1L;

	public Jardin(int filas, int columnas) {
		super();
		for(int i=0; i < filas; i++) {
			this.add(new Fila(columnas));
		}
	}
	
	public void plantar(int fila, int columna, Planta plantin) throws ErrorTerreno {
		this.get(fila).addPlanta(columna, plantin);
	}
}
