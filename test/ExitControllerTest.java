package testcases;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import static org.mockito.ArgumentMatchers.anyString;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import bcccp.carpark.CarSensor;
import bcccp.carpark.Carpark;
import bcccp.carpark.Gate;
import bcccp.carpark.ICarSensor;
import bcccp.carpark.IGate;
import bcccp.carpark.exit.ExitController;
import bcccp.carpark.exit.ExitUI;
import bcccp.carpark.exit.IExitController;
import bcccp.carpark.exit.IExitUI;
import bcccp.tickets.adhoc.AdhocTicket;
import bcccp.tickets.adhoc.IAdhocTicket;

public class ExitControllerTest {
	
	IGate exitGate;
	ICarSensor is;
	ICarSensor os; 
	IExitUI ui;
	
	Carpark carpark;
	IAdhocTicket adhocTicket;
	IExitController exitController;

	@Before
	public void setUp() throws Exception {
		exitGate  = Mockito.mock(Gate.class);
		is = Mockito.mock(CarSensor.class);
		os = Mockito.mock(CarSensor.class);
		ui = Mockito.mock(ExitUI.class);
		carpark = Mockito.mock(Carpark.class);
		adhocTicket = Mockito.mock(AdhocTicket.class);
		
		exitController = new ExitController(carpark, exitGate, is, os, ui);
		
		Mockito.when(is.carIsDetected()).thenReturn(true);
		Mockito.when(carpark.getAdhocTicket(anyString())).thenReturn(adhocTicket);
		Mockito.when(exitGate.isRaised()).thenReturn(true);
		
		
		
	}

	@After
	public void tearDown() throws Exception {
		exitController = null;
		
	}

	@Test
	public void testDetectCar() {
		assertTrue(is.carIsDetected());
		
	}
	
	public void testIsAdhocTickeetValid() {
		assertEquals(carpark.getAdhocTicket("A2"), adhocTicket);
	}
	
	public void TestRaiseGate() {
		assertTrue(exitGate.isRaised());
	}

}
