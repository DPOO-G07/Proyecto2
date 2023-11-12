package presentacion;

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
		
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.agregarSeg = new JButton(" Desea agregar un seguro?  ");
		
		this.consultarSeg = new JButton("Desea saber que seguros hay?");
		this.eliminarSeg = new JButton("Desea eliminar un seguro? " );
		
		
		this.add(Box.createVerticalGlue());
		this.add(consultarSeg);
		this.add(agregarSeg);
		
		this.add(eliminarSeg);
		

		this.add(Box.createVerticalGlue());
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
