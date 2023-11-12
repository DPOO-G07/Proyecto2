package presentacion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Map;
import java.util.ArrayList;

import Modelo.Rentadora;
import logica.Empleado;
import logica.MetododePago;
import logica.Persona;
import logica.Vehiculo;




public class Principal {
	private Rentadora ren;


	public void ejecutarAplicacion() throws IOException, ParseException
	{
		System.out.println("Rentadora de carros \n");
		Inicializaraplicacion();
		ren.Seguros();
		ren.Proveedores();
		Boolean continuar = true;
		while (continuar == true) {
			String user = (input("Por favor ingrese su usuario"));
			String contraseña = (input("Por favor ingrese su contraseña"));
			String cargo = ren.verificarIdentidad(user, contraseña);

			if (cargo.equalsIgnoreCase("Administrador Local")) {
				Menuadministradorlocal (user);
			}
			else if (cargo.equalsIgnoreCase("Administrador General")) {
				Menuadministrador(user);

			}
			else if (cargo.equalsIgnoreCase("Empleado")) {

				menuEmpleado(user);

			}
			else if( cargo.equalsIgnoreCase("Cliente")) {
				MenuCliente(user);

			}
			else {
				System.out.println("Contraseña incorrecta \n");
				System.out.println("1. Desea intentar de nuevo? \n");
				System.out.println("2. Si no tiene cuenta, desea crear una?  \n");
				System.out.println("3. Desea salir de la aplicacion? \n");
				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
				if (opcion_seleccionada == 2) {
					Inscripcion("Cliente");
				}
				else if (opcion_seleccionada == 3) {
					System.out.println("Gracias por usar la aplicacion");
					continuar = false;
				}

			}

		}
	}



	private void Inicializaraplicacion() {
		ren = carga.Leer("data/personas.txt", "data/sede.txt", "data/reserva.txt", "data/vehiculos.txt","data/Proveedores.txt","data/Seguros.txt");


		System.out.println("Se inicio la app");
	}

