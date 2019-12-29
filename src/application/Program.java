package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entitites.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc =  new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
		
			System.out.print("Room number");
			int number = sc.nextInt();
		    System.out.print("Check-in date dd/mm/yyyy");
		    Date checkin = sdf.parse(sc.next());
		    System.out.print("Check-out date dd/mm/yyyy");
		    Date checkout = sdf.parse(sc.next());
		    
		    Reservation reservation = new Reservation (number,checkin, checkout);
		    System.out.println("Reservation: " + reservation);
		    
		    System.out.println();
		    System.out.println("Enter data to update the reservation");
			System.out.print("Room number");
			number = sc.nextInt();
		    System.out.print("Check-in date dd/mm/yyyy");
		    checkin = sdf.parse(sc.next());
		    System.out.print("Check-out date dd/mm/yyyy");
		    checkout = sdf.parse(sc.next());
		    
		    reservation.updateDate(checkin, checkout);
		    System.out.println("Reservation: " + reservation);
		}
		catch(ParseException e) {
			System.out.println("Invalid Format");
		}
		catch(DomainException e) {
		System.out.println("Error in reservation:" + e.getMessage());	
		}
		catch(RuntimeException e) {
			System.out.println("Erro inesperado: " + e.getMessage());
		}
	    sc.close();
    }
}
