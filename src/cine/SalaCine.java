package cine;

public class SalaCine {

	private Pelicula proyecta;
	private double precioEntrada;
	
	public Cine() {
		this(new Pelicula(), 10);
	}
	
	public Cine (Pelicula peli, double precio) {
		this.retransmite = peli;
		this.precioEntrada = precio;
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
