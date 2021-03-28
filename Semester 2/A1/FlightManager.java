//Louis Peterson ID: 501040813
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;


public class FlightManager
{
  // Contains list of Flights departing from Toronto in a single day
	ArrayList<Flight> flights = new ArrayList<Flight>();
  
  String[] cities = 	{"Dallas", "New York", "London", "Paris", "Tokyo"};
  final int DALLAS = 0;  final int NEWYORK = 1;  final int LONDON = 2;  final int PARIS = 3; final int TOKYO = 4;
  
  // flight times in hours
  int[] flightTimes = { 3, // Dallas
  											1, // New York
  											7, // London
  											8, // Paris
  											16// Tokyo
  										};
  
  // Contains list of available airplane types and their seat capacity
  ArrayList<Aircraft> airplanes = new ArrayList<Aircraft>();  
  
  String errorMsg = null; // if a method finds an error (e.g. flight number not found) set this string. See video!
  
  Random random = new Random(); // random number generator - google "Java class Random". Use this in generateFlightNumber
  
  
  public FlightManager()
  {
  	// DO NOT ALTER THIS CODE - THE TA'S WILL USE IT TO TEST YOUR PROGRAM
  	// IN ASSIGNMENT 2 YOU WILL BE LOADING THIS INFORMATION FROM A FILE
  
  	// Create some aircraft types with max seat capacities
  	airplanes.add(new Aircraft(85, "Boeing 737"));
  	airplanes.add(new Aircraft(180,"Airbus 320"));
  	airplanes.add(new Aircraft(37, "Dash-8 100"));
  	airplanes.add(new Aircraft(12, "Bombardier 5000"));
  	airplanes.add(new Aircraft(592, 14, "Boeing 747"));
  	
  	// Populate the list of flights with some random test flights
  	String flightNum = generateFlightNumber("United Airlines");
  	Flight flight = new Flight(flightNum, "United Airlines", "Dallas", "1400", flightTimes[DALLAS], airplanes.get(0));
  	flights.add(flight);
  	flight.setStatus(Flight.Status.DELAYED);
  	
   	flightNum = generateFlightNumber("Air Canada");
   	flight = new Flight(flightNum, "Air Canada", "London", "2300", flightTimes[LONDON], airplanes.get(1));
   	flights.add(flight);
   	
   	flightNum = generateFlightNumber("Air Canada");
   	flight = new Flight(flightNum, "Air Canada", "Paris", "2200", flightTimes[PARIS], airplanes.get(1));
   	flights.add(flight);
   	
   	flightNum = generateFlightNumber("Porter Airlines");
   	flight = new Flight(flightNum, "Porter Airlines", "New York", "1200", flightTimes[NEWYORK], airplanes.get(2));
   	flights.add(flight);
   	
   	flightNum = generateFlightNumber("United Airlines");
   	flight = new Flight(flightNum, "United Airlines", "New York", "0900", flightTimes[NEWYORK], airplanes.get(3));
   	flights.add(flight);
   	flight.setStatus(Flight.Status.INFLIGHT);
   	
   	flightNum = generateFlightNumber("Air Canada");
   	flight = new Flight(flightNum, "Air Canada", "New York", "0600", flightTimes[NEWYORK], airplanes.get(2));
   	flights.add(flight);
   	flight.setStatus(Flight.Status.INFLIGHT);
   	
   	
   	flightNum = generateFlightNumber("United Airlines");
   	flight = new Flight(flightNum, "United Airlines", "Paris", "2330", flightTimes[PARIS], airplanes.get(0));
   	flights.add(flight);
   	
    /*
     * Add this code back in when you are ready to tackle class LongHaulFlight and have implemented its methods
     */
   	flightNum = generateFlightNumber("Air Canada");
   	flight = new LongHaulFlight(flightNum, "Air Canada", "Tokyo", "2200", flightTimes[TOKYO], airplanes.get(4));
   	flights.add(flight);
  }
  
  /*
   * This private helper method generates and returns a flight number string from the airline name parameter
   * For example, if parameter string airline is "Air Canada" the flight number should be "ACxxx" where xxx is 
   * a random 3 digit number between 101 and 300 (Hint: use class Random - see variable random at top of class)
   * you can assume every airline name is always 2 words. 
   * 
   */
  private String generateFlightNumber(String airline)
  {
    //Splits up the words from the airline name into a list
    String[] flightCodeCreator = airline.split(" ");
    //Gets the first letter of the first and last word to Generate flight number
    String empty = flightCodeCreator[0].substring(0, 1) + flightCodeCreator[flightCodeCreator.length - 1].substring(0, 1);
    //Produce 3 random numbers
    for(int i = 0; i < 3; i++){
      int rand = random.nextInt(10);
      empty += rand;
    }
    //return flight Number
  	return empty; 
  }

  // Prints all flights in flights array list (see class Flight toString() method) 
  // This one is done for you!
  public void printAllFlights()
  {
    //For each of the flights, print
  	for (int i = 0; i < flights.size(); i++)
  	{
  		System.out.println(flights.get(i).toString());
  	}
  }
  
