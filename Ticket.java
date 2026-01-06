
package cpcs204_ass3;

/* 
Course : CPCS 204 
Name : Shahad Rafi Alshehri 
University ID : 2306119
Section : 03C
Name of lab instructor : Nojoud Alshehri 
Assignment number :  #3
*/
public class Ticket {
//data feild
    private Passenger passenger;
    private Train train;
//constructor   
    public Ticket(Passenger passenger, Train train){
        this.passenger = passenger;
        this.train = train;
    }
//getters
    public Passenger getPassenger(){
        return passenger;
    }
    public Train getTrain(){
        return train;
    }
//to string methed that return the informations about the ticket
    public String toString(){
        String s = "| ";
        s += String.format("%-16s", passenger.getPassengerID());
        s += "| ";
        s += String.format("%-16s", passenger.getName());
        s += "| ";
        s += String.format("%-16s", train.getTrainID());
        s += "|"; 
        return s;
    }
}
