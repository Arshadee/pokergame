package io.poker.models;

import java.util.ArrayList;
import java.util.List;

public class Dealer {
	
	private List<Card> currentDeck;
	
	public Dealer() {
		this.currentDeck = new ArrayList<>();	
	}
	
	public Dealer(List<Card> currentDeck) {
		this.currentDeck = currentDeck;	
	}

	public List<Card> getCurrentDeck() {
		return currentDeck;
	}

	public void setCurrentDeck(List<Card> currentDeck) {
		this.currentDeck = currentDeck;
	}
	

}
