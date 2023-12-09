package presentacion;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.RoundRectangle2D;
import java.util.Map;

import javax.swing.JPanel;

import Controlador.control;

public class TablaFechas extends JPanel{
	private Map<String, Integer>mapa;
	private control con;
	public TablaFechas(Map<String, Integer> mapa) {
        this.mapa = mapa;
        
    }

	 @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);

	        Graphics2D g2d = (Graphics2D) g;
	        int ancho = getWidth() / 3;
	        int alto = getHeight();

	        String maximo = Mayor();
	        Integer max = mapa.get(maximo);
	        alto = alto / max;

	        int offset = 50;  // Offset para evitar que los rectángulos se dibujen fuera del área visible

	        for (int i = 1; i <= 3; i++) {
	            String maximo1 = Mayor();
	            Integer r = mapa.get(maximo1);
	            mapa.remove(maximo1);

	            RoundRectangle2D.Double casilla = new RoundRectangle2D.Double(ancho * (i - 1) + offset, alto * r + offset,
	                    ancho - offset * 2, alto - offset * 2, 8, 8);

	            if (i == 1) {
	                g2d.setColor(Color.YELLOW);
	            } else if (i == 2) {
	                g2d.setColor(Color.RED);
	            } else {
	                g2d.setColor(Color.GREEN);
	            }
	            g2d.fill(casilla);
	            g2d.setColor(Color.BLACK);
	        }
	    }

	    private String Mayor() {
	        Integer x = Integer.MIN_VALUE;  // Inicializar con el valor mínimo posible
	        String nom = "";
	        for (String fecha : this.mapa.keySet()) {
	            Integer ente = mapa.get(fecha);
	            if (ente > x) {
	                x = ente;
	                nom = fecha;
	            }
	        }
	        return nom;
    }
}