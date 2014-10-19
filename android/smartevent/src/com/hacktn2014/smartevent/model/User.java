package com.hacktn2014.smartevent.model;

import com.google.gson.annotations.SerializedName;

public class User {

	public static final String ID = "id";
	public static final String LAST_NAME = "lastName";
	public static final String FIRST_NAME= "firstName";
	public static final String USER_FUNCTION = "userFunction";
	public static final String DESCRIPTION = "description";
	public static final String PICTURE ="picture";
	
	@SerializedName(ID)
	public String id = null;
	
	@SerializedName(LAST_NAME)
	public String lastName = null;
	
	@SerializedName(FIRST_NAME)
	public String firstName = null;
	
	@SerializedName(USER_FUNCTION)
	public String userFunction = null;
	
	@SerializedName(DESCRIPTION)
	public String description = null;
	
	public String imageUri = null;
	
	
	public User () {
		super();
	}

	public String getSetverImageUriString() {
		return "/user/" + id + "/picture/";
		
	}
	
	public static class Builder {
		private User person = null;
		
		
		public Builder() {
			this.person = new User();
		}
		
		public User.Builder firstName(String firstName) {
			this.person.firstName = firstName;
			return this;
		}
		
		public User.Builder lastName(String lastName) {
			this.person.lastName = lastName;
			return this;
		}
		
		public User.Builder description(String description) {
			this.person.description= description;
			return this;
		}
		
		public User.Builder function(String function) {
			this.person.userFunction= function;
			return this;
		}
		
		public User.Builder picture(String imageUri) {
			this.person.imageUri = imageUri;
			return this;
		}
		
		public User build() {
			return this.person;
		}
	}

	private User(User.Builder builder) {
		
	}
	
}