package swen225.murdermadness;
import java.util.ArrayList;
import java.util.List;

import swen225.murdermadness.cards.WeaponCard;
import swen225.murdermadness.view.Board;
import swen225.murdermadness.view.Position;
import swen225.murdermadness.view.Tile;
import swen225.murdermadness.view.Wall;

public class Estate {
	private final String estateName;
	public List<WeaponCard> weapons = new ArrayList<WeaponCard>();
	
	// maximum x,y value, represents the top left of the estate 
	private Position topLeft;
	// maximum x,y value, represents the bottom right of the estate
	private Position botRight;
	
	/**
	 * Check if a Position in within the Estate (within its walls)
	 */
	public boolean within(Position pos) {
		return pos.getX() >= topLeft.getX() 
				&& pos.getX() <= botRight.getX()
				&& pos.getY() >= topLeft.getY() 
				&& pos.getY() <= botRight.getY();
	}
	
	public String getName() {
		return this.estateName;
	}
	
	public Estate(String estateName, Position topLeft, Position botRight) {
		this.estateName = estateName;
		this.topLeft = topLeft;
		this.botRight = botRight;
	}
	
	public Position nextAvailablePosition(Board board) {
		for(int x = topLeft.getX(); x <= botRight.getX(); x++) {
			for(int y = topLeft.getY(); y <=botRight.getY(); y++) {
				Position pos = new Position(x, y);
				if(!board.getTile(pos).isObstruction()) { return pos; }
			}
		}
		return null;
	}
	
	public void addWeapon(WeaponCard weapon) {
		this.weapons.add(weapon);
	}
	
	public boolean hasThisWeapon(WeaponCard weapon) {
		return this.weapons.contains(weapon);
	}
	
	public void removeWeapon(WeaponCard weapon) {
		this.weapons.remove(weapon);
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Estate) { 
			Estate e = (Estate)o;
			return this.estateName.equals(e.estateName)
					&& this.weapons.equals(e.weapons)
					&& this.topLeft.equals(e.topLeft)
					&& this.botRight.equals(e.botRight);
		} 
		return false;
	}
}
