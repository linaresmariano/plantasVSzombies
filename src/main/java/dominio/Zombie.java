package dominio;

public class Zombie {

	// La resustencia inicial se setea cuando
	// se asignan los puntos de defensa
	private int puntosAtaque, puntosDefensa, resistenciaInicial;
	
	public Zombie() {}
	
	public Zombie(int puntosAtk, int puntosDef) {
		this.setPuntosAtaque(puntosAtk);
		this.setPuntosDefensa(puntosDef);
	}
	
	public void teAtaca(int danio) {
		this.puntosDefensa -= danio;
		if(this.puntosDefensa <= 0) {
			this.puntosDefensa = 0;
			this.morir();
		}
	}
	
	public boolean estaMuerto() {
		return this.puntosDefensa <= 0;
	}
	
	public void morir() {
		System.out.println("Soy un zombie y me mori");
	}
	
	public void setPuntosAtaque(int i) {
		this.puntosAtaque = i;
	}
	
	public int getPuntosAtaque() {
		return this.puntosAtaque;
	}

	public void setPuntosDefensa(int i) {
		this.puntosDefensa = i;
		this.resistenciaInicial = i;
	}
	
	public int getResistenciaInicial() {
		return this.resistenciaInicial;
	}

	public int getPuntosDefensa() {
		return this.puntosDefensa;
	}
}
