package swen225.murdermadness;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import swen225.murdermadness.view.*;

/*
 * MurderMadness 
 * - Main class for all the logic in the game.
 */
public class MurderMadness {
	
	private static int Players = 0; // this can be minimum 3 max of 6
	
	private List<String> characterNames = new ArrayList<String>(Arrays.asList("Lucilla", "Bert",
            "Melina", "percy"));
	
	private List<String> weaponNames = new ArrayList<String>(Arrays.asList("Broom", "Scissors",
            "Knife", "Shovel", "Ipad"));
	
	private List<String> estateNames = new ArrayList<String>(Arrays.asList("Haunted House", "Manic manor",
            "Villa Celia", "Calamity Castle", "Peril Palace"));
	

    public MurderMadness() {
		Board board = new Board();
		board.show();
    }
    
    
    
	public static void main(String[] args) {
		new MurderMadness();
	}
}
