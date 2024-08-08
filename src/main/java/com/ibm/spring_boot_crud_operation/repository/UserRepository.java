package com.ibm.spring_boot_crud_operation.repository;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event.ID;

import com.ibm.spring_boot_crud_operation.dto.User;

import jakarta.persistence.Id;
import jakarta.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	public List<User> findByName(String name);
	public List<User> findByNameOrderByIdDesc(String name);
	
	@Query(value="SELECT u FROM User u Where u.email=?1")
	//select * from user where email=?1",nativeQuery=true
	public User getUserByEmaiUser(String email);
	
	@Query(value="delete from user where dob=?1",nativeQuery=true)
	@Modifying
	@Transactional
	public void deleteUserByDob(LocalDate date);
	
	
	@Query(value="update user set name=?1 where dob=?2",nativeQuery=true)
	@Modifying
	@Transactional
	public void updateUserNameByDob(String name,LocalDate date);
}
