package weathermanModule01;

public class PassengerButton 
{
	// declare class variables
	private boolean isLit = false;
	private String indicatorLight = "Not lit";
	private String seatNumber;
	
	// constructor
	public PassengerButton(String seat) 
	{
		super();
		this.isLit = false;
		this.seatNumber = seat;
	}

	// getters and setters
	public void setLit(boolean isLit) 
	{
		this.isLit = isLit;
		
		if(!isLit)
		{
			indicatorLight = "Not Lit";
		}
		else
		{
			indicatorLight = "Light is lit";
		}
	}
	
	public boolean getLit()
	{
		return isLit;
	}

	public String getIndicatorLight() 
	{
		return indicatorLight;
	}

	public void setIndicatorLight(String indicatorLight) 
	{
		this.indicatorLight = indicatorLight;
	}
	
	// works with toString to set indicators
	public void buttonPressed(boolean isPressed)
	{
		isLit = isPressed;
		indicatorLight = "Light is lit";
	}
	
	public void clearCallLight(boolean isCleared)
	{
		isLit = isCleared;
		indicatorLight = "Light is not lit";
	}

	// displays seat num and light status
	@Override
	public String toString() 
	{
		return "Passenger call lights [" + seatNumber + " call light = " + indicatorLight + "]";
	}
	
	

}
