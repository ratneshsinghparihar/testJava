package com.meetingroom.entity;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AuditedEntity extends BaseEntity {
	
	public AuditedEntity(String name) {
		super(name);
		this.createdDate=new Date();
		this.modifedDate=new Date();
		this.createdBy="test";
		this.modifiedBy="test";
		// TODO Auto-generated constructor stub
	}
	public AuditedEntity() {
		super();
		this.createdDate=new Date();
		this.modifedDate=new Date();
		this.createdBy="test";
		this.modifiedBy="test";
		// TODO Auto-generated constructor stub
	}
	

	@Column
	private Date createdDate;
	
	@Column
	private Date modifedDate;
	
	@Column
	private String createdBy;
	
	@Column
	private String modifiedBy;
	
	

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifedDate() {
		return modifedDate;
	}

	public void setModifedDate(Date modifedDate) {
		this.modifedDate = modifedDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	
	
}
