package repoblacion;

import javax.naming.OperationNotSupportedException;

import repoblacion.modelo.Bosque;
import repoblacion.utilidades.Consola;

public class MainApp {

	
	public static void main(String[] args) {
		Bosque b=new Bosque(Consola.leerAnchura(),Consola.leerAltura());
		while(true) {
			try {
				b.checkPoblacion(Consola.leerPoblacion());
				b.realizarCalculos();
				System.out.println("El arbos mas centrado es:"+b.getArbolMasCentrado());
				System.out.println("El arbos mas alejado es:" +b.getArbolMasAlejado());
				break;
			}catch (OperationNotSupportedException e) {
				System.out.println(e.getMessage());
			}
		}

		
	}
	
}
