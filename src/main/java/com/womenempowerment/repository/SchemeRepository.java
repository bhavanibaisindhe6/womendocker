package com.womenempowerment.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.womenempowerment.entity.Scheme;

@Repository
public interface SchemeRepository extends JpaRepository<Scheme,Long>{
	
	public Optional<Scheme> findByschemeName(String schemeName);
	
}
