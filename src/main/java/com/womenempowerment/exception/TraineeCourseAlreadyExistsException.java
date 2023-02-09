package com.womenempowerment.exception;

public class TraineeCourseAlreadyExistsException extends Exception{
	
	private String msg;

	public TraineeCourseAlreadyExistsException(String msg) {
		super();
		this.msg = msg;
	}

	public TraineeCourseAlreadyExistsException() {
		super();
	}
}
