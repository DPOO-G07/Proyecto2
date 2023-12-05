package presentacion;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import Controlador.control;

public class MenuAdministradorG extends JPanel{
	private JButton   actualizar,tarifas, seguros,sede,proveedor;
	private control con;

	
	public MenuAdministradorG (control con) {
		this.con = con;
		
		this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); 
        gbc.fill = GridBagConstraints.HORIZONTAL; 		
		this.actualizar = new JButton("Actualizar Estado Vehiculo ");
		this.tarifas = new JButton("Desea actualizar las tarifas?");
		this.seguros = new JButton("Desea gestionar los convenios con los seguros? ");
		this.sede = new JButton("Desea gestionar una sede?");
		this.proveedor = new JButton("Desea gestionar un proveedor? ");
		
		gbc.gridx = 0;
        gbc.gridy = 0;
    

        gbc.gridy = 1;
        this.add(actualizar, gbc);
        
        gbc.gridy = 2;
        this.add(tarifas, gbc);

        gbc.gridy = 3;
        this.add(seguros, gbc);

        gbc.gridy = 4;
        this.add(sede, gbc);

        gbc.gridy = 5;
        this.add(proveedor, gbc);

       
		
		
		
		
		actualizar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				con.actualizarV();
				
			}
		});
		tarifas.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				con.tarifas();
				
			}
		});
		seguros.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				con.Seguros();
				
			}
		});
		sede.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				con.sede();
				
			}
		});
		proveedor.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				con.hacerPedido();
				
			}
		});
		}
		
	

	
}
