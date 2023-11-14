package logica;

public class Reserva {
	public Double numerodeReserva;
	public String tipodeVehiculo;
	public String Sede;
	public String fechadeRecoleccion;
	public String horadeRecoleccion;
	public String fechadeEntrega;
	public String horadeEntrega;
	public Double cobro;
	public String nomcliente;
	public String estado;
	
	public Reserva(Double numerodeReserva, String tipodeVehiculo, String sede, String fechadeRecoleccion, String horadeRecoleccion,
			String fechadeEntrega, String horadeEntrega, Double cobro, String nomcliente, String estado) {
		super();
		this.numerodeReserva = numerodeReserva;
		this.tipodeVehiculo = tipodeVehiculo;
		Sede = sede;
		this.fechadeRecoleccion = fechadeRecoleccion;
		this.horadeRecoleccion = horadeRecoleccion;
		this.fechadeEntrega = fechadeEntrega;
		this.horadeEntrega = horadeEntrega;
		this.cobro = cobro;
		this.nomcliente = nomcliente;
		this.estado = estado;
	}
	public String getTipodeVehiculo() {
		return tipodeVehiculo;
	}
	public Double getNumerodereserva() {
		return numerodeReserva;
	}
	public String getSede() {
		return Sede;
	}
	public String getFechadeRecoleccion() {
		return fechadeRecoleccion;
	}
	public String getHoradeRecoleccion() {
		return horadeRecoleccion;
	}
	public String getFechadeEntrega() {
		return fechadeEntrega;
	}
	public String getHoradeEntrega() {
		return horadeEntrega;
	}
	public Double getCobro() {
		return cobro;
	}
	public String getNomcliente() {
		return nomcliente;
	}
	
	public String getEstado() {
		return estado;
	}
	
}
