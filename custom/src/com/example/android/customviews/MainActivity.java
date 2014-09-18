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
import android.animation.AnimatorSet;
import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.GridView;
import com.example.android.customviews.adapters.CardViewAdapter;



public class MainActivity extends Activity 
	implements View.OnLongClickListener, View.OnClickListener,
				View.OnTouchListener
{
	private DragController mDragController;
	private DragLayer mDragLayer;
	private GridView mGridViewLeft;
	private GridView mGridViewRight;
	private List<Card> data;
	
	 private WindowManager.LayoutParams mWindowParams;
	 private WindowManager mWindowManager;
	 private AnimatorSet mAnimatorSet;
	 
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
        mWindowManager = (WindowManager)getSystemService("window");
        
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
        
        mGridViewLeft = (GridView) findViewById(R.id.gridView1);
        mGridViewLeft.setAdapter(new CardViewAdapter(data, this));
        mGridViewRight = (GridView) findViewById(R.id.gridView2);
        mGridViewRight.setAdapter(new CardViewAdapter(data, this));
        
        mDragLayer = (DragLayer) findViewById(R.id.drag_layer);
        mDragLayer.setDragController (mDragController);
        mDragLayer.setGridView (mGridViewLeft);

        mDragController.setDragListener (mDragLayer);
        
        

        
        
      
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

	
	
	
   
   
}

