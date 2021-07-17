package swen225.murdermadness.view;

public class Wall implements Tile{
	
	/**
	 * Stores the Position of the Tile in the board.
	 */
	private Position wallPosition;
	
	/**
	 * Construct the tile on board
	 *
	 * @param p Position of tile
	 */
	public Wall(Position p) {
		this.wallPosition = p;
	}
	
	
	/**
	 * Gets the position of the tile.
	 *
	 * @return Position.
	 */
	public Position getPosition() {
		return this.wallPosition;
	}
	
	/**
	 * Sets the position of the tile.
	 *
	 */
	public void setPosition(Position p) {
		this.wallPosition = p;
	}
	
	@Override
	public boolean isObstruction() {
		// TODO Auto-generated method stub
		return true;
	}

}
