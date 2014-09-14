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
	private int numPeople;
	
	public LocationObj(int id, Location loc,
			String mainImage, String caption) {
		numPeople = 0;
		this.userIds = new ArrayList<Integer>();
		this.caption = caption;
		this.id = id;
		this.loc = loc;
		
		this.mainImage = mainImage;
	}
	
	public ArrayList<Integer> getuserIds(){
		return userIds;
	}
	public int getNumPeople(){
		return numPeople;
	}
	public void setNumPeople(int numPeople){
		this.numPeople = numPeople;
	}
	
	public int getId(){
		return id;
	}
	
	public void addUserId(int id){
		userIds.add(id);
		
	}
	

	
	
}
