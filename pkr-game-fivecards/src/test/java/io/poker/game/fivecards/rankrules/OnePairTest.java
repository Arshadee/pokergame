package io.poker.game.fivecards.rankrules;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.poker.core.AbstractRulesExecutor;
import io.poker.core.IRankRule;
import io.poker.models.Card;
import io.poker.models.Hand;

public class OnePairTest {

	IRankRule set = new OnePair();
	AbstractRulesExecutor rulesExecutor = new RulesExecutor();

	@Test
	void testOnePairMatchOne() {
		List<Card> hand1 = new ArrayList<>();
		hand1.add(new Card("Ace", 14, "Hearts"));
		hand1.add(new Card("Ace", 14, "Spades"));
		hand1.add(new Card("King", 13, "Clubs"));
		hand1.add(new Card("10", 10, "Clubs"));
		hand1.add(new Card("Jack", 11, "Clubs"));

		Boolean expected = true;
		Boolean actual = set.singleCheck(hand1);
		Assertions.assertEquals(expected, actual);
	}

	@Test
	void testOnePairNoMatchOne() {
		List<Card> hand2 = new ArrayList<>();

		hand2.add(new Card("Ace", 14, "Hearts"));
		hand2.add(new Card("Queen", 12, "Spades"));
		hand2.add(new Card("King", 13, "Clubs"));
		hand2.add(new Card("10", 10, "Clubs"));
		hand2.add(new Card("Jack", 11, "Clubs"));

		Boolean expected = false;
		//Boolean actual = (set.check(hand2) == null)? false : set.check(hand2).getClass() == OnePair.class;
		Boolean actual = set.singleCheck(hand2);
		Assertions.assertEquals(expected, actual);
	}

	@Test
	void testOnePairNoMatchTwo() {
		List<Card> hand3 = new ArrayList<>();

		hand3.add(new Card("Ace", 14, "Hearts"));
		hand3.add(new Card("Ace", 14, "Spades"));
		hand3.add(new Card("Ace", 14, "Clubs"));
		hand3.add(new Card("10", 10, "Clubs"));
		hand3.add(new Card("Jack", 11, "Clubs"));

		Boolean expected = false;
		Boolean actual = set.singleCheck(hand3);
		Assertions.assertEquals(expected, actual);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testOnePairMatchingHand() {
		List<Card> hand1 = new ArrayList<>();
		hand1.add(new Card("Ace", 14, "Hearts"));
		hand1.add(new Card("Ace", 14, "Spades"));
		hand1.add(new Card("King", 13, "Clubs"));
		hand1.add(new Card("10", 10, "Clubs"));
		hand1.add(new Card("Jack", 11, "Clubs"));
		Hand hand = new Hand();
		hand.setHand(hand1);

		List<IRankRule> rules = (List<IRankRule>) rulesExecutor.getRuleSetObjects();
		rules = rulesExecutor.chain(rules);
		
		IRankRule rule = rules.get(0).check(hand1);

		Boolean expected = true;
		Boolean actual = rule.getClass() == OnePair.class;
		Assertions.assertEquals(expected, actual);

	}

}
