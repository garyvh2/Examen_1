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
	
	// Custom Methods
	public Mesa AgregarJugador (Jugador _Jugador) throws Exception {
		if (this.getJugadores().size() == 4) {
			throw new Exception ("Mesa Llena!");
		}
		this.getJugadores().add(_Jugador);
		
		return this;
	}
	
	public Mesa Start21 () throws Exception {
		if (this.getJugadores().size() == 0) {
			throw new Exception ("Mesa Vacia!");
		}
		RepartirCartas(2);
		
		return this;
	}
	
	public void RepartirCartas (int Cantidad) {
		for (int i = 0; i < Cantidad; i ++) {
			this.getJugadores().forEach(_Jugador -> {
				this.Repartidor.DarCarta(_Jugador);
			});
		}
	}
	
	
}
