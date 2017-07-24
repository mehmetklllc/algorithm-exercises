package com.hepsiburada;

public class PhoenixUtil {

	
	public static String lastDirection(int number){
		String direction ="";
		if (number == 1) {
			direction = PhoenixConstant.N;
		} else if (number == 2) {
			direction = PhoenixConstant.E;
		} else if (number == 3) {
			direction = PhoenixConstant.S;
		} else if (number == 4) {
			direction = PhoenixConstant.W;
		}
		
		return direction;

	}
	
}
