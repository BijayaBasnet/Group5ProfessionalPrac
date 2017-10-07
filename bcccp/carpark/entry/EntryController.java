package bcccp.carpark.entry;

import bcccp.carpark.Carpark;
import bcccp.carpark.ICarSensor;
import bcccp.carpark.ICarSensorResponder;
import bcccp.carpark.ICarpark;
import bcccp.carpark.ICarparkObserver;
import bcccp.carpark.IGate;
import bcccp.tickets.adhoc.IAdhocTicket;

public class EntryController 
		implements ICarSensorResponder,
				   ICarparkObserver,
		           IEntryController {
	
	private IGate entryGate;
	private ICarSensor outsideSensor; 
	private ICarSensor insideSensor;
	private IEntryUI ui;
	
	private ICarpark carpark;
	private IAdhocTicket  adhocTicket = null;
	private long entryTime;
	private String seasonTicketId = null;
	
	

	public EntryController(Carpark carpark, IGate entryGate, 
			ICarSensor os, 
			ICarSensor is,
			IEntryUI ui) {
		this.ui = ui;
                this.entryGate = entryGate;
                this.insideSensor = is;
                this.outsideSensor = os;
                
                this.outsideSensor.registerResponder(this);
                this.insideSensor.registerResponder(this);
                
                ui.registerController(this);
                this.carpark = carpark;
                
                this.adhocTicket = carpark.issueAdhocTicket();
                entryTime = adhocTicket.getEntryDateTime();
                
                this.seasonTicketId = null;
                
                
	}



	@Override
	public void buttonPushed() {
            if(outsideSensor.carIsDetected()) {
		ui.printTicket(carpark.getName(), adhocTicket.getTicketNo(), entryTime, adhocTicket.getBarcode());
                ui.display("Take Ticket!");
            } 
	}



	@Override
	public void ticketInserted(String barcode) {
            if(outsideSensor.carIsDetected()) {
                if(carpark.isSeasonTicketValid(barcode)) {
                    if(carpark.isSeasonTicketInUse(barcode)) {
                        ui.display("Ticket Used!");
                    } else {
                        carpark.recordSeasonTicketEntry(barcode);
                        ui.display("");
                        ui.printTicket(carpark.getName(), 0, entryTime, barcode);
                    }
                } else {
                    ui.display("Ticket is Invalid!");
                }
                
            }
		
	}



	@Override
	public void ticketTaken() {
            ui.display("");
            carpark.recordAdhocTicketEntry();
            entryGate.raise();
		
	}



	@Override
	public void notifyCarparkEvent() {
            entryGate.lower();
	}



	@Override
	public void carEventDetected(String detectorId, boolean detected) {
            if(detectorId.equals(("Entry Outside Sensor"))) {
               if(outsideSensor.carIsDetected()) { 
                    ui.display("Push Button....");
               } else {
                   ui.display("Idle");
               }
                
            } else {
                if(insideSensor.carIsDetected()) {
                ui.display("Entering.....");
                } else {
                    ui.display("");
                    entryGate.lower();
                }
                
            }
            
		
	}

	
	
}
