package com.example.cleanupproject;

import java.io.Serializable;
import java.util.ArrayList;

public class ObjectManager implements Serializable {
	ArrayList<LocationObj> locationObjects;
	
	
	ObjectManager(){
		locationObjects = new ArrayList<LocationObj>();
		
		
	}
	
	public void addLocationObj(LocationObj l){
		locationObjects.add(l);
		
	}
	
	public ArrayList<String> getListFormat(){
		ArrayList<String> toReturn = new ArrayList<String>();
		
		for(LocationObj l:locationObjects){
			toReturn.add("Cleanup# "+l.getId()+" -            Good Samaritans: "+l.getuserIds().size()+"/20");
		}
		return toReturn;
		
	}
	
}
