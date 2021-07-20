package swen225.murdermadness.cards;

/**
 * Represents a Card for corresponding to a character
 * @author grantrona
 *
 */
public class CharacterCard implements Card{
	
	final private String character;
	
	public CharacterCard(String character) {
		this.character = character;
	}
	
	public String getCharacter() {
		return this.character;
	}

	@Override
	public String getDescription() {
		return "Character: "+ this.character;
	}
}
