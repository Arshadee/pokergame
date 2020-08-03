package io.poker.core;

import java.util.ArrayList;
import java.util.List;

import io.poker.models.Card;



public class Deck {
	
	public  List<Card> create(){
		List<Card> deck = new ArrayList<Card>();
		/*
		 * A=14 || 1
		 * K=13
		 * Q=12
		 * J=11
		 */
		deck.addAll(createAces());
		deck.addAll(createKings());
		deck.addAll(createQueens());
		deck.addAll(createJacks());
		deck.addAll(create10s());
		deck.addAll(create9s());
		deck.addAll(create8s());
		deck.addAll(create7s());
		deck.addAll(create6s());
		deck.addAll(create5s());
		deck.addAll(create4s());
		deck.addAll(create3s());
		deck.addAll(create2s());
		
		return deck;
		
	}
	
	private  List<Card> createAces(){
		List<Card> deck = new ArrayList<Card>();
		deck.add(new Card("Ace",14,"Hearts"));
		deck.add(new Card("Ace",14,"Spades"));
		deck.add(new Card("Ace",14,"Diamonds"));
		deck.add(new Card("Ace",14,"Clubs"));
		return deck;
	}
	
	private  List<Card> createKings(){
		List<Card> deck = new ArrayList<Card>();
		deck.add(new Card("King",13,"Hearts"));
		deck.add(new Card("King",13,"Spades"));
		deck.add(new Card("King",13,"Diamonds"));
		deck.add(new Card("King",13,"Clubs"));
		return deck;
	}
	
	private  List<Card> createQueens(){
		List<Card> deck = new ArrayList<Card>();
		deck.add(new Card("Queen",12,"Hearts"));
		deck.add(new Card("Queen",12,"Spades"));
		deck.add(new Card("Queen",12,"Diamonds"));
		deck.add(new Card("Queen",12,"Clubs"));
		return deck;
	}
	
	private  List<Card> createJacks(){
		List<Card> deck = new ArrayList<Card>();
		deck.add(new Card("Jack",11,"Hearts"));
		deck.add(new Card("Jack",11,"Spades"));
		deck.add(new Card("Jack",11,"Diamonds"));
		deck.add(new Card("Jack",11,"Clubs"));
		return deck;
	}
	
	private  List<Card> create10s(){
		List<Card> deck = new ArrayList<Card>();
		deck.add(new Card("10",10,"Hearts"));
		deck.add(new Card("10",10,"Spades"));
		deck.add(new Card("10",10,"Diamonds"));
		deck.add(new Card("10",10,"Clubs"));
		return deck;
	}
	
	private  List<Card> create9s(){
		List<Card> deck = new ArrayList<Card>();
		deck.add(new Card("9",9,"Hearts"));
		deck.add(new Card("9",9,"Spades"));
		deck.add(new Card("9",9,"Diamonds"));
		deck.add(new Card("9",9,"Clubs"));
		return deck;
	}
	
	private  List<Card> create8s(){
		List<Card> deck = new ArrayList<Card>();
		deck.add(new Card("8",8,"Hearts"));
		deck.add(new Card("8",8,"Spades"));
		deck.add(new Card("8",8,"Diamonds"));
		deck.add(new Card("8",8,"Clubs"));
		return deck;
	}
	
	private  List<Card> create7s(){
		List<Card> deck = new ArrayList<Card>();
		deck.add(new Card("7",7,"Hearts"));
		deck.add(new Card("7",7,"Spades"));
		deck.add(new Card("7",7,"Diamonds"));
		deck.add(new Card("7",7,"Clubs"));
		return deck;
	}
	
	private  List<Card> create6s(){
		List<Card> deck = new ArrayList<Card>();
		deck.add(new Card("6",6,"Hearts"));
		deck.add(new Card("6",6,"Spades"));
		deck.add(new Card("6",6,"Diamonds"));
		deck.add(new Card("6",6,"Clubs"));
		return deck;
	}
	
	private  List<Card> create5s(){
		List<Card> deck = new ArrayList<Card>();
		deck.add(new Card("5",5,"Hearts"));
		deck.add(new Card("5",5,"Spades"));
		deck.add(new Card("5",5,"Diamonds"));
		deck.add(new Card("5",5,"Clubs"));
		return deck;
	}
	
	private  List<Card> create4s(){
		List<Card> deck = new ArrayList<Card>();
		deck.add(new Card("4",4,"Hearts"));
		deck.add(new Card("4",4,"Spades"));
		deck.add(new Card("4",4,"Diamonds"));
		deck.add(new Card("4",4,"Clubs"));
		return deck;
	}
	
	private  List<Card> create3s(){
		List<Card> deck = new ArrayList<Card>();
		deck.add(new Card("3",3,"Hearts"));
		deck.add(new Card("3",3,"Spades"));
		deck.add(new Card("3",3,"Diamonds"));
		deck.add(new Card("3",3,"Clubs"));
		return deck;
	}
	
	private  List<Card> create2s(){
		List<Card> deck = new ArrayList<Card>();
		deck.add(new Card("2",2,"Hearts"));
		deck.add(new Card("2",2,"Spades"));
		deck.add(new Card("2",2,"Diamonds"));
		deck.add(new Card("2",2,"Clubs"));
		return deck;
	}

}
