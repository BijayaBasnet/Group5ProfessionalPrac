package bcccp.tickets.season;

public interface IUsageRecord {
	
	public String getSeasonTicketId();
	public void finalise(long endDateTime);
	public long getStartTime();
	public long getEndTime();

}
