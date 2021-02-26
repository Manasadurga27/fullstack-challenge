package com.codingChallenge.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.codingChallenge.demo.bean.Enrollee;

public interface EnrolleeRepository extends MongoRepository<Enrollee, String>{

}
