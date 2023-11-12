package logica;

public class LicenciadeConduccion {
	public int numero;
	public String paisdeExpedicion;
	public String fechadeVencimiento;
	//png imagen de la licencia//
	public LicenciadeConduccion(int numero, String paisdeExpedicion, String fechadeVencimiento) {
		super();
		this.numero = numero;
		this.paisdeExpedicion = paisdeExpedicion;
		this.fechadeVencimiento = fechadeVencimiento;
	}
	public int getNumero() {
		return numero;
	}
	public String getPaisdeExpedicion() {
		return paisdeExpedicion;
	}
	public String getFechadeVencimiento() {
		return fechadeVencimiento;
	}

}
