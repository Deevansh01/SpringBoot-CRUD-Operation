package com.ibm.spring_boot_crud_operation.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class User {
	private int id;
	private String name;
	private String email;
	private LocalDate dob;
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", dob=" + dob + "]";
	}

	
	
}
