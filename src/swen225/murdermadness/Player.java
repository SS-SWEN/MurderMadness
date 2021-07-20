package swen225.murdermadness;
import java.util.*;


import swen225.murdermadness.cards.*;
import swen225.murdermadness.view.Position;

/**
 * Represent the Player of a particular round
 * @author grantrona
 */

public class Player {
	
	final private String name;
	private Position pos;
	private Position prevPos;
	
	private List<Card> hand = new ArrayList<Card>();
	private boolean inGame = true;

	/**
	 * @return A String containing the descriptions of all the cards in the current players hand
	 */
	public String showHand(){
		if(hand.isEmpty()) { return name+"'s hand is empty!"; }
		
		StringBuilder sb = new StringBuilder();
		sb.append(name+"'s hand"+"\n");
		for(Card c : hand) {
			sb.append(c.getDescription()).append(", ");
		}
		
		return sb.toString();
	}
	
	/**
	 * @return the hand of Cards that the Character holds
	 */
	public List<Card> getHand() {
		return Collections.unmodifiableList(hand);
	}
	
	public String getName() {
		return this.name;
	}
	
	public void addToHand(Card c) {
		hand.add(c);
	}
	
	public void setHand(List<Card> cards) {
		this.hand = cards;
	}
	
	public Player(String name) {
		this.name = name;
	}
	
	/**
     * Player movement Below --------------------------------------------------------------
     */
	
	/**
     * Shorthand representation of this player for
     * displaying the player on the board
     */
    public String display() {
    	String s = this.name;
        return "" + s.charAt(0);
    }
    
	/**
     * Number of steps this player has left
     */
    private int stepsRemaining = 0;
    
    /**
     * Check whether this player still has steps
     */
    public boolean hasRemainingSteps() {
        return this.stepsRemaining > 0;
    }
    
    /**
     * Set the number of steps this player rolled on the die
     */
    public void setStepsRemaining(int steps) {
        this.stepsRemaining = steps;
    }
    
    public void decrementStep() {
    	this.stepsRemaining--;
    }
    
    /**
     * Get the amount of steps this player has remaining
     * @return the integer number of steps
     */
    public int getStepsRemaining() {
        return stepsRemaining;
    }
    
    
    public void setPos(Position pos) {
		this.pos = pos;
	}
	
	public void setPrevPos(Position prev) {
		this.prevPos = prev;
	}
	
	public Position getPos() {
		return this.pos;
	}
	
	public Position getPrevPos() {
		return this.prevPos;
	}
    
    /**
     * X and Y coordinates of the player
     */
    //public int x, y;
	public boolean turnOver;
    
    /**
     * Updates the x and y coordinates of this player
     */
	
    public void updateLocation(Position nextPos) {
    	//this.x = p.getX();
        //this.y = p.getY();
    	this.prevPos = this.pos;
    	this.pos = nextPos;
    }
    
	

}