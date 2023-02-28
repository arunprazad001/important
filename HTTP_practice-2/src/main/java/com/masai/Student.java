package com.masai;

public class Student {
  private String name;
  private int roll;
  private String div;
  private int phone;
  
  public Student() {
	// TODO Auto-generated constructor stub
}

public Student(String name, int roll, String div, int phone) {
	super();
	this.name = name;
	this.roll = roll;
	this.div = div;
	this.phone = phone;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getNo() {
	return roll;
}

public void setNo(int no) {
	this.roll = no;
}

public String getDiv() {
	return div;
}

public void setDiv(String div) {
	this.div = div;
}

public int getPhone() {
	return phone;
}

public void setPhone(int phone) {
	this.phone = phone;
}

@Override
public String toString() {
	return "Student [name=" + name + ", no=" + roll + ", div=" + div + ", phone=" + phone + "]";
}
  
  
}
