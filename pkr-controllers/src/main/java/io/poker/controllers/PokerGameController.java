package io.poker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import io.poker.models.Card;
import io.poker.services.PokerGameService;

@Controller
public class PokerGameController {

	@Autowired
	private PokerGameService service;

	public List<Card> getShuffledCards() throws Exception {
		return service.getShuffledCards();
	}

	public List<Card> getHand() throws Exception {
		return service.getHand();
	}

	public void execute(List<Card> hand) {
		service.execute(hand);
	}

	public void play() throws Exception {
		List<Card> cards = getHand();
		execute(cards);
	}
}
