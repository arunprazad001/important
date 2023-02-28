package com.masai;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class A {

	@Autowired
	private B b1;
	
	@Autowired
	private List<String>cities;
	
	public void funA() {
	System.out.println("inside funA of A");
	System.out.println(b1);
	for(String city : cities) {
      System.out.print(city+" ");
	}
	}
	
	

	
}
