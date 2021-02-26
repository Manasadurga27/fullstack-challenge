package com.codingChallenge.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingChallenge.demo.bean.Enrollee;
import com.codingChallenge.demo.exception.EnrolleeException;
import com.codingChallenge.demo.serviceimpl.EnroleeServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Validated
@Api(tags = "Enrollee APIs")
@RestController
@RequestMapping(value = "/enrollees")
public class EnroleeController {
	
	@Autowired
	private EnroleeServiceImpl enrolleeServiceImpl;
	
	@PostMapping
	@ApiOperation(value = "Create Enrollee ", notes = "Create Enrollee")
	 public ResponseEntity<List<Enrollee>> createEnrollee(@RequestBody(required = false) List<Enrollee> enrolleeList) {
		List<Enrollee> response = enrolleeServiceImpl.createEnrollee(enrolleeList);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PutMapping(value = "/{id}")
	@ApiOperation(value = "Update Enrollee ", notes = "Update Enrollee")
	 public ResponseEntity<Enrollee> updateEnrolee(@RequestBody Enrollee enrollee, @PathVariable String id) throws EnrolleeException {
		Enrollee response = enrolleeServiceImpl.updateEnrollee(enrollee, id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	

	@GetMapping(value = "/{id}")
	@ApiOperation(value = "Get Enrollee by id", notes = "Get Enrollee by id")
	public ResponseEntity<Enrollee> getEnrolleeByid(@PathVariable String id) {
		Enrollee response = enrolleeServiceImpl.getEnrolleeById(id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping()
	@ApiOperation(value = "Get all Enrollee", notes = "Get all Enrollee")
	public ResponseEntity<List<Enrollee>> getEnrolleeByid() {
		List<Enrollee> response = enrolleeServiceImpl.getAllEnrollees();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
