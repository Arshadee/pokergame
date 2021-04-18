package io.poker.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.poker.models.Card;

public class Deck {

	private enum CardSuiteEnum {
		CLUBS, SPADES, HEARTS, DIAMONDS,
	}

	private enum CardRankNameEnum {
		Ace, King, Queen, Jack, _10, _9, _8, _7, _6, _5, _4, _3, _2,
	}

	private Map<String, Integer> rankSuiteMap;// = new HashMap<>();
	
	Map<String,String> symbolsMap;

	public Deck() {
		rankSuiteMap = getRankSuiteMap();
		symbolsMap = getSymbols();
	}

	public List<Card> create() {
		/*
		 * A=14 || 1, K=13, Q=12, J=11
		 */
		List<Card> cards = new ArrayList<>();
		
		for (CardSuiteEnum cardSuit : CardSuiteEnum.values()) { 
		    for (CardRankNameEnum cardRankName : CardRankNameEnum.values()) { 
		    	String suite = cardSuit.toString();
		    	String rank = cardRankName.toString();
		    	Integer rankValue = rankSuiteMap.get(rank);
		    	String symbol = symbolsMap.get(suite);
		    	cards.add(new Card(rank, rankValue,suite, symbol));
			}
		}
		
		return cards;
	}
	
	//
	
	private Map<String, Integer> getRankSuiteMap(){
		Map<String, Integer> rankSuiteMap = new HashMap<>();
		int rank = 14;
		for (CardRankNameEnum cardRankName : CardRankNameEnum.values()) {
			rankSuiteMap.put(cardRankName.toString(), rank);	
			rank--;
		}
		return rankSuiteMap;
	}
	
	private Map<String,String> getSymbols(){
		/*
		 * SPADE : "\u2660"
		 * DIAMOND : "\u2666"
		 * CLUB : "\u2663"
		 * HEART : "\u2764"
		 */
		Map<String,String> symbolsMap = new HashMap<>();
		symbolsMap.put(CardSuiteEnum.SPADES.toString(), "\u2660");
		symbolsMap.put(CardSuiteEnum.CLUBS.toString(), "\u2663");
		symbolsMap.put(CardSuiteEnum.HEARTS.toString(), "\u2764");
		symbolsMap.put(CardSuiteEnum.DIAMONDS.toString(), "\u2666");
	    return symbolsMap;
	}
}
