package io.poker.game.fivecards.rankrules;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.poker.core.AbstractRulesExecutor;
import io.poker.core.IRankRule;
import io.poker.models.Card;
import io.poker.models.Hand;

public class ThreeKindTest {

	IRankRule set = new ThreeKind();
	AbstractRulesExecutor rulesExecutor = new RulesExecutor();

	@Test
	void testThreeKindMatchOne() {
		List<Card> hand1 = new ArrayList<>();
		hand1.add(new Card("Ace", 14, "Hearts"));
		hand1.add(new Card("Ace", 14, "Spades"));
		hand1.add(new Card("Ace", 14, "Clubs"));
		hand1.add(new Card("10", 10, "Clubs"));
		hand1.add(new Card("Jack", 11, "Clubs"));

		Boolean expected = true;
		Boolean actual = set.singleCheck(hand1);
		Assertions.assertEquals(expected, actual);
	}

	@Test
	void testThreeKindNoMatchOne() {
		List<Card> hand2 = new ArrayList<>();
		hand2.add(new Card("Ace", 14, "Hearts"));
		hand2.add(new Card("Ace", 14, "Spades"));
		hand2.add(new Card("King", 13, "Clubs"));
		hand2.add(new Card("10", 10, "Clubs"));
		hand2.add(new Card("Jack", 11, "Clubs"));

		Boolean expected = false;
		Boolean actual = set.singleCheck(hand2);
		Assertions.assertEquals(expected, actual);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testThreeKindhMatchingHand() {
		List<Card> hand1 = new ArrayList<>();
		hand1.add(new Card("Ace", 14, "Hearts"));
		hand1.add(new Card("Ace", 14, "Spades"));
		hand1.add(new Card("Ace", 14, "Clubs"));
		hand1.add(new Card("10", 10, "Clubs"));
		hand1.add(new Card("Jack", 11, "Clubs"));
		Hand hand = new Hand();
		hand.setHand(hand1);

		List<IRankRule> rules = (List<IRankRule>) rulesExecutor.getRuleSetObjects();
		rules = rulesExecutor.chain(rules);
		
		IRankRule rule = rules.get(0).check(hand1);

		Boolean expected = true;
		Boolean actual = rule.getClass() == ThreeKind.class;
		Assertions.assertEquals(expected, actual);

	}

}