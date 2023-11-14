package logica;

import java.util.ArrayList;

import java.util.Map;


public class Sede {
	public String nombre;
	public String ubicacion;
	public String horariosdeAtencion;
	public String administradordeSede;
	Map <String, Empleado> empleadosSede;
	Map <Integer,Vehiculo> listaVehiculos;
	
	public Sede(String nombre, String ubicacion, String horariosdeAtencion, String administradordeSede, Map <String, Empleado> empleadosSede, Map<Integer, Vehiculo> listaVehiculos) {
		super();
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.horariosdeAtencion = horariosdeAtencion;
		this.administradordeSede = administradordeSede;
		this.empleadosSede = empleadosSede;
		this.listaVehiculos = listaVehiculos;
		
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public String getHorariosdeAtencion() {
		return horariosdeAtencion;
	}
	public void setHorariosdeAtencion(String horariosdeAtencion) {
		this.horariosdeAtencion = horariosdeAtencion;
	}
	public String getAdministradordeSede() {
		return administradordeSede;
	}
	public void setAdministradordeSede(String administradordeSede) {
		this.administradordeSede = administradordeSede;
	}
	public Map <String, Empleado> getListaempleados(){
		return empleadosSede;
	}
	public void agregarEmpleado (String nombreempleado, Empleado elempleado) {
		empleadosSede.put(nombreempleado, elempleado);
		
	}
	public Map<Integer, Vehiculo> getMapaVehiculos(){
		
		return listaVehiculos;
		
	}
	public ArrayList<Vehiculo> getListavehiculos(){
		return new ArrayList<Vehiculo>(listaVehiculos.values());
	}
	public void agregarVehiculo(Integer id, Vehiculo elvehiculo) {
		listaVehiculos.put(id, elvehiculo);
	}

	public void setListavehiculos(Map<Integer, Vehiculo> listaVehiculos) {
		this.listaVehiculos = listaVehiculos;
	}
	public void setmapempleados(Map<String, Empleado> mapempleados) {
		this.empleadosSede = mapempleados;
		
	}

		
		
		
	

}