	private void Inscripcion(String posicion) {

		String cargo = posicion;
		String nombre = (input("Por favor ingrese su nombre"));
		Double cedula = Double.parseDouble(input("Por favor ingrese su cedula"));
		String fechadeNacimiento= (input("Por favor ingrese su fecha de nacimiento (DD/MM/YYYY"));
		String nacionalidad = (input("Por favor ingrese su nacionalidad"));
		String email = (input("Por favor ingrese su email"));
		Double numero = Double.parseDouble(input("Por favor ingrese su numero"));
		String login = (input("Por favor ingrese como desea su login"));
		String password = (input("Por favor ingrese deje a la persona ingresar su contraseña"));


		ren.agregarPersona(cargo, nombre, cedula, fechadeNacimiento, nacionalidad, email, numero, login, password);

		System.out.println("Se creo exitosamente la cuenta ");

	}
	private void menuEmpleado(String user) {
		Boolean continuar = true;
		while (continuar == true)
			System.out.println("1. Desea consultar los vehiculos de la sede?  \n");
			System.out.println("2. Desea consultar informacion de los clientes?  \n");
			System.out.println("3. Desea agregar un nuevo cliente?  \n");
			System.out.println("4. Salir del sistema  \n");
			int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
			if (opcion_seleccionada ==1){
				System.out.println("Los vehiculos de la sede son:  \n");
				ren.devolverVehiculos(user);
			}
			else if (opcion_seleccionada ==2){
				String nomcliente = (input("Ingrese el user del cliente"));
				Persona cliente = ren.devolverCliente(nomcliente);
	
				SolicitarInformacionCliente(cliente);
	
	
	
			}
			else if (opcion_seleccionada ==3){
				Inscripcion("Cliente");
			}
			else if (opcion_seleccionada ==4){
				continuar = false;
			}
		}
	private void Menuadministradorlocal(String user) {
		Boolean continuar = true;
		while (continuar == true) {


			System.out.println("Bienvenido Administrador\n");
			System.out.println("1. Desea consultar la informacion de los empleados de la sede? \n");
			System.out.println("2. Desea consultar los vehiculos de la sede?  \n");
			System.out.println("3. Desea consultar informacion de los clientes?  \n");
			System.out.println("4. Desea agregar un nuevo empleado?  \n");
			System.out.println("5. Desea agregar un nuevo cliente?  \n");
			System.out.println("6. Desea actualizar el estado de un vehiculo?  \n");
			System.out.println("7. Salir del sistema  \n");
			int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
			if (opcion_seleccionada == 1){
				System.out.println("Los empleados de la sede son:  \n");
				ren.devolverEmpleados(user);
			}
			else if (opcion_seleccionada ==2){
				System.out.println("Los vehiculos de la sede son:  \n");
				ren.devolverVehiculos(user);
			}
			else if (opcion_seleccionada ==3){
				String nomcliente = (input("Ingrese el user del cliente"));
				Persona cliente = ren.devolverCliente(nomcliente);

				SolicitarInformacionCliente(cliente);



			}
			else if (opcion_seleccionada ==4){
				Inscripcion("Empleado");
			}
			else if (opcion_seleccionada ==5){
				Inscripcion("Cliente");
			}
			else if (opcion_seleccionada ==6){
				Integer idCarro = Integer.parseInt(input("Que carro esta buscando, ingrese el Id porfavor"));
				System.out.println("1. Desea actualizar su estado?  \n");
				System.out.println("2. Desea cambiarlo de sede para disponibilidad? \n");
				int opcion_seleccionada2 = Integer.parseInt(input("Por favor seleccione una opción"));
				if (opcion_seleccionada2 == 1) {
					String estado = (input("A que estado desea cambiar el vehiculo"));
					ren.actualizarEstadoVehiculo(idCarro,estado);
					System.out.println("Listo, el estado del vehiculo esta actualizado ");
				}
				else if (opcion_seleccionada2 == 2){
					String sede = (input("A que sede desea transladar el carro?"));
					ren.cambiarVehiculoSede(idCarro, sede);
					System.out.println("Listo, el translado fue hecho con exito ");
				}
				else {
					System.out.println("Seleccione una opcion valida");
				}
			}
			else if (opcion_seleccionada ==7){
				continuar = false;
			}

			else {
				System.out.println("Seleccione una opcion valida");
			}
		}

	}
	private void Menuadministrador(String user) {
		Boolean continuar = true;

		while (continuar == true) {
			System.out.println("1. Desea consultar la informacion de los empleados de la sede? \n");
			System.out.println("2. Desea consultar los vehiculos de la sede?  \n");
			System.out.println("3. Desea consultar informacion de los clientes?  \n");
			System.out.println("4. Desea agregar un nuevo empleado?  \n");
			System.out.println("5. Desea agregar un nuevo cliente?  \n");
			System.out.println("6. Desea actualizar el estado de un vehiculo?  \n");
			System.out.println("7. Desea actualizar las tarifas?  \n");
			System.out.println("8. Desea gestionar los convenios con los seguros?  \n");
			System.out.println("9. Desea gestionar una sede?  \n");
			System.out.println("10. Desea gestionar un proveedor?  \n");
			System.out.println("11. Salir del sistema  \n");

			int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
			if (opcion_seleccionada == 1){
				System.out.println("Los empleados de la sede son:  \n");
				String nomsede = (input("De que sede desea encontrar la informacion"));
				ren.devolverEmpleadosadmin(nomsede);
			}
			else if (opcion_seleccionada ==2){
				String nomsede = (input("De que sede desea encontrar la informacion"));
				System.out.println("Las placas de los vehiculos de la sede son:  \n");
				ren.devolverVehiculosadmin(nomsede);
			}
			else if (opcion_seleccionada ==3){
				String nomcliente = (input("Ingrese el user del cliente"));
				Persona cliente = ren.devolverCliente(nomcliente);

				SolicitarInformacionCliente(cliente);



			}
			else if (opcion_seleccionada ==4){
				Inscripcion("Empleado");
			}
			else if (opcion_seleccionada ==5){
				Inscripcion("Cliente");
			}
			else if (opcion_seleccionada ==6){
				Integer idCarro = Integer.parseInt(input("Que carro esta buscando, ingrese el Id porfavor"));
				System.out.println("1. Desea actualizar su estado?  \n");
				System.out.println("2. Desea cambiarlo de sede para disponibilidad? \n");
				int opcion_seleccionada2 = Integer.parseInt(input("Por favor seleccione una opción"));
				if (opcion_seleccionada2 == 1) {
					String estado = (input("Que carro esta buscando, ingrese el Id porfavor"));
					ren.actualizarEstadoVehiculo(idCarro,estado);
					System.out.println("Listo, el estado del vehiculo esta actualizado ");
				}
				else if (opcion_seleccionada2 == 2){
					String sede = (input("A que sede desea transladar el carro?"));
					ren.cambiarVehiculoSede(idCarro, sede);
					System.out.println("Listo, el translado fue hecho con exito ");
				}
				else {
					System.out.println("Seleccione una opcion valida");
				}
			}
			else if (opcion_seleccionada == 8) {
				System.out.println("1. Desea agregar un seguro?  \n");
				System.out.println("2. Desea eliminar un seguro?  \n");
				System.out.println("3. Desea saber que seguros hay?  \n");
				int opcion = Integer.parseInt(input("Por favor seleccione una opción"));
				if (opcion ==1) {
					String nomSeguro = (input("El nombre del seguro: "));
					Integer segurotarifa = Integer.parseInt(input("Cual es la tarifa de este seguro: "));
					ren.agregarSeguro(nomSeguro, segurotarifa);
				}
				else if(opcion ==2) {
					String nomSeguro = (input("El nombre del seguro: "));
					ren.eliminarSeguro(nomSeguro);
				}
				else if(opcion ==3) {
					System.out.println("Los seguros son:   \n");
					ren.mostrarSeguross();
				}
			}

			else if (opcion_seleccionada == 7) {

			}
			else if (opcion_seleccionada == 9) {
				modificarSede();
			}
			else if (opcion_seleccionada == 10) {
				gestionarProveedores();
			}
			else if (opcion_seleccionada ==11){
				continuar = false;
			}

			else {
				System.out.println("Seleccione una opcion valida");
			}
		}

	}

