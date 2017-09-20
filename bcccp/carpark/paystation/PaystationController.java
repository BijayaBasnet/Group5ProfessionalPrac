package bcccp.carpark.paystation;

import bcccp.carpark.ICarpark;
import bcccp.tickets.adhoc.IAdhocTicket;
import java.util.Date;

public class PaystationController 
		implements IPaystationController {
	
	private IPaystationUI ui_;
	private ICarpark carpark_;

	private IAdhocTicket  adhocTicket_ = null;
	private float charge_;
	
	

	public PaystationController(ICarpark carpark, IPaystationUI ui) {

        this.carpark_ = carpark;
        this.ui_ = ui;

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
        adhocTicket.pay(new Date().getTime(), charge);
        ui.printTicket(adhocTicket.getCarparkId(), adhocTicket.getTicketNo(),
                       adhocTicket.getEntryDateTime(), adhocTicket.getPaidDateTime() ,
                       adhocTicket.getCharge(), adhocTicket.getBarcode()
                       );
		
	}



	@Override
	public void ticketTaken() {
		ui.display("");
		
	}

	
	
}
