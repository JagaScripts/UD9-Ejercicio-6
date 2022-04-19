package cine;

import java.util.Random;

public class mainApp {

	public static void main(String[] args) {

		// variables
		final int FILA = 8, COL = 9;
		final int NUM_ESPECTADORES = 20;
		// Sala de cine
		char[][] sala = new char[FILA][COL];
		int fila, col, total = FILA * COL; // total de asientos
		Espectador espectadores[] = new Espectador[NUM_ESPECTADORES];

		// objetos
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
		for (int i = 0; i < NUM_ESPECTADORES; i++) {

			int filaAsiento, columnaAsiento;
			boolean condicion = false;

			filaAsiento = asientoRandom(FILA);
			columnaAsiento = asientoRandom(COL);

			espectadores[i] = new Espectador();

			// Comprobamos que el cliente cumpla las condiciones
			if (espectadores[i].compraEntrada(cine) && espectadores[i].aptoEdad(peli)) {
				do {
					if (cine1.comprobarAsiento(sala, filaAsiento, columnaAsiento)) {
						sala[filaAsiento][columnaAsiento] = 'X';
						espectadores[i].setFil(filaAsiento);
						espectadores[i].setCol(columnaAsiento);
						espectadores[i].setSentado(true);
						condicion = true;
					} else {
						filaAsiento = asientoRandom(FILA);
						columnaAsiento = asientoRandom(COL);
					}

				} while (!condicion);
			} else {
				espectadores[i].setSentado(false);
			}

		}
		
		System.out.println("Estos espectadores si han podido entrar: \n");
		
		for (int i = 0; i < espectadores.length; i++) {
			if(espectadores[i].isSentado()) {
				System.out.println(espectadores[i].getNombre());
			}
		}

		System.out.println("\nEstos espectadores no han podido entrar: \n");

		for (int i = 0; i < espectadores.length; i++) {
			if (!espectadores[i].isSentado()) {
				if (!espectadores[i].compraEntrada(cine)) {
					System.out.println(espectadores[i].getNombre() + " no tiene dinero suficiente... su dinero: "
							+ espectadores[i].getDinero() + "€");
				} else {
					System.out.println(espectadores[i].getNombre() + " no tiene la edad suficiente... su edad: "
							+ espectadores[i].getEdad() + " años");
				}
			}
		}

		System.out.println("\nCINE CON ESPECTADORES");
		System.out.println("El asiento ocupado se indeca con una equis (X)\n");
		cine.mostrarCine(sala);

	}

	// Para generar asiento random
	public static int asientoRandom(int max) {
		Random rnd = new Random();
		return (int) (rnd.nextDouble() * max);
	}

}
