package repoblacion.utilidades;

import org.iesalandalus.programacion.utilidades.Entrada;

import repoblacion.modelo.Bosque;

public class Consola {
	private Consola() {
		
	}
	
	public static int leerAnchura() {
		int anchura=0;
		do {
			System.out.println("Introduce la anchura del bosque, debe de ser como mínimo "+Bosque.MINIMO+", y como máximo "+Bosque.MAX_ANCHURA);
			anchura=Entrada.entero();
		}while(anchura<Bosque.MINIMO || anchura>Bosque.MAX_ANCHURA);
		return anchura;
	}
	
	public static int leerAltura() {
		int altura=0;
		do {
			System.out.println("Introduce la altura del bosque, debe de ser como mínimo "+Bosque.MINIMO+", y como máximo "+Bosque.MAX_ALTURA);
			altura=Entrada.entero();
		}while(altura<Bosque.MINIMO || altura>Bosque.MAX_ALTURA);
		return altura;
	}
	
	public static int leerPoblacion() {
		int poblacion=0;
		do {
			System.out.println("Introduce la población del bosque");
			poblacion=Entrada.entero();
		}while(poblacion<=0);
		return poblacion;
	}
}
