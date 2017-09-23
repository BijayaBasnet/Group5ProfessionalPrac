package testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import bcccp.carpark.Carpark;
import bcccp.carpark.ICarpark;
import bcccp.carpark.ICarparkObserver;
import bcccp.carpark.entry.EntryController;
import bcccp.tickets.adhoc.AdhocTicket;
import bcccp.tickets.adhoc.AdhocTicketDAO;
import bcccp.tickets.adhoc.IAdhocTicket;
import bcccp.tickets.adhoc.IAdhocTicketDAO;
import bcccp.tickets.season.ISeasonTicket;
import bcccp.tickets.season.ISeasonTicketDAO;
import bcccp.tickets.season.SeasonTicket;
import bcccp.tickets.season.SeasonTicketDAO;

public class CarparkTest {
	
	ICarparkObserver carparkObserver;
	ISeasonTicketDAO seasonTicketDAO;
	IAdhocTicketDAO adhocTicketDAO;
	IAdhocTicket adhocTicket;
	ISeasonTicket seasonTicket;
	ICarpark carpark;
	String carparkId;
	int numberOfCapacity;
	

	@Before
	public void setUp() throws Exception {
		carparkObserver = Mockito.mock(EntryController.class);
		seasonTicketDAO = Mockito.mock(SeasonTicketDAO.class);
		adhocTicketDAO = Mockito.mock(AdhocTicketDAO.class);
		adhocTicket = Mockito.mock(AdhocTicket.class);
		seasonTicket = Mockito.mock(SeasonTicket.class);
		long currentDateTime = new Date().getTime() + 300000;
		
		Mockito.when(adhocTicketDAO.createTicket("Bathurst")).thenReturn(adhocTicket);
		Mockito.when(seasonTicketDAO.findTicketById("1")).thenReturn(seasonTicket);
		Mockito.when(seasonTicket.getEndValidPeriod()).thenReturn(currentDateTime);
		carparkId = "Bathurst";
		numberOfCapacity = 1;
		
		carpark = new Carpark(carparkId, numberOfCapacity, adhocTicketDAO, seasonTicketDAO);
		
		
	}
	

	@After
	public void tearDown() throws Exception {
		carparkObserver = null;
	}
	
	@Test
	public void testInit() {
		assertEquals(carpark.getName(), carparkId);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructorWithAdhocTicketDAONull() {
		carpark = new Carpark(carparkId, numberOfCapacity, null, seasonTicketDAO);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorWithSeasonTicketDAONull() {
		carpark = new Carpark(carparkId, numberOfCapacity, adhocTicketDAO, null);
	}
	
	@Test
	public void testisFull() {
		carpark.register(carparkObserver);
		assertEquals(carpark.isFull(), true);
	}
	
	@Test
	public void testIssueAdhocTicket() {
		assertTrue(carpark.issueAdhocTicket() instanceof IAdhocTicket);
		
	}
	
	@Test
	public void testIsSeasonTicketValid() {
		assertTrue(carpark.isSeasonTicketValid("1"));
	}

		
	}
