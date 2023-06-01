package repoblacion.modelo;

import java.util.Arrays;
import java.util.Random;

import javax.naming.OperationNotSupportedException;

public class Bosque {
	public static final int MAX_ALTURA=500;
	public static final int MINIMO=10;
	public static final int MAX_ANCHURA=1000;
	public static final int MAX_ESPECIES=4;
	
	private Arbol [] arboles;
	private Arbol arbolMasAlejado;
	private Arbol arbolMasCentrado;
	private Random generador;
	private int ancho;
	private int alto;
	
	public Bosque(int ancho, int alto) {
		generador=new Random();
		setAncho(ancho);
		setAlto(alto);
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		if(ancho>=MINIMO && ancho<=MAX_ANCHURA) {
			this.ancho = ancho;
		}else {
			throw new IllegalArgumentException("El ancho se sale del parametro.");
		}
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		if(alto>=MINIMO && alto<=MAX_ALTURA) {
			this.alto = alto;
		}else {
			throw new IllegalArgumentException("El alto se sale del parametro.");
		}
		
	}

	private void setArbolMasAlejado(Arbol arbolMasAlejado) {
		this.arbolMasAlejado = arbolMasAlejado;
	}
	private void setArbolMasCentrado(Arbol arbolMasCentrado) {
		this.arbolMasCentrado = arbolMasCentrado;
	}
	
	public Arbol getArbolMasAlejado() {
		return arbolMasAlejado;
	}
	public Arbol getArbolMasCentrado() {
		return arbolMasCentrado;
	}
	
	public void checkPoblacion(int poblacion) throws OperationNotSupportedException {
		
		if(poblacion>0 && poblacion<(2*(this.getAncho() + this.getAlto()))) {
			this.arboles= new Arbol[poblacion];
			repoblar();
		}else {
			throw new OperationNotSupportedException("La población excede el perímetro");
		}
		
	}
	
	private void repoblar() {
		Especie[] especiesDisponibles=randomEspecies();//Obtenemos un máximo de especies aleatorias determinadas en la constante.
		for(int i=0;i<this.arboles.length;i++) {//bucle para ir plantando arboles.
			
			Posicion posicion=randomPosicion();//obtenemos una posición aleatoria
			Especie especie=especiesDisponibles[generador.nextInt(0, MAX_ESPECIES)];//obtenemos una especie aleatoria de las disponibles.
			
			if(arboles[0]!=null) {//condicional para evitar un ArrayOutBoundExeception 
				do {
					especie=especiesDisponibles[generador.nextInt(0, MAX_ESPECIES)];//obtenemos una especie aleatoria de las disponibles hasta que sea compatible
				}while(//En este bucle controlamos antes de plantar el arbol donde arboles incompables en i-1
						(especie.equals(Especie.ALAMO) && arboles[i-1].getEspecie().equals(Especie.CASTANO)) ||
						(especie.equals(Especie.CIPRES) && arboles[i-1].getEspecie().equals(Especie.OLIVO)) ||
						(especie.equals(Especie.OLIVO) && arboles[i-1].getEspecie().equals(Especie.ALAMO)) ||
						(especie.equals(Especie.OLIVO) && arboles[i-1].getEspecie().equals(Especie.ENCINA))
					);
					
					arboles[i]=new Arbol(posicion,especie);
					
				
			}else {//En el caso de que arboles[0]==null no es necesario controlar los arboles compatibles y de esta manera nos ahorramos posibles errores.
				arboles[i]=new Arbol(posicion,especie);
			}

		}
		
	}

	private Especie[] randomEspecies() {

		Especie [] especies=Especie.values(); //Especies que existen.
		Especie [] especiesDisponibles= new Especie[MAX_ESPECIES];//Un array con el máximo de especies permitidas obtenidas desde la constante.
		
		for (int i = 0; i < especiesDisponibles.length; i++) {//Recorremos el array donde queremos insertar las especies 
			Especie e = especies[generador.nextInt(0, especies.length)];//extreamos una especie aleatoria de nuestro array de especies
			boolean valido = true;//creamos una variable centinela
			for (int j = 0; j < i; j++) {//hacemos un nuevo bucle donde me comprobara si la nueva especie es igual a la anterior con otro itinerador j
				if(e.equals(especiesDisponibles[j])) {//si es igual 
					i--;//restamos i para que todo el proceso vuelva a empezar con otra especie random
					valido = false;//centinela en falso 
					break;//y salimos del bucle
				}
			}
			if(valido) {//comprobamos si es valido 
				especiesDisponibles[i] = e;
			}
				
		}
		
		System.out.println(Arrays.toString(especiesDisponibles));
		return especiesDisponibles;
		
	}

	private Posicion randomPosicion() {
		
		double randomX=generador.nextDouble(-this.ancho/2, this.ancho/2);
		double randomY=generador.nextDouble(-this.alto/2, this.alto/2);
		
		return new Posicion(randomX,randomY);
		
	}
	
	public void realizarCalculos() {
		double distancia=0;
		
		Posicion posicionCero=new Posicion(0,0);
		setArbolMasAlejado(arboles[0]);
		setArbolMasCentrado(arboles[0]);
		
		double mayorDistancia=arboles[0].getPosicion().distancia(posicionCero);
		double menorDistancia=arboles[0].getPosicion().distancia(posicionCero);
		
		for(int i=0;i<arboles.length;i++) {

			distancia=arboles[i].getPosicion().distancia(posicionCero);
			
			if(mayorDistancia<distancia) {
				arbolMasAlejado=new Arbol(arboles[i]);
				mayorDistancia=distancia;
			}
			
			else if(menorDistancia>distancia) {
				arbolMasCentrado=new Arbol(arboles[i]);
				menorDistancia=distancia;
			}
			
		}
	}
	
}
