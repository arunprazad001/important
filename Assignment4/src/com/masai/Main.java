package com.masai;

public class Main {

	public static void main(String[] args) {
		Thread1Impl t1=new Thread1Impl();
		Thread2Impl t2=new Thread2Impl();
		Thread t=new Thread(t2);
		t1.start();
        t.start();
	}

}
