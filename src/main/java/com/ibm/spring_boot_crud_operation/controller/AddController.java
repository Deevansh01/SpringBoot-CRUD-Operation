package com.ibm.spring_boot_crud_operation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddController {
	
	/*@RequestMapping(value ="/getAdd")
	public int getAddition(int a, int b)
	{
		return a+b;
	}
	*/
	
	//using path variable
	@GetMapping(value ="/getAdd/{a},{b}")
	public Integer getAddition(@PathVariable Integer a,@PathVariable Integer b)
	{
		return a+b;
	}
}
