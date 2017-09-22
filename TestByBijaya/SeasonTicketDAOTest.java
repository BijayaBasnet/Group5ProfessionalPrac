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
		
		
	}

	@After
	public void tearDown() throws Exception {
		}

	@Test
	public void testRegisterSeasonTicket() {
		
	}
	
	@Test
	public void testDeregisterSeasonTicket() {
		s
	}
	
	@Test
	public void testFindSeasonTicketByID() {
		
	}
	
	@Test
	public void testRecordTicketEntry() {
		
	}

}
