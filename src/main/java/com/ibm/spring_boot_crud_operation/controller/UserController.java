package com.ibm.spring_boot_crud_operation.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.spring_boot_crud_operation.dao.UserDao;
import com.ibm.spring_boot_crud_operation.dto.User;
import com.ibm.spring_boot_crud_operation.response.ResponseStructure;
import com.ibm.spring_boot_crud_operation.response.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService service;

	@Autowired
	UserDao dao;

	/*
	 * @RequestMapping(value = "/getTodaysDate") public String getTodayDate() {
	 * return LocalDate.now()+""; }
	 */

	/*
	 * @PostMapping(value="/saveUser") public User saveUserController(@RequestBody
	 * User user) { System.out.println(user); return user; }
	 */

//	@PostMapping(value = "/saveUser")
//	public User saveUserController(@RequestBody User user) {
//		return dao.saveUserDao(user);
//	}

	@GetMapping(value = "/findById/{id}")
	public User findUserByIdController(@PathVariable int id) {
		return dao.findUserByIdDao(id);
	}
	
	@GetMapping(value="/findAllUser")
	public List<User> findAllUserController() {
		return dao.findAllUserDao();
	}

	@GetMapping(value = "findUserByName/{name}")
	public List<User> findByNameController(@PathVariable String name) {
		return dao.findByNameDao(name);
	}

	@GetMapping(value = "findByIdDesc/{name}")
	public List<User> findByNameOrderByIdDesc(@PathVariable String name) {
		return dao.findByNameOrderByIdDesc(name);
	}

	@GetMapping(value = "findByEmail/{email}")
	public User getUserByEmaiUser(@PathVariable String email) {
		return dao.getUserByEmaiUser(email);
	}

	@DeleteMapping(value = "/deleteUserByDob/{date}")
	public ResponseEntity<String> deleteUserByDob(@PathVariable LocalDate date) {
		boolean b = dao.deleteUserByDob(date);
		if (b) {
			return new ResponseEntity<String>("Data Deleted", HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<String>("Given DOB is not found/invalid ", HttpStatus.NOT_ACCEPTABLE);
		}

	}
	 @PutMapping("/updateNameByDob/{dob}/{name}")
	    public ResponseEntity<String> updateUserNameByDob(@PathVariable LocalDate dob, @PathVariable String name) {
	        boolean b=dao.updateUserNameByDob(name,dob);
	        if (b) {
				return new ResponseEntity<String>("Data updated", HttpStatus.ACCEPTED);
			} else {
				return new ResponseEntity<String>("Given DOB is not found/invalid ", HttpStatus.NOT_ACCEPTABLE);
			}
	    }
	 
	 @PostMapping(value="/saveUser") 
	 public ResponseStructure<User> saveUserController1(@RequestBody User user){
		 System.out.println(user);
		 return service.saveUserService(user);
	 }
	 
	 

}
