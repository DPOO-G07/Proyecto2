package presentacion;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import Controlador.control;

public class GestionarSeguro extends JPanel {
	private control con;
	private JButton agregarSeg, eliminarSeg, consultarSeg;
	
	public GestionarSeguro (control con) {
		this.con = con;
		
		
		this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); 
        gbc.fill = GridBagConstraints.HORIZONTAL; 
        
		this.agregarSeg = new JButton(" Desea agregar un seguro?  ");
		
		this.consultarSeg = new JButton("Desea saber que seguros hay?");
		this.eliminarSeg = new JButton("Desea eliminar un seguro? " );
		
		
		 gbc.gridx = 0;
	        gbc.gridy = 0;
	        this.add(agregarSeg, gbc);

	        gbc.gridy = 1;
	        this.add(consultarSeg, gbc);

	        gbc.gridy = 2;
	        this.add(eliminarSeg, gbc);

		agregarSeg.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				con.agregarSeguro();;
				
			}
		});
		consultarSeg.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				con.mostrarseguros();;
				
			}
		});
		eliminarSeg.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				con.eliminarSeguro();
				
			}
		});
		
	}
}
