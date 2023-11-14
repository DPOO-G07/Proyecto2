package presentacion;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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
			
			this.setLayout(new GridBagLayout());
	        GridBagConstraints gbc = new GridBagConstraints();
	        gbc.insets = new Insets(10, 10, 10, 10); 
	        gbc.fill = GridBagConstraints.HORIZONTAL;	
	        this.reservar = new JButton("Reservar");
			this.recoger = new JButton("Recoger Vehiculo");
			
			
		
		
			
			
			  gbc.gridx = 0;
		        gbc.gridy = 0;
		        this.add(reservar, gbc);

		        gbc.gridy = 1;
		        this.add(recoger, gbc);
		
			
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
				try {
					con.recoger();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			});
			
		

		
	
}}
