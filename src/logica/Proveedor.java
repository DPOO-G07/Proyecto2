package logica;

import java.util.ArrayList;

public class Proveedor {
	public String nombre;
	public String vehiculo;
	public int cantidaddeVehiculo;
	
	public Proveedor(String nombre, String vehiculo, int cantidaddeVehiculo) {
		super();
		this.nombre = nombre;
		this.vehiculo = vehiculo;
		this.cantidaddeVehiculo = cantidaddeVehiculo;
		
	}
	public String getNombre() {
		return nombre;
	}
	public String getVehiculo() {
		return vehiculo;
	}
	public int getCantidaddeVehiculo() {
		return cantidaddeVehiculo;
	}
	public void agregarCantidad(int cantidad) {
		this.cantidaddeVehiculo = cantidaddeVehiculo + cantidad;
		
		
	}
	
	

}
