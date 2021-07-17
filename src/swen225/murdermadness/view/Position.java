package swen225.murdermadness.view;

public class Position {
	
	/**
	 * Stores the X coordinate of the position.
	 */
	public final int x;
	
	/**
	 * Stores the Y coordinate of the position.
	 */
	public final int y;
	
	
	/**
	 * Construct position on the board
	 *
	 * @param x X coordinate of position
	 * @param y Y coordinate of position
	 */
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Get the X-coordinate of this position.
	 *
	 * @return X-coordinate
	 */
	public int getX() {
		return this.x;
	}
	
	/**
	 * Get the Y-coordinate of this position.
	 *
	 * @return Y-coordinate
	 */
	public int getY() {
		return this.y;
	}
}
