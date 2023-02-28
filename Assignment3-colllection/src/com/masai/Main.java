package com.masai;

import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter  a choice 1:add,2:delete,3:findbyid,4:findbypincode,5:sortbyname,6:setofmarks,7:addallstudents,8:view all");
        int choice=sc.nextInt();
        StudOperations so=new StuddOperationsImpl();
		switch(choice) {
		case 1: 
		        System.out.println("Enter student details");
		        System.out.println("Enter id");
		        int id=sc.nextInt();
		        System.out.println("Enter name");
		        String name=sc.next();
		        System.out.println("Enter marks");
		        int marks=sc.nextInt();
		        System.out.println("Enter Section");
		        String sec=sc.next();
		        System.out.println("Enter address");
		        System.out.println("Enter city");
		        String city=sc.next();
		        System.out.println("Enter state");
		        String state=sc.next();
		        System.out.println("Enter pincode");
		        String pin=sc.next();
		        Student s1=new Student(id,name,marks,sec,new Address(city,state,pin));
		        String message=so.addStudent(s1);
		        System.out.println(message);
		 break;
		 
		case 2: System.out.println("Enter id");
		        int no=sc.nextInt();
		        String m=so.deleteStudent(no);
		        System.out.println(m);
		break;
		
		case 3: System.out.println("Enter id");
                int n=sc.nextInt();
               Student s=so.findStudentById(n);
               if(s!=null) {
            	   System.out.println(s);
               }else {
            	   System.out.println("No student found");
               }
        break; 
        
		case 4:  System.out.println("Enter pin"); 
		String pinc=sc.next();
			List<Student>ss=so.findByPincode(pinc);
			for(Student x:ss) {
	        	System.out.print(x);
	        }
		break;
		
		
		case 5: List<Student>studss=so.SortByName();
		    for(Student x:studss) {
        	System.out.print(x);
        }
		break; 
		
		case 8: List<Student>studs=so.viewall();
		        for(Student x:studs) {
		        	System.out.print(x);
		        }
		break;        
		}
	}

}
