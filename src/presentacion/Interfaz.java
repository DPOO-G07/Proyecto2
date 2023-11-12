package presentacion;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Controlador.control;


public class Interfaz extends JFrame {
	public control con;
	public inicio in;
	private CardLayout cardLayout;
	private JPanel cardPanel;
	public MenuAdministradorL adminL;
	public MenuAdministradorG adminG;
	public MenuEmpleado empleado;
	
	
	
	public Interfaz(){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(500,500);
		this.cardLayout = new CardLayout();
        this.cardPanel = new JPanel(cardLayout);
        
		this.setLayout(new BorderLayout());
		this.setTitle("Tu Rentadora de Confianza");
		
		this.con = new control(this);
		this.in = con.getPrimera();
		this.adminL = con.getMenuadminL();
		this.adminG = con.getMenuadminG();
		this.empleado = con.getMenuE();
		this.cardPanel.add(in, "Inicio");
		this.cardPanel.add(adminL, "Admin Local");
		this.cardPanel.add(adminG, "Administrador General");
		this.cardPanel.add(empleado, "Empleado");
		this.cardPanel.add(empleado, "Cliente");
		
		
		
	
		this.add(cardPanel,BorderLayout.CENTER);
		
		
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                // 
            	try {
					con.salvar();
				} catch (FileNotFoundException | UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
		
	}
	public static void main(String[] args) {
		Interfaz prin = new Interfaz();
		
	}
	public void adminLocal() {
		this.cardLayout.show(cardPanel, "Admin Local");
	}
	public void adminGeneral() {
		this.cardLayout.show(cardPanel, "Administrador General");
	}
	public void Empleado() {
		this.cardLayout.show(cardPanel, "Empleado");
	}
	public void Cliente() {
		this.cardLayout.show(cardPanel, "Cliente");
	}
	
}
