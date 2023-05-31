package repoblacion.modelo;

public enum Especie {
	ALAMO("Álamo"),
	ENCINA("Encina"),
	CASTANO("Castaño"),
	CIPRES("Ciprés"),
	PINO_PINONERO("Pino piñonero"),
	ROBLE_MEDITERRANEO("Roble Mediterráneo"),
	OLIVO("Olivo");
	
	private String cadenaAMostrar;
	
	private Especie(String cadenaAMostrar) {
		this.cadenaAMostrar=cadenaAMostrar;
	}
	
	public String toString() {
		return this.cadenaAMostrar;
				
	}
	
}
