package com.womenempowerment.exception;

public class NGOAlreadyExistsException extends Exception{
	private String msg;
	public NGOAlreadyExistsException(String msg) {
		super();
		this.msg = msg;
	}
	public NGOAlreadyExistsException() {
		super();
	}
}
