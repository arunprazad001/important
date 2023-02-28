package com.masai;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MainLogic {

	
	
	
	public void journeyDetails() {
		 
		
		Scanner sc=new Scanner(System.in);
		while(true) {
			
			System.out.println("Select type of passenger adult/senior/child");
			String passengertype=sc.nextLine();
		    System.out.println("Select journey type single/return");
			String journeytype=sc.nextLine();
			
			MetroTrain mt=new MetroTrain(passengertype,journeytype);
			
			if(journeytype.equals("single")) {
				int Singlefare=mt.CalculateFare(passengertype,journeytype);
				MetroTrain.totalCollectedAmount+=Singlefare;
				MetroTrain.passengerCount.put(passengertype, MetroTrain.passengerCount.getOrDefault(passengertype,0)+1);
			}else if(journeytype.equals("return")) {
				int Returnfare=mt.CalculateFare(passengertype,journeytype);
				int singlejourneyfare=mt.CalculateFare(passengertype,"single");
				int discount=Returnfare-singlejourneyfare;
				MetroTrain.totalCollectedAmount+=Returnfare;
				MetroTrain.totalDiscountGiven+=discount;
				MetroTrain.passengerCount.put(passengertype, MetroTrain.passengerCount.getOrDefault(passengertype,0)+2);
			}else {
				System.out.println("Invalid type");
			}
			
			
			
			System.out.println("Do you want to continue yes/no ?");
			String choice=sc.nextLine();
			if(choice.equals("yes")) {
				continue;
			}else if(choice.equals("no")) {
				break;
			}else {
			    System.out.println("Invalid Entry");
			}
		}
		
		
		
		
		System.out.println("total collected amount= "+ MetroTrain.totalCollectedAmount);
		System.out.println("total discount given= "+MetroTrain.totalDiscountGiven);
		
		Set<Map.Entry<String,Integer>>set=MetroTrain.passengerCount.entrySet();
		for(Map.Entry<String,Integer>x:set) {
			System.out.println("PassengerType= "+x.getKey()+" - "+"No of passengers= "+x.getValue());
		}
	}
	
	
	
	
}
