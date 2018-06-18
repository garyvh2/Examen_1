package cr.ac.ucenfotec.Cartas.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cr.ac.ucenfotec.Cartas.Carta;
import cr.ac.ucenfotec.Cartas.Palo;
import cr.ac.ucenfotec.Cartas.Repartidor;

public class Repartidor_Test {
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
		@Test
		public void Valid_Repartidor_Naipe_Order () throws Exception {
			Repartidor _Repartidor = new Repartidor();

			_Repartidor.getNaipe().print();
			
			// Duda
			assertNotEquals(new Carta ("As", Palo.ESCUDOS, 1), 	_Repartidor.getNaipe().getCartas().stream().findFirst().get());
			assertNotEquals(new Carta ("Ka", Palo.GOTAS, 10), 	_Repartidor.getNaipe().getCartas().stream().reduce((first, second) -> second).orElse(null));
		}
}
