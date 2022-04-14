package cine;

public class SalaCine {

	private Pelicula proyecta;
	private double precioEntrada;
	
	final private double PRECIO_ENTRADA=7.80;
	
	public SalaCine (Pelicula peli) {
		this.proyecta = peli;
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
}
