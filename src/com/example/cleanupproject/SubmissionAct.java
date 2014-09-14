package com.example.cleanupproject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.location.Location;
import android.location.LocationManager;
import android.media.ExifInterface;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;



public class SubmissionAct extends Activity {
	
	//Connection to database
	
	ImageView image;
	TextView ID;
	EditText Comment;
	Button submit;
	int randomInt ;
	String caption;
	String picture;
	Bitmap bit, returnedImage;
	String loc;

	
	Firebase myFirebaseRef = new Firebase("https://torid-heat-3961.firebaseio.com/");
	Firebase locRef = myFirebaseRef.child("Locations");
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_submission);
		image=(ImageView)findViewById(R.id.imageView1);
		ID=(TextView)findViewById(R.id.textView1);
		Comment=(EditText)findViewById(R.id.editText1);
		submit=(Button)findViewById(R.id.button1);
		
		
		// For Bitmap
		Intent intent=getIntent();
		bit=(Bitmap)intent.getParcelableExtra("image");
		image.setImageBitmap(bit);
		
		//For Randon Numbers(ID)		
		Random r  = new Random();
		 randomInt = r.nextInt(1000)*10;
		ID.setText(String.valueOf(randomInt));
		
		
	
		submit.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				/**
				 * get randomInt, caption and location and send to server.
				 */
				//For Comment
				LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE); 
				Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
				double longitude = location.getLongitude();
				double latitude = location.getLatitude();
				
				picture=BitMapToString(bit);
				
				caption=Comment.getText().toString();
				Log.i("Mos", caption);
				Firebase idRef = locRef.child(""+randomInt);
				idRef.child("Caption").setValue(caption);
				idRef.child("Location").setValue(longitude+":"+latitude);
				idRef.child("String").setValue(""+picture);
				idRef.child("NumUsers").setValue(0);
				
				
				
				Intent returntomain=new Intent(SubmissionAct.this,LocationsList.class);
				returntomain.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(returntomain);
				
				
			}
			
			
		});
		
		
		
		
	}
	//Convert Bitmap to String
		public String BitMapToString(Bitmap bitmap){
	        ByteArrayOutputStream baos=new  ByteArrayOutputStream();
	        bitmap.compress(Bitmap.CompressFormat.PNG,100, baos);
	        byte [] b=baos.toByteArray();
	        String temp=Base64.encodeToString(b, Base64.DEFAULT);
	        return temp;
	  }

	
//	public int makeId(){
//		int startAt = 1234;
//
//		new Firebase("https://torid-heat-3961.firebaseio.com/Locations/startAt").once("7250", function(snap) {
//			   console.log('I fetched a user!', snap.val());
//			});
//return 0;
//
//		
//	}

		

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
