package com.womenempowerment.exception;

public class FeedBackNotPresentException extends Exception{
	private String msg;

	public FeedBackNotPresentException(String msg) {
		super();
		this.msg = msg;
	}

	public FeedBackNotPresentException() {
		super();
	}
	
}
