package io.poker.services;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import io.poker.config.AppConfig;
import io.poker.models.Card;

public class PokerGameServiceTest {
	private ApplicationContext factory;

	@Test
	void testshuffle() throws Exception {	
		factory = new AnnotationConfigApplicationContext(AppConfig.class);
		PokerGameService service = factory.getBean(PokerGameService.class);
		String gameId = service.getGenGameId();
		//controller.getShuffledCards(gameId);
		List<Card> cards = service.createDeck();
		List<Card> shuffled = service.createDeck();
		Assertions.assertEquals(cards, shuffled);
		shuffled = service.getShuffledCards(gameId);
		Assertions.assertNotEquals(cards, shuffled);
	}
	
	@Test
	void testdealHand() throws Exception {
		factory = new AnnotationConfigApplicationContext(AppConfig.class);
		PokerGameService service = factory.getBean(PokerGameService.class);
		String gameId = service.getGenGameId();
		List<Card> cards = service.createDeck();
		List<Card> shuffled = service.getShuffledCards(gameId);			
		List<Card> hand1 = service.getHand(gameId);		
		shuffled = service.getShuffledCards(gameId);	
		List<Card> hand2 = service.getHand(gameId);
		Assertions.assertNotEquals(hand1, hand2);		
	}
	
	@Test
	void testCardsDealt() throws Exception {
		factory = new AnnotationConfigApplicationContext(AppConfig.class);
		PokerGameService service = factory.getBean(PokerGameService.class);
		String gameId = service.getGenGameId();
		List<Card> cards = service.createDeck();
		List<Card> shuffled = service.getShuffledCards(gameId);			
		int deckUndealtSize = service.getNumberOfCardsInPlay(gameId);
		Assertions.assertEquals(52, deckUndealtSize);
		List<Card> hand1 = service.getHand(gameId);
		deckUndealtSize = service.getNumberOfCardsInPlay(gameId);
		Assertions.assertEquals(47, deckUndealtSize);		
	}

}
