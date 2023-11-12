package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import Controlador.control;

public class MenuEmpleado extends JPanel{
	private JButton  vehiSede, infoClientes, nuevoClie;
	private control con;

	
	public MenuEmpleado (control con) {
		this.con = con;
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.infoClientes = new JButton("Informacion Cliente ");
		this.nuevoClie = new JButton("Agregar Cliente ");
		
		this.vehiSede = new JButton("Lista Vehiculos Sede");
		
		
	
	
		
		
		this.add(Box.createVerticalGlue());
		
		this.add(infoClientes);
		this.add(nuevoClie);
		
		this.add(vehiSede);
	
		
		this.add(Box.createVerticalGlue());
		
		
		
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
		
		
		}
		
	

	
}
