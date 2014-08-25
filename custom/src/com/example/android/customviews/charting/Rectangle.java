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
	 private Paint textLetter;
	 private Paint textWord;
	 private Paint rectanglePaint;
	 private Paint mShadowPaint;
	 private int textColor;
	 private float rectangleSize;
	 
	 private Bitmap imageBitmap; 
	
	

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
            // Retrieve the values from the TypedArray and store into
            // fields of this class.
            //
            // The R.styleable.PieChart_* constants represent the index for
            // each custom attribute in the R.styleable.PieChart array.
            showImage = a.getBoolean(R.styleable.Rectangle_showImage, false);
            showWord = a.getBoolean(R.styleable.Rectangle_showWord, false);
            showLetter = a.getBoolean(R.styleable.Rectangle_showLetter, false);
            rectangleSize = a.getDimension(R.styleable.Rectangle_rectangleSize,250);
        
        } finally {
            // release the TypedArray so that it can be reused.
            a.recycle();
        }

        init(context);
    }
	private void init(Context context) {
		imageBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.dado);
        rectanglePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        rectanglePaint.setColor(Color.BLACK);
        rectanglePaint.setStyle(Paint.Style.STROKE);
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		   super.onDraw(canvas);
		   
//		   canvas.drawRect(new Rect(40, (int)rectangleSize, (int)rectangleSize, 40), rectanglePaint);
		   canvas.drawRect(new Rect(getLeft(), getTop(), getRight(), getBottom()),rectanglePaint);
		   canvas.drawBitmap(imageBitmap, 0.0f, 0.0f, null);
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
	
	


	

}
