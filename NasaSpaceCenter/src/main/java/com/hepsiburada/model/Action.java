package com.hepsiburada.model;

import java.util.HashMap;

public class Action {
	HashMap<String, Integer> location = new HashMap<String, Integer>();
	GridPoint[][] grid = new GridPoint[4][4];

	public Action(Object existingDirection) throws Exception {
		if (existingDirection instanceof TurnLeft) {
		TurnLeft left =	(TurnLeft) existingDirection;
			location = left.command();
		} else if (existingDirection instanceof TurnRight) {
			TurnRight right =(TurnRight) existingDirection;
			location = right.command();
		} else if (existingDirection instanceof Move) {
			Move move =(Move) existingDirection;
			location = move.command();
			
		}
	}

	public HashMap<String, Integer> getLocation() {
		return location;
	}
	

}
