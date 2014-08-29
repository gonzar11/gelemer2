package com.example.android.customviews.charting;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import com.example.android.customviews.R;

public class Rectangle extends View{
	
	private boolean showImage, showLetter, showWord;
	 private Paint imagePaint;
	 private Paint textPaint;
	 private Paint textWord;
	 private Paint rectanglePaint;
	 private Paint mShadowPaint;
	 private int textColor;
	 private float rectangleSize;
	 private int textSize;
	 private int widthSize,heightSize;
	 
	 private Bitmap imageBitmap; 
	 
	 private String word,letter;
	
	


	public Rectangle(Context context) {
		super(context);
		init(context);
		// TODO Auto-generated constructor stub
	}
	
	public Rectangle(Context context, AttributeSet attrs) {
        super(context, attrs);

        // attrs contains the raw values for the XML attributes
        // that were specified in the layout, which don't include
        // attributes set by styles or themes, and which may have
        // unresolved references. Call obtainStyledAttributes()
        // to get the final values for each attribute.
        //
        // This call uses R.styleable.PieChart, which is an array of
        // the custom attributes that were declared in attrs.xml.
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.Rectangle,
                0, 0
        );

        try {
          
            showImage = a.getBoolean(R.styleable.Rectangle_showImage, false);
            showWord = a.getBoolean(R.styleable.Rectangle_showWord, false);
            showLetter = a.getBoolean(R.styleable.Rectangle_showLetter, false);
       
            textSize = a.getInteger(R.styleable.Rectangle_textSize, 200);
        
        } finally {
            // release the TypedArray so that it can be reused.
            a.recycle();
        }

        init(context);
    }
	private void init(Context context) {
		
		widthSize = 200;
		heightSize = 200;
		
		imageBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.dado);
        rectanglePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        rectanglePaint.setColor(Color.BLACK);
        rectanglePaint.setStyle(Paint.Style.STROKE);
        
        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(23);
  
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		   super.onDraw(canvas);
//		   Rect rectangle = new Rect(40, 40, getRight(), getBottom());
		   Rect rectangle = new Rect(0, 0, getMeasuredHeight(), getMeasuredWidth());
		   
		   
		   canvas.drawRect(rectangle, rectanglePaint);
		   canvas.drawLine(0, 40, getMeasuredWidth(), 40, rectanglePaint);

//		   canvas.drawRect(new Rect(getLeft(), getTop(), getRight(), getBottom()),rectanglePaint);
//		   canvas.drawBitmap(imageBitmap, null, rectangle, null);
//		   canvas.drawBitmap(imageBitmap, 0.0f, 0.0f, null);
		   if (showLetter){
			   canvas.drawText("A", 100, 90, textPaint);
		   }
		   
		   if (showWord){
			   canvas.drawText(word, 100, 140, textPaint);
		   }
		   if (showImage){
			   canvas.drawBitmap(imageBitmap, null, rectangle, null);
			   
			   
		   }
		   
	}
	@Override 
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
//	   int parentWidth = MeasureSpec.getSize(widthMeasureSpec);
//	   int parentHeight = MeasureSpec.getSize(heightMeasureSpec);
//	   this.setMeasuredDimension(parentWidth/2, parentHeight);
//	   this.setLayoutParams(new *ParentLayoutType*.LayoutParams(parentWidth/2,parentHeight));
	   super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	   setMeasuredDimension(widthSize, heightSize);
	}
 
	@Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

    }
    
    public boolean isShowImage(){
    	return showImage;
    }
    public boolean isShowLetter(){
    	return showLetter;
    }
    public boolean isShowWord(){
    	return showWord;
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
	
	


	

}
