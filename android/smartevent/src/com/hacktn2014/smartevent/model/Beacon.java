package com.hacktn2014.smartevent.model;

import com.google.gson.annotations.SerializedName;

public class Beacon {

	public static final String ROOM_TYPE = "room";
	public static final String MENTOR_TYPE = "mentor";
	
	@SerializedName("id")
	public String id;
	
	@SerializedName("beaconID")
	public String uuid;
	
	@SerializedName("type")
	public String type;
	
	@SerializedName("profileID")
	public String profile;
	
	@SerializedName("description")
	public String description;
	
	@SerializedName("major")
	public String major;
	
	@SerializedName("minor")
	public String minor;
	
}
