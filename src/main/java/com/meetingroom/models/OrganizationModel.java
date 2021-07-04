package com.meetingroom.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.meetingroom.entity.AuditedEntity;

@Entity(name = "organization")
public class OrganizationModel extends AuditedEntity {
	
	public OrganizationModel(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public OrganizationModel() {
		// TODO Auto-generated constructor stub
	}

//	@OneToMany(fetch = FetchType.EAGER, mappedBy = "organization" )
//	@Fetch(value = FetchMode.SUBSELECT)
//	@Column
//	private List<UserModel> users;
//
//	@OneToMany(fetch = FetchType.EAGER, mappedBy = "organization")
//	@Column
//	private List<LocationModel> locations;
//
//	public List<UserModel> getUsers() {
//		return users;
//	}
//
//	public void setUsers(List<UserModel> users) {
//		this.users = users;
//	}
//
//	public List<LocationModel> getLocations() {
//		return locations;
//	}
//
//	public void setLocations(List<LocationModel> locations) {
//		this.locations = locations;
//	}
//
//

}
