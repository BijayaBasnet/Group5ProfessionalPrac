package bcccp.tickets.adhoc;

import java.util.Calendar;
import java.util.Date;

public class AdhocTicket implements IAdhocTicket {
	
	private String carparkId;
	private int ticketNo;
	private long entryDateTime;
	private long paidDateTime;
	private long exitDateTime;
	private float charge;
	private String barcode;

	
	
	public AdhocTicket(String carparkId, int ticketNo, String barcode) {
		this.carparkId = carparkId;
                this.ticketNo = ticketNo;
                this.barcode = barcode;
                
               entryDateTime = new Date().getTime();
	}


	@Override
	public int getTicketNo() {
            return this.ticketNo;
	}


	@Override
	public String getBarcode() {
            return this.barcode;
	}


	@Override
	public String getCarparkId() {
            return this.carparkId;
	}


	@Override
	public void enter(long dateTime) {
		
	}


	@Override
	public long getEntryDateTime() {
            return entryDateTime;
	}


	@Override
	public boolean isCurrent() {
		return false;
	}


	@Override
	public void pay(long dateTime, float charge) {
            this.paidDateTime = dateTime;
            this.charge = charge;
            
		
	}


	@Override
	public long getPaidDateTime() {
            return this.paidDateTime;
	}


	@Override
	public boolean isPaid() {
		return false;
	}


	@Override
	public float getCharge() {
             Calendar cal = Calendar.getInstance();
             cal.setTime(new Date());
             int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
             switch(dayOfWeek) { 
             case 1: 
                return 4;
             case 2: case 3: case 4: case 5: case 6:
                return 8;
             case 7:
                 return 4;

              
             }
             
             return 0;
	}


	@Override
	public void exit(long dateTime) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public long getExitDateTime() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public boolean hasExited() {
                
		return false;
	}

	
	
}
