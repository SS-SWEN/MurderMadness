package swen225.murdermadness;
import java.util.ArrayList;
import java.util.List;

import swen225.murdermadness.view.Position;
import swen225.murdermadness.view.Tile;
import swen225.murdermadness.view.Wall;

public class Estate {
	private final List<Tile> estatePosition;
	private final String estateName;
	
	// maximum x,y value, represents the top left of the estate 
	private Position topLeft;
	// maximum x,y value, represents the bottom right of the estate
	private Position botRight;
	
	/**
	 * Check if a Position in within the Estate (within its walls)
	 */
	public boolean within(Position pos) {
		return pos.getX() > topLeft.getX() 
				&& pos.getX() < botRight.getX()
				&& pos.getY() > topLeft.getY() 
				&& pos.getY() < botRight.getY();
	}
	
	public String getName() {
		return this.estateName;
	}
	
	public Estate(String estateName, ArrayList<Tile> estatePosition) {
		this.estateName = estateName;
		this.estatePosition = estatePosition;
		calculateEnclosing(estatePosition);
	}
	
	/**
	 * Calculate the top left and bottom left corners of the Estate, useful for finding the Area Tiles
	 * enclosed by the Estate (Assumes the state area is a square!)
	 * @param walls
	 */
	private void calculateEnclosing(List<Tile> pos) {
		// find the walls of the estate, then find the positions of the walls
		List<Position> walls = new ArrayList<Position>();
		for(Tile t : pos) { if(t instanceof Wall) {walls.add(((Wall) t).getPosition()); }}
		
		// find the min Position (top left wall)
		Position min = null;
		for(Position p : walls) {
			if(min == null) { min = p;}
			else if(min.xySum() > p.xySum()) { min = p; }
		}
		
		// find the max Position (bottom right wall)
		Position max = null;
		for(Position p : walls) {
			if(max == null) { max = p;}
			else if(max.xySum() < p.xySum()) { max = p; }
		}
		
		this.topLeft = min;
		this.botRight = max;
	}
	
}
