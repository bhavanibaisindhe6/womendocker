package com.womenempowerment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.womenempowerment.entity.Scheme;
import com.womenempowerment.exception.SchemeAlreadyExistsException;
import com.womenempowerment.exception.SchemeNotPresentException;
import com.womenempowerment.repository.SchemeRepository;

@Service
public class SchemeServiceImpl implements SchemeService{

	@Autowired
	private SchemeRepository scRepo;
	
	@Override
	public List<Scheme> getAllSchemes() {
		return scRepo.findAll();
	}

	@Override
	public Optional<Scheme> getById(long schemeId) throws SchemeNotPresentException{
		Optional<Scheme> sch=scRepo.findById(schemeId);
		if(sch.isEmpty()) {
			throw new SchemeNotPresentException();
		}
		return sch;
	}

	@Override
	public Scheme addScheme(Scheme s) throws SchemeAlreadyExistsException{
		if(scRepo.existsById(s.getSchemeId())) {
			throw new SchemeAlreadyExistsException();
		}
		return scRepo.save(s);
	}

	@Override
	public Optional<Scheme> getSchemeByName(String schemeName) throws SchemeNotPresentException{
		Optional<Scheme> sch=scRepo.findByschemeName(schemeName);
		if(sch.isEmpty()) {
			throw new SchemeNotPresentException();
		}
		return sch;
	}

	@Override
	public String deleteScheme(long schemeId) throws SchemeNotPresentException{
		Optional<Scheme> sc=scRepo.findById(schemeId);
		if(sc.isPresent()) {
			scRepo.deleteById(schemeId);
			return "Deleted Successfully";
		}
		throw new SchemeNotPresentException();
	}

	@Override
	public Scheme updateScheme(Scheme s) throws SchemeNotPresentException{
		if(scRepo.existsById(s.getSchemeId())) {
			return scRepo.save(s);
		}
		throw new SchemeNotPresentException();
	}

}
