package cr.ac.ucenfotec.Cartas.test;

import static org.junit.Assert.*;

import javax.swing.JOptionPane;

import org.junit.Test;

import cr.ac.ucenfotec.Cartas.Carta;
import cr.ac.ucenfotec.Cartas.Naipe;
import cr.ac.ucenfotec.Cartas.Palo;

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
		
		_Naipe.print();
		
		assertTrue(_Naipe.contains(new Carta ("As", 	Palo.ESCUDOS, 	1)));
		assertTrue(_Naipe.contains(new Carta ("Jota", 	Palo.ESTRELLAS,	10)));
		assertTrue(_Naipe.contains(new Carta ("3", 		Palo.GOTAS,		3)));
		assertTrue(_Naipe.contains(new Carta ("4", 		Palo.FLORES, 	4)));
		
		
		assertEquals(52, _Naipe.getCartas().size());
	}
	
	

}
