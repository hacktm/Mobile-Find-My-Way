package com.hacktn2014.smartevent.api;

import java.io.File;

import android.os.AsyncTask;
import android.util.Log;
import ch.boye.httpclientandroidlib.HttpEntity;
import ch.boye.httpclientandroidlib.HttpResponse;
import ch.boye.httpclientandroidlib.client.HttpClient;
import ch.boye.httpclientandroidlib.client.methods.HttpPost;
import ch.boye.httpclientandroidlib.entity.mime.HttpMultipartMode;
import ch.boye.httpclientandroidlib.entity.mime.MultipartEntityBuilder;
import ch.boye.httpclientandroidlib.entity.mime.content.FileBody;
import ch.boye.httpclientandroidlib.entity.mime.content.StringBody;
import ch.boye.httpclientandroidlib.impl.client.DefaultHttpClient;

import com.hacktn2014.smartevent.Settings;
import com.hacktn2014.smartevent.model.User;
import com.hacktn2014.smartevent.ui.OnUserUpdatedListener;

public class ServiceInvoker extends AsyncTask<String, Void, Integer> {
	
	int responseCode = 500;
	private User user = null;
	private OnUserUpdatedListener listener = null;
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public void setListener(OnUserUpdatedListener listener) {
		this.listener = listener;
	}
	
	@Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

	@Override
    protected void onPostExecute(Integer returnCode) {
    
		if (listener != null) {
			listener.onUserUpdated(returnCode.intValue());
		}
	}
	
	@Override
	protected Integer doInBackground(String... parameters) {
	
		try {
			
			File pictureFile = null;
			FileBody pictureFileBody  = null;
			if (user.imageUri != null) {
				pictureFile = new File(user.imageUri);
			    pictureFileBody = new FileBody(pictureFile); 
			}
	    	
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost(Settings.serverIP + "/user");
			
		    MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		    	builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
		    	if (user.firstName != null && user.firstName.trim().length() !=0) {
		    		builder.addPart(User.FIRST_NAME, new StringBody(user.firstName));	
		    	}
		    	
		    	if (user.lastName != null && user.lastName.trim().length() !=0) {
		    		builder.addPart(User.LAST_NAME, new StringBody(user.lastName));
		    	}
		    	
		    	if (user.userFunction != null && user.userFunction.trim().length() !=0) {
		    		builder.addPart(User.USER_FUNCTION, new StringBody(user.userFunction));
		    	}
		    	if (user.description != null && user.description.trim().length() !=0) {
		    		builder.addPart(User.DESCRIPTION, new StringBody(user.description));
		    	}
		    	if (pictureFileBody != null){
		    		builder.addPart(User.PICTURE, pictureFileBody);
		    	}
		    	
		    httppost.setEntity(builder.build());
		    	
	        // Execute HTTP Post Request
		    HttpResponse response = httpclient.execute(httppost);
		    HttpEntity httpEntity = response.getEntity();
	    
		    int status = response.getStatusLine().getStatusCode();
		    return status;
		} 
		catch (Exception e) {
		    // TODO Auto-generated catch block
			Log.d("SetviceInvike", e.getStackTrace().toString());
		}
	  
		return Integer.valueOf(500);
	 }
}
