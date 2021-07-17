package swen225.murdermadness.cards;
import swen225.murdermadness.*;

/*
 * Card that corresponds to an Estate
 */

public class EstateCard implements Card  {
	
final private Estate estate;
	
	public EstateCard(Estate estate) {
		this.estate = estate;
	}

	@Override
	public String getDescription() {
		return "Estate: "+this.estate.getName();
	}

}
