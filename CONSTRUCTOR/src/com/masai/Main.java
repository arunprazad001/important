package com.masai;

public class Main {

	public Main(){
		this(10);
		
		System.out.println("inside Main()");
		}
		public Main(int x){
			this(1.22);
		System.out.println("inside Main(int x)");
		}
		public Main(double d){
			this("a");
		System.out.println("inside Main(double d)");
		}
		public Main(String s){
		System.out.println("inside Main(String s)");
		}

	
	
	public static void main(String[] args) {
		Main m=new Main();
        
	}

}
