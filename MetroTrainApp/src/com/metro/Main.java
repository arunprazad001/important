package com.metro;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		MainLogic ml=new MainLogic();
		Scanner sc=new Scanner(System.in);
		System.out.println("Do you want to proceed y/n?");
		String choice=sc.nextLine();
		if(choice.equals("y")) {
			ml.run();
		}else {
			System.out.println("Invalid Entry");
		}

	}

}
