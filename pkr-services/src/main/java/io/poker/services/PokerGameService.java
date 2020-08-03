package io.poker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.poker.core.AbstractRulesExecutor;
import io.poker.core.IFunctions;
import io.poker.models.Card;

@Component
public class PokerGameService {

	@Autowired
	private IFunctions functions; 

	@Autowired
	private AbstractRulesExecutor rulesExecutor;

	public List<Card> getShuffledCards() throws Exception {
		List<Card> cards = functions.shuffle(functions.createDeck());
		return cards;
		
	}

	public List<Card> getHand() throws Exception {
		return functions.dealHand(getShuffledCards());
	}

	public void execute(List<Card> hand) {
		rulesExecutor.execute(hand);
	}

}
