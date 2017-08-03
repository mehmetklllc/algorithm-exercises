package com.hepsiburada.model;

import java.util.HashMap;

import com.hepsiburada.PhoenixConstant;

public class TurnLeft {
	HashMap<String, Integer> location = new HashMap<String, Integer>();

	public TurnLeft(HashMap<String, Integer> location) {
		this.location = location;
	}

	public HashMap<String, Integer> command() {
		int existingDirection = location.get("direction");

		if ((existingDirection - 1) < PhoenixConstant.NORTH) {
			existingDirection = PhoenixConstant.WEST;
		} else {
			existingDirection--;
		}
		location.put("direction", existingDirection);
		return location;

	}

}
