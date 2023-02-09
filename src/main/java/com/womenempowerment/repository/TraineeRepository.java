package com.womenempowerment.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.womenempowerment.entity.Trainee;

@Repository
public interface TraineeRepository extends JpaRepository<Trainee,Long>{
	
	public Optional<Trainee> findByfirstName(String firstName);
	
	public Trainee findByTraineeId(long traineeId);
}
