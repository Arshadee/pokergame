package io.poker.game.fivecards.rankrules;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import io.poker.core.IRankRule;
import io.poker.models.Card;

/**
 * Implementation for Flush Rank
 * implements IRankRule
 * 
 * @author arshadmayet
 *
 */
public class Flush implements IRankRule {

	private static final Integer RANK = 4;
	private static final String RANK_NAME = "Flush";

	private IRankRule next;

	public Flush() {
		//this.next = new Straight();
	}

	@Override
	public boolean singleCheck(List<Card> hand) {
		Map<String, Integer> checkMap = new HashMap<>();
		boolean match = false;
		for (Card card : hand) {
			if (checkMap.get(card.getSuite()) == null) {
				checkMap.put(card.getSuite(), 1);
			} else {
				Integer count = checkMap.get(card.getSuite()) + 1;
				checkMap.put(card.getSuite(), count);
			}
		}

		match = (checkMap.keySet().size() == 1);

		return match;

	}

	@Override
	public IRankRule check(List<Card> hand) {
		if (singleCheck(hand)) {
			return this;
		} else {
			return next.check(hand);
		}
	}

	@Override
	public Integer getRank() {
		return RANK;
	}

	@Override
	public String getRankName() {
		return RANK_NAME;
	}

	@Override
	public IRankRule next() {
		return next;
	}

	@Override
	public void setNext(IRankRule next) {
		this.next = next;
	}
}
