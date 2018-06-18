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
		boolean has_special = false, 
				has_2		= false, 
				has_10		= false;
		for (Carta _Carta : this.Mano) {
			int Card_Value = _Carta.getValor();
			if (_Carta.isSpecial())
				has_special = true;
			if (Card_Value == 2)
				has_2 = true;
			if (Card_Value == 10)
				has_10 = true;
			Value += Card_Value;
		}
		if ((Value == 20 && has_special) || (has_2 && has_10))
			Value = 21;
		return Value;
		
	}
	
	public void TomarCarta (Naipe Deck) {
		Mano.add(Deck.PopFirst());
	}
	
}
