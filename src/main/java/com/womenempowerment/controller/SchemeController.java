package com.womenempowerment.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.womenempowerment.entity.Scheme;
import com.womenempowerment.exception.SchemeAlreadyExistsException;
import com.womenempowerment.exception.SchemeNotPresentException;
import com.womenempowerment.service.SchemeService;

@RestController
public class SchemeController {

	@Autowired
	private SchemeService schServ;
	/**
	 * 
	 * @param scheme
	 * @return scheme
	 * @throws SchemeAlreadyExistsException
	 */
	@PostMapping("/addScheme")
	public String addSchemes(@RequestBody Scheme s) throws SchemeAlreadyExistsException{
		Scheme sc=schServ.addScheme(s);
		return "Saved Successfully"+"\n"+sc;
	}
	
	/**
	 * 
	 * @return list
	 */
	@GetMapping("/getAllSchemes")
	public ResponseEntity<List<Scheme>> getAllSchemes(){
		List<Scheme> list=schServ.getAllSchemes();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param schemeId
	 * @return optional
	 * @throws SchemeNotPresentException
	 */
	@GetMapping("/getSchemeById/{schemeId}")
	public ResponseEntity<Optional<Scheme>> getById(@PathVariable long schemeId) throws SchemeNotPresentException{
		Optional<Scheme> sch=schServ.getById(schemeId);
		return new ResponseEntity<>(sch,HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param schemeName
	 * @return optional
	 * @throws SchemeNotPresentException
	 */
	@GetMapping("/getSchemeByName/{schemeName}")
	public ResponseEntity<Optional<Scheme>> getSchemeByName(@PathVariable String schemeName) throws SchemeNotPresentException{
		Optional<Scheme> sch=schServ.getSchemeByName(schemeName);
		return new ResponseEntity<>(sch,HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param schemeId
	 * @return string
	 * @throws SchemeNotPresentException
	 */
	@DeleteMapping("/deleteScheme/{schemeId}")
	public ResponseEntity<String> deleteScheme(@PathVariable long schemeId) throws SchemeNotPresentException{
		String s=schServ.deleteScheme(schemeId);
		return new ResponseEntity<>(s,HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param scheme
	 * @return scheme
	 * @throws SchemeNotPresentException
	 */
	@PutMapping("/updateScheme")
	public ResponseEntity<Scheme> updateScheme(@RequestBody Scheme s) throws SchemeNotPresentException{
		Scheme sch=schServ.updateScheme(s);
		return new ResponseEntity<>(sch,HttpStatus.OK);
	}
	
}
