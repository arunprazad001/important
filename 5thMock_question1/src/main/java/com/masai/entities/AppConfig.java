package com.masai.entities;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.Value;

import java.util.*;
@Configuration
public class AppConfig {

	@Bean
    public Map<Person, Gym> theMap() {
        // create and return a Map with 3 entries
		Map<Person, Gym>map=new LinkedHashMap<>();
		map.put(new Person(1,"a","a@gmail.com",22,"8544654"), new Gym(1,"abc",12000));
		map.put(new Person(2,"b","b@gmail.com",23,"854414154"), new Gym(2,"aby",18000));
		map.put(new Person(3,"c","c@gmail.com",24,"8544654545"), new Gym(4,"arc",15000));
		return map;
    }

    @Bean
    public List<Person> theList() {
        // create and return a List of 5 Person objects
    	List<Person>persons =new ArrayList<>();
    	persons.add(new Person(1,"a","a@gmail.com",22,"8544654"));
    	persons.add(new Person(2,"b","b@gmail.com",23,"854414154"));
    	persons.add(new Person(3,"c","c@gmail.com",24,"8544654545"));
    	persons.add(new Person(4,"d","d@gmail.com",26,"855646544654"));
    	persons.add(new Person(5,"e","e@gmail.com",28,"85454544654"));
    	return persons;
    }

    @Value("${gym_name}")
    private String gym_name;

    @Bean
    public PersonService personService() {
        return new PersonService(theMap(), theList(), gym_name);
    }
	
}
