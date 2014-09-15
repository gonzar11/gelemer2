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



public class Rectangle extends View implements DragSource, DropTarget {
	
	
	private boolean mShowImage, mShowLetter, mShowWord, mDropeable, mAllowDrag;
	private Paint imagePaint;
	private Paint mTextPaint;
	private Paint mTextWord;
	private Paint mRectanglePaint;
	private Paint mShadowPaint;
	private int textColor;
	private float rectangleSize;
	private int textSize;
	private int widthSize,heightSize;
	 
	 private Bitmap imageBitmap; 
	 private int rectangleWidth, rectangleHeight;
	 
	 private String word,letter;
	 
	 public boolean mEmpty = true;
	 public int myCellnumber;
	 public CardViewAdapter mAdapter;
	
	


	public Rectangle(Context context) {
		super(context);
		init(context);
	}
	
	public Rectangle(Context context, AttributeSet attrs) {
        super(context, attrs);

        
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.Rectangle,
                0, 0
        );

        try {
          
            mShowImage = a.getBoolean(R.styleable.Rectangle_showImage, false);
            mShowWord = a.getBoolean(R.styleable.Rectangle_showWord, false);
            mShowLetter = a.getBoolean(R.styleable.Rectangle_showLetter, true);
            mDropeable = a.getBoolean(R.styleable.Rectangle_dropeable, true);
            

         
         } finally {
            a.recycle();
        }

        init(context);
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
		   Rect rectangle = new Rect(2, 2, rectangleHeight, rectangleWidth);
//		   Rect rectangle2 = new Rect(rectangleHeight*0.3, rectangleHeight*0.3, rectangleHeight*0.7, rectangleHeight*0.7);
		   RectF rect = new RectF(rectangleHeight*0.25f, rectangleHeight*0.25f, rectangleHeight*0.75f, rectangleHeight*0.75f);
		   float f=0.3f;
		   
		   
		   canvas.drawRect(rectangle, mRectanglePaint);
		   canvas.drawLine(2, (float) (rectangleHeight*0.2), rectangleWidth, (float) (rectangleHeight*0.2), mRectanglePaint);
		   

		   if (isShowLetter()){
			   canvas.drawText(getLetter(),rectangleWidth/2, (float) (rectangleHeight*0.18), mTextPaint);
		   }
		   if (isShowWord()){
			   canvas.drawText("Auto", rectangleWidth/2, (float) (rectangleHeight*0.93), mTextPaint);
		   }
		   if (isShowImage()){
			   canvas.drawBitmap(imageBitmap, null, rect, null);
		   
		   }
		   
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
    
    public boolean isShowImage(){
    	return mShowImage;
    }
    public boolean isShowLetter(){
    	return mShowLetter;
    }
    public boolean isShowWord(){
    	return mShowWord;
    }
    
    public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getLetter() {
		return letter;
	}

	public void setLetter(String letter) {
		this.letter = letter;
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
		// Hacerle algún efecto a la tarjeta para que resale que fue seleccionada
//		setVisibility(View.GONE);
//		invalidate();
		
	}

	@Override
	public void onDropCompleted(DropTarget target, boolean success) {
		if (success){
			setVisibility(View.VISIBLE);
		}
		
	}

	@Override
	public void onDrop(DragSource source, int x, int y, int xOffset,
			int yOffset, DragShadow dragView, Object dragInfo) {
			
			Rectangle rect = (Rectangle)source;
			rect.setVisibility(GONE);
			Card carDataItem = mAdapter.getmData().get(rect.myCellnumber);
			mAdapter.getmData().remove(carDataItem);
			mAdapter.getmData().add(this.myCellnumber, carDataItem);
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
