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
	public inicio inempleado;
	private CardLayout cardLayout;
	private JPanel cardPanel;
	public MenuAdministradorL adminL;
	public MenuAdministradorG adminG;
	public MenuEmpleado empleado;
	public MenuCliente cliente;
	public inicioCliente incliente;
	public inicioG inG;
	
	 
	
	public Interfaz(){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(300,300);
		this.cardLayout = new CardLayout();
        this.cardPanel = new JPanel(cardLayout);
        
		this.setLayout(new BorderLayout());
		this.setTitle("Tu Rentadora de Confianza");
		
		this.con = new control(this);
		this.inempleado = con.getPrimera();
		this.adminL = con.getMenuadminL();
		this.adminG = con.getMenuadminG();
		this.empleado = con.getMenuE();
		this.cliente = con.getMenuCl();
		this.incliente = con.getInCliente();
		
		this.inG = con.getInG();
		this.cardPanel.add(inG, "Inicio");
		this.cardPanel.add(inempleado, "Inicio empl");
		this.cardPanel.add(adminL, "Admin Local");
		this.cardPanel.add(adminG, "Administrador General");
		this.cardPanel.add(empleado, "Empleado");
		this.cardPanel.add(cliente, "Cliente");
		this.cardPanel.add(incliente, "Inicio cliente");
		
		
	
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
		this.setSize(500,500);
		this.setLocationRelativeTo(null);
		
	}
	public void inGE() {
		this.cardLayout.show(cardPanel,"Inicio");
		this.setSize(300,300);
		this.setLocationRelativeTo(null);
	}
	public void adminGeneral() {
		this.cardLayout.show(cardPanel, "Administrador General");
		this.setSize(500,500);
		this.setLocationRelativeTo(null);
	}
	public void Empleado() {
		this.cardLayout.show(cardPanel, "Empleado");
		this.setSize(500,500);
		this.setLocationRelativeTo(null);
	}
	public void Cliente() {
		this.cardLayout.show(cardPanel, "Cliente");
		this.setSize(500,500);
		this.setLocationRelativeTo(null);
	}
	public void inCliente() {
		this.cardLayout.show(cardPanel, "Inicio empl");
		this.setSize(500,500);
		this.setLocationRelativeTo(null);
	}
	public void inEmpleado() {
		this.cardLayout.show(cardPanel, "Inicio cliente");
		this.setSize(500,500);
		this.setLocationRelativeTo(null);
	}
	
	
}
