package com.meetingroom.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.meetingroom.entity.AuditedEntity;

@Entity(name = "BookingTrail")
public class BookingTrailModel extends AuditedEntity{
	
	public BookingTrailModel(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public BookingTrailModel() {
		// TODO Auto-generated constructor stub
	}

	public BookingTrailModel(BookingModel model, String perviousStatus, String currentStatus) {
		// TODO Auto-generated constructor stub
		this.booking = model;
		this.perviousStatus = perviousStatus;
		this.currentStatus = currentStatus;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "BookingId")
	private BookingModel booking;
	
	@Column
	private String perviousStatus;
	
	@Column
	private String currentStatus;

	public BookingModel getBooking() {
		return booking;
	}

	public void setBooking(BookingModel booking) {
		this.booking = booking;
	}

	public String getPerviousStatus() {
		return perviousStatus;
	}

	public void setPerviousStatus(String perviousStatus) {
		this.perviousStatus = perviousStatus;
	}

	public String getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}
	
	
	
}
