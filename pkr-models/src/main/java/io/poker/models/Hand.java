package io.poker.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class to be instantiated for object to hold the hand thats dealt and its rank
 * 
 * @author arshadmayet
 *
 */
public class Hand {
	
	private List<Card> hand;
	private HandRank handRank;
	
	public Hand() {
		hand = new ArrayList<>();
	}
	
	public Hand(List<Card> hand, HandRank handRank) {
		this.hand = hand;
		this.handRank = handRank;
	}

	public List<Card> getHand() {
		return hand;
	}

	public void setHand(List<Card> hand) {
		this.hand = hand;
	}

	public HandRank getHandRank() {
		return handRank;
	}

	public void setHandRank(HandRank handRank) {
		this.handRank = handRank;
	}

	@Override
	public String toString() {
		String output = "hand=" + hand + ", "+System.lineSeparator()+ handRank + "]";
		output =output+"\n -----> \n";
		for(Card card : hand) {
			output = output+"["+card.getRankName().replace("_", "")+" "+card.getSuiteSymbol()+"] ";
		}
		output = output+System.lineSeparator()+ handRank;
		return output;
	}
    
}
