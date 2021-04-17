package io.poker.controllers;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import io.poker.config.AppConfig;
import io.poker.models.Card;



public class PokerGameControllerTest {
	private ApplicationContext factory;

		@Test
		void testshuffle() throws Exception {	
			factory = new AnnotationConfigApplicationContext(AppConfig.class);
			PokerGameController controller = factory.getBean(PokerGameController.class);
			String gameId = controller.getGenGameId();
			controller.getShuffledCards(gameId);
			List<Card> cards = controller.createDeck();
			List<Card> shuffled = controller.createDeck();
			Assertions.assertEquals(cards, shuffled);
			shuffled = controller.getShuffledCards(gameId);
			Assertions.assertNotEquals(cards, shuffled);
		}
		
		@Test
		void testdealHand() throws Exception {
			factory = new AnnotationConfigApplicationContext(AppConfig.class);
			PokerGameController controller = factory.getBean(PokerGameController.class);
			String gameId = controller.getGenGameId();
			List<Card> cards = controller.createDeck();
			List<Card> shuffled = controller.getShuffledCards(gameId);			
			List<Card> hand1 = controller.getHand(gameId);		
			shuffled = controller.getShuffledCards(gameId);	
			List<Card> hand2 = controller.getHand(gameId);
			Assertions.assertNotEquals(hand1, hand2);		
		}
		
		@Test
		void testCardsDealt() throws Exception {
			factory = new AnnotationConfigApplicationContext(AppConfig.class);
			PokerGameController controller = factory.getBean(PokerGameController.class);
			String gameId = controller.getGenGameId();
			List<Card> cards = controller.createDeck();
			List<Card> shuffled = controller.getShuffledCards(gameId);			
			int deckUndealtSize = controller.getNumberOfCardsInPlay(gameId);
			Assertions.assertEquals(52, deckUndealtSize);
			List<Card> hand1 = controller.getHand(gameId);
			deckUndealtSize = controller.getNumberOfCardsInPlay(gameId);
			Assertions.assertEquals(47, deckUndealtSize);		
		}
}
