package swen225.murdermadness;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;

import swen225.murdermadness.cards.Card;
import swen225.murdermadness.cards.Character;
import swen225.murdermadness.cards.CharacterCard;
import swen225.murdermadness.cards.EstateCard;
import swen225.murdermadness.cards.WeaponCard;
import swen225.murdermadness.view.*;

/*
 * MurderMadness 
 * - Main class for all the logic in the game.
 */
public class MurderMadness {
	
	private static int Players = 0; // this can be minimum 3 max of 6
	
	
	private List<String> characterNames = new ArrayList<String>(Arrays.asList("Lucilla", "Bert",
            "Melina", "Percy")); // this also indicates the order of turns
	
	private List<String> weaponNames = new ArrayList<String>(Arrays.asList("Broom", "Scissors",
            "Knife", "Shovel", "Ipad"));
	
	private List<String> estateNames = new ArrayList<String>(Arrays.asList("Haunted House", "Manic manor", 
			"Villa Celia", "Calamity Castle", "Peril Palace"));
	
	private Board game;
	private Set<Card> murderSolution;
	private List<Player> players;
	
    public MurderMadness() {
    	// TESTING
    	//onAccusation(null);
    	
    	//Ask user preliminary stuff i.e. total players playing..etc
    	BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    	System.out.println("How many players?");
    	try { 
    		setup(input.read());
    		input.close(); 
    		} 
    	catch (IOException e) { e.printStackTrace(); }
    }
    
    
    void setup(int totalPlayers) {
    	
    	List<String> remainingChars = new ArrayList<String>();
    	remainingChars.addAll(characterNames);

    	// Initialize Players, players can input which characters they wish to play as
    	players = new ArrayList<Player>();
    	for (int i = 0;i < characterNames.size();i++) {
    		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    		try {
				System.out.println("-------------------------------------------------------------");
				System.out.println("Player "+i+": CHOOSE YOUR CHARACTER");
	    		System.out.println(remainingChars);
	    		while(true) {
	    			boolean found = false;
	    			String inName = input.readLine().trim();
		    		for(String name : remainingChars){
		    			
		    			if(inName.equalsIgnoreCase(name)){
		    				Player p = new Player(new Character(name));
		    				players.add(p);
		    				remainingChars.remove(name);
		    				found = true;
		    				break;
		    			}
		    		}
		    		if(found) { break; }
		    		else {
		    			System.out.println("Invalid character name, please choose a character from the list!");
		    		}
    			}
	    		System.out.println("-------------------------------------------------------------");
	    		
    		} catch(Exception e) {
    			System.out.println("Invalid Input: "+e.getMessage());
    			continue;
        	}
    		
    	}
    	
    	initializeCards();
		game = new Board();
		game.show();
    }
    
    /*
     * Initialize the cards, the murder scenario and the hands that the players
     * will be dealt
     */
    public void initializeCards() {
    	// Initialize & Store Respective Cards
    	murderSolution = new HashSet<Card>();
    	
		List<WeaponCard> weapons = new ArrayList<WeaponCard>();
		for(String w : weaponNames) {
			weapons.add(new WeaponCard(w));
		}
		
		List<CharacterCard> characters = new  ArrayList<CharacterCard>();
		// adds the relevant player characters that have been selected by the players (characters that are
		// actually in the game)
		for(Player p : players) {
			characters.add(new CharacterCard(p.getCharacter()));
		}
		
		List<EstateCard> estates = new  ArrayList<EstateCard>();
		for(String es : estateNames) {
			//TODO load data on the positions of the estates?
		}
		
		// Set up Murder Circumstances
		Random ran = new Random();
		Collections.shuffle(weapons);Collections.shuffle(characters);Collections.shuffle(estates);
		murderSolution.add(weapons.remove(ran.nextInt(weapons.size())));
		murderSolution.add(characters.remove(ran.nextInt(characters.size())));
		murderSolution.add(estates.remove(ran.nextInt(estates.size())));
		
		// Distribute Remaining Cards to Players
		List<Card> remaining = new ArrayList<Card>();
		remaining.addAll(weapons);remaining.addAll(characters);remaining.addAll(estates);
		
		while(!remaining.isEmpty()) {
			for(Player p : players) {
				if(remaining.isEmpty()) { break; }
				p.addToHand(remaining.get(0));
				remaining.remove(0);
			}
		}
    }

    /*
     * A player attempts to solve the murder scenario.
     */
    public void onAccusation(Player p) {
    	boolean accusing = true;
    	BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    	while (accusing) {
    		try {
    			System.out.println("-------------------------------------------------------------");
    			System.out.println("YOU ARE CURRENTLY ACCUSING");
	    		System.out.println("Pick two cards that you think may be in the murder scenario");
	    		System.out.println("-------------------------------------------------------------");
	    		
	    		
    		} catch(Exception e) {
    			System.out.println("Invalid Input: "+e.getMessage());
    			continue;
    		}
    	}
    }
    
    
    /*
     * A player attempts to guess a card that may or may not exist in the murder scenario.
     */
    public void onRefute(Player p) {
    	boolean accusing = true;
    	BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    	while (accusing) {
    		try {
    			System.out.println("-------------------------------------------------------------");
    			System.out.println("YOU ARE CURRENTLY REFUTING");
	    		System.out.println("You are inside the Peril Palace"); // TODO: Print Estate Player is in.
	    		System.out.println("-------------------------------------------------------------");
	    		
	    		System.out.print("Choose a Weapon: ");
	    		String weapon = input.readLine(); // Could probably use a map to grab the card.
	    		
	    		System.out.print("Choose a Character: ");
	    		String character = input.readLine();
	    		
	    		// if the grab is unsuccessful then the card should be null
	    		if (character.equals(null)) {
	    			
	    		}
	    		
	    		
	    		
    		} catch(Exception e) {
    			System.out.println("Invalid Input: "+e.getMessage());
    			continue;
    		}
    	}
    }
    
    
	public static void main(String[] args) {
		new MurderMadness();
	}
}
