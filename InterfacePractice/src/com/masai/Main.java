package com.masai;

public class Main {
	
	public enum Color {
		 RED,
		 GREEN,
		 BLUE;
		}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         ConsolePrinter c=new ConsolePrinter();
         Printer p1=new ConsolePrinter();
         Printer p2=new FilePrinter();
//         c.print();
//         p1.print();
//         p2.print();
//         c.method2();
//         Printer.method3();
         Color c1=Color.RED;
         System.out.println(c1);
	}

}
