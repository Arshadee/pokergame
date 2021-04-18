package io.poker.app;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import io.poker.config.AppConfig;
import io.poker.controllers.PokerGameController;


public class FiveCardDrawApp {

	public static void main(String[] args) throws Exception {

		String play = "c";
		
		@SuppressWarnings("resource")
		ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);
		PokerGameController controller = factory.getBean(PokerGameController.class);
		String gameId = controller.getGenGameId();
		controller.getShuffledCards(gameId);
		
		while (
				(!controller.isGameOver(gameId)) &&
			    (play.toLowerCase().equals("c")) 
			   ){
			System.out.println();
			System.out.println("*** Poker 5 Card Deal Evaluation ***");
			controller.play(gameId);
			System.out.println("Cards left : "+controller.getNumberOfCardsInPlay(gameId));
			System.out.println("--------");
			System.out.println("To try another hand press 'c' or any other key to quit");
			@SuppressWarnings("resource")
			Scanner in = new Scanner(System.in);
			play = in.nextLine();
			if(controller.isGameOver(gameId) ||
			   !play.toLowerCase().equals("c")){
				System.out.println("Game Over");
				
			}
		}

	}
}
