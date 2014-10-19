package com.hacktn2014.smartevent.ui;

import android.graphics.Bitmap;
import android.graphics.Matrix;

public class Utils {

	private static Bitmap rotateBitmap(Bitmap source, int targetDimension, float angle)
	{
		  int width = source.getWidth();
		  int height = source.getHeight();
		  int max = width > height ? width : height;
		  Bitmap scaledBitmap = Bitmap.createScaledBitmap(source, targetDimension * source.getWidth() / max , targetDimension * source.getHeight() / max,true);
	
		  if (angle != 0) {
	    	  Matrix matrix = new Matrix();
		      matrix.postRotate(angle);
		     
	    	  return Bitmap.createBitmap(scaledBitmap, 0, 0, scaledBitmap.getWidth(), scaledBitmap.getHeight(), matrix, true); 
		  }
	      
	      return scaledBitmap;
	}

}
