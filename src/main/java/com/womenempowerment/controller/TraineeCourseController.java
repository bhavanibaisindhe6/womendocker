package com.womenempowerment.controller;

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

import com.womenempowerment.entity.TraineeCourse;
import com.womenempowerment.exception.TraineeCourseAlreadyExistsException;
import com.womenempowerment.exception.TraineeCourseNotPresentException;
import com.womenempowerment.service.TraineeCourseService;

@RestController
public class TraineeCourseController {
	@Autowired
    private TraineeCourseService tServ;

	/**
	 * 
	 * @param traineeCourse
	 * @return traineeCourse
	 * @throws TraineeCourseAlreadyExistsException
	 */
    @PostMapping("/saveCourse")
    public ResponseEntity<TraineeCourse> addCourse(@RequestBody TraineeCourse cr) throws TraineeCourseAlreadyExistsException {
        TraineeCourse ad = tServ.addCourse(cr);
        return new ResponseEntity<>(ad, HttpStatus.OK);
    }

    /**
     * 
     * @return list
     */
    @GetMapping("/getallCourses")
    public ResponseEntity<List<TraineeCourse>> getAllCourses() {
        List<TraineeCourse> gt = tServ.getAllCourses();
        return new ResponseEntity<>(gt, HttpStatus.ACCEPTED);
    }

    /**
     * 
     * @param courseCode
     * @return optional
     * @throws TraineeCourseNotPresentException
     */
    @GetMapping("/getCourseByCourseCode/{CourseCode}")
    public ResponseEntity<Optional<TraineeCourse>> getByCourseCode(@PathVariable int courseCode) throws TraineeCourseNotPresentException {
        Optional<TraineeCourse> get = tServ.getByCourseCode(courseCode);
        return new ResponseEntity<>(get, HttpStatus.OK);
    }
    
    /**
     * 
     * @param traineeCourse
     * @return traineeCourse
     * @throws TraineeCourseNotPresentException
     */
    @PutMapping("/updateCourses")
    public ResponseEntity<TraineeCourse> updateCourse(@RequestBody TraineeCourse cr) throws TraineeCourseNotPresentException{
        TraineeCourse up = tServ.updateCourse(cr);
        return new ResponseEntity<>(up,HttpStatus.OK);

    }
    
    /**
     * 
     * @param id
     * @return optional
     * @throws TraineeCourseNotPresentException
     */
    @GetMapping("/getCourseById/{id}")
    public ResponseEntity<Optional<TraineeCourse>> getById(@PathVariable long id) throws TraineeCourseNotPresentException{
         Optional<TraineeCourse> get= tServ.getById(id);
         return new ResponseEntity<>(get,HttpStatus.OK);                        
    }
    
    /**
     * 
     * @param id
     * @return string
     * @throws TraineeCourseNotPresentException
     */
    @DeleteMapping("/deleteCourse/{id}")
	public ResponseEntity<String> deleteCourse(@PathVariable long id) throws TraineeCourseNotPresentException{
		String s=tServ.deleteCourse(id);
		return new ResponseEntity<>(s,HttpStatus.OK);
	}
}
