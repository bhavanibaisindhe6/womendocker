package com.womenempowerment.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.womenempowerment.entity.TraineeCourse;

@Repository
public interface TraineeCourseRepository extends JpaRepository<TraineeCourse,Long>{
	public Optional<TraineeCourse> findBycourseCode(int courseCode);
}
