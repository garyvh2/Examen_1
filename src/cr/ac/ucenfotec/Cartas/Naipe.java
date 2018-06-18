package cr.ac.ucenfotec.Cartas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Naipe {
	private List<Carta> Cartas;
	// Constructor
	public Naipe () throws Exception {
		Cartas = new ArrayList<Carta>();
		
		List<Integer> Numeric = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		List<String> Special  = Arrays.asList("Jota", "Quina", "Ka");
		// Palos
		List<Palo> Palos = Arrays.asList(Palo.values());
		// Recorrido por palos
		Palos.forEach(_Palo -> {
			Numeric.forEach(Number -> {
				try {
					if (Number == 1) {
						Carta _As = new Carta("As", _Palo, 1);
						Cartas.add(_As);
					} else if (Number == 10) {
						Carta _Carta = new Carta(Number.toString(), _Palo, Number);
						Cartas.add(_Carta);
						Special.forEach(_Name -> {
							try {
								Carta _Special = new Carta(_Name, _Palo, 10);
								Cartas.add(_Special);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						});
					} else {
						Carta _Carta = new Carta(Number.toString(), _Palo, Number);
						Cartas.add(_Carta);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		});
	}
	
	// Get & Set
	public List<Carta> getCartas () {
		return Cartas;
	}
	
	// Methods
	public Naipe Sort () {
		Collections.shuffle(Cartas);
		return this;
	}
	
	// Custom Methods
	public boolean contains (Carta _Carta) {
		return Cartas.stream().anyMatch(Carta -> {
			return 	Carta.getValor() ==_Carta.getValor() 	&&
					Carta.getNombre().equals(_Carta.getNombre())	&&
					Carta.getPalo().equals(_Carta.getPalo());
		});
	}
	public void print() {
		Cartas.forEach(Carta -> System.out.println(Carta.toString()));
	}
}
