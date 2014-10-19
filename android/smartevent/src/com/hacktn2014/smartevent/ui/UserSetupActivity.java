package com.hacktn2014.smartevent.ui;


import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.hacktn2014.smartevent.R;
import com.hacktn2014.smartevent.Settings;
import com.hacktn2014.smartevent.api.Services;
import com.hacktn2014.smartevent.model.User;

public class UserSetupActivity extends Activity implements OnUserUpdatedListener {

	private static final String TAG = UserSetupActivity.class.getSimpleName();
	
	private static final int SELECT_PHOTO = 100;
	private static final int TAKE_PICTURE = 200; //must be > 0
	private static int avatarSizePx = 0;
			
	//public static final String ACTION_CAPTURE = "android.media.action.IMAGE_CAPTURE";
	private static Uri imageUri = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(
				WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
				requestWindowFeature(Window.FEATURE_NO_TITLE);
	
		setContentView(R.layout.activity_user_setup_screen);    
	    
		Resources r = getResources();
		avatarSizePx = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, Settings.IMAGE_SIZE_DP, r.getDisplayMetrics());
		
	    ImageView background = (ImageView) findViewById(R.id.dimbackground);
		background.setAlpha(Settings.BACKGROUND_DIM);
		background.invalidate();
		
		ImageView avatar = (ImageView) findViewById(R.id.avatar);
		avatar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//            	Intent photoPickerIntent = new Intent (Intent.ACTION_PICK);
//            	photoPickerIntent.setType("image/*");
//            	startActivityForResult(photoPickerIntent, SELECT_PHOTO); 
            	
            	
            	Intent intent = new Intent("android.media.action.IMAGE_CAPTURE"); //MediaStore.ACTION_IMAGE_CAPTURE
                File photo = new File(Environment.getExternalStorageDirectory(),  Settings.IMAGE_NAME);
                imageUri = Uri.fromFile(photo);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                startActivityForResult(intent, TAKE_PICTURE);
            }
        });
		
		Button button = (Button) findViewById(R.id.button_update);
		button.setOnClickListener(
				new View.OnClickListener() {
		            public void onClick(View v) {
		            	EditText nameView = (EditText) findViewById(R.id.person_name);
		            	String name = nameView.getText().toString().trim();
		            	
		            	EditText sureNameView = (EditText) findViewById(R.id.person_surename);
		            	String sureName = sureNameView.getText().toString().trim();
		            	
		            	Spinner roleView = (Spinner) findViewById(R.id.person_role);
		            	String function = roleView.getSelectedItem().toString().trim();
		            	
		            	EditText desctiptionView = (EditText) findViewById(R.id.person_description);
		            	String description = desctiptionView.getText().toString().trim();
  	            	
		            	if (name.length() != 0 && sureName.length() != 0 && function.length() != 0 && description.length() != 0) {
		            		User.Builder personBuilder = (new User.Builder()).firstName(name).lastName(sureName).description(description).function(function);

		            		if (imageUri != null) {
		            			personBuilder.picture(imageUri.toString());
		            		}
		            		
		            		User person = personBuilder.build();
		            		Services.updateUser(person, UserSetupActivity.this);
		            	}
		            	else {
		            		Intent intent = new Intent(UserSetupActivity.this, ListBeaconsActivity.class);
							intent.putExtra(Settings.TARGET_ACTIVITY, UserSetupActivity.class.getSimpleName());
							startActivity(intent);
		            	}
		            			
		            }
		        }
		);
		
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
		    super.onActivityResult(requestCode, resultCode, intent); 

		    Bitmap newBitmap = null;
		    
		    switch (requestCode) {
			    case TAKE_PICTURE:
			        if (resultCode == Activity.RESULT_OK) {
			        	updateAvatar(imageUri);
			        }
			        break;
			    case SELECT_PHOTO:
			        if(resultCode == RESULT_OK){  
				        if (intent.getData() != null) {
					    	imageUri = intent.getData();
					    	updateAvatar(imageUri);
					    }
			        }
			        break;
		    	default:
		    		Toast.makeText(this, "Failed to load", Toast.LENGTH_SHORT).show();
	                Log.e("Camera", "Failed to load Image");
	                return;
		    }
		   
		}

	private void updateAvatar(Uri imageUri) {
		Bitmap bitmap;
		Bitmap newBitmap;
		ImageView imageView = (ImageView) findViewById(R.id.avatar);
		ContentResolver cr = getContentResolver();

		try {
		    bitmap = android.provider.MediaStore.Images.Media.getBitmap(cr, imageUri);
		    newBitmap = ThumbnailUtils.extractThumbnail(bitmap, avatarSizePx, avatarSizePx);
		    imageView.setImageBitmap(newBitmap);
		} 
		catch (Exception e) {
		    Toast.makeText(this, "Failed to load", Toast.LENGTH_SHORT).show();
		    Log.e("Camera", e.toString());
		}
	}

	@Override
	public void onUserUpdated(int code) {
		if (code == 200) {
			Toast.makeText(this, R.string.success_update_user, Toast.LENGTH_SHORT).show();
		}
		else {
			Toast.makeText(this, R.string.fail_update_user, Toast.LENGTH_SHORT).show();
		}
		
		new Timer().schedule(
				new TimerTask() {
					
					@Override
					public void run() {
						Intent intent = new Intent(UserSetupActivity.this, ListBeaconsActivity.class);
						intent.putExtra(Settings.TARGET_ACTIVITY, DistanceBeaconActivity.class.getName());
						startActivity(intent);
					}	
				}
				, Settings.WAIT_READ_TOAST);
	}

}
