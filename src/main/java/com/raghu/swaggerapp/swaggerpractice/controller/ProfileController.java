package com.raghu.swaggerapp.swaggerpractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raghu.swaggerapp.swaggerpractice.model.Person;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path = "/")
public class ProfileController {

	@Autowired
	private Person person;

	/*
	 * @Api -->swagger.annotations.Api
	 * 
	 * @ApiOperation -->swagger.annotations.ApiOperation;
	 * 
	 * @ApiResponses -->swagger.annotations.ApiResponse(s)
	 * 
	 * @ApiParam -->swagger.annotations.ApiParam
	 */
	@ApiOperation(value = "Person", nickname = "hb details")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "500 custom message"),
			@ApiResponse(code = 404, message = "404 custom message"),
			@ApiResponse(code = 200, message = "200 custom message", response = Person.class, responseContainer = "Person") })
	@GetMapping(value = "/hello/{name}/{age}", produces = "application/json")
	public Person profileDetails(
			@ApiParam(value = "Pass name and age of person here", required = true, defaultValue = "101") @PathVariable("name") String name,
			@PathVariable("age") int age) {
		person.setName(name);
		person.setAge(age);
		person.setProfession("hb");
		return person;
	}
}
