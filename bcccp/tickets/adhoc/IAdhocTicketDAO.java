package bcccp.tickets.adhoc;
//importing List package
import java.util.List;

public interface IAdhocTicketDAO {
	
	public IAdhocTicket createTicket(String carparkId);
	public IAdhocTicket findTicketByBarcode(String barcode);
	public List<IAdhocTicket> getCurrentTickets();


}
