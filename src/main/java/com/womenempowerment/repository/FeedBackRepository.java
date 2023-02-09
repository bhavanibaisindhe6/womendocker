package com.womenempowerment.repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.womenempowerment.entity.FeedBack;

@Repository
public interface FeedBackRepository extends JpaRepository<FeedBack,Long>{
	public List<FeedBack> findByfeedBackDate(LocalDate feedBackDate);
}
