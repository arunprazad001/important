package com.metro;

import java.util.*;

public class MetroTrain {

	    private static final String adult = "adult";
	    private static final String child = "child";
	    private static final String senior = "senior";
	    
	    private static final String single = "single";
	    private static final String returnn = "return";

	    private static final int ADULT_SINGLE_FARE = 200;
	    private static final int ADULT_RETURN_FARE = 300;
	    private static final int CHILD_SINGLE_FARE = 50;
	    private static final int CHILD_RETURN_FARE = 75;
	    private static final int SENIOR_SINGLE_FARE = 100;
	    private static final int SENIOR_RETURN_FARE = 150;
	    
	   public int totalCollectedAmount;
	   public int totalDiscountGiven;
	    
	   public Map<String,Integer> passengerCount = new HashMap<>();
	    
	  

	     public int CalculateFare(String p,String j) {
	    	if(p.equals(this.adult) && j.equals(this.single)) {
	    		return 200;
	    	}else if(p.equals(this.adult) && j.equals(this.returnn)) {
	    		return 300;
	    	}else if(p.equals(this.senior) && j.equals(this.single)) {
	    		return 100;
	    	}else if(p.equals(this.senior) && j.equals(this.returnn)) {
	    		return 150;
	    	}else if(p.equals(this.child) && j.equals(this.single)) {
	    		return 50;
	    	}else if(p.equals(this.child) && j.equals(this.returnn)) {
	    		return 75;
	    	}else {
	    		return 0;
	    	}
	    }
	    
	    
	   
	
}
