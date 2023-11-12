package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import Controlador.control;

public class MenuAdministradorG extends JPanel{
	private JButton infoSede, vehiSede, infoClientes, nuevoEmp, nuevoClie, actualizar,tarifas, seguros,sede,proveedor;
	private control con;

	
	public MenuAdministradorG (control con) {
		this.con = con;
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.infoSede = new JButton("Informacion Empleados");
		this.infoClientes = new JButton("Informacion Clientes ");
		this.nuevoClie = new JButton("Agregar Cliente ");
		this.nuevoEmp = new JButton("Agregar Empleado ");
		this.vehiSede = new JButton("Informacion Vehiculos Sede");
		this.actualizar = new JButton("Actualizar Estado Vehiculo ");
		this.tarifas = new JButton("Desea actualizar las tarifas?");
		this.seguros = new JButton("Desea gestionar los convenios con los seguros? ");
		this.sede = new JButton("Desea gestionar una sede?");
		this.proveedor = new JButton("Desea gestionar un proveedor? ");
		
		this.add(Box.createVerticalGlue());
		this.add(infoSede);
		this.add(infoClientes);
		this.add(nuevoClie);
		this.add(nuevoEmp);
		this.add(vehiSede);
		this.add(actualizar);
		this.add(tarifas);
		this.add(seguros);
		this.add(sede);
		this.add(proveedor);
		this.add(Box.createVerticalGlue());
		
		infoSede.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				con.infoempleados();
				
			}
		});
		
		infoClientes.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			con.infoClientes();
			
		}
	});
	
		nuevoClie.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			con.nuevoCliente();
			
		}
	});
		nuevoEmp.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				con.nuevoEmpleado();
				
			}
		});
		vehiSede.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				con.vehiculoSede();
				
			}
		});
		actualizar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				con.actualizarV();
				
			}
		});
		tarifas.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		seguros.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				con.Seguros();
				
			}
		});
		sede.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				con.sede();
				
			}
		});
		proveedor.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				con.hacerPedido();
				
			}
		});
		}
		
	

	
}
