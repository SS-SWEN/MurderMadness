package swen225.murdermadness.cards;

/**
 * Represents a Card for corresponding to a character
 * @author grantrona
 *
 */
public class CharacterCard implements Card{
	
	final private Character character;
	
	public CharacterCard(Character character) {
		this.character = character;
	}
	
	public Character getCharacter() {
		return this.character;
	}

	@Override
	public String getDescription() {
		return "Character: "+ this.character.getName();
	}
}
