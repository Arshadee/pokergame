package io.poker.game.fivecards.functions;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.poker.core.IFunctions;
import io.poker.models.Card;

public class FunctionsTest {

	
	@Test
	void testshuffle() throws Exception {
		IFunctions functions = new Functions();
		List<Card> cards = functions.createDeck();
		List<Card> shuffled = functions.createDeck();
		Assertions.assertEquals(cards, shuffled);
		shuffled = functions.shuffle(cards);
		Assertions.assertNotEquals(cards, shuffled);
	}
	
	@Test
	void testdealHand() throws Exception {
		IFunctions functions = new Functions();
		List<Card> cards = functions.createDeck();
		List<Card> shuffled = functions.shuffle(cards);
		List<Card> hand1 = functions.dealHand(shuffled);
		shuffled = functions.shuffle(cards);
		List<Card> hand2 = functions.dealHand(shuffled);
		Assertions.assertNotEquals(hand1, hand2);		
	}
	

}
