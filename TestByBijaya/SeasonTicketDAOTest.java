package testcases;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;

import java.util.Date;

import bcccp.tickets.season.ISeasonTicket;
import bcccp.tickets.season.ISeasonTicketDAO;
import bcccp.tickets.season.IUsageRecord;
import bcccp.tickets.season.IUsageRecordFactory;
import bcccp.tickets.season.SeasonTicket;
import bcccp.tickets.season.SeasonTicketDAO;
import bcccp.tickets.season.UsageRecord;
import bcccp.tickets.season.UsageRecordFactory;

public class SeasonTicketDAOTest {
	
	IUsageRecordFactory usageFactory;
	ISeasonTicketDAO seasonTicketDAO;
	ISeasonTicket seasonTicket;
	long currentTime;

	@Before
	public void setUp() throws Exception {
	currentTime = new Date().getTime();
	usageFactory = Mockito.mock(UsageRecordFactory.class);
	Mockito.when(usageFactory.make(anyString(), anyLong())).thenReturn(new UsageRecord("1", currentTime));
	seasonTicketDAO = new SeasonTicketDAO(usageFactory);
	seasonTicket = new SeasonTicket("1","S1111", new Date().getTime(), new Date().getTime()+ 300000 );
	seasonTicketDAO.registerTicket(seasonTicket);

		
	}

	@After
	public void tearDown() throws Exception {
		usageFactory = null;
		seasonTicketDAO = null;
		}

	@Test
	public void testRegisterSeasonTicket() {
	assertEquals(seasonTicketDAO.getNumberOfTickets(), 1);	
	}
	
	@Test
	public void testDeregisterSeasonTicket() {
		seasonTicketDAO.deregisterTicket(seasonTicket);
		assertEquals(seasonTicketDAO.getNumberOfTickets(), 0);

	}
	
	@Test
	public void testFindSeasonTicketByID() {
		
	}
	
	@Test
	public void testRecordTicketEntry() {
		
	}

}
