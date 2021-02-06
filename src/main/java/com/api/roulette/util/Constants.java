package com.api.roulette.util;

public class Constants {

	public static final String CREATE_ROULETTE = "/create_roulette";
	public static final String OPEN_ROULETTE = "/open_roulette/{id}";
	public static final String DO_BET_ROULETTE = "/do_bet_roulette";
	public static final String CLOSE_ROULETTE = "/close_roulette/{id}";
	public static final String GET_ALL_ROULETTE = "/get_all_roulette";

	public static final Long RULE_ROULETTE_MONEY_CAP = 10000L;
	public static final String RULE_ROULETTE_COLOR_BLACK = "negro";
	public static final String RULE_ROULETTE_COLOR_RED = "rojo";
	public static final Long RULE_ROULETTE_STARTING_NUMBER = 0L;
	public static final Long RULE_ROULETTE_FINAL_NUMBER = 36L;

	public static final String MESSAGE_DO_BE_ROULETTE_SUCCESSFUL = "Apuesta registrada con exito";
	public static final String MESSAGE_DO_BE_ROULETTE_WRONG = "Apuesta indebida";
	public static final String MESSAGE_DO_BE_ROULETTE_INVALID_NUMBER = "Número de apuesta invalido";
	public static final String MESSAGE_DO_BE_ROULETTE_INVALID_COLOR = "Color de apuesta invalido";
	public static final String MESSAGE_UNEXPECTED_ERROR = "Ha sucedido un error inesperado";

}
