package com.meetingroom.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	@Column
	private String name;
	
	@Column
	private String description;
	
	public BaseEntity(String name) {
		this.name = name;
	}
	
	public BaseEntity() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public String toString() {
		return "BaseEntity [Id=" + Id + ", name=" + name + ", description=" + description + "]";
	}
	
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		this.Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
