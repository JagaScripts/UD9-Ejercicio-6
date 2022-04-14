package cine;

public class mainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			final int FILA = 8, COL = 9;
				
			// Sala de cine
			char[][] sala = new char[FILA][COL];

			
			SalaCine cine = new SalaCine();
			cine.llenarMatriz(sala);
			cine.mostrarCine(sala);
		}

			
		

}
