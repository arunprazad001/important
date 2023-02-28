package com.metro;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MainLogic {

	public void run() {
		 
		MetroTrain mt=new MetroTrain();
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("Select type of passenger adult/senior/child  or select E to Exit");
			String ptype=sc.nextLine();
			if(ptype.equals("E")) {
				System.out.println("Thank You!");
				break;
			}
			
			System.out.println("Select journey type single/return");
			String jtype=sc.nextLine();
			
			if(jtype.equals("single")) {
				int Sfare=mt.CalculateFare(ptype,jtype);
				mt.totalCollectedAmount+=Sfare;
				mt.passengerCount.put(ptype, mt.passengerCount.getOrDefault(ptype,0)+1);
			}else if(jtype.equals("return")) {
				int Rfare=mt.CalculateFare(ptype,jtype);
				int xfare=mt.CalculateFare(ptype,"single");
				int discount=Rfare-xfare;
				mt.totalCollectedAmount+=Rfare;
				mt.totalDiscountGiven+=discount;
				mt.passengerCount.put(ptype, mt.passengerCount.getOrDefault(ptype,0)+2);
			}else {
				System.out.println("Invalid type");
			}
			
			System.out.println("Do you want to continue y/n ?");
			String choice=sc.nextLine();
			if(choice.equals("y")) {
				continue;
			}else if(choice.equals("n")) {
				break;
			}else {
			    System.out.println("Invalid Entry");
			}
		}
		
		System.out.println("total collected amount= "+ mt.totalCollectedAmount);
		System.out.println("total discount given= "+mt.totalDiscountGiven);
		
		Set<Map.Entry<String,Integer>>s=mt.passengerCount.entrySet();
		for(Map.Entry<String,Integer>x:s) {
			System.out.println("PassengerType= "+x.getKey()+" - "+"No of passengers= "+x.getValue());
		}
	}
	
	
	
	
}
