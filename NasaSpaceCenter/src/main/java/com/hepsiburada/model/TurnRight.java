package com.hepsiburada.model;

import java.util.HashMap;

import com.hepsiburada.PhoenixConstant;

public class TurnRight {
	HashMap<String, Integer> location = new HashMap<String, Integer>();

	public TurnRight(HashMap<String, Integer> location) {
		this.location = location;
	}

	public HashMap<String, Integer> command() {
		int existingDirection = location.get("direction");
		if ((existingDirection + 1) > PhoenixConstant.WEST) {
			existingDirection = PhoenixConstant.NORTH;
		} else {
			existingDirection++;
		}
		location.put("direction", existingDirection);
		return location;

	}
}
