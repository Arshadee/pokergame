package io.poker.core;

import java.util.List;

import io.poker.models.Card;

public interface IRankRule {
	
	public IRankRule check(List<Card> hand);
	
	public Integer getRank();
	
	public String getRankName();

	public IRankRule next();
	
	public void setNext(IRankRule next);
	
	public boolean singleCheck(List<Card> hand);

}
