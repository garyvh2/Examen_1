package cr.ac.ucenfotec.Cartas;

public class Repartidor {
	private Naipe Naipe;
	// Constructor
	public Repartidor () throws Exception {
		this.Naipe = new Naipe().Sort();
	}
	
	// Get & Set
	public Naipe getNaipe () {
		return Naipe;
	}
	
	// Custom Methods
	public void DarCarta (Jugador _Jugador) {
		Carta _Carta = Naipe.PopFirst();
		_Jugador.getMano().add(_Carta);
	}
}
