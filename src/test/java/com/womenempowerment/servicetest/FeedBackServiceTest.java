package com.womenempowerment.servicetest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.womenempowerment.entity.FeedBack;
import com.womenempowerment.exception.FeedBackAlreadyExistsException;
import com.womenempowerment.exception.FeedBackNotPresentException;
import com.womenempowerment.repository.FeedBackRepository;
import com.womenempowerment.service.FeedBackServiceImpl;

@ExtendWith(MockitoExtension.class)
class FeedBackServiceTest {

    @InjectMocks
    private FeedBackServiceImpl feedbackServiceImpl;

    @Mock
    private FeedBackRepository feedbackrepository;

    /**
     * Adding the feedback
     * @throws FeedBackAlreadyExistsException
     */
    @Test
    void test_feedback() throws FeedBackAlreadyExistsException {
        FeedBack feedBack = new FeedBack(6, 12, "good", "Java", LocalDate.now());
        when(feedbackrepository.save(any())).thenReturn(feedBack);
        FeedBack savedData = feedbackServiceImpl.addFeedBack(feedBack);
        Assertions.assertEquals(feedBack.getFeedBackId(), savedData.getFeedBackId());
    }

    /**
     * Test case for viewing all the feedbacks
     * @throws FeedBackNotPresentException
     */
    @Test
    void getAllFeedBack() throws FeedBackNotPresentException {

        when(feedbackrepository.findAll()).thenReturn((List<FeedBack>) Stream.of(new FeedBack(1, 11, "bad", "aafd", LocalDate.now()))
                .collect(Collectors.toList()));
        Assertions.assertEquals(1, feedbackServiceImpl.getAllFeedBack().size());
    }

    /**
     * In this test case updating feedback which is already present
     * @throws FeedBackNotPresentException
     */
	@Test
	void updateFeedBack_success() throws FeedBackNotPresentException {

		FeedBack FeedBack = new FeedBack(6, 15, "better", "javaa", LocalDate.now());
		when(feedbackrepository.existsById((long) 6)).thenReturn(true);
		FeedBack upFeedBack = feedbackServiceImpl.updateFeedBack(FeedBack);
		Assertions.assertEquals(6, FeedBack.getFeedBackId());

	}

	/**
	 * It throws the exception when updating feedback which is not present
	 * @throws FeedBackNotPresentException
	 */
	@Test
	void updateFeedBack_exception() throws FeedBackNotPresentException {
		FeedBack FeedBack = new FeedBack(6, 15,"better", "javaa", LocalDate.now());
		when(feedbackrepository.existsById((long) 6)).thenReturn(false);
		Assertions.assertThrows(FeedBackNotPresentException.class, () -> feedbackServiceImpl.updateFeedBack(FeedBack));
	}
}