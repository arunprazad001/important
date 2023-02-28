package com.masai.entities;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
public class PersonService {

	    private Map<Person, Gym> theMap;
	    private List<Person> theList;
	    private String gym_name;
	    
	    @Autowired
	    public PersonService(Map<Person, Gym> theMap, List<Person> theList, String gym_name) {
	        this.theMap = theMap;
	        this.theList = theList;
	        this.gym_name = gym_name;
	    }

	    public void printMap() {
	        
	    	Set<Map.Entry<Person, Gym>>set=theMap.entrySet();
	    	for(Map.Entry<Person, Gym>x:set) {
	    		System.out.print(x.getKey()+" "+x.getValue());
	    		System.out.println();
	    	}
	    }

	    public void printList() {
	       
	    	Collections.sort(theList,new Comparator<Person>() {

				@Override
				public int compare(Person o1, Person o2) {
					
					return o1.getAge()-o2.getAge();
				}
	    		
	    	});
	    	System.out.println(theList);
	    }

	    public void printGymName() {
	       System.out.print(gym_name);
	    }
}
