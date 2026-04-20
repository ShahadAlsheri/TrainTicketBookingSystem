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
