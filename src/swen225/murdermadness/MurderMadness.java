package swen225.murdermadness;

import java.io.BufferedReader;
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
            "Melina", "percy"));
	
	private List<String> weaponNames = new ArrayList<String>(Arrays.asList("Broom", "Scissors",
            "Knife", "Shovel", "Ipad"));
	
	private List<String> estateNames = new ArrayList<String>(Arrays.asList("Haunted House", "Manic manor", 
			"Villa Celia", "Calamity Castle", "Peril Palace"));
	
	private Board game;
	private Set<Card> murderSolution;
	private List<Player> players;
	
    public MurderMadness() {
    	// TESTING
    	onAccusation(null);
    	
    	// TODO: Ask user preliminary stuff i.e. total players playing..etc
    	setup(4);
    }
    
    void setup(int totalPlayers) {

    	// Initialize Players
    	players = new ArrayList<Player>();
    	for (int i = 0;i < characterNames.size();i++) {
    		Player p = new Player(); // TODO: Update when Player Class Finished
    		players.add(p);
    	}
    	
    	// Initialize & Store Respective Cards
    	murderSolution = new HashSet<Card>();
		List<WeaponCard> weapons = new ArrayList<WeaponCard>();
		List<CharacterCard> characters = new  ArrayList<CharacterCard>();
		List<EstateCard> estates = new  ArrayList<EstateCard>();
		
		// TODO: Initialize Cards
		
		// Set up Murder Circumstances
		Random ran = new Random();
		Collections.shuffle(weapons);Collections.shuffle(characters);Collections.shuffle(estates);
		murderSolution.add(weapons.remove(ran.nextInt(weapons.size())));
		murderSolution.add(characters.remove(ran.nextInt(characters.size())));
		murderSolution.add(estates.remove(ran.nextInt(estates.size())));
		
		// Distribute Remaining Cards to Players

		List<Card> remaining = new ArrayList<Card>();
		remaining.addAll(weapons);remaining.addAll(characters);remaining.addAll(estates);
		
		
		for (Card c: remaining) {
			for (Player p: players) {
				// TODO: p.addHand(c);
			}
		}
		
		game = new Board();
		game.show();
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
