package io.poker.core;

import java.util.List;

import io.poker.models.Card;
/**
 * Basic RankRule Interface to be implement
 * for each rule for specific poker game implementation
 * 
 * @author arshadmayet
 *
 */
public interface IRankRule {
	
	public IRankRule check(List<Card> hand);
	
	public Integer getRank();
	
	public String getRankName();

	public IRankRule next();
	
	public void setNext(IRankRule next);
	
	public boolean singleCheck(List<Card> hand);

}
