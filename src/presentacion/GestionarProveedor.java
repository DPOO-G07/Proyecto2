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

public class GestionarProveedor extends JPanel {
	private control con;
	private JButton agregarPro, eliminarPro, consultarPro, pedido;
	
	public GestionarProveedor (control con) {
		this.con = con;
		 
		
		this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); 
        gbc.fill = GridBagConstraints.HORIZONTAL; 
        
		this.agregarPro = new JButton(" Desea agregar un proveedor?  ");
		
		this.consultarPro = new JButton("Desea saber que proveedores hay?");
		this.eliminarPro = new JButton("Desea eliminar un proveedor? " );
		this.pedido = new JButton("Desea hacer un pedido? ");
		
		 gbc.gridx = 0;
	        gbc.gridy = 0;
	        this.add(agregarPro, gbc);

	        gbc.gridy = 1;
	        this.add(consultarPro, gbc);

	        gbc.gridy = 2;
	        this.add(eliminarPro, gbc);

	        gbc.gridy = 3;
	        this.add(pedido, gbc);

	        
		agregarPro.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				con.agregrProveedor();;
				
			}
		});
		consultarPro.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				con.mostrarProveedor();;
				
			}
		});
		eliminarPro.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				con.eliminarProveedor();
				
			}
		});
		pedido.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				con.agregrProveedor();;
				
			}
		});
		
	}
}
