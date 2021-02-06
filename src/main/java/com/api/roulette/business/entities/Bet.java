package com.api.roulette.business.entities;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("Bet")
public class Bet {

	private Long id;

	private Long idRoulette;

	private String idUser;

	private Long number;

	private String color;

	private Long bet;

	private double gain;

	public Bet() {
	}

	public Bet(Long idRoulette, String idUser, Long number, String color, Long bet) {
		this.idRoulette = idRoulette;
		this.idUser = idUser;
		this.number = number;
		this.color = color;
		this.bet = bet;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdRoulette() {
		return idRoulette;
	}

	public void setIdRoulette(Long idRoulette) {
		this.idRoulette = idRoulette;
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Long getBet() {
		return bet;
	}

	public void setBet(Long bet) {
		this.bet = bet;
	}

	public double getGain() {
		return gain;
	}

	public void setGain(double gain) {
		this.gain = gain;
	}

}
