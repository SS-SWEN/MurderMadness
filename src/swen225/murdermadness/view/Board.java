package swen225.murdermadness.view;

public class Board {
	private Tile[][] board;
	
	/**
	 * Get the tile at a given position on the board. If the position is outside the
	 * board dimensions, it just returns empty air.
	 *
	 * @param position Board position to get tile from
	 * @return Tile at given position
	 */
	public Tile getTile(Position position) {
		final int x = position.getX();
		final int y = position.getY();
		if (x < 0 || x > 23) { // Error check
			System.out.println("Invalid position! X coordinate is out of the board.");
			return null;
		} 
		else if (y < 0 || y > 23) { // Error check
			System.out.println("Invalid position! Y coordinate is out of the board.");
			return null;
		} 
		else {
			return board[position.getY()][position.getX()];
		}
	}
	
	
	public static String layout =
	        ". . . . . . . . . . . . . . . . . . . . . . . ." + // 00
			". . . . . . . . . . . . . . . . . . . . . . . ." + // 01
			". . H H H H H . . . . . . . . . . M M M M M . ." + // 02
			". . H o o o o . . . . . . . . . . M o o o M . ." + // 03
			". . H o o o H . . . . . . . . . . M o o o M . ." + // 04
			". . H o o o H . . . . G G . . . . o o o o M . ." + // 05
			". . H H H o H . . . . G G . . . . M M M o M . ." + // 06
			". . . . . . . . . . . . . . . . . . . . . . . ." + // 07
			". . . . . . . . . . . . . . . . . . . . . . . ." + // 08
			". . . . . . . . . . . . . . . . . . . . . . . ." + // 09
			". . . . . . . . . V V o V V V . . . . . . . . ." + // 10
			". . . . . G G . . o o o o o o . . G G . . . . ." + // 11
			". . . . . G G . . V o o o o V . . G G . . . . ." + // 12
			". . . . . . . . . V V o V V V . . . . . . . . ." + // 13
			". . . . . . . . . . . . . . . . . . . . . . . ." + // 14
			". . . . . . . . . . . . . . . . . . . . . . . ." + // 15
			". . . . . . . . . . . . . . . . . . . . . . . ." + // 16
			". . C o C C C . . . . G G . . . . P o P P P . ." + // 17
			". . C o o o o . . . . G G . . . . P o o o P . ." + // 18
			". . C o o o C . . . . . . . . . . P o o o P . ." + // 19
			". . C o o o C . . . . . . . . . . o o o o P . ." + // 20
			". . C C C C C . . . . . . . . . . P P P P P . ." + // 21
			". . . . . . . . . . . . . . . . . . . . . . . ." + // 22
			". . . . . . . . . . . . . . . . . . . . . . . ." ; // 23
   


	public void show() {
		layout = layout.replaceAll(" ", "");
		layout = layout.replaceAll("o", " ");
		int counter = 0;
		
		for(int i =0; i < 24; i++) {
		    for (int j = 0 ;j < 24 ; j++) {
		        System.out.print(layout.charAt(counter));   
		        counter++;
		    }
		    System.out.println ();
		}
	}
}
