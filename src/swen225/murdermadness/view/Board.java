package swen225.murdermadness.view;

import swen225.murdermadness.Player;

public class Board {
	private Tile[][] board;
	
	String layout =
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
		for (int y = 0; y <= 23; y++) {
			for (int x = 0; x <= 23; x++) {
				System.out.print(this.board[y][x].getCharacter());
			}
			System.out.println ();
		}
	}
	
	/**
	 * Construct initial board.
	 */
	public Board() {
		this.board = new Tile[24][24]; //changed to 24 from 23 
		layout = layout.replaceAll(" ", "");
		layout = layout.replaceAll("o", " ");
		int counter = 0;
		
		for (int x = 0; x <= 23; x++) {
			for (int y = 0; y <= 23; y++) {
				String c = Character.toString(layout.charAt(counter));
				this.board[x][y] = new NormalTile(new Position(x, y) , c);	
			}
		}
		//playerStartingPositions
		this.board[1][11] = new Wall(new Position(1,12),"1"); // lucilla
		this.board[15][22] = new Wall(new Position(15,22),"2"); // Percy
		this.board[22][9] = new Wall(new Position(22,9),"3"); // Malina
		this.board[8][1] = new Wall(new Position(8,1),"4"); // Bert
		
		// Haunted House walls

				// First row
				this.board[2][2] = new Wall(new Position(2,2),"H");
				this.board[3][2] = new Wall(new Position(3,2),"H");
				this.board[4][2] = new Wall(new Position(4,2),"H");
				this.board[5][2] = new Wall(new Position(5,2),"H");
				this.board[6][2] = new Wall(new Position(6,2),"H");

				// Second row
				this.board[2][3] = new Wall(new Position(2,3),"H");

				// Third row
				this.board[2][4] = new Wall(new Position(2,4),"H");
				this.board[6][4] = new Wall(new Position(6,4),"H");

				// Fourth row
				this.board[2][5] = new Wall(new Position(2,5),"H");
				this.board[6][5] = new Wall(new Position(6,5),"H");

				// Fifth row
				this.board[2][6] = new Wall(new Position(2,6),"H");
				this.board[3][6] = new Wall(new Position(3,6),"H");
				this.board[4][6] = new Wall(new Position(4,6),"H");
				this.board[6][6] = new Wall(new Position(6,6),"H");

				// Manic Manor walls

				// First row
				this.board[17][2] = new Wall(new Position(17,2),"M");
				this.board[18][2] = new Wall(new Position(18,2),"M");
				this.board[19][2] = new Wall(new Position(19,2),"M");
				this.board[20][2] = new Wall(new Position(20,2),"M");
				this.board[21][2] = new Wall(new Position(21,2),"M");

				// Second row
				this.board[17][3] = new Wall(new Position(17,3),"M");
				this.board[21][3] = new Wall(new Position(21,3),"M");

				// Third row
				this.board[17][4] = new Wall(new Position(17,4),"M");
				this.board[21][4] = new Wall(new Position(21,4),"M");

				// Fourth row
				this.board[21][5] = new Wall(new Position(21,5),"M");


				// Fifth row
				this.board[17][6] = new Wall(new Position(17,6),"M");
				this.board[18][6] = new Wall(new Position(18,6),"M");
				this.board[19][6] = new Wall(new Position(19,6),"M");
				this.board[21][6] = new Wall(new Position(21,6),"M");

				// Villa Celia

				// First row
				this.board[9][10] = new Wall(new Position(9,10),"V");
				this.board[10][10] = new Wall(new Position(10,10),"V");
				this.board[11][10] = new Wall(new Position(11,10),"V");
				this.board[13][10] = new Wall(new Position(13,10),"V");
				this.board[14][10] = new Wall(new Position(14,10),"V");

				// Second row
				this.board[9][11] = new Wall(new Position(9,11),"V");

				// Third row
				this.board[14][12] = new Wall(new Position(14,12),"V");

				// Fourth row
				this.board[9][13] = new Wall(new Position(9,13),"V");
				this.board[10][13] = new Wall(new Position(10,13),"V");
				this.board[12][13] = new Wall(new Position(12,13),"V");
				this.board[13][13] = new Wall(new Position(13,13),"V");
				this.board[14][13] = new Wall(new Position(14,13),"V");

				// Calamity Castle

				// First row
				this.board[2][17] = new Wall(new Position(2,17),"C");
				this.board[4][17] = new Wall(new Position(4,17),"C");
				this.board[5][17] = new Wall(new Position(5,17),"C");
				this.board[6][17] = new Wall(new Position(6,17),"C");

				// Second row
				this.board[2][18] = new Wall(new Position(2,18),"C");

				// Third row
				this.board[2][19] = new Wall(new Position(2,19),"C");
				this.board[6][19] = new Wall(new Position(6,19),"C");

				// Fourth row
				this.board[2][20] = new Wall(new Position(2,20),"C");
				this.board[6][20] = new Wall(new Position(6,20),"C");

				// Fifth row
				this.board[2][21] = new Wall(new Position(2,21),"C");
				this.board[3][21] = new Wall(new Position(3,21),"C");
				this.board[4][21] = new Wall(new Position(4,21),"C");
				this.board[5][21] = new Wall(new Position(5,21),"C");
				this.board[6][21] = new Wall(new Position(6,21),"C");

				// Peril Palace

				// First row
				this.board[17][17] = new Wall(new Position(17,17),"P");
				this.board[19][17] = new Wall(new Position(19,17),"P");
				this.board[20][17] = new Wall(new Position(20,17),"P");
				this.board[21][17] = new Wall(new Position(21,17),"P");

				// Second row
				this.board[17][18] = new Wall(new Position(17,18),"P");
				this.board[21][18] = new Wall(new Position(21,18),"P");

				// Third row
				this.board[17][19] = new Wall(new Position(17,19),"P");
				this.board[21][19] = new Wall(new Position(21,19),"P");

				// Fourth row
				this.board[21][20] = new Wall(new Position(21,20),"P");

				// Fifth row
				this.board[17][21] = new Wall(new Position(17,21),"P");
				this.board[18][21] = new Wall(new Position(18,21),"P");
				this.board[19][21] = new Wall(new Position(19,21),"P");
				this.board[20][21] = new Wall(new Position(20,21),"P");
				this.board[21][21] = new Wall(new Position(21,21),"P");
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
	
	/**
     * Gets the adjacent tile of the new location to move the gamePiece to
     */
    public Tile getNewLocation(Position current, int direction) {
    	final int x = current.getX();
		final int y = current.getY();

        switch (direction) {
            case 1:
                return board[current.getX()-1][current.getY()];  //north
            case 2:
                return board[current.getX()][current.getY()+1];//east
            case 3:
                return board[current.getX()+1][current.getY()];//south
            case 4:
                return board[current.getX()][current.getY()-1]; //west
            default:
                return null;
        }
    }

	public boolean movePlayer(Player player, int direction) {
		Position oldP = player.getCharacter().getPos();
		System.out.println(oldP);
		Tile oldT = getTile(oldP);
		Tile newT = getNewLocation(oldP,direction);
		
		player.getCharacter().setPos(newT.getPos());;
		System.out.println(player.getCharacter().getPos());

		return false;
	}
    
    

}