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

public class ModificarVehi extends JPanel {
	private control con;
	private JButton actualizarEst, camSede;
	
	public ModificarVehi (control con) {
		this.con = con;
		
		
		
		
		this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); 
        gbc.fill = GridBagConstraints.HORIZONTAL; 
        
		this.actualizarEst = new JButton("Desea actualizar su estado?  ");
		this.camSede = new JButton("Desea cambiarlo de sede para disponibilidad?");

		
		gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(actualizarEst, gbc);

        gbc.gridy = 1;
        this.add(camSede, gbc);
	
		
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
