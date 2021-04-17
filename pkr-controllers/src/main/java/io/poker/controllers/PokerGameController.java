package io.poker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import io.poker.models.Card;
import io.poker.services.PokerGameService;

/**
 * This class is the controller to handle request from the game console
 * application and communicate to the backend via a service layer
 *
 * @author arshadmayet
 *
 */
@Controller
public class PokerGameController {

	@Autowired
	private PokerGameService service;

	public List<Card> createDeck() {
		return service.createDeck();
	}
	
	public List<Card> getShuffledCards(String gameId) throws Exception {
		return service.getShuffledCards(gameId);
	}

	public List<Card> getHand(String gameId) throws Exception {
		return service.getHand(gameId);
	}

	public void execute(List<Card> hand) {
		service.execute(hand);
	}

	public void play(String gameId) throws Exception {
		List<Card> hand = getHand(gameId);
		execute(hand);
	}

	public int getNumberOfCardsInPlay(String gameId) {
		return service.getNumberOfCardsInPlay(gameId);
	}

	public int getHandSize() {
		return service.getHandSize();
	}
	
	public String getGenGameId() {
		return service.getGenGameId();
	}

	public boolean isGameOver(String gameId) {
		return service.isGameOver(gameId);
	}
}
