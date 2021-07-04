package com.meetingroom.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.meetingroom.entity.AuditedEntity;

@Entity(name = "Room")
public class RoomModel  extends AuditedEntity {
	
	public RoomModel(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public RoomModel() {
		// TODO Auto-generated constructor stub
	}

	@ManyToOne(fetch = FetchType.EAGER)	
	@JoinColumn(name = "locationId")
	private LocationModel location;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "room")
	private List<BookingModel> bookingRooms;

	public LocationModel getLocation() {
		return location;
	}

	public void setLocation(LocationModel location) {
		this.location = location;
	}

	public List<BookingModel> getBookingRooms() {
		return bookingRooms;
	}

	public void setBookingRooms(List<BookingModel> bookingRooms) {
		this.bookingRooms = bookingRooms;
	}

	
}
