package com.masai;

public interface Printer {

	int tax=10;
	void print();
	
	default void method2()
	{
	System.out.println("hello");
	}
	
	static void method3()
	{
	System.out.println("inside method3");
	}
	
}
