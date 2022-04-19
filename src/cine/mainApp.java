package cine;

import java.util.Hashtable;
import java.util.Random;

import javax.swing.JOptionPane;

public class mainApp {

	public static void main(String[] args) {

		//variables
		final int FILA = 8, COL = 9;
		// Sala de cine
		char[][] sala = new char[FILA][COL];
		boolean generar;
		int fila, col, total = FILA * COL; // total de asientos
		String pregunta;
		Espectador espectadores[] = new Espectador[10];
		
		//objetos
		Pelicula peli = new Pelicula("Batman", 144, 10, "saik");
		SalaCine cine1 = new SalaCine(peli);
		SalaCine cine = new SalaCine();

		cine.llenarMatriz(sala);

		System.out.println("CINE INICIAL");
		cine.mostrarCine(sala);

		// Una vuelta por cada Espectador
		for (int i = 0; i < 10; i++) {

			int filaAsiento, columnaAsiento;
			boolean condicion = false;
			
			filaAsiento = asientoRandom(FILA);
			columnaAsiento = asientoRandom(COL);
			do {
				// Generamos los asientos

				// Si el asiento esta libre
				if (cine.comprobarAsiento(sala, filaAsiento, columnaAsiento)) {// Creamos el espectador
					espectadores[i] = new Espectador(generarNombresAleatorios(), edadRandom(), dineroRandom());
					//mirar si tiene sufucuente dinero i edad	
					if (espectadores[i].getDinero() >= cine.getPrecioEntrada()
							&& espectadores[i].getEdad() >= peli.getEdadMinima()) {
						sala[filaAsiento][columnaAsiento] = 'X';
						espectadores[i].setFil(filaAsiento);
						espectadores[i].setCol(columnaAsiento);
						condicion = true;
					}
					//printamos si no puede estat i m ostramos las sod opciones
					else {
						System.out.println("No puedes entrar " + espectadores[i].getNombre());
						System.out.println("tu edad " + espectadores[i].getEdad() + "--> edad minima de la pelicula "+ peli.getEdadMinima());
						System.out.println("tu dinero " + espectadores[i].getDinero() + "--> Precio de el cine "+ cine.getPrecioEntrada());
					}

					} else {// Si no esta libre generamos otro asiento
						// System.out.println("Es false");
					filaAsiento = asientoRandom(FILA);
					columnaAsiento = asientoRandom(COL);
				}
			} while (!condicion);
				System.out.println(espectadores[i]);
		}
		
		System.out.println("CINE CON ESPECTADORES");
		cine.mostrarCine(sala);

	}

	// Para generar edad random
	public static int edadRandom() {
		Random rnd = new Random();
		return (int) (rnd.nextDouble() * 100 + 1);

	}

	// Para generar dinero random
	public static int dineroRandom() {
		Random rnd = new Random();
		return (int) (rnd.nextDouble() * 90 + 1);

	}

	// Para generar asiento random
	public static int asientoRandom(int max) {
		Random rnd = new Random();
		return (int) (rnd.nextDouble() * max);
	}
	//Generar nombres aleatorios
	public static String generarNombresAleatorios() {
		String nombresAleatorios;

		String[] nombres = { "Andrea", "David", "Baldomero", "Balduino", "Baldwin", "Baltasar", "Barry", "Bartolo",
				"Bartolom�", "Baruc", "Baruj", "Candelaria", "C�ndida", "Canela", "Caridad", "Carina", "Carisa",
				"Caritina", "Carlota", "Baltazar" };

		nombresAleatorios = nombres[(int) (Math.floor(Math.random() * ((nombres.length - 1))))];

		return nombresAleatorios;
	}
}
