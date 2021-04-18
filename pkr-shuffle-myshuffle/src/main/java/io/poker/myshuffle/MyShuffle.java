package io.poker.myshuffle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

import io.poker.core.IShuffle;
import io.poker.models.Card;
import io.poker.models.GameStore;

/**
 * This is my basic implementation for deck shuffle functionality
 * which is decoupled from the solution and therefore easily interchangeable
 * with another deck shuffle implementation using my inteface
 * 
 * @author arshadmayet
 *
 */
@Component("MyShuffle")
public class MyShuffle implements IShuffle{

	@Override
	public List<Card> shuffle(String gameId, List<Card> cards) throws Exception {
		List<Card> shuffledCards = new ArrayList<>();

		List<Integer> integers = IntStream.range(0, 52) // <-- creates a stream of ints
				.boxed() // <-- converts them to Integers
				.collect(Collectors.toList()); // <-- collects the values to a list

		for(int i =0; i<3;i++) Collections.shuffle(integers);


		for (Integer i : integers) {
			shuffledCards.add(cards.get(i));
		}

		Set<Card> unique = new HashSet<>(cards);
		if (unique.size() != shuffledCards.size())
			throw new Exception("duplicates in deck");
		
		GameStore.pokerGame.put(gameId, shuffledCards);
		return GameStore.pokerGame.get(gameId);
	}

}
