//Louis Peterson ID: 501040813
import java.util.ArrayList;
/* 
 *  Class to model an airline flight. In this simple system, all flights originate from Toronto
 *  
 *  This class models a simple flight that has only economy seats
 */
public class Flight
{
	public enum Status {DELAYED, ONTIME, ARRIVED, INFLIGHT};

	String flightNum;
	String airline;
	String origin, dest;
	String departureTime;
	Status status; // see enum Status above. google this to see how to use it
	int flightDuration;
	Aircraft aircraft;
	protected int passengers; // count of (economy) passengers on this flight - initially 0
	ArrayList<Passenger> passengerList = new ArrayList<Passenger>();
	ArrayList<Integer> availableSeats = new ArrayList<Integer>();
  
	public Flight()
	{
		// write code to initialize instance variables to default values
	}
	
	public Flight(String flightNum, String airline, String dest, String departure, int flightDuration, Aircraft aircraft)
	{
		this.flightNum = flightNum;
		this.airline = airline;
		this.dest = dest;
		this.origin = "Toronto";
		this.departureTime = departure;
		this.flightDuration = flightDuration;
		this.aircraft = aircraft;
		passengers = 0;
		status = Status.ONTIME;
		for(int i=0; i < aircraft.getNumSeats(); i++){
			availableSeats.add(i+1);
		}
	}
	public String getFlightNum()
	{
		return flightNum;
	}
	public void setFlightNum(String flightNum)
	{
		this.flightNum = flightNum;
	}
	public String getAirline()
	{
		return airline;
	}
	public void setAirline(String airline)
	{
		this.airline = airline;
	}
	public String getOrigin()
	{
		return origin;
	}
	public void setOrigin(String origin)
	{
		this.origin = origin;
	}
	public String getDest()
	{
		return dest;
	}
	public void setDest(String dest)
	{
		this.dest = dest;
	}
	public String getDepartureTime()
	{
		return departureTime;
	}
	public void setDepartureTime(String departureTime)
	{
		this.departureTime = departureTime;
	}
	
	public Status getStatus()
	{
		return status;
	}
	public void setStatus(Status status)
	{
		this.status = status;
	}
	public int getFlightDuration()
	{
		return flightDuration;
	}
	public void setFlightDuration(int dur)
	{
		this.flightDuration = dur;
	}
	
	public int getPassengers()
	{
		return passengers;
	}
	public void setPassengers(int passengers)
	{
		this.passengers = passengers;
	}
	
	// Check to see if there is room on this flight - compare current passenger count
	// with aircraft max capacity of economy seats
	public boolean seatsAvailable()
	{
		//if less than # of econ seats, return true
		if(passengers < aircraft.numEconomySeats){
			return true;
		}
		else{
			return false;
		}
	}
	
	/*
	 * Cancel a seat - essentially reduce the passenger count by 1. Make sure the count does not
	 * fall below 0 (see instance variable passenger)
	 */
	public void cancelSeat()
	{
		//if passengers > 0, subtract
		if(passengers > 0){
			passengers--;
		}
	}
	/*
	 * reserve a seat on this flight - essentially increases the passenger count by 1 only if there is room for more
	 * economy passengers on the aircraft used for this flight (see instance variables above)
	 */
	public void cancelSeat(String name, String passportNumber)
	{
		//If flight isn't empty
		if(passengers > 0)
			//search passengers for this info
			for (int i = 0; i < passengerList.size(); i++){
				//if name and passport are the same
				if(passengerList.get(i).getName().equalsIgnoreCase(name) && passengerList.get(i).getPassportNumber().equalsIgnoreCase(passportNumber)){
					//re-add the passengers seat to open seats
					availableSeats.add(0, passengerList.get(i).getSeatNumber());
					//remove the passenger
					passengerList.remove(i);
					passengers--;
				}
			}
		}
	/*
	 * reserve a seat on this flight - essentially increases the passenger count by 1 only if there is room for more
	 * economy passengers on the aircraft used for this flight (see instance variables above)
	 */
	public boolean reserveSeat()
	{
		//If flight isn't full, add passenger and return true
		if(passengers < aircraft.numEconomySeats){
			passengers++;
			return true;
		}
		return false;
	}

	/*
	 * reserve a seat on this flight(using passenger info) - essentially increases the passenger count by 1 only if there is room for more
	 * economy passengers on the aircraft used for this flight (see instance variables above)
	 */
	public boolean reserveSeat(String name, String passportNumber)
	{
		//If flight isn't full, add passenger and return true
		if(passengers < aircraft.numEconomySeats){
			//check if passenger already exists
			for (int i = 0; i < passengerList.size(); i++){
				//Cant double book
				if(passengerList.get(i).getName() == name && passengerList.get(i).getPassportNumber() == passportNumber){
					return false;
				}
			}
			//create a new passenger with the most immediate seat and add to list
			Passenger flier = new Passenger(name, passportNumber, availableSeats.get(0));
			passengerList.add(flier);
			//remove seat number from Array List
			availableSeats.remove(0);
			passengers++;
			return true;
		}
		return false;
	}
	
	public String toString()
	{
		 return airline + "\t Flight:  " + flightNum + "\t Dest: " + dest + "\t Departing: " + departureTime + "\t Duration: " + flightDuration + "\t Status: " + status;
		
	}

  
}
