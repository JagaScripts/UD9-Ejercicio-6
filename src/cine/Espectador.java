package cine;

import java.util.Random;

public class Espectador {

	private String nombre;
	private int edad;
	private double dinero;
	private int fil;
	private int col;
	private boolean sentado;

	public Espectador() {
		this.nombre = generarNombresAleatorios();
		this.edad = edadRandom();
		this.dinero = dineroRandom();
		this.sentado = false;
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

	public int getFil() {
		return fil;
	}

	public void setFil(int fil) {
		this.fil = fil;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
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

		//Si tienes la edad ...true
		if (getEdad() >= peli.getEdadMinima()) {
			apto = true;

		}

		return apto;
	}

	// metodo para ver si es comprar la entrada de cine
	public boolean compraEntrada(SalaCine cine) {

		//Si tienes menos dinero que la entrada... false
		if (cine.getPrecioEntrada() >= getDinero()) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public String toString() {
		return "Espectador [nombre=" + nombre + ", edad=" + edad + ", dinero=" + dinero + "]";
	}

	public boolean isSentado() {
		return sentado;
	}

	public void setSentado(boolean sentado) {
		this.sentado = sentado;
	}
	
	// Para generar edad random
	private static int edadRandom() {
		//Generamos la edad aleatoriamente
		Random rnd = new Random();
		return (int) (rnd.nextDouble() * 100 + 1); //Entre 1 y 100

	}

	// Para generar dinero random
	private static int dineroRandom() {
		//generamos dinero aleatoriamente
		Random rnd = new Random();
		return (int) (rnd.nextDouble() * 90 + 1); //Entre 1 y 90

	}
	
	// Generar nombres aleatorios
	private static String generarNombresAleatorios() {
		String nombresAleatorios;

		String[] nombres = { "Andrea", "David", "Baldomero", "Balduino", "Baldwin", "Baltasar", "Barry", "Bartolo",
				"Bartolom�", "Baruc", "Baruj", "Candelaria", "C�ndida", "Canela", "Caridad", "Carina", "Carisa",
				"Caritina", "Carlota", "Baltazar" };

		//Generamos un nombre aleatorio de la matriz
		nombresAleatorios = nombres[(int) (Math.floor(Math.random() * ((nombres.length - 1))))];

		return nombresAleatorios;
	}
}
