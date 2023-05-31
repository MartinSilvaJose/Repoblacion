package repoblacion.modelo;

import java.text.DecimalFormat;

public class Posicion {
	private double x;
	private double y;
	
	public Posicion(double x, double y) {
		setX(x);
		setY(y);
	}
	
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	
	public double distancia(Posicion p) {
		if(p!=null) {
			return Math.sqrt(Math.pow(this.getX()-p.getX(),2)+Math.pow(this.getY()-p.getY(), 2));
		}else {
			throw new NullPointerException("ERROR:La distancia no puede ser nula.");
		}
	}

	@Override
	public String toString() {
		DecimalFormat dF= new DecimalFormat("#.000");
		return "(x=" + dF.format(this.getX()) + ", y=" + dF.format(this.getY()) + ")";
	}
	
	
	
}
