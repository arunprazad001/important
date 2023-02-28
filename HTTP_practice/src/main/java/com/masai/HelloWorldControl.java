package com.masai;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldControl {

	
	@GetMapping("/hi")
	public String display() {
		return "This is the new method";
	}
	
	
}
