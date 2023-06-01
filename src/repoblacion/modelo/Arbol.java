package repoblacion.modelo;

public class Arbol {
	private Posicion posicion;
	private Especie especie;
	
	public Arbol(Posicion p, Especie e) {
		setPosicion(p);
		setEspecie(e);
	}
	
	public Arbol(Arbol a) {
		setPosicion(a.getPosicion());
		setEspecie(a.getEspecie());

	}
	
	public Posicion getPosicion() {
		return posicion;
	}
	public void setPosicion(Posicion posicion) {
		if(posicion!=null) {
			this.posicion = posicion;

		}else {
			throw new NullPointerException("Poscion no puede ser nula.");
		}
	}
	
	public Especie getEspecie() {
		return especie;
	}
	public void setEspecie(Especie especie) {
		if(especie!=null) {
			this.especie = especie;

		}else {
			throw new NullPointerException("Especie no puede ser nula.");
		}
	}

	@Override
	public String toString() {
		return "(" + this.getEspecie() + ", " + this.getPosicion() + ")";
	}
	
	
}
