package swen225.murdermadness;
import java.util.*;

import swen225.murdermadness.cards.*;
import swen225.murdermadness.cards.Character;

/**
 * Represent the Player of a particular round
 * @author grantrona
 */

public class Player {
	
	final private Character playerCharacter;
	private List<Card> hand = new ArrayList<Card>();

	/**
	 * @return A String containing the descriptions of all the cards in the current players hand
	 */
	public String showHand(){
		if(hand.isEmpty()) { return playerCharacter.getName()+"'s hand is empty!"; }
		
		StringBuilder sb = new StringBuilder();
		sb.append(playerCharacter.getName()+"'s hand"+"\n");
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
	
	public Character getCharacter() {
		return this.playerCharacter;
	}
	
	public void addToHand(Card c) {
		hand.add(c);
	}
	
	public void setHand(List<Card> cards) {
		this.hand = cards;
	}
	
	public Player(Character playerCharacter) {
		this.playerCharacter = playerCharacter;
	}
	

}
