package io.poker.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.poker.core.AbstractRulesExecutor;
import io.poker.core.IFunctions;
import io.poker.models.Card;

/**
 * This is a service class - stateless
 * to make calls directly to back end data store
 * 
 * @author arshadmayet
 *
 */
@Component
public class PokerGameService {

	@Autowired
	private IFunctions functions; 

	@Autowired
	private AbstractRulesExecutor rulesExecutor;
	
	public List<Card> createDeck(){
		return functions.createDeck();
	}
	
	public List<Card> getShuffledCards(String gameId) throws Exception {
		List<Card> cards = functions.shuffle(gameId, functions.createDeck());
		return cards;
	}

	public List<Card> getHand(String gameId) throws Exception {
		return functions.dealHand(gameId);
	}

	public void execute(List<Card> hand) {
		rulesExecutor.execute(hand);
	} 
	
	public int getNumberOfCardsInPlay(String gameId) {
		List<Card> cards = functions.getDeckforGame(gameId);
		return cards.stream().filter(c -> !c.isPlayed())
				.collect(Collectors.toList()).size();
	}
	
	public int getHandSize() {
		return functions.getHandSize();
	}
	
	public String getGenGameId() {
		return functions.genGameId();
	}
	
	public boolean isGameOver(String gameId) {
		return functions.isGameOver(gameId);
	}

}
