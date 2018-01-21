package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.domain.User;
import com.example.demo.dao.UserRepository;

@RestController
public class HelloWorld {
	
	@Autowired
	private UserRepository userRepository; 
	
	
	@RequestMapping(value="/greetting", method = RequestMethod.GET)
	public String sayHello() {
		
		System.out.println(userRepository.findAll().size());
		
		return "Hellow World!.";
		
	}
	
	@RequestMapping(value="/getUser", method = RequestMethod.GET)
	public ResponseEntity<?> sayHello1() {
		
		List<User>  list= userRepository.findAll();
		
		return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
	}
	
	
}
