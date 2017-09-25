package testcases;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;

import org.mockito.Mock;
import org.mockito.Mockito;

import bcccp.tickets.adhoc.AdhocTicket;
import bcccp.tickets.adhoc.AdhocTicketDAO;
import bcccp.tickets.adhoc.AdhocTicketFactory;
import bcccp.tickets.adhoc.IAdhocTicket;
import bcccp.tickets.adhoc.IAdhocTicketDAO;
import bcccp.tickets.adhoc.IAdhocTicketFactory;

public class AdhocTicketDAOTest {
	
	@Mock
	IAdhocTicketFactory adhocTicketFactory;
	
	
	IAdhocTicketDAO adhocTicketDAO;
	IAdhocTicket adhocTicket;
	
	
	

	@Before
	public void setUp() throws Exception {
		adhocTicketFactory = Mockito.mock(AdhocTicketFactory.class);
		Mockito.when(adhocTicketFactory.make(anyString(),anyInt())).thenReturn(
				new AdhocTicket("Bathurst", 1, "A1"));
		
		adhocTicketDAO = new AdhocTicketDAO(adhocTicketFactory);
		adhocTicket = adhocTicketDAO.createTicket("Bathurst");
		
	}

	@After
	public void tearDown() throws Exception {
		adhocTicketDAO = null;
		adhocTicket = null;
	}

	@Test
	public void testInit() {
	
		assertTrue(adhocTicket instanceof IAdhocTicket);
		assertEquals(adhocTicketDAO.createTicket("Bathurst").getCarparkId(), "Bathurst");
		
	}
	@Test
	public void testFindAdhocTicket() {
		
		assertEquals(adhocTicketDAO.findTicketByBarcode("A1"), adhocTicket);
	}