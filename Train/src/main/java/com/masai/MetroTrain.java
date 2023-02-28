package com.masai;

import java.util.*;

public class MetroTrain {

	    private String passengerType;
	    private String journeyType;
	    
	    public static int totalCollectedAmount=0;
	    public static int totalDiscountGiven=0;
	    public static Map<String,Integer> passengerCount = new HashMap();
	    
	  
	    
	   public MetroTrain() {
		// TODO Auto-generated constructor stub
	   }
	   
	  
	    public MetroTrain(String passengerType, String journeyType) {
		super();
		this.passengerType = passengerType;
		this.journeyType = journeyType;
	    }


	     public String getPassengerType() {
			return passengerType;
		}


		public void setPassengerType(String passengerType) {
			this.passengerType = passengerType;
		}


		public String getJourneyType() {
			return journeyType;
		}


		public void setJourneyType(String journeyType) {
			this.journeyType = journeyType;
		}


		public int CalculateFare(String passenger,String journey) {
	    	if(passenger.equals("adult") && journey.equals("single")) {
	    		return 200;
	    	}else if(passenger.equals("adult") && journey.equals("return")) {
	    		return 300;
	    	}else if(passenger.equals("senior") && journey.equals("single")) {
	    		return 100;
	    	}else if(passenger.equals("senior") && journey.equals("return")) {
	    		return 150;
	    	}else if(passenger.equals("child") && journey.equals("single")) {
	    		return 50;
	    	}else if(passenger.equals("child") && journey.equals("return")) {
	    		return 75;
	    	}else {
	    		return 0;
	    	}
	    }
	    
	    
	   
	
}
