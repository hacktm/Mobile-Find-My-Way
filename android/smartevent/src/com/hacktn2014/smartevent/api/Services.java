package com.hacktn2014.smartevent.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hacktn2014.smartevent.Settings;
import com.hacktn2014.smartevent.model.Beacon;
import com.hacktn2014.smartevent.model.Room;
import com.hacktn2014.smartevent.model.User;
import com.hacktn2014.smartevent.ui.OnUserUpdatedListener;

public class Services {
	
	public static void updateUser(User user, OnUserUpdatedListener listener) {
		
		ServiceInvoker task =  new ServiceInvoker();
		task.setUser(user);
		task.setListener(listener);
		task.execute();
	}
	
	public static List<Beacon> getValidBeacons() {
		
		String test = "[{\"id\":5,\"beaconID\":\"B9407F30-F5F8-466E-AFF9-25556B57FE6D\",\"type\":\"room\",\"profileID\":1,\"description\":\"Verde\",\"major\":16490,\"minor\":43514},{\"id\":6,\"beaconID\":\"B9407F30-F5F8-466E-AFF9-25556B57FE6D\",\"type\":\"room\",\"profileID\":2,\"description\":\"Albastru deschis\",\"major\":10442,\"minor\":43800},{\"id\":7,\"beaconID\":\"B9407F30-F5F8-466E-AFF9-25556B57FE6D\",\"type\":\"room\",\"profileID\":2,\"description\":\"Albastru Inchis\",\"major\":10649,\"minor\":50267},{\"id\":8,\"beaconID\":\"E2C56DB5-DFFB-48D2-B060-D0F5A71096E0\",\"type\":\"room\",\"profileID\":3,\"description\":\"Unkown 1\",\"major\":1,\"minor\":2},{\"id\":9,\"beaconID\":\"5A4BCFCE-174E-4BAC-A814-092E77F6B7E5\",\"type\":\"room\",\"profileID\":3,\"description\":\"Unkown 2\",\"major\":3,\"minor\":4},{\"id\":10,\"beaconID\":\"74278BDA-B644-4520-8F0C-720EAF059935\",\"type\":\"mentor\",\"profileID\":4,\"description\":\"Unkown mentor\",\"major\":5,\"minor\":6}]";
		
		GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat(Settings.JSON_DATE_FORMAT);
        Gson gson = gsonBuilder.create();
        List<Beacon> beacons = new ArrayList<Beacon>();
        beacons = Arrays.asList(gson.fromJson(test, Beacon[].class));
		
		return beacons;
		
	}
	
	public static List<Beacon> getBeacons() {
		
		String test = "[{\"id\":5,\"beaconID\":\"B9407F30-F5F8-466E-AFF9-25556B57FE6D\",\"type\":\"room\",\"profileID\":1,\"description\":\"Verde\",\"major\":16490,\"minor\":43514},{\"id\":6,\"beaconID\":\"B9407F30-F5F8-466E-AFF9-25556B57FE6D\",\"type\":\"room\",\"profileID\":2,\"description\":\"Albastru deschis\",\"major\":10442,\"minor\":43800},{\"id\":7,\"beaconID\":\"B9407F30-F5F8-466E-AFF9-25556B57FE6D\",\"type\":\"room\",\"profileID\":2,\"description\":\"Albastru Inchis\",\"major\":10649,\"minor\":50267},{\"id\":8,\"beaconID\":\"E2C56DB5-DFFB-48D2-B060-D0F5A71096E0\",\"type\":\"room\",\"profileID\":3,\"description\":\"Unkown 1\",\"major\":1,\"minor\":2},{\"id\":9,\"beaconID\":\"5A4BCFCE-174E-4BAC-A814-092E77F6B7E5\",\"type\":\"room\",\"profileID\":3,\"description\":\"Unkown 2\",\"major\":3,\"minor\":4},{\"id\":10,\"beaconID\":\"74278BDA-B644-4520-8F0C-720EAF059935\",\"type\":\"mentor\",\"profileID\":4,\"description\":\"Unkown mentor\",\"major\":5,\"minor\":6}]";
		
		GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat(Settings.JSON_DATE_FORMAT);
        Gson gson = gsonBuilder.create();
        List<Beacon> result = new ArrayList<Beacon>();
        result = Arrays.asList(gson.fromJson(test, Beacon[].class));
		
		return result;
		
	}
	
