package presentacion;

import java.awt.Dimension;
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

public class MenuAdministradorL extends JPanel{
	private JButton infoSede, vehiSede, infoClientes, nuevoEmp, nuevoClie, actualizar;
	private control con;

	
	public MenuAdministradorL (control con) {
		this.con = con;

        
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); 
        gbc.fill = GridBagConstraints.HORIZONTAL; 

        this.infoSede = new JButton("Lista Empleados");
        this.infoClientes = new JButton("Informacion Cliente ");
        this.nuevoClie = new JButton("Agregar Cliente ");
        this.nuevoEmp = new JButton("Agregar Empleado ");
        this.vehiSede = new JButton("Lista Vehiculos Sede");
        this.actualizar = new JButton("Actualizar Estado Vehiculo ");

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
