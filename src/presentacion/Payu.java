package presentacion;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controlador.control;
import logica.MetododePago;

public class Payu extends JPanel{
	private control con;
	public Payu(control con){
		this.con = con;
	JLabel plat = new JLabel("PayPal");
	JTextField tipopago = new JTextField("");
	
	JTextField numerotar = new JTextField("");
	JTextField fechacaducidad = new JTextField("");
	JTextField tipo = new JTextField("");
	
	JLabel fechacaducidadd = new JLabel(
			"Por favor ingrese la fecha de caducidad en formato yyyy-MM-dd:");
	JLabel tipoo = new JLabel("Por favor ingrese el tipo de tarjeta:");
	JButton pagar = new JButton("pagar");
	this.add(plat);
	this.add(tipopago);
	this.add(numerotar);
	this.add(fechacaducidadd);
	this.add(fechacaducidad);
	this.add(tipoo);
	this.add(tipo);
	this.add(pagar);
	this.setLayout(new GridLayout(10,2 , 10, 10));
	
	pagar.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			con.pagar(numerotar.getText(), fechacaducidad.getText(), tipo.getText());
			
		}
	});
	
	

	
	
	
}}
