package com.example.android.customviews;

import android.graphics.Bitmap;
import android.view.View;
import android.view.animation.TranslateAnimation;

public class Util {
	
	public static Bitmap getViewBitmap(View v) {
	    v.clearFocus();
	    v.setPressed(false);

	    boolean willNotCache = v.willNotCacheDrawing();
	    v.setWillNotCacheDrawing(false);

	    // Reset the drawing cache background color to fully transparent
	    // for the duration of this operation
	    int color = v.getDrawingCacheBackgroundColor();
	    v.setDrawingCacheBackgroundColor(0);

	    if (color != 0) {
	        v.destroyDrawingCache();
	    }
	    v.buildDrawingCache();
	    Bitmap cacheBitmap = v.getDrawingCache();
	    if (cacheBitmap == null) {
//	        Log.e(TAG, "failed getViewBitmap(" + v + ")", new RuntimeException());
	        return null;
	    }

	    Bitmap bitmap = Bitmap.createBitmap(cacheBitmap);

	    // Restore the view
	    v.destroyDrawingCache();
	    v.setWillNotCacheDrawing(willNotCache);
	    v.setDrawingCacheBackgroundColor(color);

	    return bitmap;
	}
	
	public static int[] getDragViewPosition(View v) {
		int[] loc = new int[2];
	     v.getLocationOnScreen(loc);
	     return loc;
	}
	
	public static void setOriginalPositionToImageWithAnimation(View v){
		  TranslateAnimation localTranslateAnimation = new TranslateAnimation(0, 500, 0, 500);
		  localTranslateAnimation.setDuration(400);
		  localTranslateAnimation.setFillAfter(false);
		//  localTranslateAnimation.setAnimationListener(new MyAnimationListener(this));
		  v.startAnimation(localTranslateAnimation);
	}

}
