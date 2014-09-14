package com.example.cleanupproject;

import java.io.Serializable;
import java.util.ArrayList;

import android.location.Location;

public class LocationObj implements Serializable {
	private int id;
	private Location loc;
	private ArrayList<Integer> userIds;
	private String mainImage;
	private String caption;
	
	public LocationObj(int id, Location loc,
			String mainImage, String caption) {

		this.userIds = new ArrayList<Integer>();
		this.caption = caption;
		this.id = id;
		this.loc = loc;
		
		this.mainImage = mainImage;
	}
	
	public ArrayList<Integer> getuserIds(){
		return userIds;
	}
	
	public int getId(){
		return id;
	}
	
	public void addUserId(int id){
		userIds.add(id);
		
	}
	

	
	
}
