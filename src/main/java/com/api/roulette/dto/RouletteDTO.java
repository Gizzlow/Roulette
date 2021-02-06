package com.api.roulette.dto;

import java.util.List;

import com.api.roulette.business.entities.Bet;

public class RouletteDTO {

	private Long id;

	private boolean state;

	private List<Bet> bets;

	private Long winningNumber;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isState() {
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
