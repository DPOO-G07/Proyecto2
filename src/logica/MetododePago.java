package logica;

public class MetododePago {
	public double numerodeTarjeta;
	public String fechadeCaducidad;
	public String tipo;
	public Boolean bloqueada;
	public MetododePago(double numerodeTarjeta, String fechadeCaducidad, String tipo, Boolean bloqueada) {
		super();
		this.numerodeTarjeta = numerodeTarjeta;
		this.fechadeCaducidad = fechadeCaducidad;
		this.tipo = tipo;
		this.bloqueada = bloqueada;
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
	public Boolean getBloqueada() {
		return bloqueada;
	}
	public void setBloqueada(Boolean bloqueada) {
		this.bloqueada = bloqueada;
	}

}
