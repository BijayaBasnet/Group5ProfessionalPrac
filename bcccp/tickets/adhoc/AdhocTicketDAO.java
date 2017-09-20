package bcccp.tickets.adhoc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class AdhocTicketDAO  implements IAdhocTicketDAO  {

	private IAdhocTicketFactory factory;
	private List<IAdhocTicket> currentTickets;
        private static int ticketNo = 0;

	
	
	public AdhocTicketDAO(IAdhocTicketFactory factory) {
		this.factory = factory;
                 currentTickets = new ArrayList<IAdhocTicket>();
                
	}



	@Override
	public IAdhocTicket createTicket(String carparkId) {
                int ticketNo = ThreadLocalRandom.current().nextInt(1, 10);
                IAdhocTicket record = factory.make(carparkId,ticketNo);
                currentTickets.add(record);
                return record;
                }



	@Override
	public IAdhocTicket findTicketByBarcode(String barcode) {
            
            for(IAdhocTicket currentAdhocTicket : currentTickets){
                if(barcode.equalsIgnoreCase(currentAdhocTicket.getBarcode())) {
                    return currentAdhocTicket;
                }
            }
		return null;
	}



	@Override
	public List<IAdhocTicket> getCurrentTickets() {
		
		return null;
	}

	
	
}
