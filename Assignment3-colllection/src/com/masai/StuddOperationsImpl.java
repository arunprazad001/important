package com.masai;

import java.util.*;

public class StuddOperationsImpl implements StudOperations {
	public static List<Student>students=new ArrayList<>();
	 
	@Override
	public String addStudent(Student student) {
		
		students.add(student);
		if(students.size()==0) {
			return "Student not added";
		}else {
			return "Student added";
		}
		
	}

	@Override
	public String deleteStudent(int id) {
		int count=0;
		for(Student x:students) {
			if(x.getId()==id) {
				students.remove(x);
				count++;
				break;
				
			}
		}
		if(count>0) {
			return "student removed";
		}else {
			return "No student found";
		}
		
	}

	@Override
	public Student findStudentById(int id) {
		
		Student s=null;
		for(Student x:students) {
			if(x.getId()==id) {
				s=x;
				break;
				
				
			}
		}
		if(s!=null) {
			return s;
		}else {
			return null;
		}
	}

	@Override
	public List<Student> findByPincode(String pincode) {
		List<Student>l=new ArrayList<>();
		for(Student x:students) {
			if(x.getAddress().getPincode().equals(pincode)) {
				l.add(x);
			}
		}
		if(l.size()==0) {
			return null;	
		}else {
			return l;
		}
		
	}

	@Override
	public List<Student> SortByName() {
		students.add(new Student(20,"Amit",520,"c",new Address("ktm","kerala","68222")));
		students.add(new Student(15,"Suresh",550,"b",new Address("ktvm","kerala","68982")));
		
		return students;
	}

	@Override
	public Set<Student> SetOfMarks() {
		Set<Student> studentss = new HashSet<>();
		students.add(new Student(20,"Amit",520,"c",new Address("ktm","kerala","68222")));
		students.add(new Student(15,"Suresh",550,"b",new Address("ktvm","kerala","68982")));
		students.add(new Student(20,"Amit",520,"c",new Address("ktm","kerala","68222")));
		
		return studentss;
	}

	@Override
	public String AddAllStudents(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> viewall() {
		return students;
	}

}