	private void MenuCliente(String user) throws ParseException {
		System.out.println("1. Desea hacer una reserva");
		System.out.println("2. Desea Recoger su vehiculo");
		int opcion_seleccionada2 = Integer.parseInt(input("Por favor seleccione una opción"));
		if (opcion_seleccionada2 == 1) {
		
				System.out.println("Este es el sistema de reservas por favor escoga una de las siguientes opciones para completar una reserva");
				System.out.println("Estas son las categorias disponibles");
				System.out.println(" Economica ");
				System.out.println(" SUV ");
				System.out.println(" Pequeño");
				System.out.println(" Lujo ");
				String categoria = input("Por favor ingrese el nombre de la categoria del vehiculo que le gustaria reservar:\n ");
				System.out.println("Estas son las sedes disponibles");
				System.out.println(" Motors Cañas");
				System.out.println(" Motors Palmas");
				System.out.println(" Motors Flora");
				String sede = input("Por favor ingrese el nombre de la sede en la cual le gustaria recoger el vehiculo:\n  ");
				String fechadeRecoleccion = input("Por favor ingrese la fecha en formato yyyy-MM-dd en la cual le gustaria recoger el vehiculo:\n  ");
				String horadeRecoleccion = input("Por favor ingrese la hora en formato militar y con esta notacion HH:MM  en la cual le gustaria recoger el vehiculo:\n  ");
				String fechadeEntrega = input("Por favor ingrese la fecha en formato yyyy-MM-dd en la cual le gustaria entregar el vehiculo:\n  ");
				String horadeEntrega = input("Por favor ingrese la hora en formato militar y con esta notacion HH:MM  en la cual le gustaria entregar el vehiculo:\n  ");
				String nombre = input("Por favor ingrese su nombre: \n  ");
				ArrayList<Double> lista = ren.iniciarReserva(categoria,sede,fechadeRecoleccion,horadeRecoleccion,fechadeEntrega,horadeEntrega,nombre);
				double cobro =lista.get(0);
				double id = lista.get(1);
				double cobro30 = cobro * 0.3;
				System.out.println("El monto que debe pagar es: "+ cobro30);
				double numerotar = Double.parseDouble(input("Por favor ingrese el numero de tarjeta:"));
				String fechacaducidad = input("Por favor ingrese la fecha de caducidad en formato yyyy-MM-dd:");
				String tipo = input("Por favor ingrese el tipo de tarjeta:");
				new MetododePago(numerotar,fechacaducidad,tipo);
				System.out.println("Se realizo el cobro del 30%");
				System.out.println("su reserva de un " + categoria + " fue realizada con exito, puede pasar a recoger su vehiculo el " + fechadeRecoleccion + "a las " + horadeRecoleccion + " en la sede " + sede + " el numero de reserva es: "+ id );
				
		}else if (opcion_seleccionada2 == 2) {
			System.out.println("Este es el sistema de para recoger el carro por favor escoga una de las siguientes opciones  \n");
			String otroconductor = input("Desea añadir un conductor responda si/no");
			if (otroconductor == "si") {
				double numerodereserva = Double.parseDouble(input("Por favor ingrese el numero de la reserva:\n "));
				double cobro = ren.obtenercobrofinal(numerodereserva);
				System.out.println("Este el cobro de un conductor adicional es de:"+ cobro*0.2);
				double cobro2 = cobro*0.2 + cobro;
				System.out.println("Este es el cobro final del carro:"+ cobro2);
				double numerotar = Double.parseDouble(input("Por favor ingrese el numero de tarjeta:"));
				String fechacaducidad = input("Por favor ingrese la fecha de caducidad en formato yyyy-MM-dd:");
				String tipo = input("Por favor ingrese el tipo de tarjeta:");
				new MetododePago(numerotar,fechacaducidad,tipo);
				System.out.println("Se realizo el cobro total, ya puede recoger su vehiculo y su tarjeta ha sido bloqueada hasta que se devuelva el vehiculo");
				
				
				
			}else if (otroconductor == "no") {
				double numerodereserva = Double.parseDouble(input("Por favor ingrese el numero de la reserva:\n "));
				double cobro = ren.obtenercobrofinal(numerodereserva);
				System.out.println("Este es el cobro final del carro:"+ cobro);
				double numerotar = Double.parseDouble(input("Por favor ingrese el numero de tarjeta:"));
				String fechacaducidad = input("Por favor ingrese la fecha de caducidad en formato yyyy-MM-dd:");
				String tipo = input("Por favor ingrese el tipo de tarjeta:");
				new MetododePago(numerotar,fechacaducidad,tipo);
				System.out.println("Se realizo el cobro total y su tarjeta ha sido bloqueada hasta que se devuelva el vehiculo");
				
				

			}
			
			
			
			
		}
		

		

		
		
	}
	
		






