package testcases;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import bcccp.carpark.CarSensor;
import bcccp.carpark.Carpark;
import bcccp.carpark.Gate;
import bcccp.carpark.ICarSensor;
import bcccp.carpark.ICarpark;
import bcccp.carpark.IGate;
import bcccp.carpark.entry.EntryController;
import bcccp.carpark.entry.EntryUI;
import bcccp.carpark.entry.IEntryController;
import bcccp.carpark.entry.IEntryUI;
import bcccp.tickets.adhoc.AdhocTicket;
import bcccp.tickets.adhoc.IAdhocTicket;

public class EntryControllerTest {
	
	IGate entryGate;
	ICarSensor outsideSensor; 
	ICarSensor insideSensor;
	IEntryUI ui;
	
	Carpark carpark;
    IAdhocTicket adhocTicket;
    IEntryController entryController;

	@Before
	public void setUp() throws Exception {
		entryGate  = Mockito.mock(Gate.class);
		insideSensor = Mockito.mock(CarSensor.class);
		outsideSensor = Mockito.mock(CarSensor.class);
		ui = Mockito.mock(EntryUI.class);
		carpark = Mockito.mock(Carpark.class);
		adhocTicket = Mockito.mock(AdhocTicket.class);
		Mockito.when(carpark.issueAdhocTicket()).thenReturn(adhocTicket);
		Mockito.when(adhocTicket.getEntryDateTime()).thenReturn(new Date().getTime());
		entryController = new EntryController(carpark, entryGate, outsideSensor, insideSensor, ui);
		
		Mockito.when(outsideSensor.carIsDetected()).thenReturn(true);
		Mockito.when(entryGate.isRaised()).thenReturn(false);
	}

	@After
	public void tearDown() throws Exception {
				entryController = null;
	}

	@Test
	public void testCarDetected() {
				assertTrue(outsideSensor.carIsDetected());
		
	}
	
	public void testGateRaise() {
				assertFalse(entryGate.isRaised());
	}
	

}
