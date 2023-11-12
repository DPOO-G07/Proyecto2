package presentacion;

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
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.horarioAten = new JButton(" Desea cambiar los horario de atencion? ");
		this.cambAdmin = new JButton("Desea cambiar el administrador de sede?");
		this.nuevoEmp = new JButton("Desea agregar un empleado? ");
		this.nuevoVehi = new JButton("Desea agregar un vehiculo?");
		
		this.add(Box.createVerticalGlue());
		this.add(horarioAten);
		this.add(cambAdmin);
		this.add(nuevoEmp);
		this.add(nuevoVehi);

		this.add(Box.createVerticalGlue());
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
