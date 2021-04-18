package io.poker.game.fivecards.rankrules;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.poker.core.AbstractRulesExecutor;
import io.poker.core.IRankRule;
import io.poker.models.Card;
import io.poker.models.Hand;

public class StraighFlushTest {

	IRankRule set = new StraightFlush();
	AbstractRulesExecutor rulesExecutor = new RulesExecutor();

	@Test
	void testStraightFlushMatchOne() {
		List<Card> hand1 = new ArrayList<>();
		hand1.add(new Card("10", 10, "Hearts","\u2764"));
		hand1.add(new Card("Queen", 12, "Hearts","\u2764"));
		hand1.add(new Card("Ace", 14, "Hearts","\u2764"));
		hand1.add(new Card("Jack", 11, "Hearts","\u2764"));
		hand1.add(new Card("King", 13, "Hearts","\u2764"));

		Boolean expected = true;
		Boolean actual = set.singleCheck(hand1);
		Assertions.assertEquals(expected, actual);
	}

	@Test
	void testStraightFlushtMatchTwo() {
		List<Card> hand2 = new ArrayList<>();
		hand2.add(new Card("Ace", 14, "Clubs","\u2663"));
		hand2.add(new Card("3", 3, "Clubs","\u2663"));
		hand2.add(new Card("5", 5, "Clubs","\u2663"));
		hand2.add(new Card("4", 4, "Clubs","\u2663"));
		hand2.add(new Card("2", 2, "Clubs","\u2663"));

		Boolean expected = true;
		Boolean actual = set.singleCheck(hand2);
		Assertions.assertEquals(expected, actual);
	}

	@Test
	void testStraightFlushtNoMatchOne() {
		List<Card> hand3 = new ArrayList<>();
		hand3.add(new Card("10", 10, "Hearts","\u2764"));
		hand3.add(new Card("3", 3, "Hearts","\u2764"));
		hand3.add(new Card("2", 2, "Hearts","\u2764"));
		hand3.add(new Card("King", 13, "Hearts","\u2764"));
		hand3.add(new Card("Ace", 14, "Hearts","\u2764"));

		Boolean expected = false;
		Boolean actual = set.singleCheck(hand3);
		Assertions.assertEquals(expected, actual);
	}

	@Test
	void testStraightFlushtNoMatchTwo() {
		List<Card> hand4 = new ArrayList<>();
		hand4.add(new Card("Ace", 14, "Clubs","\u2663"));
		hand4.add(new Card("3", 3, "Clubs","\u2663"));
		hand4.add(new Card("5", 5, "Clubs","\u2663"));
		hand4.add(new Card("4", 4, "Clubs","\u2663"));
		hand4.add(new Card("2", 2, "Hearts","\u2764"));

		Boolean expected = false;
		Boolean actual = set.singleCheck(hand4);
		Assertions.assertEquals(expected, actual);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testStraightFlushMatchingHand() {
		List<Card> hand1 = new ArrayList<>();
		hand1.add(new Card("10", 10, "Hearts","\u2764"));
		hand1.add(new Card("Queen", 12, "Hearts","\u2764"));
		hand1.add(new Card("Ace", 14, "Hearts","\u2764"));
		hand1.add(new Card("Jack", 11, "Hearts","\u2764"));
		hand1.add(new Card("King", 13, "Hearts","\u2764"));
		Hand hand = new Hand();
		hand.setHand(hand1);
		
		List<IRankRule> rules = (List<IRankRule>) rulesExecutor.getRuleSetObjects();
		rules = rulesExecutor.chain(rules);
		
		IRankRule rule = rules.get(0).check(hand1);

		Boolean expected = true;
		Boolean actual = rule.getClass() == StraightFlush.class;
		Assertions.assertEquals(expected, actual);

	}
}
