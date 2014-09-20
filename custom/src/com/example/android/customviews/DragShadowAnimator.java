package com.example.android.customviews;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.view.WindowManager;
import android.widget.Toast;

public class DragShadowAnimator {
	
	private Context mContext;
	private WindowManager mWindowManager;
	private AnimatorListener mAnimationListner;
	private DragShadow mViewToAnimate;
	private DragSource mDragSource;
	
	public DragShadowAnimator(Context context) {
		mContext = context;
		 mWindowManager = (WindowManager)mContext.getSystemService("window");
		 mAnimationListner = new AnimatorListener();
	}
	
	private void updateViewLayout(DragShadow view, Integer x, Integer y, Integer w, Integer h){
	    if (view!=null) {
	        WindowManager.LayoutParams lp = (WindowManager.LayoutParams) view.getLayoutParams();
	
	        if(x != null)lp.x=x;
	        if(y != null)lp.y=y;
	        if(w != null && w>0)lp.width=w;
	        if(h != null && h>0)lp.height=h;
	        mWindowManager.updateViewLayout(view, lp);
	     }
	 }
    public  void translateXY(final DragShadow viewToAnimate,DragSource originalDragView, int viewX, int endX, int viewY, int endY) {
    	mViewToAnimate = viewToAnimate;
    	mDragSource = originalDragView;
    	ValueAnimator translateX = ValueAnimator.ofInt(viewX, endX);
    	ValueAnimator translateY = ValueAnimator.ofInt(viewY, endY);
    
    	translateY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
        @Override
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int val = (Integer) valueAnimator.getAnimatedValue();
            updateViewLayout(viewToAnimate, null, val, null, null);

        }
    });
    
    translateX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
        @Override
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int val = (Integer) valueAnimator.getAnimatedValue();
            updateViewLayout(viewToAnimate, val, null, null, null);

        }
    });

    AnimatorSet animSetXY = new AnimatorSet();
    animSetXY.addListener(mAnimationListner);
    animSetXY.playTogether(translateX, translateY);
    animSetXY.setDuration(1000);
   
    animSetXY.start();
    
    translateX.start();
//    translateY.setDuration(1000);
//    translateY.start();
    
}
    private class AnimatorListener extends AnimatorListenerAdapter {
    	@Override
    	public void onAnimationEnd (Animator animation){
    		if (mViewToAnimate != null) mViewToAnimate.remove();
    		if (mDragSource != null) mDragSource.onDropCompleted(null, false);
    		
    	}
	
    }
    

}
