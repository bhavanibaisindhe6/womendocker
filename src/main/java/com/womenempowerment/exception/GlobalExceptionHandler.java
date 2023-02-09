package com.womenempowerment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value=TraineeAlreadyExistsException.class)
	public ResponseEntity<String> traineeAlreadyExistsException(TraineeAlreadyExistsException user){
		return new ResponseEntity<>("Trainee already exists in database.Please try again",HttpStatus.CONFLICT);
	}
	@ExceptionHandler(value=TraineeNotPresentException.class)
	public ResponseEntity<String> traineeNotPresentException(TraineeNotPresentException e){
		return new ResponseEntity<>("Trainee doesn't exist in database",HttpStatus.CONFLICT);
	}
	@ExceptionHandler(value=SchemeNotPresentException.class)
	public ResponseEntity<String> schemeNotPresentException(SchemeNotPresentException e){
		return new ResponseEntity<>("Scheme doesn't exist in database",HttpStatus.CONFLICT);
	}
	@ExceptionHandler(value=SchemeAlreadyExistsException.class)
	public ResponseEntity<String> schemeAlreadyExistsException(SchemeAlreadyExistsException user){
		return new ResponseEntity<>("Scheme already exists in database.Please try again",HttpStatus.CONFLICT);
	}
	@ExceptionHandler(value=NGONotPresentException.class)
	public ResponseEntity<String> ngoNotPresentException(NGONotPresentException e){
		return new ResponseEntity<>("NGO doesn't exist in database",HttpStatus.CONFLICT);
	}
	@ExceptionHandler(value=NGOAlreadyExistsException.class)
	public ResponseEntity<String> ngoAlreadyExistsException(NGOAlreadyExistsException user){
		return new ResponseEntity<>("NGO already exists in database.Please try again",HttpStatus.CONFLICT);
	}
	@ExceptionHandler(value=FeedBackNotPresentException.class)
	public ResponseEntity<String> feedBackNotPresentException(FeedBackNotPresentException e){
		return new ResponseEntity<>("FeedBack doesn't exist in database",HttpStatus.CONFLICT);
	}
	@ExceptionHandler(value=FeedBackAlreadyExistsException.class)
	public ResponseEntity<String> feedBackAlreadyExistsException(FeedBackAlreadyExistsException user){
		return new ResponseEntity<>("FeedBack already exists in database.Please try again",HttpStatus.CONFLICT);
	}
	@ExceptionHandler(value=TraineeCourseNotPresentException.class)
	public ResponseEntity<String> traineeCourseNotPresentException(TraineeCourseNotPresentException e){
		return new ResponseEntity<>("Trainee Course doesn't exist in database",HttpStatus.CONFLICT);
	}
	@ExceptionHandler(value=TraineeCourseAlreadyExistsException.class)
	public ResponseEntity<String> traineeCourseAlreadyExistsException(TraineeCourseAlreadyExistsException e){
		return new ResponseEntity<>("Trainee Course already exists in database.Please try again",HttpStatus.CONFLICT);
	}
	
}
