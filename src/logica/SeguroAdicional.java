package logica;

public class SeguroAdicional {
	public String nombredelSeguro;
	public int tarifaporDia;
	public SeguroAdicional(String nombredelSeguro, int tarifaporDia) {
		super();
		this.nombredelSeguro = nombredelSeguro;
		this.tarifaporDia = tarifaporDia;
	}
	public int getTarifaporDia() {
		return tarifaporDia;
	}
	public void setTarifaporDia(int tarifaporDia) {
		this.tarifaporDia = tarifaporDia;
	}
	public String getNombredelSeguro() {
		return nombredelSeguro;
	}
	

}
