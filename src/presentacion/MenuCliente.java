package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import Controlador.control;

public class MenuCliente extends JPanel {

	private JButton reservar, recoger;
	private control con;

	public MenuCliente (control con) {
			this.con = con;
			
			this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			this.reservar = new JButton("Reservar");
			this.recoger = new JButton("Recoger Vehiculo");
			
			
			
			
			
			this.add(Box.createVerticalGlue());
			this.add(reservar); 
			this.add(recoger);
			
			this.add(Box.createVerticalGlue());
			
			reservar.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					try {
						con.reservar();
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
			
			recoger.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				con.recoger();
				}
			});
			
		

		
	
}}
