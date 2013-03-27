package dominio;

public class Planta {
	
	private int puntosAtaque = 10, puntosDefensa = 10;
	private String name = "Planta";
	private boolean terrestre = true;

	public Planta() {}
	
	public Planta(String name, int ptsAtk, int ptsDef, boolean terrestre) {
		this.name = name;
		this.setPuntosAtaque(ptsAtk);
		this.setPuntosDefensa(ptsDef);
		this.terrestre = terrestre;
	}
	
	// Te muerde un zombie
	public void teAtaca() {
		this.puntosDefensa -= 1;
	}
	
	public boolean estaMuerta() {
		return this.puntosDefensa <= 0;
	}
	
	public void morir() {
		System.out.println("Soy una planta y me mori");
	}
	
	public void setPuntosAtaque(int i) {
		this.puntosAtaque = i;		
	}
	
	public int getPuntosAtaque() {
		return this.puntosAtaque;
	}

	public void setPuntosDefensa(int i) {
		this.puntosDefensa = i;
	}

	public int getPuntosDefensa() {
		return this.puntosDefensa;
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean esTerrestre() {
		return this.terrestre;
	}
}
