//Louis Peterson ID: 501040813
import java.util.ArrayList;
import java.util.Scanner;

// Flight System for one single day at YYZ (Print this in title) Departing flights!!


public class FlightReservationSystem
{
	public static void main(String[] args)
	{
		// Create a FlightManager object
		FlightManager manager = new FlightManager();

		// List of reservations that have been made
		ArrayList<Reservation> myReservations = new ArrayList<Reservation>();	// my flight reservations

		Scanner scanner = new Scanner(System.in);
		System.out.print(">");

		while (scanner.hasNextLine())
		{
			String inputLine = scanner.nextLine();
			if (inputLine == null || inputLine.equals("")) continue;

			// The command line is a scanner that scans the inputLine string
			// For example: list AC201
			Scanner commandLine = new Scanner(inputLine);
			
			// The action string is the command to be performed (e.g. list, cancel etc)
			String action = commandLine.next();

			if (action == null || action.equals("")) continue;

			if (action.equalsIgnoreCase("Q") || action.equalsIgnoreCase("QUIT"))
				return;
			
			// List all flightsvff
			else if (action.equalsIgnoreCase("LIST"))
			{
				manager.printAllFlights(); 
			}
			//print list of passengers on a flight given a flight number
			else if (action.equalsIgnoreCase("PSNGRS")){
				if(commandLine.hasNext()){
					action = commandLine.next();
					for(int i = 0; i < manager.flights.size(); i++){
						if(manager.flights.get(i).flightNum.equalsIgnoreCase(action)){
							for(int j = 0; j < manager.flights.get(i).passengerList.size(); j++){
								manager.flights.get(i).passengerList.get(j).print();
							}
							break;
						}
					}
				}
			}
			// Reserve a flight based on Flight number string (example input: res AC220)
			else if (action.equalsIgnoreCase("RES"))
			{
				// Get the flight number string from the commndLine scanner (use hasNext() to check if there is a
				// flight number string entered
				if(commandLine.hasNext()){
					action = commandLine.next();
					Reservation current = manager.reserveSeatOnFlight(action, "Economy Seat");
					if(current == null){
						System.out.println(action + " " + manager.getErrorMessage());
					}
					else{
						myReservations.add(current);
						current.print();
					}
				}
				// call reserveSeatOnFlight() method in manager passing in the flight number string
				// A reference to a Reservation object is returned. Check to make sure it is not == null
				// If it is null, then call manager.getErrorMessage() and print the message
				// If it is not null, add the reservation to the myReservations array list and print the reservation (see class Reservation)
				
			}
		  // Reserve a first class seat on a flight based on Flight number string (example input: res AC220)
			else if (action.equalsIgnoreCase("RESFCL"))
			{
				if(commandLine.hasNext()){
					action = commandLine.next();
					Reservation current = manager.reserveSeatOnFlight(action, "First Class Seat");
					if(current == null){
						System.out.println(manager.getErrorMessage());
					}
					else{
						myReservations.add(current);
						current.print();
					}
				}
			}
			//Reservation including passenger details, name and passport
			else if (action.equalsIgnoreCase("RESPSNGR")){
				if(commandLine.hasNext()){
					action = commandLine.next();
					//reservation with name and passport
					Reservation current = manager.reserveSeatOnFlight(action, "First Class Seat", commandLine.next(), commandLine.next());
					if(current == null){
						System.out.println(manager.getErrorMessage());
					}
					else{
						myReservations.add(current);
						current.print();
					}
				}
			}
			// Query the flight manager to see if seats are still available for a specific flight (example input: seats AC220)
		  // This one is done for you as a guide for other commands
			else if (action.equalsIgnoreCase("SEATS"))
			{
				String flightNum = null;

				if (commandLine.hasNext())
				{
					flightNum = commandLine.next();

					if (manager.seatsAvailable(flightNum))
					{
						System.out.println("Seats are available");
					}
					else
					{
						System.out.println(manager.getErrorMessage());
					}
				}
			}
			// Cancel an existing reservation (example input: cancel AC220) 
			else if (action.equalsIgnoreCase("CANCEL"))
			{
        // get the flight number string from commandLine scanner (check if there is input first)
				// Use the flight number to find the Reservation object in the myReservations array list
				// If the reservation is found,  
				// 		call cancelReservation() method in the flight manager
				//    remove the reservation from myReservations
				// If the reservation is not found, print a message (see video)
				if(commandLine.hasNext()){
					action = commandLine.next();
					for(int i = 0; i < myReservations.size(); i++){
						if(myReservations.get(i).getFlightNum().equalsIgnoreCase(action)){
							manager.cancelReservation(myReservations.get(i));
							myReservations.remove(i);
						}
					}
				}

			}
			//Cancel based on Flightnum and passenger Details
			else if (action.equalsIgnoreCase("CNCLPSNGR")){
				//get flight num
				action = commandLine.next();
				//reservation loop
				for(int i = 0; i < myReservations.size(); i++){
					//if the flight number is correct, and passenger exists cancel the reservation
					if(myReservations.get(i).getFlightNum().equalsIgnoreCase(action)){
						//loop through flights
						for(int j = 0; j < manager.flights.size(); j++){
							//if correct flight number
							if(manager.flights.get(j).getFlightNum().equalsIgnoreCase(action)){
								//Cancel Seat using name and passport entered
								manager.flights.get(j).cancelSeat(commandLine.next(), commandLine.next());
								myReservations.remove(i);
							}
						}
					}
				}
			}
      // Print all the reservations in array list myReservations
			else if (action.equalsIgnoreCase("MYRES"))
			{
				for (int i = 0; i < myReservations.size(); i++){
					myReservations.get(i).print();
				}
			}
			// Print the list of aircraft (see class Manager)
			else if (action.equalsIgnoreCase("CRAFT"))
		  {
			  manager.printAllAircraft();
			}
			// These commands can be left until we study Java interfaces
			// Feel free to implement the code in class Manager if you already understand interface Comparable
			// and interface Comparator
			else if (action.equalsIgnoreCase("SORTCRAFT"))
		  {
		  	manager.sortAircraft();
		  }
		  else if (action.equalsIgnoreCase("SORTBYDEP"))
		  {
			  manager.sortByDeparture();
			  
		  }
		  else if (action.equalsIgnoreCase("SORTBYDUR"))
		  {
			  manager.sortByDuration();
		  }
	  
			System.out.print("\n>");
		}
	}

	
}

