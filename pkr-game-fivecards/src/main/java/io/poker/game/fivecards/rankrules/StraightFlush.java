package io.poker.game.fivecards.rankrules;

import java.util.List;

import io.poker.core.IRankRule;
import io.poker.models.Card;

public class StraightFlush implements IRankRule {

	private static final Integer RANK = 1;
	private static final String RANK_NAME = "StraightFlush";

	private IRankRule next;

	public StraightFlush() {

	}

	@Override
	public boolean singleCheck(List<Card> hand) {
		IRankRule flush = new Flush();
		IRankRule straight = new Straight();
		return flush.singleCheck(hand) && straight.singleCheck(hand);
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
