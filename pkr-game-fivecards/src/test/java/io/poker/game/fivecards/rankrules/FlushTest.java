package io.poker.game.fivecards.rankrules;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.poker.core.AbstractRulesExecutor;
import io.poker.core.IRankRule;
import io.poker.models.Card;
import io.poker.models.Hand;

public class FlushTest {
	
	IRankRule set = new Flush();
	AbstractRulesExecutor rulesExecutor = new RulesExecutor();
	
	@Test
	void testFlushMatchOne() {
		List<Card> hand1 = new ArrayList<>();
		hand1.add(new Card("Ace", 14, "Hearts","\u2764"));
		hand1.add(new Card("King", 13, "Hearts","\u2764"));
		hand1.add(new Card("Queen", 12, "Hearts","\u2764"));
		hand1.add(new Card("_8", 8, "Hearts","\u2764"));
		hand1.add(new Card("_10", 10, "Hearts","\u2764"));

		Boolean expected = true;
		Boolean actual = set.singleCheck(hand1);
		Assertions.assertEquals(expected, actual);
	}

	@Test
	void testFlushNoMatchOne() {
		List<Card> hand = new ArrayList<>();
		hand.add(new Card("Ace", 14, "Hearts","\u2764"));
		hand.add(new Card("Ace", 14, "Spades","\u2660"));
		hand.add(new Card("King", 13, "Clubs","\u2663"));
		hand.add(new Card("King", 13, "Hearts","\u2764"));
		hand.add(new Card("Jack", 11, "Clubs","\u2663"));

		Boolean expected = false;
		Boolean actual = set.singleCheck(hand);
		Assertions.assertEquals(expected, actual);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testFlushMatchingHand() {
		List<Card> hand1 = new ArrayList<>();
		hand1.add(new Card("Ace", 14, "Hearts","\u2764"));
		hand1.add(new Card("King", 13, "Hearts","\u2764"));
		hand1.add(new Card("Queen", 12, "Hearts","\u2764"));
		hand1.add(new Card("_8", 8, "Hearts","\u2764"));
		hand1.add(new Card("_10", 10, "Hearts","\u2764"));

		Hand hand = new Hand();
		hand.setHand(hand1);

	
		List<IRankRule> rules = (List<IRankRule>) rulesExecutor.getRuleSetObjects();
		rules = rulesExecutor.chain(rules);
		
		IRankRule rule = rules.get(0).check(hand1);
		
		Boolean expected = true;
		Boolean actual = rule.getClass() == Flush.class;
		Assertions.assertEquals(expected, actual);

	}

}
