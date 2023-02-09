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

import com.womenempowerment.entity.Trainee;
import com.womenempowerment.entity.TraineeCourse;
import com.womenempowerment.exception.TraineeAlreadyExistsException;
import com.womenempowerment.exception.TraineeNotPresentException;
import com.womenempowerment.service.TraineeService;

@RestController
public class TraineeController {
	@Autowired
	private TraineeService trSrv;
	
	/**
	 * 
	 * @param trainee
	 * @return trainee
	 * @throws TraineeAlreadyExistsException
	 */
	@PostMapping("/saveTrainee")
    public String addTrainee(@RequestBody Trainee tr) throws TraineeAlreadyExistsException{
        return trSrv.addTrainee(tr);
    }
	
	/**
	 * 
	 * @return list
	 */
	@GetMapping("/getAllTrainee")
	public ResponseEntity<List<Trainee>> getAllTrainee(){
		List<Trainee> t=trSrv.getAllTrainee();
		return new ResponseEntity<>(t,HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param traineeId
	 * @return optional
	 * @throws TraineeNotPresentException
	 */
	@GetMapping("/getTraineeById/{traineeId}")
	public ResponseEntity<Optional<Trainee>> getTraineeById(@PathVariable long traineeId) throws TraineeNotPresentException{
		Optional<Trainee> t=trSrv.getTraineeById(traineeId);
		return new ResponseEntity<>(t,HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param traineeId
	 * @return string
	 * @throws TraineeNotPresentException
	 */
	@DeleteMapping("/deleteTrainee/{traineeId}")
	public ResponseEntity<String> deleteTrainee(@PathVariable long traineeId) throws TraineeNotPresentException{
		String s=trSrv.deleteTrainee(traineeId);
		return new ResponseEntity<>(s,HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param trainee
	 * @return trainee
	 * @throws TraineeNotPresentException
	 */
	@PutMapping("/updateTrainee")
	public ResponseEntity<Trainee> updateTrainee(@RequestBody Trainee s) throws TraineeNotPresentException{
		Trainee sch=trSrv.updateTrainee(s);
		return new ResponseEntity<>(sch,HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param firstName
	 * @return optional
	 * @throws TraineeNotPresentException
	 */
	@GetMapping("/getTraineeByName/{firstName}")
	public ResponseEntity<Optional<Trainee>> getTraineeByName(@PathVariable String firstName) throws TraineeNotPresentException{
		Optional<Trainee> t=trSrv.getTraineeByName(firstName);
		return new ResponseEntity<>(t,HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param trainee
	 * @param traineeId
	 * @return trainee
	 * @throws TraineeNotPresentException
	 */
	@PutMapping("/updateTraineeNyId/{traineeId}")
    public ResponseEntity<Trainee> updateTraineeById(@RequestBody Trainee tr,@PathVariable long traineeId) throws TraineeNotPresentException{
        Trainee upCourse = trSrv.updateTraineeById(tr,traineeId);
        return new ResponseEntity<>(upCourse,HttpStatus.OK);            
    }
	
	/**
	 * 
	 * @param list of courses
	 * @param traineeId
	 * @return trainee
	 * @throws TraineeNotPresentException
	 */
	@PutMapping("/updateCourse/{traineeId}")
    public ResponseEntity<Trainee> updateCourse(@RequestBody List<TraineeCourse> cr,@PathVariable long traineeId) throws TraineeNotPresentException{
        Trainee t = trSrv.updateCourse(cr,traineeId);
        return new ResponseEntity<>(t,HttpStatus.OK);

    }
	
	/**
	 * 
	 * @param trainee
	 * @return string
	 */
	@PostMapping("/loginTrainee")
	public ResponseEntity<String> loginAdmin(@RequestBody Trainee trainee) {
		String s = trSrv.loginTrainee(trainee);
		return new ResponseEntity<>(s, HttpStatus.OK);
	}

}
