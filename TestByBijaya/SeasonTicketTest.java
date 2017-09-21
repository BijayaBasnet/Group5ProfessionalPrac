package testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bcccp.tickets.season.ISeasonTicket;
import bcccp.tickets.season.SeasonTicket;

public class SeasonTicketTest {
	ISeasonTicket seasonTicket;
	String ticketId;
    	String carparkId;
    	long startValidPeriod;
    	long endValidPeriod; 
  @Before
	public void setUp() throws Exception {
		ticketId = "S1111";
	    	carparkId = "Bathurst Chase";
    }
  @After
	public void tearDown() throws Exception {
		
	}
  
	@Test
	public void testInit() {
    	}

}
