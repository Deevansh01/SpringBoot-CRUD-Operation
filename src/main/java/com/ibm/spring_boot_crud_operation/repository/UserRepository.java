package com.ibm.spring_boot_crud_operation.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event.ID;

import com.ibm.spring_boot_crud_operation.dto.User;

import jakarta.persistence.Id;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	public List<User> findByName(String name);
}
