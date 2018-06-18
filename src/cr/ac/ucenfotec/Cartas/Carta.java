package cr.ac.ucenfotec.Cartas;

public class Carta {
	private String Nombre;
	private Palo Palo;
	private int Valor;
	
	// Constructor
	public Carta(String _Nombre, Palo _Palo, int _Valor) throws Exception {
		if (_Nombre.isEmpty() 	|| _Palo == null || (_Valor < 1 || _Valor > 10)) {
			throw new Exception ("Invalid parameters!");
		}
		try {
			int IntName = Integer.parseInt(_Nombre);
			if (IntName != _Valor) {
				throw new Exception ("Invalid name! " + IntName);
			}
		} catch (Exception e) {
			String LowerName = _Nombre.toLowerCase();
			if (!LowerName.equals("jota") 	&&
				!LowerName.equals("quina") 	&&
				!LowerName.equals("ka") 	&&
				!LowerName.equals("as") ) {
				throw new Exception ("Invalid name! " + LowerName);
			} else {
				if (_Valor != 1 && LowerName.equals("as")) {
					throw new Exception ("Invalid Value! " + _Valor);
				} else if (_Valor != 10 && !LowerName.equals("as")) {
					throw new Exception ("Invalid Value! " + _Valor);
				}
			}
		}
		
		this.Nombre = _Nombre;
		this.Palo = _Palo;
		this.Valor = _Valor;
	}
	
	// Get & Set
	public String getNombre() {
		return Nombre;
	}
	public Palo getPalo() {
		return Palo;
	}
	public int getValor() {
		return Valor;
	}
	
	// Overries
	@Override
	public boolean equals(Object obj) {
		// Same instance : True
		if (this == obj) 				return true;
		// Null instance : False
		if (obj == null)				return false;
		// Different Kind : False
		if (!(obj instanceof Carta))	return false;
		// Casting
		Carta _obj = (Carta) obj;
		// Different Value : False
		if (Valor != _obj.Valor) return false;
		// Otherwise : True
		return true;
	}
}