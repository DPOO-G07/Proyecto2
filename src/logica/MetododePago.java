package logica;

public class MetododePago {
	public double numerodeTarjeta;
	public String fechadeCaducidad;
	public String tipo;
	public MetododePago(double numerodeTarjeta, String fechadeCaducidad, String tipo) {
		super();
		this.numerodeTarjeta = numerodeTarjeta;
		this.fechadeCaducidad = fechadeCaducidad;
		this.tipo = tipo;
	}
	public double getNumerodeTarjeta() {
		return numerodeTarjeta;
	}
	public void setNumerodeTarjeta(double numerodeTarjeta) {
		this.numerodeTarjeta = numerodeTarjeta;
	}
	public String getFechadeCaducidad() {
		return fechadeCaducidad;
	}
	public void setFechadeCaducidad(String fechadeCaducidad) {
		this.fechadeCaducidad = fechadeCaducidad;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