	public static List<User> getUsers() {
		
		String test = "[{\"id\":5,\"beaconID\":\"B9407F30-F5F8-466E-AFF9-25556B57FE6D\",\"type\":\"room\",\"profileID\":1,\"description\":\"Verde\",\"major\":16490,\"minor\":43514},{\"id\":6,\"beaconID\":\"B9407F30-F5F8-466E-AFF9-25556B57FE6D\",\"type\":\"room\",\"profileID\":2,\"description\":\"Albastru deschis\",\"major\":10442,\"minor\":43800},{\"id\":7,\"beaconID\":\"B9407F30-F5F8-466E-AFF9-25556B57FE6D\",\"type\":\"room\",\"profileID\":2,\"description\":\"Albastru Inchis\",\"major\":10649,\"minor\":50267},{\"id\":8,\"beaconID\":\"E2C56DB5-DFFB-48D2-B060-D0F5A71096E0\",\"type\":\"room\",\"profileID\":3,\"description\":\"Unkown 1\",\"major\":1,\"minor\":2},{\"id\":9,\"beaconID\":\"5A4BCFCE-174E-4BAC-A814-092E77F6B7E5\",\"type\":\"room\",\"profileID\":3,\"description\":\"Unkown 2\",\"major\":3,\"minor\":4},{\"id\":10,\"beaconID\":\"74278BDA-B644-4520-8F0C-720EAF059935\",\"type\":\"mentor\",\"profileID\":4,\"description\":\"Unkown mentor\",\"major\":5,\"minor\":6}]";
		
		GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat(Settings.JSON_DATE_FORMAT);
        Gson gson = gsonBuilder.create();
        List<User> users = new ArrayList<User>();
        users = Arrays.asList(gson.fromJson(test, User[].class));
		
		return users;
		
	}
	

	public static List<Room> getRooms() {
		
		String test = "[{\"id\":1,\"name\":\"room1\",\"location\":\"Located at first floor near elevator\",\"events\":[{\"id\":2,\"name\":\"Fucked up\",\"description\":\"it's us\",\"roomid\":1,\"startDate\":\"Oct 19 2014  17:00\",\"endDate\":\"10/19/2014 18:00\"}]},{\"id\":2,\"name\":\"room2\",\"location\":\"Located at ground floor near main entrance\",\"events\":[{\"id\":3,\"name\":\"new event\",\"description\":\"zzz\",\"roomid\":2,\"startDate\":\"10/19/2014 19:00\",\"endDate\":\"10/19/2014 20:00\"},{\"id\":4,\"name\":\"second event\",\"description\":\"whatever\",\"roomid\":2,\"startDate\":\"10/19/2014 21:00\",\"endDate\":\"10/19/2014 22:00\"}]},{\"id\":3,\"name\":\"Top Floor\",\"location\":\"4th floor of the building\",\"events\":[]},{\"id\":4,\"name\":\"Ground Floor\",\"location\":\"The full ground floor structure\",\"events\":[]}]";
	
		GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat(Settings.JSON_DATE_FORMAT);
        Gson gson = gsonBuilder.create();
        List<Room> result = new ArrayList<Room>();
        result = Arrays.asList(gson.fromJson(test, Room[].class));
		
		return result;
		
	}
	
	public static List<Services> getServices() {
		
		String test = "[{\"id\":1,\"name\":\"Open source demo\",\"description\":\"Presentation off all open source projects\",\"roomid\":1,\"startDate\":\"19/10/2014 15:00\",\"endDate\":\"19/10/2014 16:00\"},{\"id\":2,\"name\":\"Mobile projects demos\",\"description\":\"Mobile projects demos, with anything that touches main mobile platforms, iOS, Android, Windows Mobile\",\"roomid\":1,\"startDate\":\"19/10/2014 16:00\",\"endDate\":\"19/10/2014 17:00\"},{\"id\":3,\"name\":\"Home Automation\",\"description\":\"Presentation of all projects touching home automation\",\"roomid\":2,\"startDate\":\"19/10/2014 18:00\",\"endDate\":\"19/10/2014 19:00\"},{\"id\":4,\"name\":\"Hardware and robotics\",\"description\":\"All hardware and robotics presentation for hackTM\",\"roomid\":2,\"startDate\":\"19/10/2014 19:00\",\"endDate\":\"19/10/2014 20:00\"},{\"id\":5,\"name\":\"Closing ceremony\",\"description\":\"Prizes and awards. A few notes from the organizers, and more surprises\",\"roomid\":1,\"startDate\":\"19/10/2014 20:00\",\"endDate\":\"19/10/2014 21:00\"}]";
		
		GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat(Settings.JSON_DATE_FORMAT);
        Gson gson = gsonBuilder.create();
        List<Services> result = new ArrayList<Services>();
        result = Arrays.asList(gson.fromJson(test, Services[].class));
		
		return result;
	}
	
	
	
}
