//Louis Peterson ID: 501040813
/*
 * A simple class to model an electronic airline flight reservation
 * 
 * This class has been done for you
 */
public class Reservation
{
	String flightNum;
	String flightInfo;
	String passengerName = null;
	String passportNumber = null;
	boolean firstClass;
	
	
	public Reservation(String flightNum, String info)
	{
		this.flightNum = flightNum;
		this.flightInfo = info;
		this.firstClass = false;
	}

	//override for passenger info
	public Reservation(String flightNum, String info, String passengerName, String passportNumber)
	{
		this.flightNum = flightNum;
		this.flightInfo = info;
		this.passengerName = passengerName;
		this.passportNumber = passportNumber;
		this.firstClass = false;
	}
	
	public boolean isFirstClass()
	{
		return firstClass;
	}

	public void setFirstClass()
	{
		this.firstClass = true;
	}

	public String getFlightNum()
	{
		return flightNum;
	}
	
	public String getFlightInfo()
	{
		return flightInfo;
	}

	public void setFlightInfo(String flightInfo)
	{
		this.flightInfo = flightInfo;
	}

	public String getName(){
		return passengerName;
	}

	public void setName(String name){
		this.passengerName = name;
	}

	public String getPassport(){
		return passportNumber;
	}

	public void setPassport(String passport){
		this.passportNumber = passport;
	}

	public void print()
	{
		System.out.println(flightInfo);
	}
}
