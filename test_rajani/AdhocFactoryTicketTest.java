package testcases;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bcccp.tickets.adhoc.AdhocTicketFactory;
import bcccp.tickets.adhoc.IAdhocTicket;

public class AdhocFactoryTicketTest {

	String carparkID;
	int ticketNo;
	String barcode;
	IAdhocTicket adhocTicket;

	@Before
	public void setUp() throws Exception {
		carparkID = "Bathurst Chase";
		ticketNo = 1;
		barcode = "A" + ticketNo;
		adhocTicket = new AdhocTicketFactory().make(carparkID, ticketNo);
	}

	@After
	public void tearDown() throws Exception {
		adhocTicket = new;
	}

	@Test
	public void testInit() {
		assertTrue(adhocTicket instanceof IAdhocTicket);
		assertEquals(adhocTicket.getCarparkId(), carparkID);
		assertEquals(adhocTicket.getTicketNo(), ticketNo);
		assertEquals(adhocTicket.getBarcode(), barcode);
	}

}
