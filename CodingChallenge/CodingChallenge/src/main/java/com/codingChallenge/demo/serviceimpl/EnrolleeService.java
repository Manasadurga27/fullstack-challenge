package com.codingChallenge.demo.serviceimpl;

import java.util.List;

import com.codingChallenge.demo.bean.Enrollee;
import com.codingChallenge.demo.exception.EnrolleeException;

public interface EnrolleeService {
/**
* Looks up all [Enrollee] associated with
* an interview identified by id and returns
* as a List.
*/
public Enrollee getEnrolleeById(String id);
public List<Enrollee> createEnrollee(List<Enrollee> enrolleeList);
public Enrollee updateEnrollee(Enrollee enrollee, String id) throws EnrolleeException;
public List<Enrollee> getAllEnrollees();
}

