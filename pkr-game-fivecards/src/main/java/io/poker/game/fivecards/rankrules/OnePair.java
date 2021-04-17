package io.poker.game.fivecards.rankrules;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.poker.core.IRankRule;
import io.poker.models.Card;

/**
 * Implementation for OnePair Rank
 * implements IRankRule
 * 
 * @author arshadmayet
 *
 */
public class OnePair implements IRankRule {

	private static final Integer RANK = 8;
	private static final String RANK_NAME = "OnePair";

	private IRankRule next;

	public OnePair() {
		
	}

	@Override
	public boolean singleCheck(List<Card> hand) {
		Map<String, Integer> checkMap = new HashMap<>();
		boolean match = false;

		for (Card card : hand) {
			if (checkMap.get(card.getRankName()) == null) {
				checkMap.put(card.getRankName(), 1);
			} else {
				Integer count = checkMap.get(card.getRankName()) + 1;
				checkMap.put(card.getRankName(), count);
			}
		}

		for (String cardRank : checkMap.keySet()) {
			if (checkMap.get(cardRank) == 2) {
				match = true;
				break;
			}
		}
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