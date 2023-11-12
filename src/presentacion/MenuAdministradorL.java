package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import Controlador.control;

public class MenuAdministradorL extends JPanel{
	private JButton infoSede, vehiSede, infoClientes, nuevoEmp, nuevoClie, actualizar;
	private control con;

	
	public MenuAdministradorL (control con) {
		this.con = con;
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.infoSede = new JButton("Lista Empleados");
		this.infoClientes = new JButton("Informacion Cliente ");
		this.nuevoClie = new JButton("Agregar Cliente ");
		this.nuevoEmp = new JButton("Agregar Empleado ");
		this.vehiSede = new JButton("Lista Vehiculos Sede");
		this.actualizar = new JButton("Actualizar Estado Vehiculo ");
		
		
		
		
		
		this.add(Box.createVerticalGlue());
		this.add(infoSede);
		this.add(infoClientes);
		this.add(nuevoClie);
		this.add(nuevoEmp);
		this.add(vehiSede);
		this.add(actualizar);
		
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
		
		}
		
	

	
}
