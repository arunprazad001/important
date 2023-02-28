package com.masai;

import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {

	
	
	
	public static void main(String[] args) {
		TreeSet<Student> students=new TreeSet(new RollComparator());
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("Enter details");
			System.out.println("Enter name");
			String name=sc.next();
			System.out.println("Enter roll");
			int roll=sc.nextInt();
			System.out.println("Enter marks");
			int marks=sc.nextInt();
			
			Student student=new Student(roll,name,marks);
			students.add(student);
			
			System.out.println("Do you want to continue");
			System.out.println("y/n");
			String choice=sc.next();
			if(choice.equals("n")) {
				break;
			}else {
				continue;
			}
		}
		
		for(Student s:students) {
			System.out.println(s);
		}
      sc.close();
	}

}
