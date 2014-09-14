package com.example.cleanupproject;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;


public class Camera extends Activity {
	 private static final int CAMERA_REQUEST = 1;
	 Bitmap photo;
	 
	Button add1 ;
    ImageView img1 ;
    

   
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        add1 = (Button) findViewById(R.id.button1);
        img1 = (ImageView) findViewById(R.id.imageView1);

        add1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
            	 Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE); 
                 startActivityForResult(cameraIntent, CAMERA_REQUEST); 
            }
        });
        
    }

   
	@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
                // From camera
        if (requestCode ==  CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
         photo = (Bitmap) data.getExtras().get("data"); 
            img1.setImageBitmap(photo);
            Log.i("MOSES","AM here");
        }
        
        Intent intent = new Intent(this, SubmissionAct.class);
		intent.putExtra("image",photo);
		 startActivity(intent);
             

    }  

	    
}