package io.poker.core;

import java.util.List;

import io.poker.models.Card;

/**
 * Basic Interface for the Shuffle functionality to be used for any shuffle implementation
 * this decouples the shuffling functionality from the rest of the solution and ensures
 * that any new shuffleing implementation would be stateless and thus allowing it
 * to be exposed as a REST API for future design.
 * 
 * @author arshadmayet
 *
 */
public interface IShuffle {

	public List<Card> shuffle(String gameId, List<Card> cards) throws Exception;
}
