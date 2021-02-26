package com.codingChallenge.demo.bean;

import org.springframework.data.annotation.Id;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Enrollee {

	@Id
	private String id;
	@ApiModelProperty(required = true)
	private String name;
	private String dateOfBirth;
	@ApiModelProperty(required = true)
	private Boolean active;
}
