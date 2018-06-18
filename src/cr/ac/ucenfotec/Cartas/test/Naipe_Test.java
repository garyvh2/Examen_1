package cr.ac.ucenfotec.Cartas.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cr.ac.ucenfotec.Cartas.Carta;
import cr.ac.ucenfotec.Cartas.Naipe;
import cr.ac.ucenfotec.Cartas.Palo;

public class Naipe_Test {
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
}