	private void gestionarProveedores() {
		System.out.println("1. Desea consultar que proveedores hay?  \n");
		System.out.println("2. Desea agregar un proveedor? \n");
		System.out.println("3. Desea eliminar un proovedor?  \n");
		System.out.println("4. Desea hacer un pedido? \n");
		int opcion = Integer.parseInt(input("Por favor seleccione una opción"));
		if (opcion == 1) {
			ren.mostrarProveedores();
		}
		else if (opcion ==2) {
			String nom = input(("El nombre del nuevo proveedor"));
			String vehiculo = input(("El nombre del vehiculo que distribuye"));
			int cantidad = Integer.parseInt(input("La cantidad de vehiculos que se pidieron "));
			ren.agregarProveedor(nom, vehiculo, cantidad);


		}



		else if (opcion ==3) {
			String nom = input(("El nombre del proveedor"));
			ren.eliminarProveedor(nom);
		}
		else if (opcion ==4) {
			String nom = input(("A que proveedor desea hacer el pedido"));
			int cantidad = Integer.parseInt(input("la cantidad de vehiculos"));
			ren.pedidoProveedor(nom, cantidad);

		}
	}

	private void modificarSede() {
		String nomsede = (input("Que sede desea modificar? "));

		System.out.println("1. Desea cambiar los horario de atencion?  \n");
		System.out.println("2. Desea cambiar el administrador de sede? \n");
		System.out.println("3. Desea agregar un empleado?  \n");
		System.out.println("4. Desea agregar un vehiculo? \n");
		int opcion = Integer.parseInt(input("Por favor seleccione una opción"));

		if (opcion == 1) {
			String nuevohorario = (input("Que horario desea colocar? "));
			ren.cambiarHorarios(nomsede, nuevohorario);
		}
		else if (opcion ==2) {
			String respuesta = input(("Es un nuevo empleado? (si/no) \n"));
			if (respuesta.equals("no")) {
				String nuevoAdmin = (input("Cual es el usuario del nuevo administrador? "));
				ren.cambiarAdmin(nomsede, nuevoAdmin, false);
			}
			else if (respuesta.equalsIgnoreCase("si")) {
				Inscripcion("Administrador Local");
				String nuevoAdmin = (input("Cual es el nombre del nuevo administrador? "));
				ren.cambiarAdmin(nomsede, nuevoAdmin, true);


			}

		}
		else if (opcion ==3) {
			Inscripcion("Empleado");
		}
		else if (opcion ==4) {
			crearVehiculo();
		}
	}


