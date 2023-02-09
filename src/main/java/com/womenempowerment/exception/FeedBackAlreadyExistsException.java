package com.womenempowerment.exception;

public class FeedBackAlreadyExistsException extends Exception{
	private String msg;

	public FeedBackAlreadyExistsException(String msg) {
		super();
		this.msg = msg;
	}

	public FeedBackAlreadyExistsException() {
		super();
	}
	
}
