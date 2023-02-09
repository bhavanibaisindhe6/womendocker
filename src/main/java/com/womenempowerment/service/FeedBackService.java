package com.womenempowerment.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.womenempowerment.entity.FeedBack;
import com.womenempowerment.exception.FeedBackAlreadyExistsException;
import com.womenempowerment.exception.FeedBackNotPresentException;

public interface FeedBackService {

	FeedBack addFeedBack(FeedBack feedback) throws FeedBackAlreadyExistsException;

	List<FeedBack> getAllFeedBack();

	FeedBack updateFeedBack(FeedBack feedback) throws FeedBackNotPresentException;

	String deleteFeedBackById(long feedBackId) throws FeedBackNotPresentException;

	Optional<FeedBack> getFeedBackById(long feedBackId) throws FeedBackNotPresentException;

	List<FeedBack> getFeedBackByDate(LocalDate feedBackDate) throws FeedBackNotPresentException;
}
