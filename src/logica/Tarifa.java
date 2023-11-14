package logica;

public class Tarifa {
	public String temporada;
	public String seguroAdicional;
	public String automovil;
	public String cliente;
	public String otroConductor;
	public int valorExtraPorOtroConductor;
	public Sede sede;
	public Tarifa(String temporada, String seguroAdicional, String automovil, String cliente, String otroConductor,
			int valorExtraPorOtroConductor, Sede sede) {
		super();
		this.temporada = temporada;
		this.seguroAdicional = seguroAdicional;
		this.automovil = automovil;
		this.cliente = cliente;
		this.otroConductor = otroConductor;
		this.valorExtraPorOtroConductor = valorExtraPorOtroConductor;
		this.sede = sede;
	}
	public String getTemporada() {
		return temporada;
	}
	public String getSeguroAdicional() {
		return seguroAdicional;
	}
	public String getAutomovil() {
		return automovil;
	}
	public String getCliente() {
		return cliente;
	}
	public String getOtroConductor() {
		return otroConductor;
	}
	public int getValorExtraPorOtroConductor() {
		return valorExtraPorOtroConductor;
	}
	public Sede getSede() {
		return sede;
	}
}
