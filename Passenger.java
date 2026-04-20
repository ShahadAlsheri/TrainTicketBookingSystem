public class Passenger {
//data feild
    private String passengerID;
    private String name;
//constructor     
    public Passenger(String passengerID, String name){
        this.passengerID = passengerID;
        this.name = name;
    }
//getters    
    public String getPassengerID(){
        return passengerID;
    }
    public String getName(){
        return name;
    }
//to string methed that return the informations about the passenger information
    public String toString(){
        return "Passenger "+ name +" (ID: "+ passengerID +") has been added to the system.";
    }
    
}
