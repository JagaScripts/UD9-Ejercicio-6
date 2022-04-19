package cine;

import java.util.Random;

public class Espectador {

<<<<<<< HEAD
		private String nombre;
		private int edad;
		private double dinero;
		private int fil;
		private int col;
		
		public Espectador() {
			this.nombre = "";
			this.edad = 30;
			this.dinero = 30.0;
		}
		
		public Espectador(String nombre, int edad, double dinero) {
			this.nombre = nombre;
			this.edad = edad;
			this.dinero = dinero;
=======
	private String nombre;
	private int edad;
	private double dinero;

	public Espectador() {
		this.nombre = "";
		this.edad = 30;
		this.dinero = 30.0;
	}

	public Espectador(String nombre, int edad, double dinero) {
		this.nombre = nombre;
		this.edad = edad;
		this.dinero = dinero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getDinero() {
		return dinero;
	}

	public void setDinero(double dinero) {
		this.dinero = dinero;
	}

	// METODOS para ver si es apto de edad
	public boolean aptoEdad(Pelicula peli) {
		boolean apto = false;

		if (getEdad() > peli.getEdadMinima()) {
			apto = true;
>>>>>>> de4c48ac9ffeb8bc9c6bb0a5f63989997fccfc19
		}

		return apto;
	}

	// metodo para ver si es comprar la entrada de cine
	public boolean compraEntrada(SalaCine cine) {

		if (cine.getPrecioEntrada() > getDinero()) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public String toString() {
		return "Espectador [nombre=" + nombre + ", edad=" + edad + ", dinero=" + dinero + "]";
	}
}
