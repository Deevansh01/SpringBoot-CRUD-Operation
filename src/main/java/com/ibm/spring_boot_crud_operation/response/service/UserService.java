package com.ibm.spring_boot_crud_operation.response.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.ibm.spring_boot_crud_operation.dao.UserDao;
import com.ibm.spring_boot_crud_operation.dto.User;
import com.ibm.spring_boot_crud_operation.response.ResponseStructure;

@Service
public class UserService {
	@Autowired
	private UserDao dao;
	
	@Autowired
	private ResponseStructure<User> structure;
	
	public ResponseStructure<User> saveUserService(User user) {
		User user2=dao.saveUserDao(user);
		if(user2!=null)
		{
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			structure.setMessage("data stored");
			structure.setData(user2);
			return structure;
		}else {
			structure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			structure.setMessage("Data not saved");
			structure.setData(user2);
			return structure;
		}
	}

}
