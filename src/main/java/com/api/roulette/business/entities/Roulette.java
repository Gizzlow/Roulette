package com.api.roulette.business.entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("Roulette")
public class Roulette {

	private Long id;

	private boolean state;

	private List<Bet> bets;

	private Long winningNumber;

	public Roulette() {
		this.bets = new ArrayList<Bet>();
	}

	public Roulette(Long id, boolean state) {
		this.state = state;
	}

	public void addBet(Bet bet) {
		this.bets.add(bet);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean getState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public List<Bet> getBets() {
		return bets;
	}

	public void setBets(List<Bet> bets) {
		this.bets = bets;
	}

	public Long getWinningNumber() {
		return winningNumber;
	}

	public void setWinningNumber(Long winningNumber) {
		this.winningNumber = winningNumber;
	}

}
