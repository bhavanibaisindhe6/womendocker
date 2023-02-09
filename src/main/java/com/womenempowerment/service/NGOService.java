package com.womenempowerment.service;

import java.util.List;
import java.util.Optional;

import com.womenempowerment.entity.NGO;
import com.womenempowerment.exception.NGOAlreadyExistsException;
import com.womenempowerment.exception.NGONotPresentException;

public interface NGOService {
	
	List<NGO> getAllNGOs();
    
    NGO addNGO(NGO ngo) throws NGOAlreadyExistsException;
    
    NGO updateNGO(NGO ngo) throws NGONotPresentException;
    
    String deleteNGO(long id) throws NGONotPresentException;

	Optional<NGO> getNGOById(long id) throws NGONotPresentException;
	
	Optional<NGO> getNGOByName(String ngoName) throws NGONotPresentException;
}
