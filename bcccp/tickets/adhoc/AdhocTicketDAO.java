package bcccp.tickets.adhoc;
//imporing ArrayList,List from package
import java.util.ArrayList;
import java.util.List;

public class AdhocTicketDAO  implements IAdhocTicketDAO  {

	private IAdhocTicketFactory factory;
	private List<IAdhocTicket> currentTicketNo;
        private static int ticketNo = 0;

	
	
	public AdhocTicketDAO(IAdhocTicketFactory factory) {
		this.factory = factory;
                 currentTicketNo = new ArrayList<IAdhocTicket>();
                
	}



	@Override
	public IAdhocTicket createTicket(String carparkId) {
		return factory.make(carparkId,1);
                  
                
                
	}



	@Override
	public IAdhocTicket findTicketByBarcode(String barcode) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<IAdhocTicket> getCurrentTickets() {
		
		return null;
	}

	
	
}
