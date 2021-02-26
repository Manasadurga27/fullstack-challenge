package com.codingChallenge.demo.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.bson.codecs.configuration.CodecConfigurationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.codingChallenge.demo.bean.Enrollee;
import com.codingChallenge.demo.exception.EnrolleeException;
import com.codingChallenge.demo.repository.EnrolleeRepository;
import com.codingChallenge.demo.util.CodingChallengeUtil;

@Service
public class EnroleeServiceImpl implements EnrolleeService{
	
	@Autowired
	private MongoTemplate template;
	
	@Autowired
	private EnrolleeRepository enrolleeRepository;

	@Override
	public List<Enrollee> createEnrollee(List<Enrollee> enrolleeList) {
		List<Enrollee> result = null;
		if(!enrolleeList.isEmpty()) {
			
			enrolleeList.forEach(enrollee -> {
				String id = CodingChallengeUtil.getShortGUID();
				enrollee.setId(id);
			});
			result = enrolleeRepository.saveAll(enrolleeList);
		}
		return result;
	}
	
	@Override
	public Enrollee updateEnrollee(Enrollee enrollee, String id) throws EnrolleeException {
		enrollee.setId(id);
		validateEnrollee(enrollee);
		return enrolleeRepository.save(enrollee);
	}

	private void validateEnrollee(Enrollee enrollee) throws EnrolleeException {
		Enrollee existingEnrollee = template.findById(enrollee.getId(), Enrollee.class);
		if(!existingEnrollee.getDateOfBirth().equalsIgnoreCase(enrollee.getDateOfBirth())) {
			throw new EnrolleeException("Cannot update Date of birth.");
		}
		
	}

	@Override
	public Enrollee getEnrolleeById(String id) {
		Enrollee enrollee = template.findById(id,Enrollee.class);
		return enrollee;
	}

	@Override
	public List<Enrollee> getAllEnrollees() {
		return template.findAll(Enrollee.class);		
	}	
}
