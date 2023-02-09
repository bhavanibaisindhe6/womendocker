package com.womenempowerment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.womenempowerment.entity.Trainee;
import com.womenempowerment.entity.TraineeCourse;
import com.womenempowerment.exception.TraineeAlreadyExistsException;
import com.womenempowerment.exception.TraineeNotPresentException;
import com.womenempowerment.repository.TraineeRepository;

@Service
public class TraineeServiceImpl implements TraineeService{

	@Autowired
	private TraineeRepository trRepo;

	@Override
	public String addTrainee(Trainee t) throws TraineeAlreadyExistsException{
		if(trRepo.existsById(t.getTraineeId())) {
			throw new TraineeAlreadyExistsException();
		}
		trRepo.save(t);
		return "Trainee added successfully";
	}

	@Override
	public List<Trainee> getAllTrainee() {
		return trRepo.findAll();
	}

	@Override
	public Optional<Trainee> getTraineeById(long traineeId) throws TraineeNotPresentException{
		Optional<Trainee> tr=trRepo.findById(traineeId);
		if(tr.isEmpty()) {
			throw new TraineeNotPresentException();
		}
		return tr;
	}

	@Override
	public String deleteTrainee(long traineeId) throws TraineeNotPresentException{
		Optional<Trainee> tr=trRepo.findById(traineeId);
		if(tr.isEmpty()) {
			throw new TraineeNotPresentException();
		}
		trRepo.deleteById(traineeId);
		return "Trainee Deleted Successfully";
	}

	@Override
	public Trainee updateTrainee(Trainee s) throws TraineeNotPresentException{
		if(!trRepo.existsById(s.getTraineeId())) {
			throw new TraineeNotPresentException();
		}
		return trRepo.save(s);
	}

	@Override
	public Optional<Trainee> getTraineeByName(String firstName) throws TraineeNotPresentException {
		Optional<Trainee> tr=trRepo.findByfirstName(firstName);
		if(tr.isEmpty()) {
			throw new TraineeNotPresentException();
		}
		return tr;
	}

	@Override
	public Trainee updateTraineeById(Trainee tr, long traineeId) throws TraineeNotPresentException{
		if(trRepo.findById(traineeId).isPresent()) {
	        return trRepo.save(tr);
	     }
	     else
	         throw new TraineeNotPresentException();
		
	}

	@Override
	public Trainee updateCourse(List<TraineeCourse> cr, long traineeId) throws TraineeNotPresentException{
		List<TraineeCourse> list = new ArrayList<>();
        list.addAll(cr);
        if (trRepo.findById(traineeId).isPresent()) {
            Trainee trainee = trRepo.findByTraineeId(traineeId);
            trainee.setCourse(cr);
            trRepo.save(trainee);
            return trainee;
        } else
        	throw new TraineeNotPresentException();
	}

	@Override
	public String loginTrainee(Trainee trainee) {
		Optional<Trainee> a=trRepo.findById(trainee.getTraineeId());
		if(a.isPresent()) {
			if(a.get().getPassword().equals(trainee.getPassword())) {
				return "Login successfull";
			}
		}
		return "Invalid Id or Password";
	}
	
}