	private void crearVehiculo() {

		Integer id = Integer.parseInt(input("Por favor ingrese el id del carro"));
		String categoria = (input("Por favor ingrese su categoria"));
		String estado = (input("Por favor ingrese su estado"));
		String ubicacion= (input("Por favor ingrese su ubicacion"));
		String placa = (input("Por favor ingrese su placa"));
		String marca = (input("Por favor ingrese su marca"));

		String modelo = (input("Por favor ingrese su modelo"));
		String color = (input("Por favor ingrese su color"));
		String tipotransmision = (input("Por favor ingrese su tipo de transmision "));
		Integer capacidad = Integer.parseInt(input("Por favor ingrese la capacidad de personas"));
		String sede = (input("Por favor ingrese su sede"));

		Vehiculo elvechicul = new Vehiculo(id,categoria,estado, ubicacion,placa,marca,modelo,color,tipotransmision,capacidad,sede);
		ren.agregarVehiculo(sede, id, elvechicul);
	}
	private void SolicitarInformacionCliente(Persona cliente) {
		System.out.println("1. Desea saber su nombre");
		System.out.println("2. Desea saber su cedula");
		System.out.println("3. Desea saber su fecha de nacimiento ");
		System.out.println("4. Desea saber su nacionalidad");
		System.out.println("5. Desea saber su email");
		System.out.println("6. Desea saber su numero");
		System.out.println("7. Desea saber su login");
		Integer opcion = Integer.parseInt(input("Que desea saber del cliente? "));
		if (opcion == 1) {
			System.out.println(cliente.getNombre());

		}
		else if (opcion == 2) {
			System.out.println(cliente.getCedula());

		}
		else if (opcion == 3) {
			System.out.println(cliente.getFechadeNacimiento());
		}
		else if (opcion == 4) {
			System.out.println(cliente.getNacionalidad());
		}
		else if (opcion == 5) {
			System.out.println(cliente.getEmail());
		}
		else if (opcion == 6) {
			System.out.println(cliente.getCelular());
		}
		else if (opcion == 7) {
			System.out.println(cliente.getLogin());
		}
		else {
			System.out.println("Seleccione una opcion valida");
		}
	}
	public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) throws IOException, ParseException
	{
		Principal consola = new Principal();
		consola.ejecutarAplicacion();
	}

}
