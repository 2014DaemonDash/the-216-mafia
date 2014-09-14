package com.example.cleanupproject;

import java.util.Random;





import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;



public class SubmissionAct extends Activity {
	
	//Connection to database
	
	ImageView image;
	TextView ID;
	EditText Comment;
	Button submit;
	int randomInt ;
	String caption;
	
	

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
		Bitmap bit=(Bitmap)intent.getParcelableExtra("image");
		image.setImageBitmap(bit);
		
		//For Randon Numbers(ID)		
		Random r  = new Random();
		 randomInt = r.nextInt(1000)*10;
		ID.setText(String.valueOf(randomInt));
		
		
		//For Comment
		caption=Comment.getText().toString();
		
		submit.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				/**
				 * get randomInt, caption and location and send to server.
				 */
				
			}
			
		});
		
		
		
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
