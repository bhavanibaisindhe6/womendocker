package com.womenempowerment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.womenempowerment.entity.TraineeCourse;
import com.womenempowerment.exception.TraineeCourseAlreadyExistsException;
import com.womenempowerment.exception.TraineeCourseNotPresentException;
import com.womenempowerment.repository.TraineeCourseRepository;

@Service
public class TraineeCourseServiceImpl implements TraineeCourseService{
	@Autowired
    private TraineeCourseRepository crRpo;
	
    @Override
    public TraineeCourse addCourse(TraineeCourse cr) throws TraineeCourseAlreadyExistsException{
    	if(crRpo.existsById(cr.getId())) {
    		throw new TraineeCourseAlreadyExistsException();
    	}
        return crRpo.save(cr);
    }
    
    @Override
    public List<TraineeCourse> getAllCourses() {
        return crRpo.findAll();
    }
    
    @Override
    public Optional<TraineeCourse> getByCourseCode(int courseCode) throws TraineeCourseNotPresentException {
       Optional<TraineeCourse> gt = crRpo.findBycourseCode(courseCode);
       if(gt.isEmpty()) {
    	   throw new TraineeCourseNotPresentException();
       }
        return gt;
    }
    
    @Override
    public TraineeCourse updateCourse(TraineeCourse cr) throws TraineeCourseNotPresentException{
    	if(crRpo.existsById(cr.getId())){
    		return crRpo.save(cr);
    	}
        throw new TraineeCourseNotPresentException();
    }
    
    @Override
    public Optional<TraineeCourse> getById(long id) throws TraineeCourseNotPresentException{
        Optional<TraineeCourse> gt=crRpo.findById(id);
        if(gt.isEmpty()) {
        	throw new TraineeCourseNotPresentException();
        }
        return gt;
    }

	@Override
	public String deleteCourse(long id) throws TraineeCourseNotPresentException{
		Optional<TraineeCourse> sc=crRpo.findById(id);
		if(sc.isPresent()) {
			crRpo.deleteById(id);
			return "Deleted Successfully";
		}
		throw new TraineeCourseNotPresentException();
	}
}
