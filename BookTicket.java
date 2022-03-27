package com.flightTicket;

import java.util.*;

public class BookTicket {
	
	public static void book(Flight currentFlight, int tickets, int passengerID) {
		String passengerDetail = "" ;
		//create detail about the passenger with the ID
		passengerDetail = "Passenger ID "+ passengerID + "--> " +
		" Number of tickets booked "+ tickets + "-->" + "Total cost = " + currentFlight.price*tickets;
		
		//add passenger details to flight object
		currentFlight.addPassengerDetails(passengerDetail, tickets,passengerID);
		
		currentFlight.flightSummary();
		currentFlight.printDetails();
		
	}
	
	public static void cancel(Flight currentFlight, int passengerID) {
		currentFlight.cancelTicket(passengerID);
		currentFlight.flightSummary();
		//currentFlight.printDetails(); 
	}
	
	public static void print(Flight f) {
		f.printDetails();
	}
	
	public static void main(String[] args) {
		
		//creating 2 flights as of now
		ArrayList<Flight> flights = new ArrayList<Flight>();
		
		for(int i=0;i<2;i++) {
			flights.add(new Flight());
		}
		
		//unique ID for each passenger during every booking
		int passengerID = 1;
		
		while(true) {
			System.out.println("\n---Welcome to Flight ticket booking---");
			System.out.println("\n1.Book Ticket\n2.Cancel Ticket\n3.Print Details\n4.Exit");
			System.out.print("\nEnter your choice: ");
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			
			
			switch(choice) {
				case 1:
				{
					System.out.print("Enter Flight ID: ");
					int fid = sc.nextInt();
					
					//check for valid id
					
					if(fid>flights.size()) {
						System.out.println("Invalid Flight ID!!");
						break;
					}
					//finding the corresponding flight
					Flight currentFlight = null;
					for(Flight f : flights) {
						if(f.flightID == fid) {
							currentFlight = f;
							f.flightSummary();
							break;
						}
					}
					
					System.out.print("Enter the number of tickets needed: " );
					int t = sc.nextInt();
					//check for ticket availability
					if(t>currentFlight.tickets) {
						System.out.println(t+" tickets not available!!");
						System.out.println("Tickets available = "+currentFlight.tickets);
						break;
					}
					
					//calling book ticket method
					book(currentFlight,t,passengerID);
					
					//incrementing passenger id so that next passenger will have unique one
					
					passengerID = passengerID+1;
					break;
					
				}
				
				case 2:
				{
					System.out.print("Enter flight ID and passenger ID to cancel: ");
					int fid = sc.nextInt();
					
					if(fid>flights.size()) {
						System.out.println("Invalid Flight ID");
						break;
					}
					//finding the corresponding flight
					
					Flight currentFlight = null;
					
					for(Flight f : flights) {
						if(f.flightID==fid) {
							currentFlight = f;
							break;
						}
					}
					
					//getting passenger ID
					int id = sc.nextInt();
					
					//calling the cancel method
					cancel(currentFlight, id);
					break;
					
				}
				//printing details
				case 3:
				{
					for(Flight f:flights) {
						if(f.passengerDetails.size()==0) {
							System.out.println("No tickets booked on Flight "+f.flightID);
						}
						else {
							print(f);
						}
					}
					break;
				}
				
				case 4:
					System.out.println("You have choosen to exit!");
					return;
				
				default:
					System.out.println("Invalid choice!! Please select a valid choice!");
					break;
				
			}
			
		}
		
	}
}
