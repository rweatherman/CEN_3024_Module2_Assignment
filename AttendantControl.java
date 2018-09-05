package weathermanModule01;

public class AttendantControl extends PassengerButton
{
	//declare class variables
	private boolean isLanding;
	
	// constructor
	public AttendantControl(String seat) 
	{
		super(seat);
		isLanding = false;
	}
	
	// getters and setters
	public void setIsLanding(boolean isLanding) 
	{
		this.isLanding = isLanding;
	}

	public boolean getIsLanding() 
	{
		return isLanding;
	}

	// returns a string response to an answer to a call button acknowledgement
	public String acknowledgeSeatCall(boolean isAcknowledged, int seatNumber)
	{
		String response = "";
		String seat = Integer.toString(seatNumber + 1);
		
		if(isAcknowledged)
		{
			response = "Attendant says: Seat " + seat + " I'm comming.";
			this.setLit(!isAcknowledged);
		}
		else
		{
			response = "Attendant says: Seat " + seat + " I'm busy and will be there when I can.";
			this.setLit(!isAcknowledged);
		}
		
		return response;
	}
	
}
