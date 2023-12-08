package presentacion;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controlador.control;

public class inicioG extends JPanel{
	private control con;
	private JLabel  bienvenida;
	
	 
	public inicioG(control con) {
		this.con = con;
		
	
	
		
		JButton bemp = new JButton("Empleado");
		
		JButton bcliente = new JButton("Cliente");
	
		
		
		this.setLayout(new GridLayout(1,2 , 10, 10));

		this.add(bemp);
		this.add(bcliente);
		
		
		
		bemp.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				con.inicioCl();
				
			}
	});

		bcliente.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				con.inicioEmp();
				
			}
	});
	
	}
	
	
}
