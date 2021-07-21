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
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

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
	
	private static List<String> characterNames = new ArrayList<String>(Arrays.asList("Lucilla", "Bert",
            "Melina", "Percy")); // this also indicates the order of turns
	
	private List<String> weaponNames = new ArrayList<String>(Arrays.asList("Broom", "Scissors",
            "Knife", "Shovel", "Ipad"));
	
	private List<String> estateNames = new ArrayList<String>(Arrays.asList("Haunted House", "Manic manor", 
			"Villa Celia", "Calamity Castle", "Peril Palace"));
	
	public static enum Direction {UP, RIGHT, DOWN, LEFT}
	private static int numPlayers = 0; // this can be minimum 3 max of 6
	
	private static Board board;
	private Set<Card> murderSolution;
	private Map<String, Card> allCards;
	private List<Player> players;
	
    public MurderMadness() {
    	// Ask user preliminary information
    	BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    	System.out.println("How many players?");
    	try { 
    		while(true) {
    			numPlayers = Integer.parseInt(input.readLine());
    			if(numPlayers > 0 && numPlayers < 5) { break; }
    			else {
    				System.out.println("Invalid number of players; Please input between 1-4.");
    			}
    		}
    		setup();
    		initializeCards();
    		runGame(numPlayers);
    		input.close(); 
    	} 
    	catch (IOException e) { e.printStackTrace(); }
    }
    
    private void runGame(int numPlayers) {
    	System.out.println("==============================================================");
    	System.out.println("A Game of MurderMadness has just started: "+numPlayers+" players");
    	System.out.println("==============================================================");
    	board = new Board();
    	board.show();
    	for(int i = 0; i < numPlayers; i++) {
    		int roll = (int) (((Math.random() * 6) + 1) + ((Math.random() * 6) + 1));
    		Player p = players.get(i);
    		p.setStepsRemaining(roll);
    		//System.out.println("DEBUG: Before Pos"+p.getPos());
    		
    		onPlayerMove(p);
    		// TODO: Detect when player is inside an Estate
    		// If set/store the estate inside the player
    		// and ask them if they want to refute/make a guess
    		
    		//System.out.println("DEBUG: After Pos"+p.getPos());
    	}
    }
    
    private static void onPlayerMove(Player player) {
    	BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    	player.turnOver = false;
    	System.out.println("==============================================================");
    	System.out.println(player.getName()+"'s Turn");
    	System.out.println("==============================================================");
    	while (player.hasRemainingSteps()) {
    		try {
	    		System.out.println("Steps remaining: "+player.getStepsRemaining());
	    		
	    		String moveSummary = "invalid move!";
	    		
	    		System.out.print("Direction: ");
	    		String dir = input.readLine().toLowerCase();
	
	    		
				System.out.print("Number of Steps: ");
	    		int steps = Integer.parseInt(input.readLine());
	    		System.out.println("-------------------------------------------------------------");
	    		if(steps > player.getStepsRemaining()) { System.out.println("You don't have enough steps!");}
	    		
	    		else {
	    			switch (dir) {
	                    case "w":
	                        if (board.movePlayer(player, Direction.UP, steps)) { 
	                            moveSummary = "Player " + player + " moved UP: "+steps; }
	                        break;
	                    case "d":
	                        if (board.movePlayer(player, Direction.RIGHT, steps)) { 
	                            moveSummary = "Player " + player + " moved RIGHT: "+steps; }
	                        break;
	                    case "s":
	                        if (board.movePlayer(player, Direction.DOWN, steps)) { 
	                            moveSummary = "Player " + player + " moved DOWN: "+steps; }
	                        break;
	                    case "a":
	                        if (board.movePlayer(player, Direction.LEFT, steps)) {
	                            moveSummary = "Player " + player + " moved LEFT"+steps; }
	                        break;
	                    default:
	                        moveSummary = "Invalid input!";
	                        break;
	            	}
    			}
	    		board.show();
	    		System.out.println("==============================================================");
	    		System.out.println(moveSummary);
	    		System.out.println("-------------------------------------------------------------");
    		} catch(Exception e) {
    			System.out.println("Invalid Input: "+e);
    			continue;
    		}
    	}
    }
    
    private void setup() {
    	List<String> remainingChars = new ArrayList<String>();
    	remainingChars.addAll(characterNames);

    	// Initialize Players, players can input which characters they wish to play as
    	players = new ArrayList<Player>();
    	for (int i = 0; i < numPlayers; i++) {
    		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    		try {
				System.out.println("-------------------------------------------------------------");
				System.out.println("Player "+(i+1)+": CHOOSE YOUR CHARACTER");
	    		System.out.println(remainingChars);
	    		while(true) {
	    			boolean found = false;
	    			String inName = input.readLine().trim();
		    		for(String name : remainingChars){
		    			
		    			if(inName.equalsIgnoreCase(name)){
		    				Player p = new Player(name);
		    				players.add(p);
		    				remainingChars.remove(name);
		    				found = true;
		    				break;
		    			}
		    		}
		    		if(found) { break; }
		    		else {
		    			System.out.println("Invalid character name, please choose a character from the list!");
			    		System.out.println("-------------------------------------------------------------");
		    		}
    			}
    		} catch(Exception e) {
    			System.out.println("Invalid Input: "+e.getMessage());
    			continue;
        	}
    		
    	}
    }
    
    /*
     * Initialize the cards, the murder scenario and the hands that the players
     * will be dealt
     */
    public void initializeCards() {
    	// Initialize & Store Respective Cards
    	allCards = new HashMap<String, Card>();
    	murderSolution = new HashSet<Card>();
    	
		List<WeaponCard> weapons = new ArrayList<WeaponCard>();
		for(String w : weaponNames) { 
			WeaponCard weapon = new WeaponCard(w);
			weapons.add(weapon);
			allCards.put(w, weapon);
		}
		
		List<CharacterCard> characters = new  ArrayList<CharacterCard>();
		// Adds the relevant player characters that have been selected by the players (characters that are
		// actually in the game)
		for(Player p : players) {
			CharacterCard character = new CharacterCard(p.getName(), p);
			characters.add(character);
			if (p.getName().equalsIgnoreCase("lucilla")) {
				p.setPos(new Position(11,1));
			} else if (p.getName().equalsIgnoreCase("percy")) {
				p.setPos(new Position(22,14));
			} else if (p.getName().equalsIgnoreCase("melina")) {
				p.setPos(new Position(9,22));
			} else if (p.getName().equalsIgnoreCase("bert")) {
				p.setPos(new Position(1,9));
			}
			allCards.put(p.getName(),character);
		}
		
		List<EstateCard> estates = new  ArrayList<EstateCard>();
		for(String es : estateNames) {
			// TODO load data on the positions of the estates?
			EstateCard estate = new EstateCard(new Estate(es, null));
			estates.add(estate);
			allCards.put(es, estate);
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
    	BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    	while (true) {
    		try {
    			System.out.println("==============================================================");
    			System.out.println("YOU ARE CURRENTLY ACCUSING");
	    		System.out.println("Pick two cards that you think may be in the murder scenario");
	    		System.out.println("==============================================================");
	    		
	    		
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
    	BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    	while (true) {
    		try {
    			Estate estate = null; // TODO: Grab Estate Player is in. player.getEstate();
    			EstateCard estateCard = (EstateCard)allCards.get("Peril Palace");
    			
    			System.out.println("==============================================================");
    			System.out.println("YOU ARE CURRENTLY REFUTING");
	    		System.out.println("You are inside the Peril Palace"); // TODO: Print Estate
	    		System.out.println("==============================================================");
	    		
	    		List<Card> weapons = new ArrayList<Card>();
	    		List<Card> characters = new ArrayList<Card>();
	    		for (Card c: allCards.values()) {
	    			if (!p.getEliminations().contains(c)) {
	    				if (c instanceof WeaponCard)
	    					weapons.add(c);
	    				if (c instanceof CharacterCard)
	    					characters.add(c);
	    			}
	    		}
	    		
	    		Display.displayPossibleCards(weapons);
	    		System.out.print("Guess a WeaponCard: ");
	    		Card weaponCard = allCards.get(Display.capitalize(input.readLine())); 
	    		
	    		if (weaponCard == null) throw new NoSuchElementException("Card does not exist");
	    		System.out.println("-------------------------------------------------------------");
	    		
	    		Display.displayPossibleCards(characters);
	    		System.out.print("Guess a CharacterCard: ");
	    		Card characterCard = allCards.get(Display.capitalize(input.readLine()));
	    		
	    		if (characterCard == null) throw new NoSuchElementException("Card does not exist");
	    		System.out.println("-------------------------------------------------------------");
	    		System.out.println("YOUR GUESSES: "+weaponCard+" & "+characterCard+" inside the Peril Palace"); // TODO: Print Estate
	    		System.out.println("-------------------------------------------------------------");
	    		
	    		// Move Cards into Current Estate
	    		
	    		// TODO: WeaponCard should probably have a move method too
	    		// weapon.move() into this estate
	    		
	    		// TODO: CharacterCard should store a reference to player
	    		// So character.getPlayer().move() into this estate

	    		// Check if a player can refute the guess
	    		Card refutedCard = null;
	    		List<String> order = characterNames.stream()
	    				.filter(character -> !character.equalsIgnoreCase(p.getName()))
	    				.collect(Collectors.toList()); // Filter current player & Ensures an order for guessing

	    		for (String pName: order) {
	    			CharacterCard pChar = (CharacterCard)allCards.get(pName);
	    			Player otherPlayer = pChar.getPlayer();
	    			List<Card> options = otherPlayer.countRefutableCards(weaponCard, characterCard, estateCard);
	    			
		    		if (options.size() > 1) {
		    			System.out.println(otherPlayer+" can refute one of your guesses");
			    		System.out.println("Please pass the tablet to "+otherPlayer+" before proceeding");
			    		System.out.print("Enter any key to proceed..");
			    		input.readLine();
				    	while(true) {
				    		try {
					    		System.out.println("-------------------------------------------------------------");
					    		System.out.println(otherPlayer+"'s turn");
					    		System.out.println("-------------------------------------------------------------");
					    		System.out.println(p+"'s GUESSES: "+weaponCard+" & "+characterCard+" inside the Peril Palace"+""); // TODO: estate.getName()
					    		System.out.println("-------------------------------------------------------------");
					    		System.out.println("Your Hand | "+options);
					    		System.out.println("Enter a number from 1-"+options.size()+" to pick the card");
					    		System.out.print("Choose ONE card to refute a guess: ");
					    		int chosenCard = Integer.parseInt(input.readLine());
					    		refutedCard = options.get(chosenCard);
					    		break;
				    		} catch(Exception e) {e.printStackTrace();continue;}
				    	}
		    		} else if (!options.isEmpty()) {
		    			System.out.println(otherPlayer+" has refuted one of your guesses");
		    			refutedCard = options.get(0);
		    		}
		    		break;
	    		}
	    		
	    		if (refutedCard != null) {
					System.out.println(refutedCard+" is no longer possible for this murder scenario");
					p.addToEliminations(refutedCard);
	    		} else {
	    			System.out.println("No one could refute your guesses");
	    			System.out.println("Potential MurderScenario could be: "+weaponCard+" & "+characterCard+" inside Peril Palace"+""); // TODO: estate.getName()
	    		}
	    		System.out.println("-------------------------------------------------------------");
	    		break;
    		} catch(Exception e) {
    			System.out.println("-------------------------------------------------------------");
    			System.out.println("Invalid Input: "+e.getMessage());
    			continue;
    		}
    	}
    }
    
    
	public static void main(String[] args) {
		new MurderMadness();
	}
}