package com.hepsiburada;

import java.util.HashMap;

public class PhoenixEngine {

	public static HashMap<String, Integer> location = new HashMap<String, Integer>();

	public static void drivePhoenix(String destination) {
		try {
			for (int x = 0; x < destination.length(); x++) {
				action(destination.charAt(x));
			}
			System.out.println(location.get("x") + " " + location.get("y") + " "
					+ PhoenixUtil.lastDirection(location.get("direction")));
			location = new HashMap<String, Integer>();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	public static void action(char move) throws Exception {
		switch (move) {
		case 'L':
			turn("L");
			break;
		case 'R':
			turn("R");
			break;
		case 'M':
			headway();
			break;
		default:
			System.out.println("Invalid direction!");
		}

	}

	public static void headway() throws Exception {
		int x = location.get("x");
		int y = location.get("y");
		int direction = location.get("direction");

		switch (direction) {
		case PhoenixConstant.NORTH:
			y++;
			break;
		case PhoenixConstant.SOUTH:
			y--;
			break;
		case PhoenixConstant.EAST:
			x++;
			break;
		case PhoenixConstant.WEST:
			x--;
			break;
		}
		location.put("x", x);
		location.put("y", y);
		
		if(x<0 || y<0){
		   throw new  Exception("Phoenix disconnected");
		}
		

	}

	public static void turn(String direction) {
		int existingDirection = location.get("direction");
		if (direction.equals("L")) {
			if ((existingDirection - 1) < PhoenixConstant.NORTH) {
				existingDirection = PhoenixConstant.WEST;
			} else {
				existingDirection--;
			}
			location.put("direction", existingDirection);

		} else {

			if ((existingDirection + 1) > PhoenixConstant.WEST) {
				existingDirection = PhoenixConstant.NORTH;
			} else {
				existingDirection++;
			}
			location.put("direction", existingDirection);
		}

	}

	public static void main(String[] args) {
		location.put("x", 1);
		location.put("y", 2);
		location.put("direction", PhoenixConstant.NORTH);
		drivePhoenix("LMLMLMLMM");
		
		location.put("x", 3);
		location.put("y", 3);
		location.put("direction", PhoenixConstant.EAST);
		drivePhoenix("MMRMMRMRRM");

	}

}
