package dominio;

import java.util.ArrayList;

import exceptions.ErrorTerreno;

public class Juego {
	
	private int puntos = 0;
	private ArrayList<Planta> plantas = new ArrayList<Planta>();
	
	// Representa el tablero (alto, ancho)
	private Jardin jardin = new Jardin(3, 5);
	
	// Plantines disponibles
	private ArrayList<Planta> jardinZEN = new ArrayList<Planta>();

	public Juego() {
		this.plantas.add(new Planta("Peashooters", 10, 10, true));
		this.plantas.add(new Planta("Sunflowers", 10, 10, true));
		this.plantas.add(new Planta("Cherry Bombs", 10, 10, true));
		this.plantas.add(new Planta("Wall-Nut", 10, 10, false));
		this.plantas.add(new Planta("Potato Mines", 10, 10, false));
		this.plantas.add(new Planta("Snow Pea", 10, 10, false));
	}
	
	public void plantar(int fila, int columna, Planta plantin) throws ErrorTerreno {
		this.jardin.plantar(fila, columna, plantin);
	}
	
	public void pelear(Zombie z, Fila fila) {
		while(! z.estaMuerto()) {
			Planta p = fila.getPrimeraPlanta();
			if(p != null) {
				// El zombie ataca a la primer planta
				p.teAtaca();
				if(p.estaMuerta()) {
					fila.removePlanta(p);
				}
				
				// La fila de plantas ataca al zombie
				z.teAtaca(fila.puntosDeAtaque());
			} else {
				System.out.println("Perdiste! El zombie te comio el cerebro");
				return;				
			}	
		}
		//System.out.println("Sobreviviste al ataque zombie");
		
		this.calcularPremio(z.getResistenciaInicial());
	}
	
	public void calcularPremio(int resistencia) {
		double rand = Math.random();
		
		// En el 50% da premio
		System.out.println(rand);
		if(rand <= 0.5) {
			// En un 25% da planta, en el otro puntos
			if(rand <= 0.25) {
				// Dar planta
				int indexPlant = (int)  Math.random() * this.plantas.size();
				System.out.println("PREMIO: planta " + this.plantas.get(indexPlant).getName());
				this.addPlantin(this.plantas.get(indexPlant));
				this.plantas.remove(indexPlant);
				
			} else {
				// Dar puntos
				int puntos = (int) (Math.random() * (resistencia / 3));
				this.sumarPuntos(puntos);
				System.out.println("PREMIO: " + puntos);
			}
		} else {		
			System.out.println("NO HAY PREMIO POR MATAR AL ZOMBIE");
		}
	}
	
	public void sumarPuntos(int puntos) {
		this.puntos += puntos;
	}
	
	public int getPuntos() {
		return this.puntos;
	}
	
	public void addPlantin(Planta p) {
		this.jardinZEN.add(p);
	}

	public ArrayList<Planta> getPlantas() {
		return this.plantas;
	}
}
