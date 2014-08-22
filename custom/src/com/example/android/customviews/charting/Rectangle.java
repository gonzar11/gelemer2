package com.example.android.customviews.charting;

import android.content.ClipData.Item;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import com.example.android.customviews.R;

public class Rectangle extends View{
	
	private boolean showImage, showletter, showWord;
	 private Paint imagePaint;
	 private Paint textLetter;
	 private Paint textWord;
	 private Paint rectanglePaint;
	 private Paint mShadowPaint;
	 
	 private int textColor;
	

	public Rectangle(Context context) {
		super(context);
		init();
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
            showletter = a.getBoolean(R.styleable.Rectangle_showLetter, false);
        
        } finally {
            // release the TypedArray so that it can be reused.
            a.recycle();
        }

        init();
    }
	private void init() {
        rectanglePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        rectanglePaint.setColor(Color.BLACK);
        rectanglePaint.setStyle(Paint.Style.FILL);
	}
	protected void onDraw(Canvas canvas) {
		   super.onDraw(canvas);
		   canvas.drawRect(new Rect(0, 100, 200, 0), rectanglePaint);
		   

		

//		   // Draw the label text
//		   canvas.drawText(mData.get(mCurrentItem).mLabel, mTextX, mTextY, mTextPaint);
//
//		   // Draw the pie slices
//		   for (int i = 0; i < mData.size(); ++i) {
//		       Item it = mData.get(i);
//		       mPiePaint.setShader(it.mShader);
//		       canvas.drawArc(mBounds,
//		               360 - it.mEndAngle,
//		               it.mEndAngle - it.mStartAngle,
//		               true, mPiePaint);
//		   }
//
//		   // Draw the pointer
//		   canvas.drawLine(mTextX, mPointerY, mPointerX, mPointerY, mTextPaint);
//		   canvas.drawCircle(mPointerX, mPointerY, mPointerSize, mTextPaint);
		}
	


	

}
