package io.poker.core;

import java.util.ArrayList;
import java.util.List;

import io.poker.models.Card;

public interface IFunctions {

	public default List<Card> createDeck() {
		List<Card> deck = new ArrayList<>();
		Deck cardDeck = new Deck();
		deck = cardDeck.create();
		return deck;
	}

	public List<Card> shuffle(List<Card> cards) throws Exception;

	public List<Card> dealHand(List<Card> shuffledCards);

}
