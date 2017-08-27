package bcccp.tickets.adhoc;

public class AdhocTicketFactory implements IAdhocTicketFactory {

	@Override
	public IAdhocTicket make(String carparkId, int ticketNo) {
		return new AdhocTicket(carparkId, ticketNo, carparkId);
	}


}
