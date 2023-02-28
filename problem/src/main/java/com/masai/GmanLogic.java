package com.masai;

public class GmanLogic {
	
    public int calculatePower(int sourceX,int sourceY,int destinationX,int destinationY,String direction) {
		
    	
    	 int cordinatesTotal=0;
    	 int turns=0;
    	 int finalTotal=0;
    	

		if(destinationX-sourceX>0) {
			switch(direction) {
			case "W" : turns++;
			           direction="E";
			           break;
			case "S" :  turns++;
	                   direction="E";
	                   break;
			case "N" : turns++;
	                   direction="E";
	                   break;
			}
		}
		
		if(destinationX-sourceX<0) {
			switch(direction) {
			case "E" : turns++;
			           direction="W";
			           break;
			case "S" :  turns++;
	                   direction="W";
	                   break;
			case "N" : turns++;
	                   direction="W";
	                   break;
			}
		}
		
		if(destinationY-sourceY>0) {
			switch(direction) {
			case "W" : turns++;
			           direction="N";
			           break;
			case "E" :  turns++;
	                   direction="N";
	                   break;
			case "S" : turns++;
	                   direction="N";
	                   break;
			}
		}
		
		if(destinationY-sourceY<0) {
			switch(direction) {
			case "W" : turns++;
			           direction="S";
			           break;
			case "E" :  turns++;
	                   direction="S";
	                   break;
			case "N" : turns++;
	                   direction="S";
	                   break;
			}
		}
		
		cordinatesTotal=Math.abs(destinationX-sourceX)+Math.abs(destinationY-sourceY);
		finalTotal=200-((cordinatesTotal*10)+(turns*5));
		
		return finalTotal;
	}
	
}
