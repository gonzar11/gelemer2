package com.example.android.customviews.charting;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

import com.example.android.customviews.Card;

public class JustWordRenderer implements Renderer {

	@Override
	public void Render(Canvas canvas, int rectangleWidth, int rectangleHeight,
			Paint rectanglePaint, Paint textPaint, Card card) {
		   Rect rectangle = new Rect(2, 2, rectangleHeight, rectangleWidth);

		   RectF rect = new RectF(rectangleHeight*0.25f, rectangleHeight*0.25f, rectangleHeight*0.75f, rectangleHeight*0.75f);
		   
		   
		   
		   canvas.drawRect(rectangle, rectanglePaint);
		   canvas.drawLine(2, (float) (rectangleHeight*0.2), rectangleWidth, (float) (rectangleHeight*0.2), rectanglePaint);
		   		   
		   canvas.drawText(card.getWord(), rectangleWidth/2, (float) (rectangleHeight*0.93), textPaint);


		   
		   }
		
	

}
