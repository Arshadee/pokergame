package io.poker.game.fivecards.rankrules;

import java.util.List;

import io.poker.core.IRankRule;
import io.poker.models.Card;

public class FullHouse implements IRankRule {

	private static final Integer RANK = 3;
	private static final String RANK_NAME = "FullHouse";

	private IRankRule next;

	public FullHouse() {
		
	}

	public boolean singleCheck(List<Card> hand) {
		IRankRule threeKind = new ThreeKind();
		IRankRule onePair = new OnePair();
		return threeKind.singleCheck(hand) && onePair.singleCheck(hand);
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
