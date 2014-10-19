package com.hacktn2014.smartevent.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Room {


	@SerializedName("id")
	public String id;
	
	@SerializedName("name")
	public String name;
	
	@SerializedName("location")
	public String location;
	
	@SerializedName("events")
	List<Event> events;
}
