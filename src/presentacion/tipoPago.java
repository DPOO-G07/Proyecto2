package presentacion;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controlador.control;

public class tipoPago extends JPanel{
	private control con;
	private JLabel  bienvenida;
	
	 
	public tipoPago(control con) {
		this.con = con;
		
	
	
		
		JButton bpayu = new JButton("Payu");
		
		JButton bpaypal = new JButton("PayPal");
	
		JButton bsire = new JButton("Sire");
		
		this.setLayout(new GridLayout(1,2 , 10, 10));

		this.add(bpayu);
		this.add(bpaypal);
		this.add(bsire);
		
		
		
		bpayu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				con.inicioCl();
				
			}
	});
		bpaypal.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				con.inicioCl();
				
			}
	});

		bsire.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				con.inicioEmp();
				
			}
	});
	
	}
	
	
}
