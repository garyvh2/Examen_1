package cr.ac.ucenfotec.Cartas.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import cr.ac.ucenfotec.Cartas.Mesa;
import cr.ac.ucenfotec.Cartas.Repartidor;

public class Mesa_Test {
	@Test
	public void Valid_Mesa () throws Exception {
		Repartidor _Repartidor = new Repartidor();
		Mesa _Mesa = new Mesa(_Repartidor);
		
		assertEquals(0, _Mesa.getJugadores().size());
		assertNotNull(_Mesa);
		assertNotNull(_Mesa.getRepartidor());
	}
}
