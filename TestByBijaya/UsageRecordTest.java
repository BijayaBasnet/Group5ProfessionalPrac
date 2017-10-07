package testcases;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import bcccp.tickets.season.UsageRecord;

public class UsageRecordTest {
	UsageRecord usageRecord;
	String ticketId;
	long startDateTime;

	
	@Before
	public void setUp() throws Exception {	
		ticketId = "1";
		startDateTime = new Date().getTime();
		usageRecord = new UsageRecord(ticketId, startDateTime);
	}

	@After
	public void tearDown() throws Exception {
				usageRecord = null;
			}

	@Test
	public void test() {
	assertEquals(usageRecord.getSeasonTicketId(), ticketId);		
	assertEquals(usageRecord.getStartTime(), startDateTime);
	}

}
