package com.example.android.customviews;

public class Card {
	private String mWord;
	private String mLetter;
	private String mImagePath;
	
	public Card (String letter){
		mLetter =letter;
	}
	
	public Card (String letter, String word, String imagePath){
		mLetter = letter;
		mWord = word;
		mImagePath = imagePath;
	}
	
	public String getLetter() {
		return mLetter;
	}


	public String getWord() {
		return mWord;
	}
	public String getImagePath(){
		return mImagePath;
	}

	

}
