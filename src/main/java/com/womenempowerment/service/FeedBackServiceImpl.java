package com.womenempowerment.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.womenempowerment.entity.FeedBack;
import com.womenempowerment.exception.FeedBackAlreadyExistsException;
import com.womenempowerment.exception.FeedBackNotPresentException;
import com.womenempowerment.repository.FeedBackRepository;

@Service
public class FeedBackServiceImpl implements FeedBackService{
	
	@Autowired
	private FeedBackRepository feedbackRepo;

	@Override
	public FeedBack addFeedBack(FeedBack feedback) throws FeedBackAlreadyExistsException{
		if(feedbackRepo.existsById(feedback.getFeedBackId())) {
			throw new FeedBackAlreadyExistsException();
		}
		return feedbackRepo.save(feedback);
	}

	@Override
	public List<FeedBack> getAllFeedBack() {
		return feedbackRepo.findAll();
	}

	@Override
	public FeedBack updateFeedBack(FeedBack feedback) throws FeedBackNotPresentException{
		if(feedbackRepo.existsById(feedback.getFeedBackId())) {
			return feedbackRepo.save(feedback);
		}
		throw new FeedBackNotPresentException();
	}

	@Override
	public String deleteFeedBackById(long feedBackId) throws FeedBackNotPresentException{
		Optional<FeedBack> feedback = feedbackRepo.findById(feedBackId);
		if (feedback.isPresent()) {
			feedbackRepo.deleteById(feedBackId);
			return "deleted succesfully";
		}

		throw new FeedBackNotPresentException();
	}

	@Override
	public Optional<FeedBack> getFeedBackById(long feedBackId) throws FeedBackNotPresentException{
		Optional<FeedBack> feedback = feedbackRepo.findById(feedBackId);
		if(feedback.isEmpty()) {
			throw new FeedBackNotPresentException();
		}
		return feedback;
	}

	@Override
	public List<FeedBack> getFeedBackByDate(LocalDate feedBackDate) throws FeedBackNotPresentException{
		List<FeedBack> feedback=feedbackRepo.findByfeedBackDate(feedBackDate);
		if(feedback.isEmpty()) {
			throw new FeedBackNotPresentException();
		}
		return feedback;
	}
}
