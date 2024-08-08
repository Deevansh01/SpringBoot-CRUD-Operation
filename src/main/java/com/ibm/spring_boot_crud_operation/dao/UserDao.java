package com.ibm.spring_boot_crud_operation.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibm.spring_boot_crud_operation.dto.User;
import com.ibm.spring_boot_crud_operation.repository.UserRepository;

@Repository
public class UserDao {
	
	@Autowired
	private UserRepository repository;
	
	public User saveUserDao(User user) {
		return repository.save(user);
	}
	
	public User findUserByIdDao(int id) {
		Optional<User> optional= repository.findById(id);
		
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}
	
	public List<User> findAllUserDao(){
		return repository.findAll();
		
	}
	
	public List<User> findByNameDao(String name)
	{
		return repository.findByName(name);
	}
	
	public List<User> findByNameOrderByIdDesc(String name)
	{
		return repository.findByNameOrderByIdDesc(name);
	}
	
	
	public User getUserByEmaiUser(String email)
	{
		return repository.getUserByEmaiUser(email);
	}
	
	public boolean deleteUserByDob(LocalDate date) {
		try {
			repository.deleteUserByDob(date);
			return true;
		} catch (Exception e) {
				e.printStackTrace();
				return false;
		}
	}
	
	public boolean updateUserNameByDob(String name,LocalDate dob) {
        try {
        	repository.updateUserNameByDob(name,dob);
			return true;
		} catch (Exception e) {
			return false;
		}
        
    }

}
