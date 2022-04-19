package cine;

public class SalaCine {

	private Pelicula proyecta;
	private double precioEntrada;

	final private double PRECIO_ENTRADA = 7.80;

	public SalaCine(Pelicula peli) {
		this.proyecta = peli;
		this.precioEntrada = PRECIO_ENTRADA;
	}

	public SalaCine() {
		this.proyecta = null;
		this.precioEntrada = PRECIO_ENTRADA;
	}

	public Pelicula getProyecta() {
		return proyecta;
	}

	public void setProyecta(Pelicula proyecta) {
		this.proyecta = proyecta;
	}

	public double getPrecioEntrada() {
		return precioEntrada;
	}

	public void setPrecioEntrada(double precioEntrada) {
		this.precioEntrada = precioEntrada;

	}

	public static void mostrarCine(char[][] sala) {
		final int CARACTER = 65;
		int i, j, caracter, max = sala.length;
		for (i = 0; i < sala.length; i++, max--) {
			caracter = CARACTER; // Esto es para las letra
			for (j = 0; j < sala[i].length; j++, caracter++) {
				System.out.print(max + "" + (char) caracter + "" + sala[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void llenarMatriz(char[][] sala) {
		int i, j;
		for (i = 0; i < sala.length; i++) {
			for (j = 0; j < sala[i].length; j++) {
				sala[i][j] = '-';
			}
		}
	}

	public static boolean comprobarAsiento(char[][] sala, int fil, int col) {

		//Comprobamos si el asiento esta vacio
		if (sala[fil][col] == '-') {
			return true;			
		}

		return false;
	}

}
