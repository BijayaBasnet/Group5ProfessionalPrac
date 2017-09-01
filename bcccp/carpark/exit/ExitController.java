package bcccp.carpark.exit;

import bcccp.carpark.Carpark;
import bcccp.carpark.ICarSensor;
import bcccp.carpark.ICarSensorResponder;
import bcccp.carpark.ICarpark;
import bcccp.carpark.IGate;
import bcccp.tickets.adhoc.IAdhocTicket;

public class ExitController 
		implements ICarSensorResponder,
		           IExitController {
	
	private IGate exitGate_;
	private ICarSensor insideSensor_;
	private ICarSensor outsideSensor_; 
	private IExitUI ui_;
	
	private ICarpark carpark_;
	private IAdhocTicket  adhocTicket_ = null;
	private long exitTime_;
	private String seasonTicketId_ = null;
	
	

	public ExitController(Carpark carpark, IGate exitGate, 
			ICarSensor is,
			ICarSensor os, 
			IExitUI ui) {

		this.carpark_ = carpark;
        this.exitGate_ = exitGate;
        this.insideSensor_ = is;
       	this.outsideSensor_ = os;
        this.ui_ = ui;
                
        ui_.registerController(this);
        outsideSensor_.registerResponder(this);
	}



	@Override
	public void ticketInserted(String ticketStr) {
		if(insideSensor_.carIsDetected()) {
			if(ticketStr_.startsWith("A")) {
                    
            } else {
                if(carpark_.isSeasonTicketInUse(ticketStr)) {
                    ui_.display("Take Ticket");
                } else {
                    ui_.display("Invalid Ticket");
                }
            }
                
        }
		
	}



	@Override
	public void ticketTaken() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void carEventDetected(String detectorId, boolean detected) {
		// TODO Auto-generated method stub
		
	}

	
	
}
