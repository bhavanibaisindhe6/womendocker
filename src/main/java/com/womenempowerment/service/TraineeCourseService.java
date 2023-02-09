package com.womenempowerment.service;

import java.util.List;
import java.util.Optional;

import com.womenempowerment.entity.TraineeCourse;
import com.womenempowerment.exception.TraineeCourseAlreadyExistsException;
import com.womenempowerment.exception.TraineeCourseNotPresentException;

public interface TraineeCourseService {
	
	TraineeCourse addCourse(TraineeCourse cr) throws TraineeCourseAlreadyExistsException;

	List<TraineeCourse> getAllCourses();

	Optional<TraineeCourse> getByCourseCode(int courseCode) throws TraineeCourseNotPresentException;

	TraineeCourse updateCourse(TraineeCourse cr) throws TraineeCourseNotPresentException;

	Optional<TraineeCourse> getById(long id) throws TraineeCourseNotPresentException;
	
	String deleteCourse(long id) throws TraineeCourseNotPresentException;
}
