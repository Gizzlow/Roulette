package com.api.roulette.util;

import com.api.roulette.dto.BetDTO;

public class Validators {

	public static boolean validateDoBetRoulette(BetDTO request) {
		if (request.getIdRoulette() != null && request.getBet() != null
				&& (request.getNumber() != null || request.getColor() != null)) {

			return true;
		}

		return false;
	}

}
