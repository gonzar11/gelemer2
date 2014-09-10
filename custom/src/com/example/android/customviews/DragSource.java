package com.example.android.customviews;

import android.content.ClipData;
import android.view.View;



public interface DragSource {

/**
 * This method is called to determine if the DragSource has something to drag.
 * 
 * @return boolean - True if there is something to drag
 */

public boolean allowDrag ();

/**
 * Return the ClipData associated with the drag operation.
 * 
 * @return ClipData
 */

public ClipData clipDataForDragDrop ();

/**
 * Return the view that is the actual source of the information being dragged.
 * 
 * @return View
 */

public View dragDropView ();

/**
 * This method is called at the start of a drag-drop operation so the object being
 * dragged knows that it is being dragged.
 * 
 */

public void onDragStarted ();

/**
 * This method is called on the completion of the drag operation so the DragSource knows 
 * whether it succeeded or failed.
 * 
 * @param target DropTarget - the object that accepted the dragged object
 * @param success boolean - true means that the object was dropped successfully
 */

public void onDropCompleted (DropTarget target, boolean success);

} // end DragSource
