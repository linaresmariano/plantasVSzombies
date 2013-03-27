
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dominio.Fila;
import dominio.Juego;
import dominio.Planta;
import dominio.Zombie;
import exceptions.ErrorTerreno;

public class JuegoTest {

	private Fila fila;
	private Planta p1, p2;
	private Zombie z;
	private Juego juego;
	
	@Before
	public void setUp() throws Exception {
		
		p1 = new Planta();
		p1.setPuntosAtaque(10);
		p1.setPuntosDefensa(10);
		
		p2 = new Planta();
		p2.setPuntosAtaque(10);
		p2.setPuntosDefensa(1000);
		
		fila = new Fila(5);
		fila.addPlanta(1, p1);
		fila.addPlanta(2, p2);
		
		juego = new Juego();
	}

	@Test
	public void testPelear() {

		for(int i=0; i < 8; i++) {
			juego.pelear(new Zombie(10, 100), fila);
		}
		
		System.out.println("VIDA PLANTA1: "+ p1.getPuntosDefensa());
		System.out.println("VIDA PLANTA2: "+ p2.getPuntosDefensa());
		System.out.println("PUNTOS ACTUALES: " + juego.getPuntos());
		
		assertTrue(true);
	}
	
	@Test
	public void testPelearYPerder() {
		
		p1.setPuntosDefensa(10);
		p2.setPuntosDefensa(10);
		
		// PuntosAtk, PuntosDef
		z = new Zombie(10, 1000);
		
		juego.pelear(z, fila);
		
		assertEquals(p1.getPuntosDefensa(), 0);
		assertEquals(p2.getPuntosDefensa(), 0);
		assertEquals(z.getPuntosDefensa(), 720);
	}
	
	@Test
	public void testPlantarEnLugarIncorrecto() {
		Planta acuatica = new Planta("Snow Pea", 10, 10, false);
		
		try {
			// Por defecto todos los terrenos son terrestres
			juego.plantar(2,2, acuatica);
			fail("No tira exception ErrorDeTerreno");
		} catch(Exception e) {
			assertTrue(true);
		}
	}

	@Test
	public void testPlantarEnLugarCorrecto() {
		Planta terrestre = new Planta("Snow Pea", 10, 10, true);
		
		try {
			// Por defecto todos los terrenos son terrestres
			juego.plantar(2,2, terrestre);
			assertTrue(true);
		} catch(ErrorTerreno e) {
			fail("No tira exception ErrorDeTerreno");
		}
	}
	
}
