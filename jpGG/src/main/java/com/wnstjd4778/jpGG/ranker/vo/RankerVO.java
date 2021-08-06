package com.wnstjd4778.jpGG.ranker.vo;

public class RankerVO implements Comparable<RankerVO>{
	private String summonerName;
	private int leaguePoints;
	private String Rank;
	private int wins;
	private int losses;
	/**
	 * @return the summonerId
	 */
	public String getSummonerName() {
		return summonerName;
	}
	/**
	 * @param summonerId the summonerId to set
	 */
	public void setSummonerName(String summonerName) {
		this.summonerName = summonerName;
	}
	/**
	 * @return the leaguePoints
	 */
	public int getLeaguePoints() {
		return leaguePoints;
	}
	/**
	 * @param leaguePoints the leaguePoints to set
	 */
	public void setLeaguePoints(int leaguePoints) {
		this.leaguePoints = leaguePoints;
	}
	/**
	 * @return the rank
	 */
	public String getRank() {
		return Rank;
	}
	/**
	 * @param rank the rank to set
	 */
	public void setRank(String rank) {
		Rank = rank;
	}
	/**
	 * @return the wins
	 */
	public int getWins() {
		return wins;
	}
	/**
	 * @param wins the wins to set
	 */
	public void setWins(int wins) {
		this.wins = wins;
	}
	/**
	 * @return the losses
	 */
	public int getLosses() {
		return losses;
	}
	/**
	 * @param losses the losses to set
	 */
	public void setLosses(int losses) {
		this.losses = losses;
	}
	public RankerVO(String summonerName, int leaguePoints, String rank, int wins, int losses) {
		super();
		this.summonerName = summonerName;
		this.leaguePoints = leaguePoints;
		Rank = rank;
		this.wins = wins;
		this.losses = losses;
	}
	@Override
	public int compareTo(RankerVO o) {
		if(this.getLeaguePoints() > o.getLeaguePoints()) {
			return -1;
		} else if(this.getLeaguePoints() < o.getLeaguePoints()) {
			return 1;
		} else {
			return 0;
		}
	}
	
}
