package bcccp.carpark.paystation;

import bcccp.carpark.ICarpark;
import bcccp.tickets.adhoc.IAdhocTicket;

public class PaystationController 
		implements IPaystationController {
	
	private IPaystationUI ui;	
	private ICarpark carpark;

	private IAdhocTicket  adhocTicket = null;
	private float charge;
	
	

	public PaystationController(ICarpark carpark, IPaystationUI ui) {
        this.carpark = carpark;
        this.ui = ui;
        
        ui.registerController(this);
	}



	@Override
	public void ticketInserted(String barcode) {
		      adhocTicket= carpark.getAdhocTicket(barcode);
        if( adhocTicket != null) {
            if(barcode.equalsIgnoreCase(adhocTicket.getBarcode())) {
                ui.display("Pay " + carpark.calculateAddHocTicketCharge(adhocTicket.getEntryDateTime()));
            }
        } else {
            ui.display("Ticket is Invalid!");
        }
		
	}



	@Override
	public void ticketPaid() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void ticketTaken() {
		// TODO Auto-generated method stub
		
	}

	
	
}
