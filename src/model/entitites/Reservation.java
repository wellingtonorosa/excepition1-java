package model.entitites;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
  private Integer roomNumber;
  private Date checkin;
  private Date checkout;
  
  private static SimpleDateFormat  sdf = new SimpleDateFormat("dd/MM/yyyy");
  
	public Reservation(Integer roomnumbrt, Date checkin, Date checkout) {
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
			+ duration()
			+ " Nights";
  }
}
