package testcases;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses ({
	AdhocTicketDAOTest.class,
	EntryControllerTest.class,
	ExitControllerTest.class,
	SeasonTicketTest.class,
	CarparkTest.class,
	AdhocTicketTest.class,
	PayStationControllerTest.class,
	AdhocFactoryTicketTest.class,
	UsageRecordTest.class
})

public class TestSuite {

}
