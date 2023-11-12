package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import Controlador.control;

public class MenuCliente extends JPanel {

	private JButton reservar, actualizarCl;
	private control con;

	public MenuCliente (control con) {
			this.con = con;
			
			this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			this.reservar = new JButton("Reservar");
			this.actualizarCl = new JButton("Actualizar Informacion");
			
			
			
			
			
			this.add(Box.createVerticalGlue());
			this.add(reservar); 
			this.add(actualizarCl);
			
			this.add(Box.createVerticalGlue());
			
			reservar.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					con.reservar();
					
				}
			});
			
			actualizarCl.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				con.actualizarCl();
				}
			});
			
		

		
	
}}
