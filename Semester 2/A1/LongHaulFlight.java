//Louis Peterson ID: 501040813
/*
 * A long haul flight is a flight that travels thousands of kilometers and typically has separate seating areas 
 */

public class LongHaulFlight extends Flight
{
	int numFirstClassPassengers;
	String seatType;
	
	// Possible seat types
	public static final String firstClass = "First Class Seat";
	public static final String economy = "Economy Seat";  
	

	public LongHaulFlight(String flightNum, String airline, String dest, String departure, int flightDuration, Aircraft aircraft)
	{
		super(flightNum, airline, dest, departure, flightDuration, aircraft);
	}

	public LongHaulFlight()
	{
     // default constructor
	}
	
	/*
	 * Reserves a seat on a flight. Essentially just increases the number of (economy) passengers
	 */
	public boolean reserveSeat()
	{
		//reserve Economy
		reserveSeat(economy);
		return true;
	}

	/*
	 * Reserves a seat on a flight. Essentially just increases the number of passengers, depending on seat type (economy or first class)
	 */
	public boolean reserveSeat(String seatType)
	{
		//if reserving an economy seat with open seats
		if (seatType == economy && passengers < aircraft.numEconomySeats){
			return super.reserveSeat();
		}
		//if reserving first class with open seats
		else if (seatType == firstClass && numFirstClassPassengers < numFirstClassPassengers){
			numFirstClassPassengers++;
			return true;
		}
		//otherwise return false
		else{
			return false;
		}
	}
	
	// Cancel a seat 
	public void cancelSeat()
	{
	  // override the inherited cancelSeat method and call the cancelSeat method below with an economy seatType
		// use the constants defined at the top
		cancelSeat(economy);
	}
	
	public void cancelSeat(String seatType)
	{
		//if its first class and has people in first class
		if(seatType == firstClass && numFirstClassPassengers > 0){
			numFirstClassPassengers--;
		}
		//removes economy seats
		else if(seatType == economy && super.passengers > 0){
			super.passengers--;
		}
		
	}
	// return the total passenger count of economy passengers *and* first class passengers
	// use instance variable at top and inherited method that returns economy passenger count
	public int getPassengerCount()
	{
		//total passenger count
		return numFirstClassPassengers + super.getPassengers();
	}

	public String toString()
	{
		return airline + "\t Flight:  " + flightNum + "\t Dest: " + dest + "\t Departing: " + departureTime + "\t Duration: " + flightDuration + "\t Status: " + status + "\t LongHaul";
	}
}
