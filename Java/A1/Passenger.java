//Louis Peterson ID: 501040813
public class Passenger {
    String name;
    String passportNumber;
    int seatNumber;


    public Passenger(String name, String passportNumber, int seatNumber) {
        this.name = name;
        this.passportNumber = passportNumber;
        this.seatNumber = seatNumber;
    }

    public String getName(){
        return name;
    }

    public String getPassportNumber(){
        return passportNumber;
    }

    public int getSeatNumber(){
        return seatNumber;
    }

    public void print(){
        System.out.println("Name: " + name + "\t Passport #: " + passportNumber + "\t Seat #: " + seatNumber);
    }

    public boolean equals(Passenger other) {
        if(this.name == other.name && this.passportNumber == other.passportNumber){
            return true;
        }
        return false;
    }
}
