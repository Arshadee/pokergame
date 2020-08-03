package io.poker.game.fivecards.rankrules;

import java.util.List;

import io.poker.core.IRankRule;
import io.poker.models.Card;

public class HighCards implements IRankRule {

	private static final Integer RANK = 9;
	private static final String RANK_NAME = "HighCards";

	private IRankRule next;

	public HighCards() {
		
	}

	@Override
	public boolean singleCheck(List<Card> hand) {
		return match(hand);
	}

	@Override
	public IRankRule check(List<Card> hand) {
		if (singleCheck(hand))
			return this;
		else
			return null;
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

	private Boolean match(List<Card> hand) {
//		return rulesExecutor.getRuleSetObjects().stream().filter(r -> r.getClass() == this.getClass())
//				.allMatch(r -> !r.singleCheck(hand));

		return (!new OnePair().singleCheck(hand) && !new TwoPairs().singleCheck(hand)
				&& !new ThreeKind().singleCheck(hand) && !new Straight().singleCheck(hand)
				&& !new Flush().singleCheck(hand) && !new FullHouse().singleCheck(hand)
				&& !new StraightFlush().singleCheck(hand) && !new FourKind().singleCheck(hand)

		);

	}

}
