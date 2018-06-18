package cr.ac.ucenfotec.Cartas.test;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import cr.ac.ucenfotec.Cartas.Carta;
import cr.ac.ucenfotec.Cartas.Jugador;
import cr.ac.ucenfotec.Cartas.Naipe;
import cr.ac.ucenfotec.Cartas.Palo;
import cr.ac.ucenfotec.Cartas.Repartidor;
import junit.framework.Assert;

public class Carta_Test {

	// 1. Cartas Validas
	@Test(expected = Exception.class)
	public void Invalid_Number() throws Exception {
		new Carta("1", Palo.ESCUDOS, 2);
	}
	@Test(expected = Exception.class)
	public void Invalid_Special() throws Exception {
		new Carta("Jota", 	Palo.ESTRELLAS, 11);
		new Carta("quina", 	Palo.ESTRELLAS, 6);
		new Carta("kA", 	Palo.ESTRELLAS, 8);
		new Carta("as", 	Palo.ESTRELLAS, 5);
	}
	@Test(expected = Exception.class)
	public void Invalid_Name() throws Exception {
		new Carta("other", 	Palo.ESTRELLAS, 10);
	}

	@Test
	public void Valid_Cards() throws Exception {
		new Carta("1",		Palo.ESCUDOS,	1);
		new Carta("Jota", 	Palo.ESTRELLAS, 10);
		new Carta("quina", 	Palo.ESTRELLAS, 10);
		new Carta("kA", 	Palo.ESTRELLAS, 10);
		new Carta("as", 	Palo.ESTRELLAS, 1);
	}

	// 2. Equal Cards
	@Test
	public void Equal_Cards() throws Exception {
		Carta C_1 = new Carta ("10", 	Palo.ESCUDOS, 10);
		Carta C_2 = new Carta ("jota",	Palo.FLORES,  10);
		
		assertEquals(C_1, C_2);
	}
	
	// 3. Naipe
	@Test
	public void Valid_Naipe () throws Exception {
		Naipe _Naipe = new Naipe();
		
		assertTrue(_Naipe.contains(new Carta ("As", 	Palo.ESCUDOS, 	1)));
		assertTrue(_Naipe.contains(new Carta ("Jota", 	Palo.ESTRELLAS,	10)));
		assertTrue(_Naipe.contains(new Carta ("3", 		Palo.GOTAS,		3)));
		assertTrue(_Naipe.contains(new Carta ("4", 		Palo.FLORES, 	4)));
		
		
		assertEquals(52, _Naipe.getCartas().size());
	}
	
	// 4. Repartidor
	@Test
	public void Valid_Repartidor_Naipe () throws Exception {
		Repartidor _Repartidor = new Repartidor();
		
		
		assertTrue(_Repartidor.getNaipe().contains(new Carta ("Ka", 	Palo.FLORES, 	10)));
		assertTrue(_Repartidor.getNaipe().contains(new Carta ("Quina", 	Palo.ESCUDOS,	10)));
		assertTrue(_Repartidor.getNaipe().contains(new Carta ("7", 		Palo.GOTAS,		7)));
		assertTrue(_Repartidor.getNaipe().contains(new Carta ("5", 		Palo.FLORES, 	5)));
		
		assertEquals(52, _Repartidor.getNaipe().getCartas().size());
	}
//	@Test
//	public void Valid_Repartidor_Naipe_Order () throws Exception {
//		Repartidor _Repartidor = new Repartidor();
//
//		_Repartidor.getNaipe().print();
//		
//		// Duda
//		assertNotEquals(new Carta ("As", Palo.ESCUDOS, 1), 	_Repartidor.getNaipe().getCartas().stream().findFirst().get());
//		assertNotEquals(new Carta ("Ka", Palo.GOTAS, 10), 	_Repartidor.getNaipe().getCartas().stream().reduce((first, second) -> second).orElse(null));
//	}
	
	// 5. Jugador
	public void Valid_Jugador () throws Exception {
		Carta C_1 = new Carta ("10", 	Palo.ESCUDOS, 10);
		Carta C_2 = new Carta ("jota",	Palo.FLORES,  10);
		
		Jugador _Jugador = new Jugador ("Gary", Arrays.asList(C_1, C_2));
		
		assertEquals(C_1, _Jugador.getMano().stream().findFirst());
		assertEquals("Gary", _Jugador.getNombre());
		assertNotNull(_Jugador);
	}
}
