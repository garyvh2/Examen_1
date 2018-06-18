package cr.ac.ucenfotec.Cartas;

import java.util.ArrayList;
import java.util.List;

public class Mesa {
	private Repartidor Repartidor;
	private List<Jugador> Jugadores;
	
	public Mesa (Repartidor _Repartidor) {
		this.Repartidor = _Repartidor;
		this.Jugadores  = new ArrayList<Jugador>();
	}

	public Repartidor getRepartidor() {
		return Repartidor;
	}

	public void setRepartidor(Repartidor repartidor) {
		Repartidor = repartidor;
	}

	public List<Jugador> getJugadores() {
		return Jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		Jugadores = jugadores;
	}
	
	
	
}