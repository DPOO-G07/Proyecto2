package tests;
import presentacion.carga;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Modelo.Rentadora;

class PruebaCargadeArchivos {
	
	@BeforeEach
	public void setUp() throws Exception {
		 new carga();
	}

	

	@Test
	public void carga() {
		Rentadora rentadora = carga.Leer("data/personas.txt", "data/sede.txt", "data/reserva.txt", "data/vehiculos.txt","data/Proveedores.txt","data/Seguros.txt","data/MetododePago.txt");	
		assertNotNull(rentadora);
	}
	@Test
	public void carga2() {
		Rentadora rentadora = carga.Leer("data/persona.txt", "data/sede.txt", "data/reserva.txt", "data/vehiculos.txt","data/Proveedores.txt","data/Seguros.txt","data/MetododePago.txt");	
		assertNull(rentadora);
	} 


}