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
		insideSensor = Mockito.mock(CarSensor.class);
		
	
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testCarDetected() {
		
	}
	
	public void testGateRaise() {
		
	}
	

}
