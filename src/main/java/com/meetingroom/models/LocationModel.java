package com.meetingroom.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.meetingroom.entity.AuditedEntity;

@Entity(name = "Location")
public class LocationModel extends AuditedEntity {

	public LocationModel(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public LocationModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "organizationId")
	private OrganizationModel organization;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "location", cascade = CascadeType.ALL)
	private List<RoomModel> rooms;

	public OrganizationModel getOrganization() {
		return organization;
	}

	public void setOrganization(OrganizationModel organisation) {
		this.organization = organisation;
	}

	public List<RoomModel> getRooms() {
		return rooms;
	}

	public void setRooms(List<RoomModel> rooms) {
		this.rooms = rooms;
	}
	
	
	
}
