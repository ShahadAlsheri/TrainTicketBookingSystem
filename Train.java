
public class Train {
//data feild
    private String trainID;
    private int capacity;
    private int availableSeats = capacity;
//constructor
    public Train(String trainID, int capacity){
        this.trainID = trainID;
        this.capacity = capacity;
        this.availableSeats = capacity;
    }
//getter
    public String getTrainID(){
        return trainID;
    }
//a method that return the confirming statment for booking and manipulate the number of availabelSeats 
    public String bookSeat(Passenger passenger){
        if (availableSeats > 0 ){
            availableSeats--;
            return "Booking confirmed for Passenger "+ passenger.getName() +" (ID: " +passenger.getPassengerID()+").";
        }
        else {
            return "No seats for "+ passenger.getName() +" (ID: "+ passenger.getPassengerID() +"), added to waiting list.";
        }
    }
//a method that return the confirming statment for canseling a booking and manipulate the number of availabelSeats 
    public String cancelSeat(Passenger passenger){
        availableSeats++;
        return "Booking cancelled for Passenger "+ passenger.getName() +" (ID: "+ passenger.getPassengerID() + ").";
    }
}
