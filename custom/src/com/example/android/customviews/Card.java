package com.example.android.customviews;

public class Card {
	private String mWord;
	private String mLetter;
	
	
	public String getmLetter() {
		return mLetter;
	}


	public void setmLetter(String mLetter) {
		this.mLetter = mLetter;
	}


	public Card (String letter){
		mLetter =letter;
	}

}
