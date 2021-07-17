package swen225.murdermadness.view;

public class NormalTile implements Tile{
	
	/**
	 * Stores the Position of the Tile in the board.
	 */
	private Position normalTilePosition;
	
	/**
	 * Construct the tile on board
	 *
	 * @param p Position of tile.
	 */
	public NormalTile(Position p) {
		this.normalTilePosition = p;
	}
	
	
	/**
	 * Gets the position of the tile.
	 *
	 * @return Position.
	 */
	public Position getPosition() {
		return this.normalTilePosition;
	}
	
	/**
	 * Sets the position of the tile.
	 *
	 *@param p Position in the board.
	 */
	public void setPosition(Position p) {
		this.normalTilePosition = p;
	}

	@Override 
	public boolean isObstruction() {
		// TODO Auto-generated method stub
		return false;
	}

}
