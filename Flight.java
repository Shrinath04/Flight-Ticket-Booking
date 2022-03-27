package com.flightTicket;
import java.util.*;
public class Flight {
	//id for each flight
	static int id=0;
	int flightID; 
	//tickets available currently in flight.
	int tickets;
	//current ticket price.
	int price;
	//Array list for passenger details.
	ArrayList<String> passengerDetails;
	//Array list for passenger ID's.
	ArrayList<Integer> passengerIDs;
	//Array list for no.of.tickets booked by each passenger
	ArrayList<Integer> bookedTicketsPerPassenger;
	//list for total amount paid by each passenger.
	ArrayList<Integer> passengerCost;
	
	
	//constructor
	public Flight() {
		tickets = 50;
		price = 5000;
		id = id+1;
		flightID = id;
		passengerDetails = new ArrayList<String>();
		passengerIDs = new ArrayList<Integer>();
		bookedTicketsPerPassenger = new ArrayList<Integer>();
		passengerCost = new ArrayList<Integer>();
	}
	
	public void addPassengerDetails(String passengerDetail,  int numberOfTickets, int passengerID) {		
		passengerDetails.add(passengerDetail);
		passengerIDs.add(passengerID);
		passengerCost.add(price*numberOfTickets);
		
		//updating price 
		price+=200*numberOfTickets;
		
		tickets-=numberOfTickets;
		bookedTicketsPerPassenger.add(numberOfTickets);
		System.out.println("Tickets booked Successfully!!");
	}
	
	//cancel tickets booked by a passenger ID
	public void cancelTicket(int passengerID) {
		
		//finding the index to remove
		int indexToRemove = passengerIDs.indexOf(passengerID);
		if(indexToRemove<0) {
			System.out.println("Passenger ID not found!!");
			return;
		}
		
		int ticketsToCancel = bookedTicketsPerPassenger.get(indexToRemove);
		
		//increasing number of available tickets
		tickets+=ticketsToCancel;
		
		//changing price to new value
		
		price-=200*ticketsToCancel;
		//print refund
		System.out.println("Refund amount after cancellation: "+passengerCost.get(indexToRemove));
		
		//removing details of that passenger from all lists
		bookedTicketsPerPassenger.remove(indexToRemove);
		passengerIDs.remove(Integer.valueOf(passengerID));
		passengerDetails.remove(indexToRemove);
		passengerCost.remove(indexToRemove);
		
		System.out.println("Tickets cancelled Successfully");
		
		
	}
	
	 
	public void flightSummary() {
		System.out.println("Flight ID "+flightID+"--> Remaining Tickets " + tickets +
				"--> Current Ticket Price "+price);
	}
	
	public void printDetails() {
		System.out.println("Flight ID "+ flightID +"->");
		for(String detail : passengerDetails)
			System.out.println(detail);
	}
	
	
}
