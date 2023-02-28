package com.masai;

public class Thread2Impl implements Runnable {

	@Override
	public void run() {
		for(int i=10;i<20;i++) {
			System.out.print(i+" ");
		}
		
	}

}
