package com.womenempowerment.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.womenempowerment.entity.NGO;

@Repository
public interface NGORepository extends JpaRepository<NGO,Long>{
	
	public Optional<NGO> findByngoName(String ngoName);
}
