package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import Controlador.control;
import logica.Cliente;

public class InformacionCL extends JPanel{
	private control con;
	private JButton nom, cedula, fechanac, nacionalidad,email,numero,login;

	
	public InformacionCL(control con) {
		this.con = con;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.nom = new JButton("Desea saber su nombre");
		this.cedula = new JButton("Desea saber su cedula");
		this.fechanac = new JButton("Desea saber su fecha de nacimiento ");
		this.nacionalidad = new JButton("Desea saber su nacionalidad");
		this.email = new JButton(" Desea saber su email");
		this.numero = new JButton("Desea saber su numero");
		this.login = new JButton(" Desea saber su login");
		this.add(Box.createVerticalGlue());
		this.add(nom);
		this.add(cedula);
		this.add(fechanac);
		this.add(nacionalidad);
		this.add(email);
		this.add(numero);
		this.add(login);
		
		this.add(Box.createVerticalGlue());
		nom.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				con.nom();
				
			}
		});
		cedula.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				con.cedula();
				
			}
		});
		fechanac.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				con.fechanac();
				
			}
		});
		nacionalidad.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				con.nacionalidad();
				
			}
		});
		email.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				con.email();
				
			}
		});
		numero.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				con.numero();
				
			}
		});
		login.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				con.login();
				
			}
		});
	}
}
