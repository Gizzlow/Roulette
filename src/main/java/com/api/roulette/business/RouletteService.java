package com.api.roulette.business;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.roulette.business.entities.Bet;
import com.api.roulette.business.entities.Roulette;
import com.api.roulette.dto.BetDTO;
import com.api.roulette.dto.RouletteDTO;
import com.api.roulette.infrastructure.RouletteRepo;
import com.api.roulette.util.Constants;

@Service
public class RouletteService {

	@Autowired
	RouletteRepo rouletteRepo;

	@Autowired
	HttpServletRequest requestUrl;

	ModelMapper mapper = new ModelMapper();

	public Long createRoulette() {
		Roulette roulette = new Roulette();
		Roulette response = rouletteRepo.save(roulette);

		return response.getId();
	}

	public boolean openRoulette(Long id) {
		Optional<Roulette> roulette = rouletteRepo.findById(id);
		if (roulette.isPresent()) {
			Roulette response = roulette.get();
			if (response.getState()) {

				return false;
			}
			response.setState(true);
			response.setBets(new ArrayList<Bet>());
			rouletteRepo.save(response);

			return true;
		}

		return false;
	}

	public String doBetRoulette(BetDTO request) {

		request.setIdUser(requestUrl.getHeader("user"));

		if (!validateRequest(request)) {

			return Constants.MESSAGE_DO_BE_ROULETTE_WRONG;
		}
		if (request.getNumber() != null && !validateNumber(request)) {

			return Constants.MESSAGE_DO_BE_ROULETTE_INVALID_NUMBER;
		}
		if (request.getColor() != null && !validateColor(request)) {

			return Constants.MESSAGE_DO_BE_ROULETTE_INVALID_COLOR;
		}
		Bet bet = new Bet(request.getIdRoulette(), request.getIdUser(), request.getNumber(), request.getColor(),
				request.getBet());
		Optional<Roulette> roulette = rouletteRepo.findById(request.getIdRoulette());
		if (roulette.isPresent()) {
			Roulette response = roulette.get();
			response.addBet(bet);
			rouletteRepo.save(response);
		}

		return Constants.MESSAGE_DO_BE_ROULETTE_SUCCESSFUL;
	}

	private boolean validateRequest(BetDTO request) {
		if ((request.getNumber() != null && request.getColor() != null)
				|| (request.getNumber() == null && request.getColor() == null)
				|| request.getBet() > Constants.RULE_ROULETTE_MONEY_CAP) {

			return false;
		}

		return true;
	}

	private boolean validateNumber(BetDTO request) {
		if (request.getNumber() >= Constants.RULE_ROULETTE_STARTING_NUMBER
				&& request.getNumber() <= Constants.RULE_ROULETTE_FINAL_NUMBER) {

			return true;
		}

		return false;
	}

	private boolean validateColor(BetDTO request) {
		if (request.getColor().equals(Constants.RULE_ROULETTE_COLOR_BLACK)
				|| request.getColor().equals(Constants.RULE_ROULETTE_COLOR_RED)) {

			return true;
		}

		return false;
	}

	public RouletteDTO closeRoulette(Long idRoulette) {
		Optional<Roulette> rouletteEntity = rouletteRepo.findById(idRoulette);
		Roulette roulette = new Roulette();
		if (rouletteEntity.isPresent() && rouletteEntity.get().getState()) {
			roulette = winnerRoulette(rouletteEntity.get());
			roulette.setState(false);
			rouletteRepo.save(roulette);
		}
		RouletteDTO response = mapper.map(roulette, RouletteDTO.class);

		return response;
	}

	private Roulette winnerRoulette(Roulette roulette) {
		Long winningNumber = randomNumber();
		roulette.setWinningNumber(winningNumber);
		for (Bet bet : roulette.getBets()) {
			if (bet.getColor() != null) {
				if (winningNumber % 2 == 0 && bet.getColor().equals(Constants.RULE_ROULETTE_COLOR_RED)) {
					bet.setGain(bet.getBet() * 1.8);
				} else if (winningNumber % 2 != 0 && bet.getColor().equals(Constants.RULE_ROULETTE_COLOR_BLACK)) {
					bet.setGain(bet.getBet() * 1.8);
				}
			} else if (bet.getNumber() != null) {
				if (winningNumber.equals(bet.getNumber())) {
					bet.setGain(bet.getBet() * 5);
				}
			}
		}

		return roulette;
	}

	private Long randomNumber() {

		return (long) (Math.random() * 37);
	}

	public List<RouletteDTO> getAllRoulette() {
		List<Roulette> roulettes = (List<Roulette>) rouletteRepo.findAll();
		Type type = new TypeToken<List<RouletteDTO>>() {
		}.getType();
		List<RouletteDTO> response = mapper.map(roulettes, type);

		return response;
	}

}
