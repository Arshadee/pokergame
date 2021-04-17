package io.poker.game.fivecards.rankrules;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.poker.core.IRankRule;
import io.poker.models.Card;

/**
 * Implementation for FourKind Rank
 * implements IRankRule
 * 
 * @author arshadmayet
 *
 */
public class FourKind implements IRankRule {

	private static final Integer RANK = 2;
	private static final String RANK_NAME = "FourKind";

	private IRankRule next;

	public FourKind() {
		//this.next = new FullHouse();
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
			if (checkMap.get(cardRank) == 4) {
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
