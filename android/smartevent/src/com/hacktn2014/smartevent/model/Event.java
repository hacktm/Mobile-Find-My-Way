package com.hacktn2014.smartevent.model;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

public class Event {

	@SerializedName("id")
	public String id;
	
	@SerializedName("name")
	public String name;
	
	
	@SerializedName("description")
	public String description;
	
	@SerializedName("roomid")
	public String roomid;
	
	@SerializedName("startDate")
	public Date startDate;
	
	@SerializedName("endDate")
	public Date endDate;
}
