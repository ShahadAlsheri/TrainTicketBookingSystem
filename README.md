# Train Ticket Booking System (CPCS204 - Programming 3)

## Project Overview
This is a Train Ticket Booking System implemented in Java.  
It manages trains, passengers, bookings, cancellations, and waiting lists.  
The system uses custom Queue and Stack data structures to handle confirmed and waiting tickets.

## Features
- Add new trains with a specified capacity
- Add new passengers
- Book seats for passengers
- Cancel bookings and automatically assign waiting passengers
- Maintain a waiting list for passengers if no seats are available
- Show all confirmed tickets
- Show all waiting tickets

## Files
- `TrainTicketBookingSystem.java` – Main system managing trains, passengers, bookings, and I/O  
- `Passenger.java` – Represents a passenger with ID and name  
- `Train.java` – Represents a train and handles seat booking and cancellation  
- `Ticket.java` – Represents a booking for a passenger on a train  
- `Node.java` – Generic linked list node  
- `Queue.java` – Generic queue implementation  
- `Stack.java` – Generic stack implementation  
- `input.txt` – Input file with commands  
- `output.txt` – Output file with results  

## Topics Covered
- Object-Oriented Programming (OOP)
- Generic classes
- Linked lists, Stack, and Queue data structures
- File I/O (`Scanner`, `PrintWriter`)
- Recursion (used in some helper methods)
- Control structures (`if`, `switch`, `for`, `while`)
## Notes
- Input commands are read from `input.txt`.  
- Output is written to `output.txt`.  
- No external libraries are required.  
- This is an academic project for CPCS204.
