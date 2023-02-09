package com.womenempowerment.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.womenempowerment.entity.FeedBack;
import com.womenempowerment.exception.FeedBackAlreadyExistsException;
import com.womenempowerment.exception.FeedBackNotPresentException;
import com.womenempowerment.service.FeedBackService;

@RestController
public class FeedBackController {
	@Autowired
	private FeedBackService feedbackServ;

	/**
	 * 
	 * @param feedback
	 * @return feedback
	 * @throws FeedBackAlreadyExistsException
	 */
	@PostMapping("/addFeedBack")
	public String addFeedBack(@RequestBody FeedBack feedback) throws FeedBackAlreadyExistsException{
		FeedBack adf = feedbackServ.addFeedBack(feedback);
		return "added succesfully"+"\n"+adf;
	}

	/**
	 * 
	 * @return List
	 */
	@GetMapping("/getFeedBack")
	public ResponseEntity<List<FeedBack>> getAllFeedBack(){
		List<FeedBack> feedback = feedbackServ.getAllFeedBack();
		return new ResponseEntity<>(feedback, HttpStatus.ACCEPTED);
	}

	/**
	 * 
	 * @param feedback
	 * @return feedback
	 * @throws FeedBackNotPresentException
	 */
	@PutMapping("/updateFeedBack")
	public ResponseEntity<FeedBack> updateFeedBack(@RequestBody FeedBack feedback) throws FeedBackNotPresentException{
		FeedBack upFeedBack = feedbackServ.updateFeedBack(feedback);
		return new ResponseEntity<>(upFeedBack, HttpStatus.OK);
	}

	/**
	 * 
	 * @param feedBackId
	 * @return string
	 * @throws FeedBackNotPresentException
	 */
	@DeleteMapping("/deleteFeedBack/{feedBackId}")
	public ResponseEntity<String> deleteFeedBackById(@PathVariable long feedBackId) throws FeedBackNotPresentException{
		String feedback = feedbackServ.deleteFeedBackById(feedBackId);
		return new ResponseEntity<>(feedback, HttpStatus.ACCEPTED);
	}

	/**
	 * 
	 * @param feedBackId
	 * @return optional
	 * @throws FeedBackNotPresentException
	 */
	@GetMapping("/getFeedBack/{feedBackId}")
	public ResponseEntity<Optional<FeedBack>> getFeedBackById(@PathVariable long feedBackId) throws FeedBackNotPresentException{
		Optional<FeedBack> feedback = feedbackServ.getFeedBackById(feedBackId);
		return new ResponseEntity<>(feedback, HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param feedBackDate
	 * @return list
	 * @throws FeedBackNotPresentException
	 */
	@GetMapping("/getFeedBackByDate/{feedBackDate}")
	public ResponseEntity<List<FeedBack>> getFeedBackByDate(@PathVariable LocalDate feedBackDate) throws FeedBackNotPresentException{
		List<FeedBack> fb=feedbackServ.getFeedBackByDate(feedBackDate);
		return new ResponseEntity<>(fb,HttpStatus.OK);
	}

	 
}
