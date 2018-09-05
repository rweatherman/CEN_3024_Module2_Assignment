package weathermanModule01;
import java.util.Scanner;;

public final class PlaneCallButtons 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		// set system variables
		boolean isLanding = false;
		int passengerOutput;
		int count = 0;
		boolean isCalled = false;
		int callCount = 0;
		int landingOutput;
		int attendantOutput;
		
		// set number of seats on the plane
		System.out.println("How many seats are on this plane? only enter integers.");
		
		Scanner numSeatsInput = new Scanner(System.in);
		int numSeatsOutput = numSeatsInput.nextInt();
		
		// Initialize the AttendantControl
		AttendantControl [] buttons = new AttendantControl[numSeatsOutput];
				
		for(int i = 0; i < buttons.length; i++)
		{
			String seat = "Seat " + Integer.toString(i + 1);
			buttons[i] = new AttendantControl(seat);
		}
			
		// main program. Keep it running while plane is not landing
		while(!isLanding)
		{		
			// get passenger responses
			System.out.println("If you would like to call the attendant?  Type- seat number 1 - 5. Example- 5, then hit enter.");
			
			Scanner passengerInput = new Scanner(System.in);
			passengerOutput = passengerInput.nextInt();
			
			// this would be a click event on passenger pressing a call button
			callAttendant(buttons, passengerOutput - 1);
			
			// display a status board for passenger lights
			System.out.println("Passenger Call Button Status Board:");
			for(int i = 0; i < buttons.length; i++)
			{
				lightStatus(buttons, i);
			}
			
			// see if there are any outstanding calls lights
			for(int i = 0; i < buttons.length; i++)
			{
				if(buttons[i].getLit())
				{
					callCount++;
				}
			}
			
			// if there are calls prompt attendant to answer the call or clear all calls if plane is landing
			if(callCount > 0)
			{
				System.out.println("Attendant can you answer a call light? type 1 for yes and 0 for no. (Also type 1 to clear all lights)");
				Scanner attendantBusyInput = new Scanner(System.in);
				attendantOutput = attendantBusyInput.nextInt();
				
				if(attendantOutput != 0)
				{
					System.out.println("Attendant, Type seat number from the status board, or type -1 to clear all call lights if plane is landing.");
				
					Scanner attendantInput = new Scanner(System.in);
					attendantOutput = attendantInput.nextInt();
				
					attendantAnswer(buttons, attendantOutput - 1);
				}
			}
			
			// display status board again
			System.out.println("Passenger Call Button Status Board:");
			for(int i = 0; i < buttons.length; i++)
			{
				lightStatus(buttons, i);
			}
					
			// check if plane is landing
			for(int i = 0; i < buttons.length; i++)
			{
				if(buttons[i].getIsLanding())
				{
					count++;
				}
			}
			
			if(count > 0)
			{
				isLanding = true;
			}		
		}
	}
	
	public static void callAttendant(AttendantControl [] buttons, int seat)
	{	
		int passengerOutput;
		
		// this would be a click event that gets called when a passenger presses the call button
		// passes in the entire AttnedantControl and the seat that presses the button
		// if invalid response prompt passenger to enter seat num again or cancel
		try
		{
			buttons[seat].buttonPressed(true);
			buttons[seat].setLit(true);
		}
		catch(Exception ex)
		{
			System.out.println("Invalid response, type seat number again or 0 to cancel the call.");
			
			Scanner passengerInput = new Scanner(System.in);
			passengerOutput = passengerInput.nextInt();
			
			if(passengerOutput != 0)
			{
				callAttendant(buttons, passengerOutput - 1);
			}
		}		
	}
	
	public static void attendantAnswer(AttendantControl [] buttons, int seat)
	{
		// takes attendants response to a set number or takes in a cancel buttons int and clears all lights.
		// on invalid response prompt attendant to re-enter the seat number.
		try
		{
			if(seat != -2)
			{
				System.out.println(buttons[seat].acknowledgeSeatCall(true, seat));
			}
			else
			{
				for(int i = 0; i < buttons.length; i++)
				{			
					buttons[i].setIsLanding(true);
					buttons[i].clearCallLight(true);
					buttons[i].setIndicatorLight("Not Lit");
				}
			
				System.out.println("Ladies and gentlemen we are getting ready to land. All call lights will be cleared.");
			}
		}
		catch(Exception ex)
		{
			System.out.println("Invalid response.");
			attendantAnswer(buttons, seat);
		}
	}
	
	public static void lightStatus(AttendantControl [] buttons, int seat)
	{
		// displays toString() method
		System.out.println(buttons[seat].toString());
	}

}
