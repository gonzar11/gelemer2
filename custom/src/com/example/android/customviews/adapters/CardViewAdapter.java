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
import com.example.android.customviews.charting.Rectangle;

public class CardViewAdapter extends BaseAdapter {
	 List<Card> mData = new ArrayList<Card>();
	 
	 
	public List<Card> getmData() {
		return mData;
	}
	public void setmData(List<Card> mData) {
		this.mData = mData;
	}

	private Context mContext;
	private View.OnDragListener mDragListener;

	public CardViewAdapter(List<Card> data, Context context) {
		mData = data;
		mContext = context;
	}
	public CardViewAdapter(List<Card> data, Context context, View.OnDragListener dragListener) {
		mData = data;
		mContext = context;
		mDragListener = dragListener;
	}

	@Override
	public int getCount() {
		return mData.size();
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
		Card dataCard = mData.get(position);
		Rectangle card = (Rectangle) view.findViewById(R.id.Rectangle1);
		card.myCellnumber = position;
		card.mAdapter = this;
		
		card.setLetter(dataCard.getmLetter());
		card.setOnTouchListener ((View.OnTouchListener) mContext);
		card.setOnClickListener ((View.OnClickListener) mContext);
		card.setOnLongClickListener ((View.OnLongClickListener) mContext);
		  
		  
		  

		   
		return view;
		
	}

}
