package com.hacktn2014.smartevent.ui;


import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.hacktn2014.smartevent.R;
import com.hacktn2014.smartevent.Settings;

public class StartScreenActivity extends Activity  {
	
	private static final String TAG = StartScreenActivity.class.getSimpleName();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(
				WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
				requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		setContentView(R.layout.activity_start_screen);
		
		RelativeLayout layout = (RelativeLayout) findViewById(R.id.start_touch_surface);
		layout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(StartScreenActivity.this, UserSetupActivity.class);
				intent.putExtra(Settings.TARGET_ACTIVITY, UserSetupActivity.class.getSimpleName());
				startActivity(intent);
            }
        });
		
		new Timer().schedule(new TimerTask() {
			
			@Override
			public void run() {
				Intent intent = new Intent(StartScreenActivity.this, UserSetupActivity.class);
				intent.putExtra(Settings.TARGET_ACTIVITY, UserSetupActivity.class.getSimpleName());
				startActivity(intent);
				}	
			}, Settings.SPLASH_WAIT_DELAY);
	}
}
