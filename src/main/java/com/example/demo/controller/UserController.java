package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.UserRepository;
import com.example.demo.domain.User;

@RestController
@RequestMapping("/a")
public class UserController {
	
	@Autowired
	private UserRepository userRepository; 
	
	@RequestMapping(value = "/test", method = RequestMethod.GET, produces = {"application/json"})
	public void getAllUser(){
		System.out.println(userRepository.count());
	}
	
	
	
	
}
