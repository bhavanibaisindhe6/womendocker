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

import com.womenempowerment.entity.TraineeCourse;
import com.womenempowerment.exception.TraineeCourseAlreadyExistsException;
import com.womenempowerment.exception.TraineeCourseNotPresentException;
import com.womenempowerment.repository.TraineeCourseRepository;
import com.womenempowerment.service.TraineeCourseServiceImpl;

@ExtendWith(MockitoExtension.class)
class TraineeCourseServiceTest {

	@InjectMocks
	private TraineeCourseServiceImpl traineeCourseServiceImpl;

	@Mock
	private TraineeCourseRepository traineeCourseRepository;

	/**
	 * This test case accepts the course 
	 * @throws TraineeCourseAlreadyExistsException
	 */
	@Test
	void addCourse() throws TraineeCourseAlreadyExistsException {

		TraineeCourse cr = new TraineeCourse(1, 2, "abc", 3, LocalDate.of(2022, 1, 13), LocalDate.now());
		when(traineeCourseRepository.save(any())).thenReturn(cr);
		TraineeCourse addCourse = traineeCourseServiceImpl.addCourse(cr);
		Assertions.assertEquals(cr.getId(), addCourse.getId());

	}

	/**
	 * Checking all the courses will we viewed
	 */
	@Test
    void getAllCourses(){

        when(traineeCourseRepository.findAll()).thenReturn((List<TraineeCourse>) Stream.of(new TraineeCourse(2, 13, "bhn", 4, LocalDate.of(2022, 1, 12), LocalDate.now()))
                  .collect(Collectors.toList()));
        Assertions.assertEquals(1, traineeCourseServiceImpl.getAllCourses().size());

        }

	/**
	 * In this test case the course is updates the course which is already present
	 * @throws TraineeCourseNotPresentException
	 */
	@Test
	void updateCourse_success() throws TraineeCourseNotPresentException {

		TraineeCourse cr = new TraineeCourse(1, 15, "pavani", 6, LocalDate.of(2022, 1, 16), LocalDate.now());
		when(traineeCourseRepository.existsById((long) 1)).thenReturn(true);
		when(traineeCourseRepository.save(any())).thenReturn(cr);
		TraineeCourse upcr = traineeCourseServiceImpl.updateCourse(cr);
		Assertions.assertEquals(1, upcr.getId());

	}

	/**
	 * This test case checks the exception is thrown at the time updating the course which is not present
	 * @throws TraineeCourseNotPresentException
	 */
	@Test
	void updateCourse_exception() throws TraineeCourseNotPresentException {
		TraineeCourse cr = new TraineeCourse(1, 15, "pavani", 6, LocalDate.of(2022, 1, 16), LocalDate.now());
		when(traineeCourseRepository.existsById((long) 1)).thenReturn(false);
		Assertions.assertThrows(TraineeCourseNotPresentException.class,
				() -> traineeCourseServiceImpl.updateCourse(cr));
	}

}