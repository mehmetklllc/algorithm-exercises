package com.hepsiburada.model;

public class GridPoint {

	public boolean become = false;
	public int existingDirection;

	public GridPoint(boolean become, int existingDirection) {
		super();
		this.become = become;
		this.existingDirection = existingDirection;
	}

	public boolean isBecome() {
		return become;
	}

	public void setBecome(boolean become) {
		this.become = become;
	}

	public int getExistingDirection() {
		return existingDirection;
	}

	public void setExistingDirection(int existingDirection) {
		this.existingDirection = existingDirection;
	}

}
