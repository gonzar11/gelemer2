/* Copyright (C) 2012 The Android Open Source Project

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
*/

package com.example.android.customviews;


import java.util.ArrayList;
import java.util.List;
import android.R.color;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.TranslateAnimation;
import android.widget.GridView;
import android.widget.ImageView;
import com.example.android.customviews.adapters.CardViewAdapter;



public class MainActivity extends Activity 
	implements View.OnLongClickListener, View.OnClickListener,
				View.OnTouchListener
{
	private DragController mDragController;
	private DragLayer mDragLayer;
	private GridView mGridView;
	private List<Card> data;
	
	 private WindowManager.LayoutParams mWindowParams;
	 private WindowManager mWindowManager;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // Para hacer la pantalla fullscreen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
                                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        setContentView(R.layout.main3);
        mDragController = new DragController (this);
        
        data = new ArrayList<Card>();
        Card card1 = new Card("A");
        Card card2 = new Card("B");
        Card card3 = new Card("C");
        Card card4 = new Card("D");
        Card card5 = new Card("E");
        data.add(card1);
        data.add(card2);
        data.add(card3);
        data.add(card4);
        data.add(card5);
        
        mGridView = (GridView) findViewById(R.id.gridView1);
        mGridView.setAdapter(new CardViewAdapter(data, this));
        
        mDragLayer = (DragLayer) findViewById(R.id.drag_layer);
        mDragLayer.setDragController (mDragController);
        mDragLayer.setGridView (mGridView);

        mDragController.setDragListener (mDragLayer);
        // mDragController.addDropTarget (mDragLayer)
        
        //Esto es una prueba
//        LinearLayout ml = (LinearLayout) findViewById(R.id.gadorcha);
//        gadorcha();
        


        


    }
   

	void gadorcha(Bitmap imgBitmap, int xPos, int yPos) {
		
//		Drawable draw = getResources().getDrawable(R.drawable.dado);
        ImageView img = new ImageView(this);
        img.setImageBitmap(imgBitmap);
//        img.setImageDrawable(draw);
        img.setBackgroundColor(color.black);
////        img.layout(100, 100, 100, 100);
//        ml.addView(img);
        
        mWindowParams = new WindowManager.LayoutParams();
        mWindowParams.gravity = Gravity.LEFT | Gravity.TOP;
        mWindowParams.x = xPos;
        mWindowParams.y = yPos;
        mWindowParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        mWindowParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
        mWindowParams.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
            | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
            | WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
            | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN;
        mWindowParams.format = PixelFormat.TRANSLUCENT;
        mWindowParams.windowAnimations = 0;

//        ImageView v = new ImageView(mContext);
//        int backGroundColor = mContext.getResources().getColor(R.color.bg_background);
//        v.setBackgroundColor(backGroundColor);
//        v.setImageBitmap(bm);

        mWindowManager = (WindowManager)getSystemService("window");
        mWindowManager.addView(img, mWindowParams);
        setOriginalPositionToImageWithAnimation(img);
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
	    
		boolean handledHere = false;
		final int action = event.getAction();
		

	    // In the situation where a long click is not needed to initiate a drag, simply start on the down event.
	    if (action == MotionEvent.ACTION_DOWN) {
	       handledHere = startDrag (v);
	    }
	    
	    return handledHere;
	}

//	@Override
//	public boolean isDragDropEnabled() {
//		return true;
//	}
//
//	@Override
//	public void onDragStarted(DragSource source) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void onDropCompleted(DropTarget target, boolean success) {
//		// TODO Auto-generated method stub
//		
//	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onLongClick(View v) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean startDrag (View v)
	{
	    DragSource dragSource = (DragSource) v;

	    // We are starting a drag. Let the DragController handle it.
	    mDragController.startDrag (v, dragSource, dragSource, DragController.DRAG_ACTION_MOVE);

	    return true;
	}

	
	public void setOriginalPositionToImageWithAnimation(View v){
		  TranslateAnimation localTranslateAnimation = new TranslateAnimation(1000, 0, 1000, 0);
		  localTranslateAnimation.setDuration(400);
		  localTranslateAnimation.setFillAfter(false);
		//  localTranslateAnimation.setAnimationListener(new MyAnimationListener(this));
		  v.startAnimation(localTranslateAnimation);
		}
}

