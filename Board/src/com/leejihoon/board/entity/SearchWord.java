package com.leejihoon.board.entity;

// 검색어 / 이전 검색어 / 다음 검색어

public class SearchWord {
	
	private String word;
	private String preword;
	private String nextword;
	
	public SearchWord(String word, String preword, String nextword) {
		this.word = word;
		this.preword = preword;
		this.nextword = nextword;
	}

	public String getWord() {
		return word;
	}

	public String getPreword() {
		return preword;
	}

	public String getNextword() {
		return nextword;
	}
	
	
	
}
