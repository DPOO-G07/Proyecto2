package presentacion;

import java.io.BufferedReader;

import java.util.HashMap;

import java.util.Map;

import Modelo.Rentadora;
import logica.Cliente;
import logica.Empleado;
import logica.Persona;
import logica.Proveedor;
import logica.Reserva;
import logica.Sede;
import logica.SeguroAdicional;
import logica.Vehiculo;


import java.io.FileReader;



public class carga {
	public static Rentadora Leer(String personas, String sede, String reservas, String vehiculos, String pro, String seguros) {
		try {

			Map <String, Persona> Personas = new HashMap<>();
			Map <String, Sede> Sedes = new HashMap<>();
			Map <Double, Reserva> Reservas = new HashMap<>();
			Map <Integer, Vehiculo> Vehiculos = new HashMap<>();
			Map <String, Proveedor> Proveedores = new HashMap<>();
			Map <String, SeguroAdicional> Seguros = new HashMap<>();
			
			BufferedReader br1 = new BufferedReader(new FileReader(sede));
			String linea1;
			while((linea1=br1.readLine()) != null) {
				String [] partes = linea1.split(";");
				
				
				String nombre = partes[0];
				String ubicacion = partes[1];
				String horariosdeAtencion = partes[2];
				String administradordeSede = partes[3];
				Map<String, Empleado> empleadosSede = new HashMap<>();
				Map<Integer,Vehiculo> listaVehiculos = new HashMap<>();
				
				
				
				Sede lasede = new Sede(nombre, ubicacion, horariosdeAtencion,administradordeSede, empleadosSede, listaVehiculos);
				Sedes.put(nombre, lasede);
			}
			br1.close();
			BufferedReader br3 = new BufferedReader(new FileReader(vehiculos));
			String linea3;
			while((linea3=br3.readLine()) != null) {
				String [] partes = linea3.split(";");
				Integer id = Integer.parseInt(partes[0]);
				
				String lacategoria = partes[1];
				String elestado = partes[2];
				String laubicacion = (partes[3]);
				String laplaca = partes[4];
				String lamarca = partes[5];
				String elmodelo = partes[6];
				String elcolor = partes[7];
				String eltipodeTransmision = partes[8];
				Integer elnumpersonas = Integer.parseInt(partes[9]);
				String lasede = partes[10];
				Vehiculo elvehiculo = new Vehiculo(id, lacategoria, elestado, laubicacion, laplaca, lamarca, elmodelo, elcolor, eltipodeTransmision, elnumpersonas, lasede);
				Sede lugar = Sedes.get(lasede);
				lugar.agregarVehiculo(id, elvehiculo);
				Sedes.put(lasede, lugar);
				Vehiculos.put(id, elvehiculo);
				
				
				
				
				
				
				
			}
			br3.close();
			
			BufferedReader br = new BufferedReader(new FileReader(personas));
			String linea;
			while((linea=br.readLine()) != null) {
				String [] partes = linea.split(";");
				// este archivo tiene que ser el que contenga las personas 
				String elcargo = partes[0];
				String elnombre = partes[1];
				double lacedula = Double.parseDouble(partes[2]);
				String lafechadeNacimiento = partes[3];
				String lanacionalidad = partes[4];
				String elemail = partes[5];
				double elcelular = Double.parseDouble(partes[6]);
				String ellogin = partes[7];
				String lapassword = partes[8];
				
				
				if (elcargo.equalsIgnoreCase( "Cliente")) {
					double licencia = Double.parseDouble(partes[9]);
					double metododepago = Double.parseDouble(partes[10]);
					Cliente lapersona = new Cliente(elcargo, elnombre, lacedula, lafechadeNacimiento, lanacionalidad, elemail, elcelular, ellogin, lapassword, licencia, metododepago);
					Personas.put(ellogin, lapersona);
					}
				
				else {
					String nomsede = partes[9];
					if (nomsede.equalsIgnoreCase("general")) {
						Empleado lapersona = new Empleado(elcargo, elnombre, lacedula, lafechadeNacimiento, lanacionalidad, elemail, elcelular, ellogin, lapassword, nomsede);
						Personas.put(ellogin, lapersona);
					}
					else {
						Empleado lapersona = new Empleado(elcargo, elnombre, lacedula, lafechadeNacimiento, lanacionalidad, elemail, elcelular, ellogin, lapassword, nomsede);
						Personas.put(ellogin, lapersona);
						Sede ladepersona =  Sedes.get(nomsede);
						ladepersona.agregarEmpleado(elnombre, lapersona);
					
					}
					
				}
				
				
			}
			br.close();
			
			BufferedReader br2 = new BufferedReader(new FileReader(reservas));
			String linea2;
			while((linea2=br2.readLine()) != null) {
				String [] partes = linea2.split(";");
			
				Double numeroReserva = Double.parseDouble(partes[0]);
				String tipodeVehiculo = partes[1];
				String cualSede = partes[2];
				String fechadeRecoleccion = partes[3];
				String horadeRecoleccion= partes[4];
				String fechadeEntrega = partes[5];
				String horadeEntrega = partes[6];
				Double cobro = Double.parseDouble(partes[7]);
				String nomcliente  = partes[8];
				String estado = partes[9];
				
				Reserva lareserva = new Reserva (numeroReserva,tipodeVehiculo, cualSede, fechadeRecoleccion, horadeRecoleccion, fechadeEntrega, horadeEntrega, cobro, nomcliente, estado);
				Reservas.put(numeroReserva, lareserva);
			}
			br2.close();
		
			BufferedReader br4 = new BufferedReader(new FileReader(pro));
			String linea4;
			while((linea4=br4.readLine()) != null) {
				String [] partes = linea4.split(";");
				
				
				String nombre = partes[0];
				String tipocarro = partes[1];
				
				Integer cantidad = Integer.parseInt(partes[2]);
				
				
				
				Proveedor prov = new Proveedor(nombre, tipocarro,cantidad);
				Proveedores.put(nombre, prov);
				
			}
			br4.close();
			
			BufferedReader br5 = new BufferedReader(new FileReader(seguros));
			String linea5;
			while((linea5=br5.readLine()) != null) {
				String [] partes = linea5.split(";");
				
				
				String nombre = partes[0];
				
				
				Integer precio = Integer.parseInt(partes[1]);
				
				
				
				SeguroAdicional prov = new SeguroAdicional(nombre, precio);
				Seguros.put(nombre, prov);
				
			}
			br5.close();
			
		
			Rentadora ren = new Rentadora(Personas, Sedes, Reservas, Vehiculos, Proveedores, Seguros );
			
			return ren;
		



	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return null;

}

}
