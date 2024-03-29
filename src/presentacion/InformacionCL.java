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
import logica.Cliente;

public class InformacionCL extends JPanel{
	private control con;
	private JButton nom, cedula, fechanac, nacionalidad,email,numero,login;

	
	public InformacionCL(control con) {
		this.con = con;
		this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); 
        gbc.fill = GridBagConstraints.HORIZONTAL; 
        
		this.nom = new JButton("Desea saber su nombre");
		this.cedula = new JButton("Desea saber su cedula");
		this.fechanac = new JButton("Desea saber su fecha de nacimiento ");
		this.nacionalidad = new JButton("Desea saber su nacionalidad");
		this.email = new JButton(" Desea saber su email");
		this.numero = new JButton("Desea saber su numero");
		this.login = new JButton(" Desea saber su login");
		gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(nom, gbc);

        gbc.gridy = 1;
        this.add(cedula, gbc);

        gbc.gridy = 2;
        this.add(fechanac, gbc);

        gbc.gridy = 3;
        this.add(nacionalidad, gbc);

        gbc.gridy = 4;
        this.add(email, gbc);

        gbc.gridy = 5;
        this.add(numero, gbc);
        gbc.gridy = 6;
        this.add(login, gbc);
	
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
