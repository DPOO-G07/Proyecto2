package logica;

public class Devolucion {
	public String sede;
	public String cliente;
	public String fechadeDevolucion;
	public String horadeDevolucion;
	public String daños;
	public int cobrosporDaños;
	public int vehiculo;
	public Devolucion(String sede, String cliente, String fechadeDevolucion, String horadeDevolucion, String daños,
			int cobrosporDaños, int vehiculo) {
		super();
		this.sede = sede;
		this.cliente = cliente;
		this.fechadeDevolucion = fechadeDevolucion;
		this.horadeDevolucion = horadeDevolucion;
		this.daños = daños;
		this.cobrosporDaños = cobrosporDaños;
		this.vehiculo = vehiculo;
	}
	public String getSede() {
		return sede;
	}
	public String getCliente() {
		return cliente;
	}
	public String getFechadeDevolucion() {
		return fechadeDevolucion;
	}
	public String getHoradeDevolucion() {
		return horadeDevolucion;
	}
	public String getDaños() {
		return daños;
	}
	public int getCobrosporDaños() {
		return cobrosporDaños;
	}
	public int getVehiculo() {
		return vehiculo;
	}
	
	

}
