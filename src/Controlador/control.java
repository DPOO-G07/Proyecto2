package Controlador;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Collection;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import Modelo.Rentadora;
import logica.Cliente;
import logica.Persona;
import logica.Vehiculo;
import presentacion.GestionarProveedor;
import presentacion.GestionarSeguro;
import presentacion.InformacionCL;
import presentacion.Interfaz;
import presentacion.MenuAdministradorG;
import presentacion.MenuAdministradorL;
import presentacion.MenuCliente;
import presentacion.MenuEmpleado;
import presentacion.ModificarSede;
import presentacion.carga;
import presentacion.inicio;
import presentacion.ModificarVehi;


public class control {
	private inicio primera;
	private Rentadora ren;
	private Interfaz inter;
	private MenuAdministradorL menuadminL;
	private String user;
	private Cliente clien;
	private MenuAdministradorG menuadminG;
	private String cargo;
	private MenuEmpleado menuE;
	private MenuCliente menuCl;
	
	
	
	


	public String getCargo() {
		return cargo;
	}


	public void setCargo(String cargo) {
		this.cargo = cargo;
	}


	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public control(Interfaz frame) {
		this.inter = frame;
		this.primera = new inicio(this);
		this.menuadminL = new MenuAdministradorL(this);
		this.menuadminG = new MenuAdministradorG(this);
		this.menuE = new MenuEmpleado(this);
		this.menuCl = new MenuCliente(this);
		
		this.ren = carga.Leer("data/personas.txt", "data/sede.txt", "data/reserva.txt", "data/vehiculos.txt","data/Proveedores.txt","data/Seguros.txt");
		
	}
	public void salvar() throws FileNotFoundException, UnsupportedEncodingException {
		File archivo2 = new File("data/top10.csv");
		//top.salvarRecords(archivo2);
	}
	
	
	public MenuEmpleado getMenuE() {
		return menuE;
	}


	public void setMenuE(MenuEmpleado menuE) {
		this.menuE = menuE;
	}


	public MenuAdministradorG getMenuadminG() {
		return menuadminG;
	}


	public void setMenuadminG(MenuAdministradorG menuadminG) {
		this.menuadminG = menuadminG;
	}


	public MenuAdministradorL getMenuadminL() {
		return menuadminL;
	}


	public void setMenuadminL(MenuAdministradorL menuadminL) {
		this.menuadminL = menuadminL;
	}


	public inicio getPrimera() {
		return primera;
	}


	public void setPrimera(inicio primera) {
		this.primera = primera;
	}


	public MenuCliente getMenuCl() {
		return menuCl;
	}


	public void setMenuCl(MenuCliente menuCl) {
		this.menuCl = menuCl;
	}


