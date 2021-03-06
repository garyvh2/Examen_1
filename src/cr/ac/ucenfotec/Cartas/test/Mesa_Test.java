package cr.ac.ucenfotec.Cartas.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import cr.ac.ucenfotec.Cartas.Carta;
import cr.ac.ucenfotec.Cartas.Jugador;
import cr.ac.ucenfotec.Cartas.Mesa;
import cr.ac.ucenfotec.Cartas.Palo;
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
	// 8. Start 21
	@Test
	public void Start_21 () throws Exception {
		Repartidor _Repartidor = new Repartidor();
		Mesa _Mesa = new Mesa(_Repartidor);
		
		// Jugadores
		Jugador _J1 = new Jugador ("J1", null);
		Jugador _J2 = new Jugador ("J2", null);
		Jugador _J3 = new Jugador ("J3", null);
		Jugador _J4 = new Jugador ("J4", null);
		
		_Mesa.AgregarJugador(_J1);
		_Mesa.AgregarJugador(_J2);
		_Mesa.AgregarJugador(_J3);
		_Mesa.AgregarJugador(_J4);
		
		// Empezar
		_Mesa.Start21();
		
		_Mesa.getJugadores().forEach(_Jugador -> {
			assertEquals(2, _Jugador.getMano().size());
		});
		
		assertEquals(44, _Mesa.getRepartidor().getNaipe().Size());
		
	}
	// 9. Ganar 21
	@Test
	public void Ganar_21 () throws Exception {
		Repartidor _Repartidor = new Repartidor();
		Mesa _Mesa = new Mesa(_Repartidor);
		
		// Jugadores
		Jugador _J1 = new Jugador ("J1", null);
		Jugador _J2 = new Jugador ("J2", null);
		Jugador _J3 = new Jugador ("J3", null);
		Jugador _J4 = new Jugador ("J4", null);
		
		_Mesa.AgregarJugador(_J1);
		_Mesa.AgregarJugador(_J2);
		_Mesa.AgregarJugador(_J3);
		_Mesa.AgregarJugador(_J4);
		
		// Empezar
		_Mesa.Start21();
		
		assertTrue(_Mesa.Ganador21().size() >= 1);
		
	}

	// 10. Cambiar Mano 21
	@Test
	public void Cambiar_Mano_21 () throws Exception {
		Repartidor _Repartidor = new Repartidor();
		Mesa _Mesa = new Mesa(_Repartidor);
		
		// Cartas
		Carta C_3 = new Carta ("3", Palo.ESCUDOS, 3);
		Carta C_5 = new Carta ("5", Palo.GOTAS, 5);
		Carta C_J = new Carta ("Jota", Palo.ESTRELLAS, 10);
		C_J.setSpecial(true);
		
		// Jugadores
		Jugador _J1 = new Jugador ("J1", Arrays.asList(C_3, C_J));
		Jugador _J2 = new Jugador ("J2", Arrays.asList(C_5, C_J));
		
		_Mesa.AgregarJugador(_J2);
		
		assertEquals(0, _Mesa.VerificarMano().size());
		
		_Mesa.AgregarJugador(_J1);
		assertEquals(1, _Mesa.VerificarMano().size());
	}
	// 11. Veintiuno y medio
	@Test
	public void Veintiuno_Medio () throws Exception {
		Repartidor _Repartidor = new Repartidor();
		Mesa _Mesa = new Mesa(_Repartidor);
		
		// Cartas
		Carta C_2 = new Carta ("2", Palo.ESCUDOS, 2);
		Carta C_5 = new Carta ("5", Palo.GOTAS, 5);
		Carta C_J = new Carta ("Jota", Palo.ESTRELLAS, 10);
		C_J.setSpecial(true);
		
		// Jugadores
		Jugador _J1 = new Jugador ("J1", Arrays.asList(C_2, C_J));
		Jugador _J2 = new Jugador ("J2", Arrays.asList(C_5, C_J));
		
		
		_Mesa.AgregarJugador(_J1);
		_Mesa.AgregarJugador(_J2);
		
		assertEquals(_J1, _Mesa.Ganador21().stream().findFirst().get());
	}	
	// 13. Start Ron
	@Test
	public void Start_Ron () throws Exception {
		Repartidor _Repartidor = new Repartidor();
		Mesa _Mesa = new Mesa(_Repartidor);
		
		// Jugadores
		Jugador _J1 = new Jugador ("J1", null);
		Jugador _J2 = new Jugador ("J2", null);
		Jugador _J3 = new Jugador ("J3", null);
		Jugador _J4 = new Jugador ("J4", null);
		
		_Mesa.AgregarJugador(_J1);
		_Mesa.AgregarJugador(_J2);
		_Mesa.AgregarJugador(_J3);
		_Mesa.AgregarJugador(_J4);
		
		// Empezar
		_Mesa.StartRon();
		
		_Mesa.getJugadores().forEach(_Jugador -> {
			assertEquals(7, _Jugador.getMano().size());
		});
		
		assertEquals(24, _Mesa.getRepartidor().getNaipe().Size());
		
	}
	// 14. Tomar una carta
	@Test
	public void Tomar_Carta () throws Exception {
		Repartidor _Repartidor = new Repartidor();
		Mesa _Mesa = new Mesa(_Repartidor);
		
		// Jugadores
		Jugador _J1 = new Jugador ("J1", null);
		Jugador _J2 = new Jugador ("J2", null);
		Jugador _J3 = new Jugador ("J3", null);
		Jugador _J4 = new Jugador ("J4", null);
		
		_Mesa.AgregarJugador(_J1);
		_Mesa.AgregarJugador(_J2);
		_Mesa.AgregarJugador(_J3);
		_Mesa.AgregarJugador(_J4);
		
		// Empezar
		_Mesa.StartRon();
		
		_J1.TomarCarta(_Mesa.getDeck(), _Mesa.getDiscarted());
		_J2.TomarCarta(_Mesa.getDeck(), _Mesa.getDiscarted());
		
		assertEquals(7, _J1.getMano().size());
		assertEquals(7, _J2.getMano().size());
		assertEquals(7, _J3.getMano().size());
		assertEquals(7, _J4.getMano().size());
		
		assertEquals(22, _Mesa.getDeck().Size());
		
	}
	// 15. Descartar una carta
	@Test
	public void Descartar_Carta () throws Exception {
		Repartidor _Repartidor = new Repartidor();
		Mesa _Mesa = new Mesa(_Repartidor);
		
		// Jugadores
		Jugador _J1 = new Jugador ("J1", null);
		Jugador _J2 = new Jugador ("J2", null);
		Jugador _J3 = new Jugador ("J3", null);
		Jugador _J4 = new Jugador ("J4", null);
		
		_Mesa.AgregarJugador(_J1);
		_Mesa.AgregarJugador(_J2);
		_Mesa.AgregarJugador(_J3);
		_Mesa.AgregarJugador(_J4);
		
		// Empezar
		_Mesa.StartRon();
		
		_J1.TomarCarta(_Mesa.getDeck(), _Mesa.getDiscarted());
		_J2.TomarCarta(_Mesa.getDeck(), _Mesa.getDiscarted());
		
		assertEquals(7, _J1.getMano().size());
		assertEquals(7, _J2.getMano().size());
		

		assertEquals(2, _Mesa.getDiscarted().Size());
		assertEquals(22, _Mesa.getDeck().Size());
		
	}
	// 16. Reset
	@Test
	public void Reset_Mesa () throws Exception {
		Repartidor _Repartidor = new Repartidor();
		Mesa _Mesa = new Mesa(_Repartidor);
		
		// Jugadores
		Jugador _J1 = new Jugador ("J1", null);
		Jugador _J2 = new Jugador ("J2", null);
		Jugador _J3 = new Jugador ("J3", null);
		Jugador _J4 = new Jugador ("J4", null);
		
		_Mesa.AgregarJugador(_J1);
		_Mesa.AgregarJugador(_J2);
		_Mesa.AgregarJugador(_J3);
		_Mesa.AgregarJugador(_J4);
		
		// Empezar
		_Mesa.StartRon();
		
		_J1.TomarCarta(_Mesa.getDeck(), _Mesa.getDiscarted());
		_J2.TomarCarta(_Mesa.getDeck(), _Mesa.getDiscarted());
		
		assertEquals(7, _J1.getMano().size());
		assertEquals(7, _J2.getMano().size());
		

		assertEquals(2, _Mesa.getDiscarted().Size());
		assertEquals(22, _Mesa.getDeck().Size());
		
		_Mesa.Reset();
		

		assertEquals(52, _Mesa.getRepartidor().getNaipe().Size());
		assertEquals(0, _Mesa.getJugadores().size());
	}
}
