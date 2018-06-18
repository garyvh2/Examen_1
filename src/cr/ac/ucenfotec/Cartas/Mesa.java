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
	
	public void RepartirCartas (int Cantidad) {
		for (int i = 0; i < Cantidad; i ++) {
			this.getJugadores().forEach(_Jugador -> {
				this.Repartidor.DarCarta(_Jugador);
			});
		}
	}
	
	// 21
	public Mesa Start21 () throws Exception {
		if (this.getJugadores().size() == 0) {
			throw new Exception ("Mesa Vacia!");
		}
		RepartirCartas(2);
		
		return this;
	}
	public List<Jugador> Ganador21 () throws Exception {
		List<Jugador> Ganadores = new ArrayList<Jugador>();
		List<Jugador> Ganadores_Iter = new ArrayList<Jugador>();
		
		this.Jugadores.forEach(_Jugador -> {
			Ganadores_Iter.clear();
			Ganadores_Iter.addAll(Ganadores);
			if (Ganadores.size() > 0)
				Ganadores_Iter.forEach(_Ganador -> {
					if (_Ganador.ManoVal() < _Jugador.ManoVal()) {
						Ganadores.clear();
						Ganadores.add(_Jugador);
					} else if (_Ganador.ManoVal() == _Jugador.ManoVal()) {
						Ganadores.add(_Jugador);
					}
				});
			else 
				Ganadores.add(_Jugador);
		});
		return Ganadores;
	}
	public List<Jugador> VerificarMano () throws Exception {
		List<Jugador> Change = new ArrayList<Jugador>();
		
		this.Jugadores.forEach(_Jugador -> {
			boolean have_3 = false, have_special = false;
			for (Carta _Carta : _Jugador.getMano()) {
				if (_Carta.getValor() == 3)
					have_3 = true;
				if (_Carta.isSpecial())
					have_special = true;
			}
			if (have_3 && have_special)
				Change.add(_Jugador);
		});
		
		return Change;
	}
	
}
