package com.womenempowerment.exception;

public class TraineeNotPresentException extends Exception{
	private String msg;

	public TraineeNotPresentException(String msg) {
		super();
		this.msg = msg;
	}

	public TraineeNotPresentException() {
		super();
	}
	
}
