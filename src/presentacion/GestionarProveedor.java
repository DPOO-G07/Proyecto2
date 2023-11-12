package presentacion;

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
		
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.agregarPro = new JButton(" Desea agregar un proveedor?  ");
		
		this.consultarPro = new JButton("Desea saber que proveedores hay?");
		this.eliminarPro = new JButton("Desea eliminar un proveedor? " );
		this.pedido = new JButton("Desea hacer un pedido? ");
		
		this.add(Box.createVerticalGlue());
		this.add(consultarPro);
		this.add(agregarPro);
		
		this.add(eliminarPro);
		this.add(pedido);

		this.add(Box.createVerticalGlue());
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
