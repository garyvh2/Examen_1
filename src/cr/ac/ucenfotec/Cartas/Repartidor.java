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
}
