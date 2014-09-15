package com.example.android.customviews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.Toast;



/**
 * A ViewGroup that supports dragging within it.
 * Dragging starts in an object that implements the DragSource interface and
 * ends in an object that implements the DropTarget interface.
 *
 * <p> This class used DragLayer in the Android Launcher activity as a model.
 * It is a bit different in several respects: (1) it supports dragging to a grid view and trash area;
 * (2) it dynamically adds drop targets when a drag-drop sequence begins.
 * The child views of the GridView are assumed to implement the DropTarget interface. 
 */
public class DragLayer extends FrameLayout
    implements DragController.DragListener
{
    DragController mDragController;
    GridView mGridView;

    /**
     * Used to create a new DragLayer from XML.
     *
     * @param context The application's context.
     * @param attrs The attribtues set containing the Workspace's customization values.
     */
    public DragLayer (Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setDragController(DragController controller) {
        mDragController = controller;
    }
    
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        return mDragController.dispatchKeyEvent(event) || super.dispatchKeyEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return mDragController.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return mDragController.onTouchEvent(ev);
    }

    @Override
    public boolean dispatchUnhandledMove(View focused, int direction) {
        return mDragController.dispatchUnhandledMove(focused, direction);
    }

/**
 * Get the value of the GridView property.
 * 
 * @return GridView
 */

public GridView getGridView ()
{
   //if (mGridView == null) {}
   return mGridView;
} // end getGridView

/**
 * Set the value of the GridView property.
 * 
 * @param newValue GridView
 */

public void setGridView (GridView newValue)
{
   mGridView = newValue;
} // end setGridView
/* end Property GridView */

/**
 */
// DragListener Interface Methods

/**
 * A drag has begun.
 * 
 * @param source An object representing where the drag originated
 * @param info The data associated with the object that is being dragged
 * @param dragAction The drag action: either {@link DragController#DRAG_ACTION_MOVE}
 *        or {@link DragController#DRAG_ACTION_COPY}
 */

public void onDragStart(DragSource source, Object info, int dragAction) 
{
    // We are starting a drag. 
    // Build up a list of DropTargets from the child views of the GridView.
    // Tell the drag controller about them.

    if (mGridView != null) {
       int numVisibleChildren = mGridView.getChildCount();
       for ( int i = 0; i < numVisibleChildren; i++ ) {
           DropTarget view = (DropTarget) mGridView.getChildAt (i);
           mDragController.addDropTarget (view);
       }
    }

  
    
}

/**
 * A drag-drop operation has eneded. 
 */

public void onDragEnd() 
{
    mDragController.removeAllDropTargets ();
}

/**
 */
// Other Methods

/**
 * Show a string on the screen via Toast.
 * 
 * @param msg String
 * @return void
 */

public void toast (String msg)
{
    // if (!DragActivity.Debugging) return;
    Toast.makeText (getContext (), msg, Toast.LENGTH_SHORT).show ();
} // end toast

} // end class

