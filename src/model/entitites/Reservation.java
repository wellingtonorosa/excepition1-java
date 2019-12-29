package model.entitites;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import model.exceptions.DomainException;

public class Reservation {
  private Integer roomNumber;
  private Date checkin;
  private Date checkout;
  
  private static SimpleDateFormat  sdf = new SimpleDateFormat("dd/MM/yyyy");
  
	public Reservation(Integer roomnumbrt, Date checkin, Date checkout)  {
		 if (!checkout.after(checkin)) {
			  throw new DomainException("Check-out date must be after check-in date"); 
		  }
		this.roomNumber = roomnumbrt;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getRoomnumbrt() {
		return roomNumber;
	}

	public void setRoomnumbrt(Integer roomnumbrt) {
		this.roomNumber = roomnumbrt;
	}

	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckout() {
		return checkout;
	}


  public long  duration(){
	  long diff = checkout.getTime() - checkin.getTime();
	  return TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);
  }
  
  public void updateDate(Date checkin, Date checkout) {
	  Date now = new Date();
	  if (checkin.before(now) || checkout.before(now)) {
		  throw new DomainException("Resaervation dates for updayes must be future dates");
	  }
	  if (!checkout.after(checkin)) {
		  throw new DomainException("Check-out date must be after check-in date"); 
	  }
	  this.checkin = checkin;
	  this.checkout = checkout;
  }
  
  @Override
  public  String toString() {
	  return "Room " 
			+ roomNumber
			+ ", checkin: "
			+ sdf.format(checkin)
			+ ", checkout: "
			+ sdf.format(checkout)
			+ " "
			+ duration()
			+ " Nights";
  }
}
