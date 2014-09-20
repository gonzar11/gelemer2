package com.example.android.customviews.adapters;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.android.customviews.Card;
import com.example.android.customviews.R;
import com.example.android.customviews.charting.CardView;
import com.example.android.customviews.charting.EmptyRenderer;
import com.example.android.customviews.charting.Renderer;

public class CardViewAdapter extends BaseAdapter {
	 private List<Card> mData = new ArrayList<Card>();
	 private Renderer mRenderer;
	 private Renderer mEmptyRenderer;
	 int j =1;
	 
	 
	 
	public List<Card> getmData() {
		return mData;
	}
	public void setmData(List<Card> mData) {
		this.mData = mData;
	}

	private Context mContext;
	private View.OnDragListener mDragListener;

	public CardViewAdapter(List<Card> data, Context context, Renderer renderer) {
		mData = data;
		mContext = context;
		mRenderer = renderer;
		mEmptyRenderer = new EmptyRenderer();
	}


	@Override
	public int getCount() {
		return mData.size();
//		return 9;
	}

	@Override
	public Object getItem(int position) {
		return mData.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view;
		
		
		if (convertView == null){
			LayoutInflater inflater = (LayoutInflater) mContext
			        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			  		view = inflater.inflate(R.layout.grid_row, parent, false);
		} else {
			view = convertView;
		}
		
		
		
		CardView cardView = (CardView) view;
//		if (position % 2 != 0){
//			cardView.setRenderer(mEmptyRenderer);
//			return cardView;
//		}
//		int pos = position - j + 1;
		Card dataCard = mData.get(position);
		
		cardView.myCellnumber = position;
		cardView.mAdapter = this;
		cardView.setCard(dataCard);
		cardView.setRenderer(mRenderer);
		

		cardView.setOnTouchListener ((View.OnTouchListener) mContext);
		cardView.setOnClickListener ((View.OnClickListener) mContext);
		cardView.setOnLongClickListener ((View.OnLongClickListener) mContext);
		j++;
		  
		  
		  

		   
		return view;
		
	}

}
