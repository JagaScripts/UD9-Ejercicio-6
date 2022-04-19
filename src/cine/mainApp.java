package cine;

import java.util.Random;

import javax.swing.JOptionPane;

public class mainApp {

	public static void main(String[] args) {

		final int FILA = 8, COL = 9;
		// Sala de cine
		char[][] sala = new char[FILA][COL];
		boolean generar;
		int fila, col, total = FILA * COL; // total de asientos
		String pregunta;
		Pelicula peli = new Pelicula("Batman", 144, 10, "saik");
		SalaCine cine1 = new SalaCine (peli);
		
		SalaCine cine = new SalaCine();
		
		cine.llenarMatriz(sala);
		
		//cine.mostrarCine(sala);
		
		}
	//Para generar edad random
	public static int edadRandom () {
		Random rnd = new Random();
		return (int) (rnd.nextDouble()* 100 + 1);		
		
	}
	
	//Para generar dinero random
	public static int dineroRandom () {
		Random rnd = new Random();
		return (int) (rnd.nextDouble()*90 + 1);	
		
	}
	//Para generar asiento random
	public static int asientoRandom (int max) {
		Random rnd = new Random();
		return (int)(rnd.nextDouble() * max);
	}
	

}
