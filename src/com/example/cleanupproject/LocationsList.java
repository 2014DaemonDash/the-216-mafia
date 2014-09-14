package com.example.cleanupproject;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


public class LocationsList extends ListActivity {

	ListView listView;
	Button reportButton;
	ObjectManager man;
	public void onResume() {
	    super.onResume();  // Always call the superclass method first
	    UpdateObjectManagerAndView();
	   
	}
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        man = new ObjectManager();
        LocationObj testObj1 = new LocationObj(8493, null, null, null);
        testObj1.addUserId(111);
        
        LocationObj testObj2 = new LocationObj(2928, null, null, null);
        testObj2.addUserId(222);
        testObj2.addUserId(223);
        testObj2.addUserId(222);
        
        LocationObj testObj3 = new LocationObj(8393, null, null, null);
        
        man.addLocationObj(testObj1);
        man.addLocationObj(testObj2);
        man.addLocationObj(testObj3);
        
        
        

        ArrayList<String> listToConvert = man.getListFormat();
        String [] listItems = listToConvert.toArray(new String[listToConvert.size()]);
        
        
        listView =  (ListView) findViewById(android.R.id.list);
        
        
        
//        String[] values = new String[] { "Android List View", 
//                "Adapter implementation",
//                "Simple List View In Android",
//                "Create List View Android", 
//                "Android Example", 
//                "List View Source Code", 
//                "List View Array Adapter", 
//                "Android Example List View" 
//               };
        
        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, listItems);
        
        
        
        
        listView.setAdapter(adapter);
        
        listView.setOnItemClickListener(new OnItemClickListener() {
        	 
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
               int position, long id) {
              
             // ListView Clicked item index
             int itemPosition     = position;
             
             // ListView Clicked item value
             String  idToParse    = (String) listView.getItemAtPosition(position);
             idToParse = idToParse.substring(9, 13);
             
             
             //Switch to activity
             Intent i = new Intent(LocationsList.this, MoreInfo.class);
             i.putExtra("LOCID", Integer.parseInt(idToParse));
             startActivity(i);
             
             
              // Show Alert 
              Toast.makeText(getApplicationContext(),
                "  ListItem : " +idToParse , Toast.LENGTH_LONG)
                .show();
           
            }

       }); 
        
        
        reportButton=(Button)findViewById(R.id.report);
        reportButton.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        Intent i = new Intent(LocationsList.this,Camera.class);
                        startActivity(i);
                    }
                });
        
        
    }
    
    public void UpdateObjectManagerAndView(){
    	 man = new ObjectManager();
    	 
    	 //Parsefrom server
    	 //newLocationObject() for each server entry, then do man.addLocationObj() for each
    	 
    	 //demo
         LocationObj testObj3 = new LocationObj(8393, null, null, null);
         testObj3.setNumPeople(4);
         man.addLocationObj(testObj3);
    	 
    	  ArrayList<String> listToConvert = man.getListFormat();
          String [] listItems = listToConvert.toArray(new String[listToConvert.size()]);
          
          
          listView =  (ListView) findViewById(android.R.id.list);
          
          ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                  android.R.layout.simple_list_item_1, android.R.id.text1, listItems);
          

          
          
          listView.setAdapter(adapter);
          
          listView.setOnItemClickListener(new OnItemClickListener() {
          	 
              @Override
              public void onItemClick(AdapterView<?> parent, View view,
                 int position, long id) {
                
               // ListView Clicked item index
               int itemPosition     = position;
               
               // ListView Clicked item value
               String  idToParse    = (String) listView.getItemAtPosition(position);
               idToParse = idToParse.substring(9, 13);
               
               
               //Switch to activity
               Intent i = new Intent(LocationsList.this, MoreInfo.class);
               i.putExtra("LOCID", Integer.parseInt(idToParse));
               startActivity(i);
               
               
                // Show Alert 
                Toast.makeText(getApplicationContext(),
                  "  ListItem : " +idToParse , Toast.LENGTH_LONG)
                  .show();
             
              }

         }); 
    	
    	
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
