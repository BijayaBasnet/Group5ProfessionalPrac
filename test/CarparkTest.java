package testcases;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import bcccp.carpark.Carpark;
import bcccp.carpark.ICarpark;
import bcccp.carpark.ICarparkObserver;
import bcccp.carpark.entry.EntryController;
import bcccp.tickets.adhoc.AdhocTicketDAO;
import bcccp.tickets.adhoc.IAdhocTicketDAO;
import bcccp.tickets.season.ISeasonTicketDAO;
import bcccp.tickets.season.SeasonTicketDAO;

public class CarparkTest {
	
	ICarparkObserver carparkObserver;
	ISeasonTicketDAO seasonTicketDAO;
	IAdhocTicketDAO adhocTicketDAO;
	ICarpark carpark;
	String carparkId;
	int numberOfCapacity;
	

	@Before
	public void setUp() throws Exception {
		carparkObserver = Mockito.mock(EntryController.class);
		seasonTicketDAO = Mockito.mock(SeasonTicketDAO.class);
		adhocTicketDAO = Mockito.mock(AdhocTicketDAO.class);
		carparkId = "Bathurst";
		numberOfCapacity = 3;
		
		ICarpark carpark = new Carpark(carparkId, numberOfCapacity, adhocTicketDAO, seasonTicketDAO);
		
		
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

}
