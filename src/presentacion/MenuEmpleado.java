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

public class MenuEmpleado extends JPanel{
	private JButton  vehiSede, infoClientes, nuevoClie, porfechas;
	private control con;

	
	public MenuEmpleado (control con) {
		this.con = con;
		
		this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); 
        gbc.fill = GridBagConstraints.HORIZONTAL;		
		this.infoClientes = new JButton("Informacion Cliente ");
		this.nuevoClie = new JButton("Agregar Cliente ");
		
		this.vehiSede = new JButton("Lista Vehiculos Sede");
		this.porfechas = new JButton("Fechas Concurridas");
		
	
	
		
		
		  gbc.gridx = 0;
	        gbc.gridy = 0;
	        this.add(vehiSede, gbc);

	        gbc.gridy = 1;
	        this.add(infoClientes, gbc);

	        gbc.gridy = 2;
	        this.add(nuevoClie, gbc);
	        gbc.gridy = 3;
	        this.add(porfechas, gbc);
	        
		
		
		
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
		
		vehiSede.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				con.vehiculoSede();
				
			}
		});
		porfechas.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				con.tabal();
				
			}
		});
		
		}
		
	

	
}
