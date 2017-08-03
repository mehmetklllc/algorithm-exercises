package com.hepsiburada.model;

import java.util.HashMap;

import com.hepsiburada.PhoenixConstant;

public class Move {
	HashMap<String, Integer> location = new HashMap<String, Integer>();

	public Move(HashMap<String, Integer> location) {
		this.location = location;

	}

	public HashMap<String, Integer> command() throws Exception {
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

		if (x > 4) {
			location.put("flag", 99);
			x = 4;
		}
		if (y > 4) {
			location.put("flag", 99);
			y = 4;
		}
		location.put("x", x);
		location.put("y", y);
		if (x < 0 || y < 0) {
			throw new Exception("Phoenix disconnected");
		}
		return location;

	}

}
