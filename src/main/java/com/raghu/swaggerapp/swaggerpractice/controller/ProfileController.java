package com.raghu.swaggerapp.swaggerpractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raghu.swaggerapp.swaggerpractice.model.Person;

@RestController
@RequestMapping(path = "/")
public class ProfileController {
	
	@Autowired
	private Person person;
	
	/*
	 * @Api -->swagger.annotations.Api
	 * @Apm fesco.commons.monitoring.apm.APM
	 * @ApiResponses -->swagger.annotations.ApiResponse(s)
	 * @ApiParam -->swagger.annotations.ApiParam
	 */
	@GetMapping(value = "/hello", produces = "application/json")
	public Person profileDetails(String name, int age) {
		person.setName(name);
		person.setAge(age);
		person.setProfession("hb");
		return person;
	}
}
