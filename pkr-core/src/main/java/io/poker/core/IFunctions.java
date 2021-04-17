package io.poker.core;

import java.util.ArrayList;
import java.util.List;

import io.poker.models.Card;

/**
 * Functions interface to be implemented by any game implementation
 * used to decouple the specific game implementation from the rest 
 * of the solution
 * 
 * @author arshadmayet
 *
 */
public interface IFunctions {

	public default List<Card> createDeck() {
		List<Card> deck = new ArrayList<>();
		Deck cardDeck = new Deck();
		deck = cardDeck.create();
		return deck;
	}

	public List<Card> shuffle(String gameId, List<Card> cards) throws Exception;

	public List<Card> dealHand(String gameId);
	
	public int getHandSize();
	
	public String genGameId();
	
	public List<Card> getDeckforGame(String gameId);
	
	public boolean isGameOver(String gameId);
	
	

}
