package testcases;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.ArgumentMatchers.anyLong;

import bcccp.carpark.Carpark;
import bcccp.carpark.ICarpark;
import bcccp.carpark.entry.EntryUI;
import bcccp.carpark.paystation.IPaystationUI;
import bcccp.carpark.paystation.PaystationUI;
import bcccp.tickets.adhoc.AdhocTicket;
import bcccp.tickets.adhoc.IAdhocTicket;

public class PayStationControllerTest {
	
	
	IPaystationUI ui;	
	ICarpark carpark;

	IAdhocTicket  adhocTicket;
	float charge;

	@Before
	public void setUp() throws Exception {
		carpark = Mockito.mock(Carpark.class);
		ui = Mockito.mock(PaystationUI.class);
		adhocTicket = Mockito.mock(AdhocTicket.class);
		
		
		Mockito.when(carpark.getAdhocTicket("Bathurst")).thenReturn(adhocTicket);
		Mockito.when(carpark.calculateAddHocTicketCharge(anyLong())).thenReturn(4.0f);
	}

	@After
	public void tearDown() throws Exception {
	}


}
