package com.womenempowerment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.womenempowerment.entity.Admin;
import com.womenempowerment.service.AdminService;


@RestController
public class AdminController {	
	
	@Autowired
	private AdminService adService;
	/**
	 * 
	 * @param Admin object s
	 * @return String
	 */
	@PostMapping("/saveAdmin")
	public String saveAdmin(@RequestBody Admin s){
		Admin sc=adService.saveAdmin(s);
		return "Saved Successfully"+"\n"+sc;
	}
	
	/**
	 * 
	 * @param Admin object ad
	 * @return String
	 */
	@PostMapping("/loginAdmin")
	public ResponseEntity<String> loginAdmin(@RequestBody Admin ad) {
		String s = adService.loginAdmin(ad);
		return new ResponseEntity<>(s, HttpStatus.OK);
	}
}
