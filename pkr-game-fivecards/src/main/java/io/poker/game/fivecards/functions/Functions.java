package io.poker.game.fivecards.functions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import io.poker.core.IFunctions;
import io.poker.core.IShuffle;
import io.poker.models.Card;
import io.poker.models.GameStore;

/**
 * This is class houses the functions required for the 5 cards game 
 * which is decoupled from the solution and therefore easily interchangeable
 * with another game (with different) implementation using my inteface.
 * 
 * This class is stateless
 * 
 * @author arshadmayet
 *
 */
@Component
public class Functions implements IFunctions {

	private static Integer HAND_SIZE = 5;
	
	@Autowired
	@Qualifier("MyShuffle")
	private IShuffle shuffle;

	public Functions() {

	}

	public List<Card> shuffle(String gameId, List<Card> cards) throws Exception {
		return shuffle.shuffle(gameId, cards);
	}

	public List<Card> dealHand(String gameId) {
		List<Card> hand = new ArrayList<>();
		List<Card> shuffledCards = GameStore.pokerGame.get(gameId);
		
		//logic to seperate cards dealt from the deck of shuffled cards
		List<Card> unPlayedShuffled = shuffledCards.stream()
				.filter(c -> !c.isPlayed())
				.collect(Collectors.toList());
		for (int i = 0; i < HAND_SIZE; i++) {
			Card card = unPlayedShuffled.get(i);
			card.setPlayed(true);
			hand.add(card);
		}
		return hand;
	}
	
	public int getHandSize() {
		return HAND_SIZE;
	}
		
	public List<Card> getDeckforGame(String gameId){
		return GameStore.pokerGame.get(gameId);
	}
	
	public List<Card> getCards(){
		return null;
	}
	
	/**
	 * util method used to generate unique game Id
	 * to store deck state
	 * 
	 * @return
	 */
	public String genGameId() {
		Random random=new Random();
		int rnd = random.nextInt(90) + 10;
	
		Date date = new Date();
		long timeMilli = date.getTime();
		return String.valueOf(timeMilli)+String.valueOf(rnd);
	}
	
	public boolean isGameOver(String gameId) {
		int size = GameStore.pokerGame.get(gameId)
				.stream()
				.filter(c -> !c.isPlayed())
				.collect(Collectors.toList())
				.size();
		
		return size < HAND_SIZE;
	}
	
}
