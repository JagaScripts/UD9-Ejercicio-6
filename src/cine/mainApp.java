package cine;

import java.util.Random;

public class mainApp {

	public static void main(String[] args) {

		// variables
		final int FILA = 8, COL = 9;
		final int NUM_ESPECTADORES = 20;
		// Sala de cine
		char[][] sala = new char[FILA][COL];
		//int fila, col, total = FILA * COL; // total de asientos
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
				//Una vez que sabemos que pueden entrar, les asignamos un asiento que no este ocupado
				do {
					if (cine1.comprobarAsiento(sala, filaAsiento, columnaAsiento)) {
						sala[filaAsiento][columnaAsiento] = 'X';
						espectadores[i].setFil(filaAsiento);
						espectadores[i].setCol(columnaAsiento);
						espectadores[i].setSentado(true);
						condicion = true;
					} else {//Si esta ocupado, entra aqui y les reasigna a otra asiento
						filaAsiento = asientoRandom(FILA);
						columnaAsiento = asientoRandom(COL);
					}

				} while (!condicion);
			} else {//Si no tienen dinero o la edad no entran
				espectadores[i].setSentado(false);
			}

		}
		
		//Bucle para listar los espectadores que estan en el cine
		System.out.println("Estos espectadores si han podido entrar: \n");		
		for (int i = 0; i < espectadores.length; i++) {
			if(espectadores[i].isSentado()) {
				System.out.println(espectadores[i].getNombre());
			}
		}

		//Bucle para listar los que no han entrado
		System.out.println("\nEstos espectadores no han podido entrar: \n");
		for (int i = 0; i < espectadores.length; i++) {
			if (!espectadores[i].isSentado()) {
				if (!espectadores[i].compraEntrada(cine)) { //Si no tienen dinero...
					System.out.println(espectadores[i].getNombre() + " no tiene dinero suficiente... su dinero: "
							+ espectadores[i].getDinero() + "€");
				} else {//Si no tienen la edad
					System.out.println(espectadores[i].getNombre() + " no tiene la edad suficiente... su edad: "
							+ espectadores[i].getEdad() + " años");
				}
			}
		}

		//Mostramos como a quedado el cine
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
