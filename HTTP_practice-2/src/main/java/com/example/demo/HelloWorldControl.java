package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Student;

@RestController
public class HelloWorldControl {

	
	@GetMapping("/hi/{roll}/{n}/{p}")
	public Student message(@PathVariable("roll") Integer roll,@PathVariable("n") String name,@PathVariable("p") Integer phone) {
		Student s1=new Student(name,roll,"A",phone);
		return s1;
	}
	
	@GetMapping("/list")
	public List<Student> students() {
		List<Student>l=new ArrayList<>();
		l.add(new Student("Arun",10,"A",15454));
		l.add(new Student("Arud",11,"e",15564));
		l.add(new Student("vrun",12,"v",154554));
		
		return l;
	}
	
//	
//	@RequestMapping(value= "/hi",method = RequestMethod.GET)
//	public String sayHello() {
//	return "welcome"; // it will be represented as raw data.
//	}
//	
}
