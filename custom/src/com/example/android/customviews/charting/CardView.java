package com.example.android.customviews.charting;

import android.content.ClipData;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.drawable.Drawable;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.android.customviews.Card;
import com.example.android.customviews.DragShadow;
import com.example.android.customviews.DragSource;
import com.example.android.customviews.DropTarget;

import com.example.android.customviews.R;
import com.example.android.customviews.adapters.CardViewAdapter;



public class CardView extends View implements DragSource, DropTarget {
	
	
	private Card mCard;
	private Renderer mRenderer;
	private Paint mTextPaint, mRectanglePaint;
	private int rectangleWidth, rectangleHeight;



	private float rectangleSize;
	private int textSize;
	private int widthSize,heightSize;
	 
	 private Bitmap imageBitmap; 
	 
	 public boolean mEmpty = true;
	 public int myCellnumber;
	 public CardViewAdapter mAdapter;
	
	 

	
	


	public CardView(Context context) {
		super(context);
		init(context);
	}
	
	public CardView(Context context, AttributeSet attrs) {
        super(context, attrs);

        
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.CardView,
                0, 0
        );

        try {
          

            

         
         } finally {
            a.recycle();
        }

        init(context);
    }
	
	public String getCardId(){
		return mCard.getLetter();
	}
	
	public void setCard(Card card){
		mCard = card;
	}
	public void setRenderer(Renderer renderer){
		mRenderer = renderer;
	}
	
	
	
	private void init(Context context) {
		
		imageBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.dado);
		
        mRectanglePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mRectanglePaint.setColor(Color.BLACK);
        mRectanglePaint.setStyle(Paint.Style.STROKE);
        mRectanglePaint.setStrokeWidth(2);
        
        mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setColor(Color.BLACK);
        mTextPaint.setTextSize(40);
        mTextPaint.setTextAlign(Align.CENTER);
  
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		   super.onDraw(canvas);
		   
		  
		   rectangleWidth = getMeasuredWidth()-2;
		   rectangleHeight = getMeasuredHeight() - 2;
		   mRenderer.Render(canvas, rectangleWidth, rectangleHeight, mRectanglePaint, mTextPaint, mCard);
		   
		   
	}
	@Override 
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
	   super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	   int w = getMeasuredWidth();
	   int h = getMeasuredHeight();
	   setMeasuredDimension(w, h);
	}
 
	@Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
	}
    
   

	


	@Override
	public boolean allowDrag() {
		return true;
	}

	@Override
	public ClipData clipDataForDragDrop() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public View dragDropView() {
		return this;
	}
	/**
	 * This method is called at the start of a drag-drop operation so the object being
	 * dragged knows that it is being dragged.
	 * 
	 */
	@Override
	public void onDragStarted() {
		// Hacerle alg�n efecto a la tarjeta para que resale que fue seleccionada
		setVisibility(View.GONE);
//		invalidate();
		
	}

	@Override
	public void onDropCompleted(DropTarget target, boolean success) {
		if (!success){
			setVisibility(View.VISIBLE);
		}
		
	}

	@Override
	public void onDrop(DragSource source, int x, int y, int xOffset,
			int yOffset, DragShadow dragView, Object dragInfo) {
			
			CardView rect = (CardView)source;
			rect.setVisibility(GONE);
			Card carDataItem = mAdapter.getmData().get(rect.myCellnumber);
//			mAdapter.getmData().remove(carDataItem);
			mAdapter.getmData().set(this.myCellnumber++, carDataItem);
			mAdapter.notifyDataSetChanged();
	}
	
	

	@Override
	public void onDragEnter(DragSource source, int x, int y, int xOffset,
			int yOffset, DragShadow dragView, Object dragInfo) {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public void onDragOver(DragSource source, int x, int y, int xOffset,
			int yOffset, DragShadow dragView, Object dragInfo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDragExit(DragSource source, int x, int y, int xOffset,
			int yOffset, DragShadow dragView, Object dragInfo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean acceptDrop(DragSource source, int x, int y, int xOffset,
			int yOffset, DragShadow dragView, Object dragInfo) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Rect estimateDropLocation(DragSource source, int x, int y,
			int xOffset, int yOffset, DragShadow dragView, Object dragInfo,
			Rect recycle) {
		// TODO Auto-generated method stub
		return null;
	}
	
	


	

}
