package com.masai;

public class Thread1Impl extends Thread {
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.print(i+" ");
		}
	}

}
