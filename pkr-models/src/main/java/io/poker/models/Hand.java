package io.poker.models;

import java.util.ArrayList;
import java.util.List;

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
		String output = "Hand [hand=" + hand + ", "+System.lineSeparator()+"handRank=" + handRank + "]";//+System.lineSeparator();
		output =output+"\n -----> \n";
		for(Card card : hand) {
			output = output+"["+card.getRankName()+" "+card.getSuite()+"] ";
		}
		output = output+System.lineSeparator()+" handRank = " + handRank;
		return output;
	}
	
	
    
}
