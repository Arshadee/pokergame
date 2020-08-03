package io.poker.models;

public class HandRank {
	
	private String handRankName;
	private Integer HandRankValue;
	
	public HandRank(String handRankName, Integer handRankValue) {
		this.handRankName = handRankName;
		this.HandRankValue = handRankValue;
	}

	public String getHandRankName() {
		return handRankName;
	}

	public void setHandRankName(String handRankName) {
		this.handRankName = handRankName;
	}

	public Integer getHandRankValue() {
		return HandRankValue;
	}

	public void setHandRankValue(Integer handRankValue) {
		HandRankValue = handRankValue;
	}

	@Override
	public String toString() {
		return "HandRank [handRankName=" + handRankName + ", HandRankValue=" + HandRankValue + "]";
	}
	
	
	

}
