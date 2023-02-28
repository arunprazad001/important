package com.masai;

import java.io.FileInputStream;

import java.util.Scanner;

public class InputTaking {

	public void inputTakingMethod(FileInputStream file) {
		 int sourceX=0;
		 int sourceY=0;
		 int destinationX=0;
		 int destinationY=0;
	     String direction="";

	          Scanner scanner = new Scanner(file); 
	            while (scanner.hasNextLine()) {
	                String input = scanner.nextLine();
	                String[] array = input.split(" ");
	                switch (array[0]) {
	                    case "SOURCE":
	                        sourceX = Integer.parseInt(array[1]);
	                        sourceY =  Integer.parseInt(array[2]);
	                        direction =  array[3];
	                        break;
	                    case "DESTINATION":
	                        destinationX = Integer.parseInt(array[1]);
	                        destinationY =  Integer.parseInt(array[2]);
	                        break;
	                    case "PRINT_POWER":
	                    	GmanLogic logic=new GmanLogic();
	                        int power  = logic.calculatePower(sourceX, sourceY, destinationX, destinationY, direction);    
	                        System.out.println("POWER "+ power);
	                        break;                    
	                }
	            }
	            scanner.close(); 
	       
			
	}
	
}
