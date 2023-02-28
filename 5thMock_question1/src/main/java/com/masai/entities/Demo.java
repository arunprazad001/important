package com.masai.entities;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Demo {

	public static void main(String[] args) {
		 AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	        PersonService personService = context.getBean(PersonService.class);
	        personService.printMap();
	        personService.printList();
	        personService.printGymName();

	}

}
