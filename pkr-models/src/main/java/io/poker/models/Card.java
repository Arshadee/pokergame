package io.poker.models;

import java.io.Serializable;

/**
 * This class is a card model
 * 
 * @author arshad mayet
 * @version 1.0 Aug 2, 2020
 *
 */
public class Card implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String rankName;
	private Integer rankValue;
	private String suite;

	/**   *
	 * 
	 */
	public Card() {}

	public Card(String rankName, Integer rankValue, String suite) {
		this.rankName =  rankName;
		this.rankValue = rankValue;
		this.suite = suite;
	}

	public String getRankName() {
		return rankName;
	}

	public void setRankName(String rankName) {
		this.rankName = rankName;
	}

	public Integer getRankValue() {
		return rankValue;
	}

	public void setRankValue(Integer rankValue) {
		this.rankValue = rankValue;
	}

	public String getSuite() {
		return suite;
	}

	public void setSuite(String suite) {
		this.suite = suite;
	}
	
	//flip = hand has a card with a rank 2
	// to change the value of Ace
	public Integer getRankValue(boolean flip) {
		if(rankName.equals("Ace") && flip) {
		return 1;
		}else {
			return rankValue;
		}
	}

	@Override
	public String toString() {
		return System.lineSeparator()+"Card [rankName=" + rankName + ", suite=" + suite + "] ";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rankName == null) ? 0 : rankName.hashCode());
		result = prime * result + ((rankValue == null) ? 0 : rankValue.hashCode());
		result = prime * result + ((suite == null) ? 0 : suite.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (rankName == null) {
			if (other.rankName != null)
				return false;
		} else if (!rankName.equals(other.rankName))
			return false;
		if (rankValue == null) {
			if (other.rankValue != null)
				return false;
		} else if (!rankValue.equals(other.rankValue))
			return false;
		if (suite == null) {
			if (other.suite != null)
				return false;
		} else if (!suite.equals(other.suite))
			return false;
		return true;
	}

	
	
}
