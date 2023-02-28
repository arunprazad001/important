package com.masai;

import java.util.List;
import java.util.Set;

public interface StudOperations {
  
	public String addStudent(Student student);
	public String deleteStudent(int id);
	public Student findStudentById(int id);
	public List<Student>findByPincode(String pincode);
	public List<Student>SortByName();
	public Set<Student>SetOfMarks();
	public String AddAllStudents(Student student);
	public List<Student>viewall();
}
