package com.ibm.spring_boot_crud_operation.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.spring_boot_crud_operation.dto.User;

@RestController
public class UserController {
	
	
	@RequestMapping(value = "/getTodaysDate")
	public String getTodayDate()
	{
		return LocalDate.now()+"";
	}
	
	@PostMapping(value="/saveUser")
	public User saveUserController(@RequestBody User user)
	{
		System.out.println(user);
		return user;
	}
}
