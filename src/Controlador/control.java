package Controlador;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JPanel;

import Modelo.Rentadora;
import logica.Cliente;
import logica.MetododePago;
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
import presentacion.inicioCliente;
import presentacion.inicioG;
import presentacion.tipoPago;
import presentacion.ModificarVehi;
import presentacion.Paypal;
import presentacion.Payu;
import presentacion.Sire;

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
	private inicioCliente inCliente;
	private inicioG inG;

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
		this.inCliente = new inicioCliente(this);
		this.inG = new inicioG(this);
		

		this.ren = carga.Leer("data/personas.txt", "data/sede.txt", "data/reserva.txt", "data/vehiculos.txt",
				"data/Proveedores.txt", "data/Seguros.txt", "data/MetododePago.txt");

	}

	public void salvar() throws FileNotFoundException, UnsupportedEncodingException {
		File archivoVehiculos = new File("data/vehiculos.txt");
		File archivoSede = new File("data/sede.txt");
		File archivoreservas = new File("data/reserva.txt");
		File archivopersonas = new File("data/personas.txt");
		File archivopro = new File("data/Proveedores.txt");
		File archivoseg = new File("data/Seguros.txt");
		File archivometodo = new File("data/MetododePago.txt");
		ren.salvar(archivoVehiculos, archivoSede, archivoreservas, archivopersonas, archivopro, archivoseg,
				archivometodo);

	}

	public MenuEmpleado getMenuE() {
		return menuE;
	}

	public void tarifas() {
		String clase = JOptionPane.showInputDialog("Que clase de tarifa desea modificar");
		double precio = Double.parseDouble(JOptionPane.showInputDialog("Que clase de tarifa desea modificar"));
		ren.modificarTarifas(clase, precio);

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

	public void verificar(String usuario, String contra) throws Exception {
		String cargo = ren.verificarIdentidad(usuario, contra);

		if (cargo.equalsIgnoreCase("Administrador Local")) {
			this.cargo = "Administrador Local";
			inter.adminLocal();

		} else if (cargo.equalsIgnoreCase("Administrador General")) {
			this.cargo = "Administrador General";
			inter.adminGeneral();

		} else if (cargo.equalsIgnoreCase("Empleado")) {
			inter.Empleado();

		} else if (cargo.equalsIgnoreCase("Cliente")) {
			JOptionPane.showMessageDialog(inter, "Eres un cliente, intentaste entrar por el lugar equivocado",
					"Cambiar de interfaz ", JOptionPane.INFORMATION_MESSAGE);

		} else {
			JOptionPane.showMessageDialog(inter, "Usuario o contraseña incorrectos", "Vuelva a intentarlo ",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void inicioCl() {
		inter.inCliente();
	}

	public void in() {
		inter.inGE();
	}

	public void inicioEmp() {
		inter.inEmpleado();
	}

	public void verificarCliente(String usuario, String contra) throws Exception {
		String cargo = ren.verificarIdentidad(usuario, contra);

		if (cargo.equalsIgnoreCase("Cliente")) {
			inter.Cliente();

		} else {
			JOptionPane.showMessageDialog(inter, "Usuario o contraseña incorrectos", "Vuelva a intentarlo ",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void infoempleados() {
		if (cargo.equals("Administrador General")) {
			String sede = JOptionPane.showInputDialog("Que sede desea consultar?");
			Collection<String> lista = ren.devolverEmpleadosadmin(sede);
			listEmpleados(lista);
		} else {
			Collection<String> lista = ren.devolverEmpleados(this.user);
			listEmpleados(lista);
		}

	}

	public void listEmpleados(Collection<String> lista) {
		DefaultListModel<String> listModel = new DefaultListModel<>();
		for (String indv : lista) {

			listModel.addElement(indv);

		}
		JList<String> muestraTop = new JList<>(listModel);
		muestraTop.setFont(new Font("Arial", Font.PLAIN, 12));
		JFrame frame = new JFrame("Lista empleados");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(350, 350);

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
		frame.setSize(350, 350);
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

		JFrame frame = new JFrame("Modificar vehiculos");
		ModificarVehi panel = new ModificarVehi(this);

		frame.add(panel);
		frame.setSize(350, 350);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public void Seguros() {

		JFrame frame = new JFrame("Seguros");
		GestionarSeguro panel = new GestionarSeguro(this);

		frame.add(panel);
		frame.setSize(350, 350);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public void Proveedores() {

		JFrame frame = new JFrame("Seguros");
		GestionarProveedor panel = new GestionarProveedor(this);

		frame.add(panel);
		frame.setSize(350, 350);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public void vehiculoSede() {

		Collection<String> lista = ren.devolverVehiculos(this.user);
		DefaultListModel<String> listModel = new DefaultListModel<>();
		for (String indv : lista) {

			listModel.addElement(indv);

		}
		JList<String> muestraTop = new JList<>(listModel);
		muestraTop.setFont(new Font("Arial", Font.PLAIN, 12));
		JFrame frame = new JFrame("Lista empleados");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(350, 350);

		JScrollPane jScrollPane = new JScrollPane(muestraTop);
		frame.getContentPane().add(jScrollPane, BorderLayout.CENTER);

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public void Inscripcion(String posicion) {

		JFrame frame = new JFrame("Inscripción");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(350, 350);
		JPanel panel = new JPanel();

		frame.setLayout(new BorderLayout());

		if (posicion.equals("Cliente")) {

			JLabel nom = new JLabel("Nombre: ");
			JTextField tnom = new JTextField();

			JLabel ced = new JLabel("Cedula: ");
			JTextField tcedula = new JTextField();

			JLabel fecha = new JLabel("Fecha Nacimiento (DD/MM/YYYY): ");
			JTextField tfecha = new JTextField();

			JLabel nac = new JLabel("Nacionalidad: ");
			JTextField tnac = new JTextField();

			JLabel email = new JLabel("Email: ");
			JTextField tmail = new JTextField();

			JLabel num = new JLabel("numero: ");
			JTextField tnum = new JTextField();

			JLabel login = new JLabel("Login: ");
			JTextField tlogin = new JTextField();

			JLabel password = new JLabel("Password: ");
			JTextField tpassword = new JTextField();

			JLabel licencia = new JLabel("Licencia: ");
			JTextField tlicencia = new JTextField();

			JLabel pago = new JLabel("Metodo de pago: ");
			JTextField tpago = new JTextField();

			JButton confirmar = new JButton("Confirmar");
			panel.add(nom);
			panel.add(tnom);
			panel.add(ced);
			panel.add(tcedula);
			panel.add(fecha);
			panel.add(tfecha);
			panel.add(nac);
			panel.add(tnac);
			panel.add(email);
			panel.add(tmail);
			panel.add(num);
			panel.add(tnum);
			panel.add(licencia);
			panel.add(tlicencia);
			panel.add(pago);
			panel.add(tpago);
			panel.add(login);

			panel.add(tlogin);
			panel.add(password);
			panel.add(tpassword);
			panel.setLayout(new GridLayout(10, 2, 5, 5));
			frame.add(panel, BorderLayout.CENTER);

			frame.add(confirmar, BorderLayout.SOUTH);
			confirmar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ren.agregarPersonaCL(cargo, tnom.getText(), Double.parseDouble(tcedula.getText()), tfecha.getText(),
							tnac.getText(), tmail.getText(), Double.parseDouble(tnum.getText()), tlogin.getText(),
							tpassword.getText(), Double.parseDouble(tlicencia.getText()),
							Double.parseDouble(tpago.getText()));
					JOptionPane.showMessageDialog(inter, "Exito", "Se agrego con exito a la persona",
							JOptionPane.INFORMATION_MESSAGE);
				}
			});

		} else {
			JLabel nom = new JLabel("Nombre: ");
			JTextField tnom = new JTextField();

			JLabel ced = new JLabel("Cedula: ");
			JTextField tcedula = new JTextField();

			JLabel fecha = new JLabel("Fecha Nacimiento (DD/MM/YYYY): ");
			JTextField tfecha = new JTextField();

			JLabel nac = new JLabel("Nacionalidad: ");
			JTextField tnac = new JTextField();

			JLabel email = new JLabel("Email: ");
			JTextField tmail = new JTextField();

			JLabel num = new JLabel("numero: ");
			JTextField tnum = new JTextField();

			JLabel login = new JLabel("Login: ");
			JTextField tlogin = new JTextField();

			JLabel password = new JLabel("Password: ");
			JTextField tpassword = new JTextField();

			JLabel nomsede = new JLabel("Nombre de la Sede: ");
			JTextField tnomsede = new JTextField();

			JButton confirmar = new JButton("Confirmar");
			panel.add(nom);
			panel.add(tnom);
			panel.add(ced);
			panel.add(tcedula);
			panel.add(fecha);
			panel.add(tfecha);
			panel.add(nac);
			panel.add(tnac);
			panel.add(email);
			panel.add(tmail);
			panel.add(num);
			panel.add(tnum);
			panel.add(nomsede);
			panel.add(tnomsede);
			panel.add(login);
			panel.add(tlogin);
			panel.add(password);
			panel.add(tpassword);
			panel.setLayout(new GridLayout(10, 2, 5, 5));
			frame.add(panel, BorderLayout.CENTER);
			frame.add(confirmar, BorderLayout.SOUTH);

			ren.agregarPersona(cargo, tnom.getText(), Double.parseDouble(tcedula.getText()), tfecha.getText(),
					tnac.getText(), tmail.getText(), Double.parseDouble(tnum.getText()), tlogin.getText(),
					tpassword.getText(), tnomsede.getText());
			JOptionPane.showMessageDialog(inter, "Exito", "Se agrego con exito a la persona",
					JOptionPane.INFORMATION_MESSAGE);
		}
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

	public void CambEstado() {
		Integer idCarro = Integer
				.parseInt(JOptionPane.showInputDialog("Que carro esta buscando, ingrese el Id porfavor"));
		String estado = JOptionPane.showInputDialog("A que estado desea cambiar el vehiculo");
		ren.actualizarEstadoVehiculo(idCarro, estado);
		JOptionPane.showMessageDialog(inter, "Listo el estado del vehiculo se modifico a " + estado,
				"Estado del Vehiculo: " + idCarro, JOptionPane.INFORMATION_MESSAGE);
	}

	public void trasnladoVehi() {
		Integer idCarro = Integer
				.parseInt(JOptionPane.showInputDialog("Que carro esta buscando, ingrese el Id porfavor"));
		String sede = JOptionPane.showInputDialog("A que sede desea transladar el carro?");
		ren.cambiarVehiculoSede(idCarro, sede);
		JOptionPane.showMessageDialog(inter, "Listo el estado del vehiculo se cambio de sede a  " + sede,
				"Cambio de Sede ", JOptionPane.INFORMATION_MESSAGE);
	}

	public void agregarSeguro() {
		String nomSeguro = JOptionPane.showInputDialog("Ingrese el nombre del seguro ");
		Integer segurotarifa = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la tarifa del seguro"));

		ren.agregarSeguro(nomSeguro, segurotarifa);
		JOptionPane.showMessageDialog(inter, "Se agregó el nuevo seguro: " + nomSeguro, "Agregar seguro ",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public void eliminarSeguro() {

		String nomSeguro = JOptionPane.showInputDialog("Ingrese El nombre del seguro");
		ren.eliminarSeguro(nomSeguro);
		JOptionPane.showMessageDialog(inter, "Se agregó el nuevo seguro: " + nomSeguro, "Agregar seguro ",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public void mostrarseguros() {

		Collection<String> lista = ren.mostrarSeguross();
		DefaultListModel<String> listModel = new DefaultListModel<>();
		for (String indv : lista) {

			listModel.addElement(indv);

		}
		JList<String> muestraTop = new JList<>(listModel);
		muestraTop.setFont(new Font("Arial", Font.PLAIN, 12));
		JFrame frame = new JFrame("Lista Seguros");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(350, 350);

		JScrollPane jScrollPane = new JScrollPane(muestraTop);
		frame.getContentPane().add(jScrollPane, BorderLayout.CENTER);

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public void agregrProveedor() {
		String nom = JOptionPane.showInputDialog("Ingrese el nombre del Proveedor ");
		String vehiculo = JOptionPane.showInputDialog("Ingrese el tipo de vehiculo ");
		Integer cantidad = Integer
				.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de vehiculos que se le compraron"));

		ren.agregarProveedor(nom, vehiculo, cantidad);
		JOptionPane.showMessageDialog(inter, "Se agregó el nuevo proveedor: " + nom, "Agregar Proveedor ",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public void eliminarProveedor() {

		String nom = JOptionPane.showInputDialog("Ingrese el nombre del Proveedor");
		ren.eliminarProveedor(nom);
		JOptionPane.showMessageDialog(inter, "Se elimino el proveedor: " + nom, "Agregar Proveedor ",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public void mostrarProveedor() {

		Collection<String> lista = ren.mostrarProveedores();
		DefaultListModel<String> listModel = new DefaultListModel<>();
		for (String indv : lista) {

			listModel.addElement(indv);

		}
		JList<String> muestraTop = new JList<>(listModel);
		muestraTop.setFont(new Font("Arial", Font.PLAIN, 12));
		JFrame frame = new JFrame("Lista Proveedores");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(350, 350);

		JScrollPane jScrollPane = new JScrollPane(muestraTop);
		frame.getContentPane().add(jScrollPane, BorderLayout.CENTER);

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	public void tabal() {
		Collection<String> lista = ren.fechasmasconcurridas();
		DefaultListModel<String> listModel = new DefaultListModel<>();
		for (String indv : lista) {

			listModel.addElement(indv);

		}
		JList<String> muestraTop = new JList<>(listModel);
		muestraTop.setFont(new Font("Arial", Font.PLAIN, 12));
		JFrame frame = new JFrame("Fechas mas concurridas");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(350, 350);

		JScrollPane jScrollPane = new JScrollPane(muestraTop);
		frame.getContentPane().add(jScrollPane, BorderLayout.CENTER);

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	public void sede() {
		String lasede = JOptionPane.showInputDialog("Que sede desea modificar ");
		JFrame frame = new JFrame("Seguros");
		ModificarSede panel = new ModificarSede(this, lasede);

		frame.add(panel);
		frame.setSize(350, 350);
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
		} else if (respuesta.equalsIgnoreCase("si")) {
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

		Vehiculo elvechicul = new Vehiculo(id, categoria, estado, ubicacion, placa, marca, modelo, color,
				tipotransmision, capacidad, sede);
		ren.agregarVehiculo(sede, id, elvechicul);
		JOptionPane.showMessageDialog(inter, "Exito", "Se agrego con exito el vehiculo",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public void hacerPedido() {
		String nom = JOptionPane.showInputDialog("A que proveedor desea hacer el pedido? ");
		Integer cantidad = Integer.parseInt(JOptionPane.showInputDialog("la cantidad de vehiculos"));
		ren.pedidoProveedor(nom, cantidad);
	}

	public void reservar() throws ParseException {
		JFrame caushaiel = new JFrame();
		caushaiel.setTitle("Reserva");
		caushaiel.setSize(900, 800);
		caushaiel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel(new GridLayout(13, 2, 40, 10));

		JTextField categoria = new JTextField("");
		JTextField sede = new JTextField("");
		JTextField fechadeRecoleccion = new JTextField("");
		JTextField horadeRecoleccion = new JTextField("");
		JTextField fechadeEntrega = new JTextField("");
		JTextField horadeEntrega = new JTextField("");
		JTextField nombre = new JTextField("");
		JLabel categoriaa = new JLabel(
				"Estas son las categorias disponibles:\n Economico \n SUV \n Pequeño \n Lujo \n Por favor ingrese el nombre de la categoria del vehiculo que le gustaria reservar: ");
		JLabel sedee = new JLabel(
				"Estas son las sedes disponibles:\n Motors Cañas \n Motors Palmas \n Motors Flora \n Por favor ingrese el nombre de la sede en la cual le gustaria recoger el vehiculo: ");
		JLabel fechadeRecoleccionn = new JLabel(
				"Por favor ingrese la fecha en formato yyyy-MM-dd en la cual le gustaria recoger el vehiculo: ");
		JLabel horadeRecoleccionn = new JLabel(
				"Por favor ingrese la hora en formato militar y con esta notacion HH:MM  en la cual le gustaria recoger el vehiculo: ");
		JLabel fechadeEntregaa = new JLabel(
				"Por favor ingrese la fecha en formato yyyy-MM-dd en la cual le gustaria entregar el vehiculo: ");
		JLabel horadeEntregaa = new JLabel(
				"Por favor ingrese la hora en formato militar y con esta notacion HH:MM  en la cual le gustaria entregar el vehiculo::");
		JLabel nombree = new JLabel("Por favor ingrese su nombre:");

		panel.add(categoriaa); 
		panel.add(categoria);
		panel.add(sedee);
		panel.add(sede);
		panel.add(fechadeRecoleccionn);
		panel.add(fechadeRecoleccion);
		panel.add(horadeRecoleccionn);
		panel.add(horadeRecoleccion);
		panel.add(fechadeEntregaa);
		panel.add(fechadeEntrega);
		panel.add(horadeEntregaa);
		panel.add(horadeEntrega);
		panel.add(nombree);
		panel.add(nombre);
		JButton reservar = new JButton("reservar");
		panel.add(reservar);
		caushaiel.add(panel);
		caushaiel.setVisible(true);
		reservar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<Double> lista;
				try {
					String categoriaaa = categoria.getText();
					String sedeee = sede.getText();
					String fechadeRecoleccionnn = fechadeRecoleccion.getText();
					String horadeRecoleccionnn = horadeRecoleccion.getText();
					String fechadeEntregaaa = fechadeEntrega.getText();
					String horadeEntregaaa = horadeEntrega.getText();
					String nombreee = nombre.getText();
					lista = ren.iniciarReserva(categoriaaa, sedeee, fechadeRecoleccionnn, horadeRecoleccionnn,
							fechadeEntregaaa, horadeEntregaaa, nombreee);
					
					
					double cobro = lista.get(0);
					double id = lista.get(1);
					double cobro30 = cobro * 0.3;
					metodospago(cobro30);
					
						} catch (ParseException e1) {
					JOptionPane.showMessageDialog(caushaiel,"No se logro realizar la reserva ingrese los datos nuevamente", "ERROR",JOptionPane.ERROR_MESSAGE);
					
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		

	}
	public void pagar(String numerotar, String fechacaducidad, String tipo) {
		double numerotarrrr = Double.parseDouble(numerotar);
		String fechacaducidadddd = fechacaducidad;
		String tipoooo = tipo;
		new MetododePago(numerotarrrr, fechacaducidadddd, tipoooo, false);
		
	}
	
	

	
		
	public void metodospago(double cobro30) {
		JFrame master = new JFrame();
	    master.setTitle("El monto que debe (30%) es: " + cobro30);
	    master.setSize(300, 300);

	    CardLayout cardLayout = new CardLayout();
	    JPanel cardPanel = new JPanel(cardLayout);

	    master.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    JPanel pa = new JPanel();
	    JButton bpayu = new JButton("Payu");
	    JButton bpaypal = new JButton("PayPal");
	    JButton bsire = new JButton("Sire");

	    pa.setLayout(new GridLayout(1, 3, 10, 10));
	    pa.add(bpayu);
	    pa.add(bpaypal);
	    pa.add(bsire);

	    cardPanel.add(pa, "Opciones");
	    cardPanel.add(new Payu(this), "Payu");
	    cardPanel.add(new Sire(this), "Sire");
	    cardPanel.add(new Paypal(this), "Paypal");

	    master.setLayout(new BorderLayout());
	    master.add(cardPanel, BorderLayout.CENTER);
	    master.setLocationRelativeTo(null);

	    bpayu.addActionListener(e -> {
	        cardLayout.show(cardPanel, "Payu");
	        master.setSize(500, 500);
	    });

	    bpaypal.addActionListener(e -> {
	        cardLayout.show(cardPanel, "Paypal");
	        master.setSize(500, 500);
	    });

	    bsire.addActionListener(e -> {
	        cardLayout.show(cardPanel, "Sire");
	        master.setSize(500, 500);
	    });

	    master.setVisible(true);
	}

	public void recoger() throws ParseException {
		String conductorextra = JOptionPane.showInputDialog("Desea añadir un conductor responda si/no");
		if ("si".equals(conductorextra)) {
			double id = Double.parseDouble(JOptionPane.showInputDialog(
					"Por favor ingrese el numero de la reserva y a continuacion se le pediran los datos para el otro conductor :"));
			Inscripcion("Cliente");
			double cobro = ren.obtenercobrofinal(id);
			double cobroconotroconductor = cobro * 0.2 + cobro;
			String seguroAd = JOptionPane.showInputDialog(
					"El cobro de un conductor adicional es de: " + cobro * 0.2 + " Es decir el cobro total seria de: "
							+ cobroconotroconductor + "\nDeseea incluir un seguro adiciona responda si/no");
			if ("si".equals(seguroAd)) {
				Collection<String> seguros = ren.mostrarSeguross();
				StringBuilder mensaje = new StringBuilder("Por favor escoja un seguro:\n");
				for (String elemento : seguros) {
					mensaje.append(elemento).append("\n");
				}
				String seguro = JOptionPane.showInputDialog(null, mensaje.toString());
				double costoundiaseguro = ren.devolvercostoSeguro(seguro);
				double costototalseguro = ren.obtenercobroconseguro(id, costoundiaseguro);
				double numerotar = Double
						.parseDouble(JOptionPane.showInputDialog("El costo de un dia para el seguro es de"
								+ costoundiaseguro + "por esto el cobro total con el seguro para todos los dias es de "
								+ (costototalseguro + cobroconotroconductor)
								+ " Por favor ingrese el numero de su tarjeta que utilizo para pagar la reserva:"));
				ren.cambiarestadotarjeta(numerotar);
				JOptionPane.showMessageDialog(inter,
						"Se realizo el cobro total, ya puede recoger su vehiculo y su tarjeta ha sido bloqueada hasta que se devuelva el vehiculo",
						"Exito", JOptionPane.INFORMATION_MESSAGE);

			} else {
				double numerotar = Double
						.parseDouble(JOptionPane.showInputDialog("Por favor ingrese el nuemro de su tarjeta"));
				String fechacaducidad = JOptionPane
						.showInputDialog("Por favor ingrese la fecha de caducidad en formato yyyy-MM-dd:");
				String tipo = JOptionPane.showInputDialog("Por favor ingrese el tipo de tarjeta:");
				ren.cambiarestadotarjeta(numerotar);
				JOptionPane.showMessageDialog(inter,
						"Se realizo el cobro total, ya puede recoger su vehiculo y su tarjeta ha sido bloqueada hasta que se devuelva el vehiculo",
						"Exito", JOptionPane.INFORMATION_MESSAGE);

			}
		} else {
			double id = Double.parseDouble(JOptionPane.showInputDialog("Por favor ingrese el numero de la reserva:"));
			double cobro = ren.obtenercobrofinal(id);
			String seguroAd = JOptionPane.showInputDialog(
					"El cobro total es de:" + cobro + "\nDeseea incluir un seguro adiciona responda si/no");
			if ("si".equals(seguroAd)) {
				Collection<String> seguros = ren.mostrarSeguross();
				StringBuilder mensaje = new StringBuilder("Por favor escoja un seguro:\n");
				for (String elemento : seguros) {
					mensaje.append(elemento).append("\n");
				}
				String seguro = JOptionPane.showInputDialog(null, mensaje.toString());
				double costoundiaseguro = ren.devolvercostoSeguro(seguro) + cobro;
				double costototalseguro = ren.obtenercobroconseguro(id, costoundiaseguro);
				double numerotar = Double
						.parseDouble(JOptionPane.showInputDialog("El costo de un dia para el seguro es de"
								+ costoundiaseguro + "por esto el cobro total con el seguro para todos los dias es de"
								+ costototalseguro + "Por favor ingrese el numero de su tarjeta"));
				String fechacaducidad = JOptionPane
						.showInputDialog("Por favor ingrese la fecha de caducidad en formato yyyy-MM-dd:");
				String tipo = JOptionPane.showInputDialog("Por favor ingrese el tipo de tarjeta:");
				ren.cambiarestadotarjeta(numerotar);
				JOptionPane.showMessageDialog(inter,
						"Se realizo el cobro total, ya puede recoger su vehiculo y su tarjeta ha sido bloqueada hasta que se devuelva el vehiculo",
						"Exito", JOptionPane.INFORMATION_MESSAGE);

			} else {
				double numerotar = Double
						.parseDouble(JOptionPane.showInputDialog("Por favor ingrese el nuemro de su tarjeta"));
				String fechacaducidad = JOptionPane
						.showInputDialog("Por favor ingrese la fecha de caducidad en formato yyyy-MM-dd:");
				String tipo = JOptionPane.showInputDialog("Por favor ingrese el tipo de tarjeta:");
				ren.cambiarestadotarjeta(numerotar);
				JOptionPane.showMessageDialog(inter,
						"Se realizo el cobro total, ya puede recoger su vehiculo y su tarjeta ha sido bloqueada hasta que se devuelva el vehiculo",
						"Exito", JOptionPane.INFORMATION_MESSAGE);

			}
		}
	}

	public void nom() {
		JOptionPane.showMessageDialog(inter, this.clien.getNombre(), "Cliente", JOptionPane.INFORMATION_MESSAGE);
	}

	public void cedula() {
		JOptionPane.showMessageDialog(inter, String.valueOf(this.clien.getCedula()), "Cedula",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public void fechanac() {
		JOptionPane.showMessageDialog(inter, this.clien.getFechadeNacimiento(), "Fecha de Nacimiento",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public void nacionalidad() {
		JOptionPane.showMessageDialog(inter, this.clien.getNacionalidad(), "Nacionalidad",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public void email() {
		JOptionPane.showMessageDialog(inter, this.clien.getEmail(), "Email", JOptionPane.INFORMATION_MESSAGE);
	}

	public void login() {
		JOptionPane.showMessageDialog(inter, this.clien.getLogin(), "Login ", JOptionPane.INFORMATION_MESSAGE);
	}

	public void numero() {
		JOptionPane.showMessageDialog(inter, String.valueOf(this.clien.getCelular()), "Numero",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public inicioCliente getInCliente() {
		return inCliente;
	}

	public void setInCliente(inicioCliente inCliente) {
		this.inCliente = inCliente;
	}

	public inicioG getInG() {
		return inG;
	}

	public void setInG(inicioG inG) {
		this.inG = inG;
	}
}
