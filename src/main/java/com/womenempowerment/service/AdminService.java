package com.womenempowerment.service;

import com.womenempowerment.entity.Admin;

public interface AdminService{
	
	String loginAdmin(Admin ad);

	Admin saveAdmin(Admin s);
}
