package io.poker.game.fivecards.functions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

import io.poker.core.IFunctions;
import io.poker.models.Card;

@Component
public class Functions implements IFunctions {

	private static Integer HAND_SIZE = 5;
	//private static Integer START_INDEX = 0;

	public Functions() {
	}

	public List<Card> shuffle(List<Card> cards) throws Exception {
		List<Card> shuffledCards = new ArrayList<>();

		List<Integer> integers = IntStream.range(0, 52) // <-- creates a stream of ints
				.boxed() // <-- converts them to Integers
				.collect(Collectors.toList()); // <-- collects the values to a list

		Collections.shuffle(integers);

		for (Integer i : integers) {
			shuffledCards.add(cards.get(i));
		}

		Set<Card> unique = new HashSet<>(cards);
		if (unique.size() != shuffledCards.size())
			throw new Exception("duplicates in deck");
		return shuffledCards;

	}

	public List<Card> dealHand(List<Card> shuffledCards) {
		List<Card> hand = new ArrayList<>();
		for (int i = 0; i < HAND_SIZE; i++) {
			hand.add(shuffledCards.get(i));
		}
		return hand;
	}

}
