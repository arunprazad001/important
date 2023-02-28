package com.masai;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class Geektrust {

	
	
	
	public static void main(String[] args) throws FileNotFoundException {
            FileInputStream file = new FileInputStream(args[0]);
            InputTaking input=new InputTaking();
            input.inputTakingMethod(file);
		
		
		
    }

}