  // Given a flight number (e.g. "UA220"), check to see if there are economy seats available
  // if so return true, if not return false
  public boolean seatsAvailable(String flightNum)
  {
    //for each flight in list, return true if its the correct flight with available seats
    for(int i = 0; i < flights.size(); i++){
      //if the correct flight has available seats
      if(flights.get(i).getFlightNum().equalsIgnoreCase(flightNum) && flights.get(i).seatsAvailable()){
        return true;
      }
    }
    //flight not found
    errorMsg = "Flight " + flightNum + " Not Found";
    return false;
  }
  
  
  // Given a flight number string flightNum and a seat type, reserve a seat on a flight
  // If successful, return a Reservation object
  // NOTE: seat types are not used for basic Flight objects (seats are all "Economy Seats")
  // class LongHaulFlight defines two seat types
  // I  suggest you first write this method *without* considering class LongHaulFlight 
  // once that works (test it!!), add the long haul flight code
  public Reservation reserveSeatOnFlight(String flightNum, String seatType)
  {
  	//loop through all flights
  	for(int i = 0; i < flights.size(); i++){
      //if its the correct flight
      if(flights.get(i).getFlightNum().equalsIgnoreCase(flightNum)){
        //Attempt to reserve first class if instanceof LongHaulFlight
        if(flights.get(i) instanceof LongHaulFlight && seatType == "First Class Seat"){
          Reservation reserved = new Reservation(flightNum, flights.get(i).toString() + "\t FCL");
          return reserved;
        }
        //Attempt to reserve Economy Seat
        else if(flights.get(i).reserveSeat()){
          Reservation reserved = new Reservation(flightNum, flights.get(i).toString());
          return reserved;
        }
        //if it fails return full error
        else{
          errorMsg = "Flight " + flights.get(i).getFlightNum() + " is Full";
          return null;
        }
      }
    }
    //flight not in list
    errorMsg = "Flight Not Found";
    return null;
  }
  
// Overridden to deal with passenger information
  public Reservation reserveSeatOnFlight(String flightNum, String seatType, String name, String passport)
  {
  	//loop through all flights
  	for(int i = 0; i < flights.size(); i++){
      //if its the correct flight
      if(flights.get(i).getFlightNum().equalsIgnoreCase(flightNum)){
        if(flights.get(i).reserveSeat(name, passport)){
          Reservation reserved = new Reservation(flightNum, flights.get(i).toString(), name, passport);
          return reserved;
        }
        //if it fails return full error
        else{
          errorMsg = "Flight " + flights.get(i).getFlightNum() + " is Full";
          return null;
        }
      }
    }
    //flight not in list
    errorMsg = "Flight Not Found";
    return null;
  }

  public String getErrorMessage()
  {
  	return errorMsg;
  }
  
  /*
   * Given a Reservation object, cancel the seat on the flight
   */
  public boolean cancelReservation(Reservation res)
  {
  	//Loop through flights
  	for(int i = 0; i < flights.size(); i++){
      // if it has the correct flight number
      if(res.flightNum == flights.get(i).flightNum){
        //if its first class reservation
        if(res.isFirstClass() && flights.get(i) instanceof LongHaulFlight){
          LongHaulFlight current = (LongHaulFlight) flights.get(i);
          current.cancelSeat(LongHaulFlight.firstClass);
        }
        //else its economy reservation
        else{
          flights.get(i).cancelSeat();
        }
      }
    }
    //cant find flight in list
    errorMsg = "Flight Not Found";
    return false;
  }
  
  // Sort the array list of flights by increasing departure time 
  // Essentially one line of code but you will be making use of a Comparator object below
  public void sortByDeparture()
  {
    //Sort by departure time
	  Collections.sort(flights, new DepartureTimeComparator());
  }
  // Write a simple inner class that implements the Comparator interface (NOTE: not *Comparable*)
  // This means you will be able to compare two Flight objects by departure time
  private class DepartureTimeComparator implements Comparator<Flight>
  {
    //Compare method
  	public int compare(Flight flight1,Flight flight2){
      return flight1.getDepartureTime().compareTo(flight2.getDepartureTime());
    }
  }
  //Sort the array list of flights by increasing flight duration  
  // Essentially one line of code but you will be making use of a Comparator object below
  public void sortByDuration()
  {
    //Sort by duration
	  Collections.sort(flights, new DurationComparator());
  }
  //Write a simple inner class that implements the Comparator interface (NOTE: not *Comparable*)
 // This means you will be able to compare two Flight objects by duration
  private class DurationComparator implements Comparator<Flight>
  {
    //Compare by duration
  	public int compare(Flight flight1,Flight flight2){
      return flight1.getFlightDuration() - flight2.getFlightDuration();
    }
  }
  // Prints all aircraft in airplanes array list. 
  // See class Aircraft for a print() method
  public void printAllAircraft()
  {
  	for(int i=0; i < airplanes.size(); i++){
      airplanes.get(i).print();
    }
  }
  
  // Sort the array list of Aircraft objects 
  // This is one line of code. Make sure class Aircraft implements the Comparable interface
  public void sortAircraft()
  {
  	Collections.sort(airplanes);
  }
  
}
