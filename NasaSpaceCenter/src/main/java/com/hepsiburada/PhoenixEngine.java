package com.hepsiburada;


import java.util.HashMap;

import com.hepsiburada.model.Action;
import com.hepsiburada.model.GridPoint;
import com.hepsiburada.model.Move;
import com.hepsiburada.model.TurnLeft;
import com.hepsiburada.model.TurnRight;

public class PhoenixEngine {
	public static HashMap<String, Integer> location = new HashMap<String, Integer>();
	static GridPoint[][] grid = new GridPoint[5][5];
	public static HashMap<String, Object> command = new HashMap<String, Object>();

	public PhoenixEngine() {
		command.put("L", new TurnLeft(location));
		command.put("R", new TurnRight(location));
		command.put("M", new Move(location));
	}

	public static String drivePhoenix(String destination) throws Exception {
		String status = "";
		for (int x = 0; x < destination.length(); x++) {
			status = action(destination.charAt(x));
			if (status.equals(PhoenixConstant.FELL)) {
				break;
			}
		}
	
	
		String print =phoenixPrint(status);
		location = new HashMap<String, Integer>();
		return print;
	}

	public static String phoenixPrint(String status) {
		String print="";
		if (!status.equals(PhoenixConstant.FELL)) {
			print =location.get(PhoenixConstant.X) + " " + location.get(PhoenixConstant.Y) + " "
					+ PhoenixUtil.lastDirection(location.get(PhoenixConstant.DIRECTION));
		}else{
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid.length; j++) {
					if (grid[i][j] != null) {
						print=i+" "+j+" "+PhoenixUtil.lastDirection(grid[i][j].getExistingDirection())+" RIP";
						}
				}
			}
			
		}
		return print;
	}

	public static String action(char move) throws Exception {

		Object existingDirection = command.get(String.valueOf(move));
		Action action = new Action(existingDirection);
		location = action.getLocation();

		if (location.get(PhoenixConstant.FLAG) != null && location.get(PhoenixConstant.FLAG) == 99) {
			grid[location.get(PhoenixConstant.X)][location.get(PhoenixConstant.Y)] = new GridPoint(true, location.get(PhoenixConstant.DIRECTION));
			return PhoenixConstant.FELL;
		}

		return PhoenixConstant.CONTINUATION;

	}

	public static void main(String[] args) throws Exception {
		@SuppressWarnings("unused")
		PhoenixEngine phoenix = new PhoenixEngine();
		location.put(PhoenixConstant.X, 1);
		location.put(PhoenixConstant.Y, 2);
		location.put(PhoenixConstant.DIRECTION, PhoenixConstant.NORTH);
		System.out.println(drivePhoenix("LMLMLMLMM"));
		phoenix = new PhoenixEngine();
		location.put(PhoenixConstant.X, 3);
		location.put(PhoenixConstant.Y, 3);
		location.put(PhoenixConstant.DIRECTION, PhoenixConstant.NORTH);
		System.out.println(drivePhoenix("MMRMMRMRRM"));

	}

}
