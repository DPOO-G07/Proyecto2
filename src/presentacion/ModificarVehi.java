package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import Controlador.control;

public class ModificarVehi extends JPanel {
	private control con;
	private JButton actualizarEst, camSede;
	
	public ModificarVehi (control con) {
		this.con = con;
		
		
		
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.actualizarEst = new JButton("Desea actualizar su estado?  ");
		this.camSede = new JButton("Desea cambiarlo de sede para disponibilidad?");

		
		this.add(Box.createVerticalGlue());
		this.add(actualizarEst);
		this.add(camSede);
		this.add(Box.createVerticalGlue());
	
		
		actualizarEst.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				con.CambEstado();
				
			}
		});
		camSede.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				con.trasnladoVehi();
				
			}
		});
		
	}
}
