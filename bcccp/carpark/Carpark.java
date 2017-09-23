package bcccp.carpark;

import java.util.List;

import bcccp.tickets.adhoc.IAdhocTicket;
import bcccp.tickets.adhoc.IAdhocTicketDAO;
import bcccp.tickets.season.ISeasonTicket;
import bcccp.tickets.season.ISeasonTicketDAO;
import java.util.ArrayList;


public class Carpark implements ICarpark {
	
	private List<ICarparkObserver> observers;
	private String carparkId;
	private int capacity;
	private int numberOfCarsParked;
	private IAdhocTicketDAO adhocTicketDAO;
	private ISeasonTicketDAO seasonTicketDAO;
	
	
	
	public Carpark(String name, int capacity, 
			IAdhocTicketDAO adhocTicketDAO, 
			ISeasonTicketDAO seasonTicketDAO) {
        this.carparkId = name;
        this.adhocTicketDAO = adhocTicketDAO;
        this.seasonTicketDAO = seasonTicketDAO;
        
        this.capacity = capacity;
        
        this.observers = new ArrayList<>();
	}



	@Override
	public void register(ICarparkObserver observer) {
		if(!observers.contains(observer)) {				
                    observers.add(observer);		
                }
		
	}



	@Override
	public void deregister(ICarparkObserver observer) {
		if(observers.contains(observer)) {				
                    observers.remove(observer);		
                }
		
	}



	@Override
	public String getName() {
		return carparkId;
	}



	@Override
	public boolean isFull() {
		if(this.capacity == this.numberOfCarsParked) {				
                return true;		
            }
		return false;
	}



	@Override
	public IAdhocTicket issueAdhocTicket() {
		return adhocTicketDAO.createTicket(carparkId)
	;
	}



	@Override
	public void recordAdhocTicketEntry() {
		 for (ICarparkObserver observer : observers ) {				
                observer.notifyCarparkEvent();				
            }
		
	}



	@Override
	public IAdhocTicket getAdhocTicket(String barcode) {
               if(adhocTicketDAO.findTicketByBarcode(barcode)!= null) {				
                return adhocTicketDAO.findTicketByBarcode(barcode);
            }		
            		
            return null;				
            
		
	}



	@Override
	public float calculateAddHocTicketCharge(long entryDateTime) {
		 return 4;
	}



	@Override
	public void recordAdhocTicketExit() {
		
		
	}



	@Override
	public void registerSeasonTicket(ISeasonTicket seasonTicket) {
		   seasonTicketDAO.registerTicket(seasonTicket);
		
	}



	@Override
	public void deregisterSeasonTicket(ISeasonTicket seasonTicket) {
		seasonTicketDAO.deregisterTicket(seasonTicket);
		
	}



	@Override
	public boolean isSeasonTicketValid(String ticketId) {
		seasonTicketDAO.findTicketById(ticketId);				
            if(seasonTicketDAO.findTicketById(ticketId)!= null) {		
                return true;		
            }		
            return false;
	}



	@Override
	public boolean isSeasonTicketInUse(String ticketId) {
		 if(seasonTicketDAO.findTicketById(ticketId).inUse()) {				
                return true;				
            }		
            return false;
		
	}



	@Override
	public void recordSeasonTicketEntry(String ticketId) {
		seasonTicketDAO.recordTicketEntry(ticketId);
		
	}



	@Override
	public void recordSeasonTicketExit(String ticketId) {
		
		
	}

	
	

}
