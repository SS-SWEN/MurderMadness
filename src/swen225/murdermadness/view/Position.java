package swen225.murdermadness.view;

public class Position {
	
	private int x;
	private int y;
	
	public int getX() { return x; }

	public int getY() { return y; }
	
	public boolean isValid() {
		return x > 0 && x <= 24 && y > 0 && y <= 24;
	}
	
	public boolean equals(Object o) {
		if(o instanceof Position) { 
			Position p = (Position)o;
			return (this.getX() == p.getX() && this.getY() == p.getY());
		} 
		return false;
		
	}

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int xySum() {
		return this.getX()+this.getY();
	}
	
	public String toString() {
		return "("+this.x+","+this.y+")";
	}
}
