package cr.ac.ucenfotec.Cartas.test;

import static org.junit.Assert.*;

import org.junit.Test;

import cr.ac.ucenfotec.Cartas.Carta;
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
	
	

}
