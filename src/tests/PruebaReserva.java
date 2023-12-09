package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import logica.Reserva;
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertNotNull;


import static org.junit.Assert.*;


	public class PruebaReserva {

	    @Test
	    public void testReservaConstructorAndGetterMethods() {
	        // Arrange
	        Double numerodeReserva = 1.0;
	        String tipodeVehiculo = "SUV";
	        String sede = "Motors Caña";
	        String fechadeRecoleccion = "2023-01-01";
	        String horadeRecoleccion = "10:00";
	        String fechadeEntrega = "2023-01-02";
	        String horadeEntrega = "12:00";
	        Double cobro = 150.0;
	        String nomcliente = "John Doe";
	        String estado = "Reservado";

	        // Act
	        Reserva reserva = new Reserva(numerodeReserva, tipodeVehiculo, sede, fechadeRecoleccion, horadeRecoleccion,
	                fechadeEntrega, horadeEntrega, cobro, nomcliente, estado);

	        // Assert
	        assertNotNull(reserva);
	        assertEquals(numerodeReserva, reserva.getNumerodereserva(), 0.001);
	        assertEquals(tipodeVehiculo, reserva.getTipodeVehiculo());
	        assertEquals(sede, reserva.getSede());
	        assertEquals(fechadeRecoleccion, reserva.getFechadeRecoleccion());
	        assertEquals(horadeRecoleccion, reserva.getHoradeRecoleccion());
	        assertEquals(fechadeEntrega, reserva.getFechadeEntrega());
	        assertEquals(horadeEntrega, reserva.getHoradeEntrega());
	        assertEquals(cobro, reserva.getCobro(), 0.001);
	        assertEquals(nomcliente, reserva.getNomcliente());
	        assertEquals(estado, reserva.getEstado());
	    }

	    // Add more tests for edge cases or additional scenarios as needed
	}



