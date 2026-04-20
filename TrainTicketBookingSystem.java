import java.io.*;
import java.util.*;

public class TrainTicketBookingSystem {
//data feild
    private Queue<Passenger> passengerQueue = new Queue();
    private Stack<Ticket> confirmedStack = new Stack();
    private Queue<Ticket> waitingQueue = new Queue();
    private Train train;
    private PrintWriter outputWriter;
    Passenger pass;
//constructor
    public TrainTicketBookingSystem() {
        try {
            outputWriter = new PrintWriter("output.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
// a method that add a new train 
    public void addTrain(String trainID, int capacity) {
        train = new Train(trainID, capacity);
        outputWriter.println("Train " + trainID + " with capacity " + capacity + " has been added.");
    }
// a method that add a new passenger to the passenger queue
    public void addPassenger(String passengerID, String name) {
        pass = new Passenger(passengerID, name);
        passengerQueue.enqueue(pass);
        outputWriter.println(passengerQueue.rear().data.toString());
    }
//a method to book a seat and add the ticket to the confirmed stack
    public void bookSeat(String passengerID) {
        Passenger p = findPassengerByID(passengerID);
        String book = train.bookSeat(p);
        outputWriter.println(book);
        if (book.contains("No seats for")) {
            waitingQueue.enqueue(new Ticket(findPassengerByID(passengerID), train));
        } else {
            confirmedStack.push(new Ticket(findPassengerByID(passengerID), train));
        }
    }
// a method to cancel a booking and replace i=this booking with a new booking from the waiting queue if exist
    public void cancelBooking(String passengerID) {
        removePassengerFromConfirmed(findPassengerByID(passengerID));
        String cancel = train.cancelSeat(findPassengerByID(passengerID));
        outputWriter.println(cancel);
        if (!waitingQueue.isEmpty()) {
            Ticket newBook = waitingQueue.dequeue();
            bookSeat(newBook.getPassenger().getPassengerID());
        }
    }
//a method to print all tickets in the confirmed stack
    public void showConfirmedTickets() {
        outputWriter.println("------------------CONFIRMED PASSENGER------------------\n"
                + "| Passenger ID    | Name            | Train ID        |\n"
                + "| --------------- | --------------- | --------------- |");
        Node current = confirmedStack.top();
        while (current != null) {
            outputWriter.println(current.data.toString());
            current = current.next;
        }
    }
// a method to print all tickets in the waiting queue
    public void showWaitingTickets() {
        outputWriter.println("------------------WAITING PASSENGER--------------------\n"
                + "| Passenger ID    | Name            | Train ID        |\n"
                + "| --------------- | --------------- | --------------- |");
        Node current = waitingQueue.peak();
        while (current != null) {
            outputWriter.println(current.data.toString());
            current = current.next;
        }
    }
//a method to search for a passenger by its' ID
    public Passenger findPassengerByID(String passengerID) {
        Node<Passenger> current = passengerQueue.peak();
        while (current != null) {
            Passenger passenger = current.data;
            if (passenger.getPassengerID().equals(passengerID)) {
                return passenger; // Found the passenger
            }
            current = current.next;
        }
        return null;
    }
    Stack<Ticket> temp = new Stack();
//a method that delet a passenger from the confirmed stack
    public Ticket removePassengerFromConfirmed(Passenger passenger) {
        if (!confirmedStack.isEmpty()) {
            if (confirmedStack.top().data.getPassenger() != passenger) {
                temp.push(confirmedStack.pop());
                removePassengerFromConfirmed(passenger);
                confirmedStack.push(temp.pop());
            } else {
                return confirmedStack.pop();
            }
        }
        return null;
    }
//a method that close and flust the printWriter
    public void closePrintWriter() {
        outputWriter.println();
        outputWriter.flush();
        outputWriter.close();
    }
    
// MAIN CLASS 
    public static void main(String[] args) throws Exception {
        //input file
        File input = new File("input.txt");
        //check if it exist
        if (!input.exists()) {
            System.out.print("File " + input.getName() + " does not exests");
            System.exit(0);
        }
        //scann the input file
        Scanner in = new Scanner(input);

        TrainTicketBookingSystem BookingSystem = new TrainTicketBookingSystem();
        //scanning the file and execute the commands
        while (in.hasNext()) {
            switch (in.next()) {
                case "add_train":{
                   BookingSystem.addTrain(in.next(), in.nextInt());
                   break;
                }
                case "add_passenger":{
                    BookingSystem.addPassenger(in.next(), in.next());
                    break;
                }
                case "book":{
                    BookingSystem.bookSeat(in.next());
                    in.next();
                    break;
                }
                case "cancel":{
                    BookingSystem.cancelBooking(in.next());
                    in.next();
                    break;
                }
                case "show_waiting":{
                    BookingSystem.showWaitingTickets();
                    break;
                }
                case "show_confirmed":{
                    BookingSystem.showConfirmedTickets();
                    break;
                }
            }
        }
        //close the print writer and scanner
        in.close();  
        BookingSystem.closePrintWriter();
    }

}
