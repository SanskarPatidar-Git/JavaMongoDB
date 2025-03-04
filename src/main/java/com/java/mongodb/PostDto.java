package com.java.mongodb;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "post")
public class PostDto {

	@Id
	private String id;
	
	@Field("role")
	private String role;
	private int experience;
	private String description;
	private List<String> locations;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<String> getLocations() {
		return locations;
	}
	public void setLocations(List<String> locations) {
		this.locations = locations;
	}
	@Override
	public String toString() {
		return "PostDto [id=" + id + ", role=" + role + ", experience=" + experience + ", description=" + description
				+ ", locations=" + locations + "]";
	}
	
	
}
