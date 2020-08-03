package io.poker.game.fivecards.rankrules;

import java.util.Collections;
import java.util.List;

import io.poker.core.IRankRule;
import io.poker.models.Card;

public class Straight implements IRankRule {

	private static final Integer RANK = 5;
	private static final String RANK_NAME = "Straight";

	private IRankRule next;

	public Straight() {

	}

	@Override
	public boolean singleCheck(List<Card> hand) {
		boolean match = true;
		boolean flip = hand.stream().anyMatch(c -> c.getRankName().equals("2"));

		Collections.sort(hand, (c1, c2) -> {
			if (c1.getRankValue(flip) == c2.getRankValue(flip))
				return 0;
			else if (c1.getRankValue(flip) > c2.getRankValue(flip))
				return 1;
			else
				return -1;
		});

		for (int i = 0; i < hand.size() - 1; i++) {
			int x = hand.get(i).getRankValue(flip) + 1;
			int y = hand.get(i + 1).getRankValue(flip);
			if (x != y) {
				match = false;
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
