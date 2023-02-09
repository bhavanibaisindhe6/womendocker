package com.womenempowerment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.womenempowerment.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long>{
	
}
