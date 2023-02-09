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

import com.womenempowerment.entity.NGO;
import com.womenempowerment.exception.NGOAlreadyExistsException;
import com.womenempowerment.exception.NGONotPresentException;
import com.womenempowerment.service.NGOService;

@RestController
public class NGOController {
	@Autowired
    private NGOService ngoService;

	/**
	 * 
	 * @return list
	 */
    @GetMapping("/getAllNGOs")
    public ResponseEntity<List<NGO>> getAllNGOs() {
        return new ResponseEntity<>(ngoService.getAllNGOs(), HttpStatus.OK);
    }

    /**
     * 
     * @param id
     * @return optional
     * @throws NGONotPresentException
     */
    @GetMapping("/getNGOById/{id}")
    public ResponseEntity<Optional<NGO>> getNGOById(@PathVariable long id) throws NGONotPresentException{
    	Optional<NGO> ngo=ngoService.getNGOById(id);
    	return new ResponseEntity<>(ngo, HttpStatus.OK);	 
    }

    /**
     * 
     * @param ngo
     * @return ngo
     * @throws NGOAlreadyExistsException
     */
    @PostMapping("/addNGO")
    public ResponseEntity<NGO> addNGO(@RequestBody NGO ngo) throws NGOAlreadyExistsException{
        return new ResponseEntity<>(ngoService.addNGO(ngo), HttpStatus.CREATED);
    }

    /**
     * 
     * @param ngo
     * @return ngo
     * @throws NGONotPresentException
     */
    @PutMapping("/updateNGO")
    public ResponseEntity<NGO> updateNGO(@RequestBody NGO ngo) throws NGONotPresentException{
    	return new ResponseEntity<>(ngoService.updateNGO(ngo), HttpStatus.OK);
    }

    /**
     * 
     * @param id
     * @return string
     * @throws NGONotPresentException
     */
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteNGO(@PathVariable long id) throws NGONotPresentException{
    	String s=ngoService.deleteNGO(id);
    	return new ResponseEntity<>(s,HttpStatus.OK); 
    }
    
    /**
     * 
     * @param ngoName
     * @return optional
     * @throws NGONotPresentException
     */
    @GetMapping("/getNGOByName/{ngoName}")
    public ResponseEntity<Optional<NGO>> getNGOByName(@PathVariable String ngoName) throws NGONotPresentException{
    	Optional<NGO> ngo=ngoService.getNGOByName(ngoName);
    	return new ResponseEntity<>(ngo, HttpStatus.OK);	 
    }
}
