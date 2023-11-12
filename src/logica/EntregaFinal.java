package logica;

public class EntregaFinal {
	public int vehiculo;
	public String cliente;
	public String otroConductor;
	public String empleado;
	public EntregaFinal(int vehiculo, String cliente, String otroConductor, String empleado) {
		super();
		this.vehiculo = vehiculo;
		this.cliente = cliente;
		this.otroConductor = otroConductor;
		this.empleado = empleado;
	}
	public int getVehiculo() {
		return vehiculo;
	}
	public String getCliente() {
		return cliente;
	}
	public String getOtroConductor() {
		return otroConductor;
	}
	public String getEmpleado() {
		return empleado;
	}

}
