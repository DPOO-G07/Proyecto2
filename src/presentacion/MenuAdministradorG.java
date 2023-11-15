package presentacion;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
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
		
		this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); 
        gbc.fill = GridBagConstraints.HORIZONTAL; 		this.infoSede = new JButton("Informacion Empleados");
		this.infoClientes = new JButton("Informacion Clientes ");
		this.nuevoClie = new JButton("Agregar Cliente ");
		this.nuevoEmp = new JButton("Agregar Empleado ");
		this.vehiSede = new JButton("Informacion Vehiculos Sede");
		this.actualizar = new JButton("Actualizar Estado Vehiculo ");
		this.tarifas = new JButton("Desea actualizar las tarifas?");
		this.seguros = new JButton("Desea gestionar los convenios con los seguros? ");
		this.sede = new JButton("Desea gestionar una sede?");
		this.proveedor = new JButton("Desea gestionar un proveedor? ");
		
		gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(infoSede, gbc);

        gbc.gridy = 1;
        this.add(infoClientes, gbc);

        gbc.gridy = 2;
        this.add(nuevoClie, gbc);

        gbc.gridy = 3;
        this.add(nuevoEmp, gbc);

        gbc.gridy = 4;
        this.add(vehiSede, gbc);

        gbc.gridy = 5;
        this.add(actualizar, gbc);
        
        gbc.gridy = 6;
        this.add(tarifas, gbc);

        gbc.gridy = 7;
        this.add(seguros, gbc);

        gbc.gridy = 8;
        this.add(sede, gbc);

        gbc.gridy = 9;
        this.add(proveedor, gbc);

       
		
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
				con.tarifas();
				
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
