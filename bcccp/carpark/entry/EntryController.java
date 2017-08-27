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
    }
    
    
    
    @Override
    public void buttonPushed() {
        ui.printTicket(carpark.getName(), adhocTicket.getTicketNo(), entryTime, adhocTicket.getBarcode());
        ui.display("Ticket Issued!");
        
    }
    
    
    
    @Override
    public void ticketInserted(String barcode) {
        // TODO Auto-generated method stub
        
    }
    
    
    
    @Override
    public void ticketTaken() {
        ui.display("");
        carpark.recordAdhocTicketEntry();
        entryGate.raise();
        
    }
    
    
    
    @Override
    public void notifyCarparkEvent() {
        // TODO Auto-generated method stub
        
    }
    
    
    
    @Override
    public void carEventDetected(String detectorId, boolean detected) {
        // TODO Auto-generated method stub
        
    }
    
    
    
}
