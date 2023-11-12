package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controlador.control;

public class inicio extends JPanel{
	private control con;
	private JLabel usuario, contraseña, bienvenida;
	
	private JTextField us,contra;
	
	
	public inicio(control con) {
		this.con = con;
		
		this.bienvenida = new JLabel("Bienvenido!");
		bienvenida.setBounds(20, 30, 200, 20);
		
		this.usuario = new JLabel("Usuario");
		usuario.setBounds(40, 80, 180, 20);
		
		this.contraseña = new JLabel("Contraseña");
		contraseña.setBounds(40, 120, 180, 20);
		
		this.us = new JTextField();
		us.setBounds(120, 80, 180, 20);
		
		this.contra = new JTextField();
		contra.setBounds(120, 120, 180, 20);
		
		JButton bver = new JButton("Ingresar");
		bver.setBounds(200,180,180,20);
		
		this.setLayout(null);
		
		this.add(bver);
		this.add(bienvenida);
		this.add(contra);
		this.add(contraseña);
		this.add(us);
		this.add(usuario);
		
		bver.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			ver();
			
		}
	});
	}
	
	public void ver () {
		con.verificar(this.us.getText(), this.contra.getText());
		con.setUser(this.us.getText());
	}
}
