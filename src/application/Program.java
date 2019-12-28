package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entitites.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc =  new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
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
	    sc.close();
    }
}
