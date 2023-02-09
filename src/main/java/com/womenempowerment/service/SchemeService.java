package com.womenempowerment.service;

import java.util.List;
import java.util.Optional;

import com.womenempowerment.entity.Scheme;
import com.womenempowerment.exception.SchemeAlreadyExistsException;
import com.womenempowerment.exception.SchemeNotPresentException;

public interface SchemeService {

	List<Scheme> getAllSchemes();
	
	Optional<Scheme> getById(long schemeId) throws SchemeNotPresentException;
	
	Scheme addScheme(Scheme s) throws SchemeAlreadyExistsException;
	
	Optional<Scheme> getSchemeByName(String schemeName) throws SchemeNotPresentException;
	
	String deleteScheme(long schemeId) throws SchemeNotPresentException;
	
	Scheme updateScheme(Scheme s) throws SchemeNotPresentException;
}
