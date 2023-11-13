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

public class ModificarSede extends JPanel {
	private control con;
	private JButton horarioAten, cambAdmin, nuevoEmp, nuevoVehi;
	private String lasede;
	
	public ModificarSede (control con, String lasede) {
		this.con = con;
		this.lasede = lasede;
		this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); 
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
		this.horarioAten = new JButton(" Desea cambiar los horario de atencion? ");
		this.cambAdmin = new JButton("Desea cambiar el administrador de sede?");
		this.nuevoEmp = new JButton("Desea agregar un empleado? ");
		this.nuevoVehi = new JButton("Desea agregar un vehiculo?");
		
		 gbc.gridx = 0;
	        gbc.gridy = 0;
	        this.add(horarioAten, gbc);

	        gbc.gridy = 1;
	        this.add(cambAdmin, gbc);

	        gbc.gridy = 2;
	        this.add(nuevoEmp, gbc);

	        gbc.gridy = 3;
	        this.add(nuevoVehi, gbc);
		horarioAten.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				con.cambiarHorario(lasede);;
				
			}
		});
		cambAdmin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				con.nuevoAdminSede(lasede);
				
			}
		});
		nuevoEmp.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				con.nuevoCliente();
				
			}
		});
		nuevoVehi.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				con.crearVehi();;
				
			}
		});
	}
}
