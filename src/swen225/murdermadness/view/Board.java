package swen225.murdermadness.view;

public class Board {
	private Tile[][] board;
	
	/**
	 * Construct initial board.
	 */
	public Board() {
		this.board = new Tile[23][23];
		
		for (int y = 0; y <= 23; y++) {
			for (int x = 0; x <= 23; x++) {
				this.board[x][y] = new NormalTile(new Position(x, y));
			}
		}
		
		// Haunted House walls
		
		// First row
		this.board[2][2] = new Wall(new Position(2,2));
		this.board[3][2] = new Wall(new Position(3,2));
		this.board[4][2] = new Wall(new Position(4,2));
		this.board[5][2] = new Wall(new Position(5,2));
		this.board[6][2] = new Wall(new Position(6,2));
		
		// Second row
		this.board[2][3] = new Wall(new Position(2,3));
		
		// Third row
		this.board[2][4] = new Wall(new Position(2,4));
		this.board[6][4] = new Wall(new Position(6,4));
		
		// Fourth row
		this.board[2][5] = new Wall(new Position(2,5));
		this.board[6][5] = new Wall(new Position(6,5));
		
		// Fifth row
		this.board[2][6] = new Wall(new Position(2,6));
		this.board[3][6] = new Wall(new Position(3,6));
		this.board[4][6] = new Wall(new Position(4,6));
		this.board[6][6] = new Wall(new Position(6,6));
		
		// Manic Manor walls
		
		// First row
		this.board[17][2] = new Wall(new Position(17,2));
		this.board[18][2] = new Wall(new Position(18,2));
		this.board[19][2] = new Wall(new Position(19,2));
		this.board[20][2] = new Wall(new Position(20,2));
		this.board[21][2] = new Wall(new Position(21,2));
		
		// Second row
		this.board[17][3] = new Wall(new Position(17,3));
		this.board[21][3] = new Wall(new Position(21,3));
		
		// Third row
		this.board[17][4] = new Wall(new Position(17,4));
		this.board[21][4] = new Wall(new Position(21,4));
		
		// Fourth row
		this.board[21][5] = new Wall(new Position(21,5));
		
		
		// Fifth row
		this.board[17][6] = new Wall(new Position(17,6));
		this.board[18][6] = new Wall(new Position(18,6));
		this.board[19][6] = new Wall(new Position(19,6));
		this.board[21][6] = new Wall(new Position(21,6));
		
		// Villa Celia
		
		// First row
		this.board[9][10] = new Wall(new Position(9,10));
		this.board[10][10] = new Wall(new Position(10,10));
		this.board[11][10] = new Wall(new Position(11,10));
		this.board[13][10] = new Wall(new Position(13,10));
		this.board[14][10] = new Wall(new Position(14,10));
		
		// Second row
		this.board[9][11] = new Wall(new Position(9,11));
		
		// Third row
		this.board[14][12] = new Wall(new Position(14,12));
		
		// Fourth row
		this.board[9][13] = new Wall(new Position(9,13));
		this.board[10][13] = new Wall(new Position(10,13));
		this.board[12][13] = new Wall(new Position(12,13));
		this.board[13][13] = new Wall(new Position(13,13));
		this.board[14][13] = new Wall(new Position(14,13));
		
		// Calamity Castle
		
		// First row
		this.board[2][17] = new Wall(new Position(2,17));
		this.board[4][17] = new Wall(new Position(4,17));
		this.board[5][17] = new Wall(new Position(5,17));
		this.board[6][17] = new Wall(new Position(6,17));
		
		// Second row
		this.board[2][18] = new Wall(new Position(2,18));
		
		// Third row
		this.board[2][19] = new Wall(new Position(2,19));
		this.board[6][19] = new Wall(new Position(6,19));
		
		// Fourth row
		this.board[2][20] = new Wall(new Position(2,20));
		this.board[6][20] = new Wall(new Position(6,20));
		
		// Fifth row
		this.board[2][21] = new Wall(new Position(2,21));
		this.board[3][21] = new Wall(new Position(3,21));
		this.board[4][21] = new Wall(new Position(4,21));
		this.board[5][21] = new Wall(new Position(5,21));
		this.board[6][21] = new Wall(new Position(6,21));
		
		// Peril Palace
		
		// First row
		this.board[17][17] = new Wall(new Position(17,17));
		this.board[19][17] = new Wall(new Position(19,17));
		this.board[20][17] = new Wall(new Position(20,17));
		this.board[21][17] = new Wall(new Position(21,17));
		
		// Second row
		this.board[17][18] = new Wall(new Position(17,18));
		this.board[21][18] = new Wall(new Position(21,18));
		
		// Third row
		this.board[17][19] = new Wall(new Position(17,19));
		this.board[21][19] = new Wall(new Position(21,19));
		
		// Fourth row
		this.board[21][20] = new Wall(new Position(21,20));
		
		// Fifth row
		this.board[17][21] = new Wall(new Position(17,21));
		this.board[18][21] = new Wall(new Position(18,21));
		this.board[19][21] = new Wall(new Position(19,21));
		this.board[20][21] = new Wall(new Position(20,21));
		this.board[21][21] = new Wall(new Position(21,21));
	}
	
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
