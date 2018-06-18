package cr.ac.ucenfotec.Cartas;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
	private String Nombre;
	private List<Carta> Mano;
	
	// Constructor
	public Jugador (String _Nombre, List<Carta> _Mano) {
		this.Nombre = _Nombre;
		this.Mano = _Mano != null ? _Mano : new ArrayList<Carta>();
	}
	// Get & Set
	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public List<Carta> getMano() {
		return Mano;
	}

	public void setMano(List<Carta> mano) {
		Mano = mano;
	}
	
	// Custom Methods
	public int ManoVal () {
		int Value = 0;
		for (Carta _Carta : this.Mano) {
			Value += _Carta.getValor();
		}
		return Value;
		
	}
	
}
