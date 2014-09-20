package com.example.android.customviews.charting;

import com.example.android.customviews.Card;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

public interface Renderer {
	
	
	public void Render(Canvas canvas, int rectangleWidth, int rectangleHeight,
			Paint rectanglePaint, Paint textPaint, Card card);
		   

		
}


