package com.example.cleanupproject;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Base64;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.client.Firebase;

public class MoreInfo extends ActionBarActivity {
	Bitmap returnedImage;
	Button join;
	TextView locationView;
	int numUsers;
	Integer locId;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_more_info);
		Intent i = getIntent();
		locId = (Integer)i.getExtras().get("LOCID");
		String 	captionText = (String)i.getExtras().get("Caption");
		String 	imageString = (String)i.getExtras().get("picString");
		numUsers = (Integer)i.getExtras().get("numusers");
		String longLat = (String)i.getExtras().get("locca");
		
		locationView= (TextView)findViewById(R.id.textView3);
		locationView.setText(longLat);
		
		
		
		join=(Button)findViewById(R.id.button1);
		
		join.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				int changedNum = numUsers++;
				Firebase myFirebaseRef = new Firebase("https://torid-heat-3961.firebaseio.com/");
				Firebase locRef = myFirebaseRef.child("Locations");
				Firebase idRef = locRef.child(""+locId);
				idRef.child("NumUsers").setValue(changedNum);
				
				
			}
			
		});
		TextView captionView = (TextView)findViewById(R.id.textView2);
		captionView.setText("CleanUp #"+locId);
		
		TextView comment = (TextView)findViewById(R.id.textView1);
		comment.setText(captionText);
		
		ImageView picView = (ImageView)findViewById(R.id.imageView1);
		returnedImage=StringToBitMap(imageString);
		picView.setImageBitmap(returnedImage);
		
	}
	
	//String to Bitmap
	 public Bitmap StringToBitMap(String encodedString){
	     try{
	       byte [] encodeByte=Base64.decode(encodedString,Base64.DEFAULT);
	       Bitmap bitmap=BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
	       return bitmap;
	     }catch(Exception e){
	       e.getMessage();
	       return null;
	     }
	      }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.more_info, menu);
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
