package com.example.android.customviews;

import android.view.View;



public interface DropTarget {

/**
 * Return true if the DropTarget allows objects to be dropped on it.
 * 
 * @param source DragSource where the drag started
 * @return boolean True if the drop will be accepted, false otherwise.
 */

public boolean allowDrop (DragSource source);

/**
 * Return the view that is the actual target of the information being dragged.
 * 
 * @return View
 */

public View dragDropView ();

/**
 * Handle an object being dropped on the DropTarget
 * 
 * @param source DragSource where the drag started
 */

public void onDrop (DragSource source);

/**
 * React to a dragged object entering into the view of the DropTarget.
 */    

public void onDragEnter (DragSource source);

/**
 * React to a dragged object leaving the view of the DropTarget.
 */    

public void onDragExit (DragSource source);

}