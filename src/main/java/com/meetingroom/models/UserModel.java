package com.meetingroom.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.meetingroom.entity.AuditedEntity;

@Entity(name = "User")
public class UserModel extends AuditedEntity {
	
	public UserModel(String name) {
		super(name);
	}
	
	public UserModel() {
		// TODO Auto-generated constructor stub
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "organizationId")
	private OrganizationModel organization;


	public OrganizationModel getOrganization() {
		return organization;
	}

	public void setOrganization(OrganizationModel organisation) {
		this.organization = organisation;
	}
	
	
	
	
}
