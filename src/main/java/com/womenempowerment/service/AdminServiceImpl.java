package com.womenempowerment.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.womenempowerment.entity.Admin;
import com.womenempowerment.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminRepository adRepo;
	
	
	@Override
	public String loginAdmin(Admin ad) {
		Optional<Admin> a=adRepo.findById(ad.getId());
		if(a.isPresent()) {
			if(a.get().getAdminPassword().equals(ad.getAdminPassword())) {
				return "Login successfull";
			}
		}
		return "Invalid Id or Password";
	}

	@Override
	public Admin saveAdmin(Admin s) {
		
		return adRepo.save(s);
	}
	
}
