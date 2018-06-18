package cr.ac.ucenfotec.Cartas.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


import org.junit.Test;

import cr.ac.ucenfotec.Cartas.Jugador;
import cr.ac.ucenfotec.Cartas.Mesa;
import cr.ac.ucenfotec.Cartas.Repartidor;

public class Mesa_Test {
	// 6.1 Mesa
	@Test
	public void Valid_Mesa () throws Exception {
		Repartidor _Repartidor = new Repartidor();
		Mesa _Mesa = new Mesa(_Repartidor);
		
		assertEquals(0, _Mesa.getJugadores().size());
		assertNotNull(_Mesa);
		assertNotNull(_Mesa.getRepartidor());
	}
	// 6.2 Agregar Jugador
	@Test
	public void Agregar_Jugador () throws Exception {
		Repartidor _Repartidor = new Repartidor();
		Mesa _Mesa = new Mesa(_Repartidor);
		
		// Vacia
		assertEquals(0, _Mesa.getJugadores().size());
		
		// Jugadores
		Jugador _J1 = new Jugador ("J1", null);
		Jugador _J2 = new Jugador ("J2", null);
		Jugador _J3 = new Jugador ("J3", null);
		Jugador _J4 = new Jugador ("J4", null);
		
		
		
		// 1 Jugador
		_Mesa.AgregarJugador(_J1);
		assertEquals(1, _Mesa.getJugadores().size());

		// 2 Jugador
		_Mesa.AgregarJugador(_J2);
		assertEquals(2, _Mesa.getJugadores().size());

		// 3 Jugador
		_Mesa.AgregarJugador(_J3);
		assertEquals(3, _Mesa.getJugadores().size());

		// 4 Jugador
		_Mesa.AgregarJugador(_J4);
		assertEquals(4, _Mesa.getJugadores().size());
		
		assertNotNull(_Mesa.getJugadores().stream().findFirst().get());
	}
	@Test(expected = Exception.class)
	public void Mesa_Llena () throws Exception {
		Repartidor _Repartidor = new Repartidor();
		Mesa _Mesa = new Mesa(_Repartidor);
		
		// Jugadores
		Jugador _J1 = new Jugador ("J1", null);
		Jugador _J2 = new Jugador ("J2", null);
		Jugador _J3 = new Jugador ("J3", null);
		Jugador _J4 = new Jugador ("J4", null);
		Jugador _J5 = new Jugador ("J5", null);
		
		_Mesa.AgregarJugador(_J1);
		_Mesa.AgregarJugador(_J2);
		_Mesa.AgregarJugador(_J3);
		_Mesa.AgregarJugador(_J4);
		_Mesa.AgregarJugador(_J5);
		
	}
}
