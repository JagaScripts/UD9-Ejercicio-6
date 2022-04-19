package cine;

import java.util.Random;

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
		System.out.println("El asiento vacío se indeca con un guión (-)");
		System.out.println();
		cine.mostrarCine(sala);
		System.out.println();
		System.out.println("********************************");
		System.out.println();

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
					espectadores[i] = new Espectador();
					// mirar si tiene sufucuente dinero i edad
					if (espectadores[i].getDinero() >= cine.getPrecioEntrada()
							&& espectadores[i].getEdad() >= peli.getEdadMinima()) {
						sala[filaAsiento][columnaAsiento] = 'X';
						espectadores[i].setFil(filaAsiento);
						espectadores[i].setCol(columnaAsiento);
						condicion = true;
						espectadores[i].setSentado(condicion);
					} else {
						//printamos si no puede estat i m ostramos las sod opciones
						System.out.println("No puedes entrar " + espectadores[i].getNombre());
						System.out.println("tu edad " + espectadores[i].getEdad() + "--> edad minima de la pelicula "+ peli.getEdadMinima());
						System.out.println("tu dinero " + espectadores[i].getDinero() + "--> Precio de el cine "+ cine.getPrecioEntrada());
						System.out.println();
						espectadores[i].setSentado(false);
					}

				} else {// Si no esta libre generamos otro asiento
					// System.out.println("Es false");
					filaAsiento = asientoRandom(FILA);
					columnaAsiento = asientoRandom(COL);
				}
			} while (!condicion);
							
		}
		
		System.out.println("Estos espectadores si han podido entrar: ");
		System.out.println();
		for (int i = 0; i < espectadores.length; i++) {
			if (espectadores[i].isSentado()) {
				System.out.println("Puedes entrar " + espectadores[i].getNombre());
				System.out.println("tu edad " + espectadores[i].getEdad() + " --> edad minima de la pelicula " + peli.getEdadMinima());
				System.out.println("tu dinero " + espectadores[i].getDinero() + " --> Precio de el cine " + cine.getPrecioEntrada());
				System.out.println("su asiento es columna " + espectadores[i].getCol() + " --> y fila " + espectadores[i].getFil());
				System.out.println();
			}
		}
			
		System.out.println("CINE CON ESPECTADORES");
		System.out.println("El asiento vacío se indeca con un guión (X)");
		System.out.println();
		cine.mostrarCine(sala);

	}

	// Para generar asiento random
	public static int asientoRandom(int max) {
		Random rnd = new Random();
		return (int) (rnd.nextDouble() * max);
	}
	
}
