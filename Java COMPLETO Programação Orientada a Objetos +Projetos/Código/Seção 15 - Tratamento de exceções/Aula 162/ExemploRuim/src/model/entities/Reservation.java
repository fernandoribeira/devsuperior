package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reservation {
	
	public SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}
	
	public Integer duration() {
		Integer duration = (int) ((checkOut.getTime() - checkIn.getTime()) /
				(1000 * 60 * 60 * 24));
		return duration;
	}
	
	public String updateDates(Date checkIn, Date checkOut) {
		Date now = new Date();	
		if (checkIn.before(now) || checkOut.before(now)) {
			return "Reservation dates for update must be future dates";			
		} else if (!checkOut.after(checkIn)) {
			return "Check-out date must be after check-in date";
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;
	}

	@Override
	public String toString() {
		return "Reservation: Room " 
				+ roomNumber 
				+ ", check-in: " 
				+ sdf.format(checkIn) 
				+ ", check-out: " 
				+ sdf.format(checkOut) 
				+ ", "
				+ duration()
				+ " nights";
	}
	
}
