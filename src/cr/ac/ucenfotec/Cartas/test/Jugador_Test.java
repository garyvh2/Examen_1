package cr.ac.ucenfotec.Cartas.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;

import org.junit.Test;

import cr.ac.ucenfotec.Cartas.Carta;
import cr.ac.ucenfotec.Cartas.Jugador;
import cr.ac.ucenfotec.Cartas.Palo;

public class Jugador_Test {
	// 5. Jugador
	@Test
	public void Valid_Jugador () throws Exception {
		Carta C_1 = new Carta ("10", 	Palo.ESCUDOS, 10);
		
		Jugador _Jugador = new Jugador ("Gary", Arrays.asList(C_1));
		
		assertEquals(C_1, _Jugador.getMano().stream().findFirst().get());
		assertEquals("Gary", _Jugador.getNombre());
		assertNotNull(_Jugador);
	}
}
