package com.ibm.spring_boot_crud_operation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.spring_boot_crud_operation.dao.UserDao;
import com.ibm.spring_boot_crud_operation.dto.User;

@RestController
public class UserController {
	
	@Autowired
	UserDao dao;
	
	/*@RequestMapping(value = "/getTodaysDate")
	public String getTodayDate()
	{
		return LocalDate.now()+"";
	}*/
	
	/*@PostMapping(value="/saveUser")
	public User saveUserController(@RequestBody User user)
	{
		System.out.println(user);
		return user;
	}*/
	
	@PostMapping(value="/saveUser")
	public User saveUserController(@RequestBody User user)
	{
		return dao.saveUserDao(user);
	}
	
	@GetMapping(value="/findById/{id}")
	public User findUserByIdController(@PathVariable int id)
	{
		return dao.findUserByIdDao(id);
	}
	
	
	public List<User> findAllUserController(){
		return dao.findAllUserDao();
	}
	
	@GetMapping(value="findUserByName/{name}")
	public List<User> findByNameController( @PathVariable String name){
		return dao.findByNameDao(name);
	}
	
	@GetMapping(value="findByIdDesc/{name}")
	public List<User> findByNameOrderByIdDesc(@PathVariable String name)
	{
		return dao.findByNameOrderByIdDesc(name);
	}
	
	@GetMapping(value="findByEmail/{email}")
	public User getUserByEmaiUser(@PathVariable String email)
	{
		return dao.getUserByEmaiUser(email);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