	public void verificar (String usuario, String contra) {
		String cargo = ren.verificarIdentidad(usuario, contra);

		if (cargo.equalsIgnoreCase("Administrador Local")) {
			this.cargo = "Administrador Local";
			inter.adminLocal();
			
			
		}
		else if (cargo.equalsIgnoreCase("Administrador General")) {
			this.cargo = "Administrador General";
			inter.adminGeneral();
			

		}
		else if (cargo.equalsIgnoreCase("Empleado")) {
			inter.Empleado();
			

		}
		else if( cargo.equalsIgnoreCase("Cliente")) {
			inter.Cliente();

		}
		else {
			JOptionPane.showMessageDialog(inter,  "Usuario o contraseña incorrectos","Vuelva a intentarlo " , JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void infoempleados() {
		if (cargo.equals("Administrador General")) {
			String sede = JOptionPane.showInputDialog("Que sede desea consultar?");
			Collection <String> lista = ren.devolverEmpleadosadmin(sede);
			listEmpleados(lista);
		}
		else {
			Collection <String> lista = ren.devolverEmpleados(this.user);
			listEmpleados(lista);
		}
		
	}
	public void listEmpleados(Collection<String> lista) {
		DefaultListModel<String> listModel = new DefaultListModel<>();
		for (String indv: lista) {
			
			listModel.addElement( indv);
			
		
		}
		JList<String> muestraTop = new JList<>(listModel);
		muestraTop.setFont(new Font("Arial", Font.PLAIN, 12));
	     JFrame frame = new JFrame("Lista empleados");
	     frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	     frame.setSize(350,350);

	     JScrollPane jScrollPane = new JScrollPane(muestraTop);
	     frame.getContentPane().add(jScrollPane, BorderLayout.CENTER);

	     frame.pack();
	     frame.setLocationRelativeTo(null);
	     frame.setVisible(true);
		
	}
	
	public void infoClientes() {
		String nomcliente = JOptionPane.showInputDialog("Por favor, ingrese el usurario del cliente:");
		Persona cliente = ren.devolverCliente(nomcliente);
		setClien(cliente);
		
		JFrame frame = new JFrame("Informacion Cliente");
		InformacionCL panel = new InformacionCL(this);
		frame.add(panel);
		frame.setSize(350,350);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
	    frame.setVisible(true);
		
		
		
	}
	public Cliente getClien() {
		return clien;
	}


	public void setClien(Persona cliente) {
		this.clien = (Cliente) cliente;
	}


	public void nuevoEmpleado() {
		Inscripcion("Empleado");
}
	public void nuevoCliente() {
		Inscripcion("Cliente");
		
}
	public void actualizarV() {
		
		
		JFrame frame = new JFrame("Informacion Cliente");
		ModificarVehi panel = new ModificarVehi(this);
		
		frame.add(panel);
		frame.setSize(350,350);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
	    frame.setVisible(true);
}
	public void Seguros() {

		JFrame frame = new JFrame("Seguros");
		GestionarSeguro panel = new GestionarSeguro(this);
		
		
		frame.add(panel);
		frame.setSize(350,350);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
	    frame.setVisible(true);
	}
	public void Proveedores() {

		JFrame frame = new JFrame("Seguros");
		GestionarProveedor panel = new GestionarProveedor(this);
		
		
		frame.add(panel);
		frame.setSize(350,350);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
	    frame.setVisible(true);
	}
	public void vehiculoSede() {
		
		Collection <String> lista = ren.devolverVehiculos(this.user);
		DefaultListModel<String> listModel = new DefaultListModel<>();
		for (String indv: lista) {
			
			listModel.addElement( indv);
			
		
		}
		JList<String> muestraTop = new JList<>(listModel);
		muestraTop.setFont(new Font("Arial", Font.PLAIN, 12));
	     JFrame frame = new JFrame("Lista empleados");
	     frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	     frame.setSize(350,350);

	     JScrollPane jScrollPane = new JScrollPane(muestraTop);
	     frame.getContentPane().add(jScrollPane, BorderLayout.CENTER);

	     frame.pack();
	     frame.setLocationRelativeTo(null);
	     frame.setVisible(true);
	}
	public void Inscripcion(String posicion) {
		
		String cargo = posicion;
		String nombre = JOptionPane.showInputDialog("Por favor ingrese su nombre");
		Double cedula = Double.parseDouble(JOptionPane.showInputDialog("Por favor ingrese su cedula"));
		String fechadeNacimiento = JOptionPane.showInputDialog("Por favor ingrese su fecha de nacimiento (DD/MM/YYYY");
		String nacionalidad = JOptionPane.showInputDialog("Por favor ingrese su nacionalidad");
		String email = JOptionPane.showInputDialog("Por favor ingrese su email");
		Double numero = Double.parseDouble(JOptionPane.showInputDialog("Por favor ingrese su numero"));
		String login = JOptionPane.showInputDialog("Por favor ingrese como desea su login");
		String password = JOptionPane.showInputDialog("Por favor ingrese deje a la persona ingresar su contraseña");
		if(cargo.equals("Cliente")) {
			Double licencia = Double.parseDouble(JOptionPane.showInputDialog("Por favor ingrese su licencia"));
			Double metododepago = Double.parseDouble(JOptionPane.showInputDialog("Por favor ingrese su metodo de pago"));
			ren.agregarPersonaCL(cargo, nombre, cedula, fechadeNacimiento, nacionalidad, email, numero, login, password,licencia,metododepago);
		}
		else {
			ren.agregarPersona(cargo, nombre, cedula, fechadeNacimiento, nacionalidad, email, numero, login, password);
		}
		
		JOptionPane.showMessageDialog(inter,"Exito", "Se agrego con exito a la persona", JOptionPane.INFORMATION_MESSAGE);
	}
	public void CambEstado() {
		Integer idCarro = Integer.parseInt(JOptionPane.showInputDialog("Que carro esta buscando, ingrese el Id porfavor"));
		String estado = JOptionPane.showInputDialog("A que estado desea cambiar el vehiculo");
		ren.actualizarEstadoVehiculo(idCarro,estado);
		JOptionPane.showMessageDialog(inter,  "Listo el estado del vehiculo se modifico a " + estado,"Estado del Vehiculo: " + idCarro, JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void trasnladoVehi() {
		Integer idCarro = Integer.parseInt(JOptionPane.showInputDialog("Que carro esta buscando, ingrese el Id porfavor"));
		String sede = JOptionPane.showInputDialog("A que sede desea transladar el carro?");
		ren.cambiarVehiculoSede(idCarro, sede);
		JOptionPane.showMessageDialog(inter,  "Listo el estado del vehiculo se cambio de sede a  " + sede,"Cambio de Sede " , JOptionPane.INFORMATION_MESSAGE);
	}
	public void agregarSeguro() {
		String nomSeguro = JOptionPane.showInputDialog("Ingrese el nombre del seguro ");
		Integer segurotarifa = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la tarifa del seguro"));
		
		ren.agregarSeguro(nomSeguro, segurotarifa);
		JOptionPane.showMessageDialog(inter,  "Se agregó el nuevo seguro: " + nomSeguro,"Agregar seguro " , JOptionPane.INFORMATION_MESSAGE);
	}
	public void eliminarSeguro() {
		
		String nomSeguro = JOptionPane.showInputDialog("Ingrese El nombre del seguro");
		ren.eliminarSeguro(nomSeguro);
		JOptionPane.showMessageDialog(inter,  "Se agregó el nuevo seguro: " + nomSeguro,"Agregar seguro " , JOptionPane.INFORMATION_MESSAGE);
	}
	public void mostrarseguros() {

		Collection <String> lista = ren.mostrarSeguross();
		DefaultListModel<String> listModel = new DefaultListModel<>();
		for (String indv: lista) {
			
			listModel.addElement( indv);
			
		
		}
		JList<String> muestraTop = new JList<>(listModel);
		muestraTop.setFont(new Font("Arial", Font.PLAIN, 12));
	     JFrame frame = new JFrame("Lista Seguros");
	     frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	     frame.setSize(350,350);

	     JScrollPane jScrollPane = new JScrollPane(muestraTop);
	     frame.getContentPane().add(jScrollPane, BorderLayout.CENTER);

	     frame.pack();
	     frame.setLocationRelativeTo(null);
	     frame.setVisible(true);
	}
	public void agregrProveedor() {
		String nom = JOptionPane.showInputDialog("Ingrese el nombre del Proveedor ");
		String vehiculo = JOptionPane.showInputDialog("Ingrese el tipo de vehiculo ");
		Integer cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de vehiculos que se le compraron"));
		
		ren.agregarProveedor(nom, vehiculo, cantidad);
		JOptionPane.showMessageDialog(inter,  "Se agregó el nuevo proveedor: " + nom,"Agregar Proveedor " , JOptionPane.INFORMATION_MESSAGE);
	}
	public void eliminarProveedor() {
		
		String nom = JOptionPane.showInputDialog("Ingrese el nombre del Proveedor");
		ren.eliminarProveedor(nom);
		JOptionPane.showMessageDialog(inter,  "Se elimino el proveedor: " + nom,"Agregar Proveedor " , JOptionPane.INFORMATION_MESSAGE);
	}
	public void mostrarProveedor() {

		Collection <String> lista = ren.mostrarProveedores();
		DefaultListModel<String> listModel = new DefaultListModel<>();
		for (String indv: lista) {
			
			listModel.addElement( indv);
			
		
		}
		JList<String> muestraTop = new JList<>(listModel);
		muestraTop.setFont(new Font("Arial", Font.PLAIN, 12));
	     JFrame frame = new JFrame("Lista Proveedores");
	     frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	     frame.setSize(350,350);

	     JScrollPane jScrollPane = new JScrollPane(muestraTop);
	     frame.getContentPane().add(jScrollPane, BorderLayout.CENTER);

	     frame.pack();
	     frame.setLocationRelativeTo(null);
	     frame.setVisible(true);
	}
	public void sede () {
		String lasede = JOptionPane.showInputDialog("Que sede desea modificar ");
		JFrame frame = new JFrame("Seguros");
		ModificarSede panel = new ModificarSede(this, lasede);
		
		
		frame.add(panel);
		frame.setSize(350,350);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
	    frame.setVisible(true);
	}
	public void cambiarHorario(String nomsede) {
		String nuevohorario = JOptionPane.showInputDialog("Que horario desea colocar? ");
		ren.cambiarHorarios(nomsede, nuevohorario);
	}
	public void nuevoAdminSede(String nomsede) {
		String respuesta = JOptionPane.showInputDialog("Es un nuevo empleado? (si/no) ");
		if (respuesta.equals("no")) {
			String nuevoAdmin = JOptionPane.showInputDialog("Cual es el usuario del nuevo Administrador");
			ren.cambiarAdmin(nomsede, nuevoAdmin, false);
		}
		else if (respuesta.equalsIgnoreCase("si")) {
			Inscripcion("Administrador Local");
			String nuevoAdmin = JOptionPane.showInputDialog("Cual es el nombre del nuevo administrador");
			ren.cambiarAdmin(nomsede, nuevoAdmin, true);


		}
	}
	
	public void crearVehi() {
		
		Integer id = Integer.parseInt(JOptionPane.showInputDialog("Por favor ingrese el id del carro"));
		String categoria = JOptionPane.showInputDialog("Por favor ingrese su categoria");
		String estado = JOptionPane.showInputDialog("Por favor ingrese su estado");
		String ubicacion = JOptionPane.showInputDialog("Por favor ingrese su ubicacion");
		String placa = JOptionPane.showInputDialog("Por favor ingrese su placa");
		String marca = JOptionPane.showInputDialog("Por favor ingrese su marca");
		String modelo = JOptionPane.showInputDialog("Por favor ingrese su modelo");
		String color = JOptionPane.showInputDialog("Por favor ingrese su color");
		String tipotransmision = JOptionPane.showInputDialog("Por favor ingrese su tipo de transmision ");
		Integer capacidad = Integer.parseInt(JOptionPane.showInputDialog("Por favor ingrese la capacidad de personas"));
		String sede = JOptionPane.showInputDialog("Por favor ingrese su sede");
		
		
		
		
	

		Vehiculo elvechicul = new Vehiculo(id,categoria,estado, ubicacion,placa,marca,modelo,color,tipotransmision,capacidad,sede);
		ren.agregarVehiculo(sede, id, elvechicul);
		JOptionPane.showMessageDialog(inter,"Exito", "Se agrego con exito el vehiculo", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void hacerPedido() {
		String nom = JOptionPane.showInputDialog("A que proveedor desea hacer el pedido? ");
		Integer cantidad = Integer.parseInt(JOptionPane.showInputDialog("la cantidad de vehiculos"));
		ren.pedidoProveedor(nom, cantidad);
	}
	

public void reservar(){
	
}
public void actualizarCl() {
	
}
	
 	public void nom( ) {
		JOptionPane.showMessageDialog(inter,  this.clien.getNombre(),"Cliente", JOptionPane.INFORMATION_MESSAGE);
	}
	public void cedula() {
		JOptionPane.showMessageDialog(inter,  String.valueOf(this.clien.getCedula()),"Cedula", JOptionPane.INFORMATION_MESSAGE);
	}
	public void fechanac() {
		JOptionPane.showMessageDialog(inter, this.clien.getFechadeNacimiento(),"Fecha de Nacimiento", JOptionPane.INFORMATION_MESSAGE);
	}
	public void nacionalidad() {
		JOptionPane.showMessageDialog(inter,  this.clien.getNacionalidad(),"Nacionalidad", JOptionPane.INFORMATION_MESSAGE);
	}
	public void email() {
		JOptionPane.showMessageDialog(inter,  this.clien.getEmail(),"Email", JOptionPane.INFORMATION_MESSAGE);
	}
	public void login() {
		JOptionPane.showMessageDialog(inter, this.clien.getLogin(), "Login ",JOptionPane.INFORMATION_MESSAGE);
	}
	public void numero() {
		JOptionPane.showMessageDialog(inter, String.valueOf(this.clien.getCelular()),"Numero", JOptionPane.INFORMATION_MESSAGE);
	}
}









