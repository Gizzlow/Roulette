package com.api.roulette.apicontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.roulette.business.RouletteService;
import com.api.roulette.dto.BetDTO;
import com.api.roulette.dto.RouletteDTO;
import com.api.roulette.util.Constants;
import com.api.roulette.util.Validators;

@RestController
public class RouletteRestController {
	@Autowired
	RouletteService rouletteService;

	@PostMapping(Constants.CREATE_ROULETTE)
	public Long createRoulette() {

		return rouletteService.createRoulette();
	}

	@GetMapping(Constants.OPEN_ROULETTE)
	public boolean openRoulette(@PathVariable("id") Long idRoulette) {

		return rouletteService.openRoulette(idRoulette);
	}

	@PostMapping(Constants.DO_BET_ROULETTE)
	public String doBetRoulette(@RequestBody BetDTO request) {
		if (Validators.validateDoBetRoulette(request)) {

			return rouletteService.doBetRoulette(request);
		}

		return Constants.MESSAGE_DO_BE_ROULETTE_WRONG;
	}

	@GetMapping(Constants.CLOSE_ROULETTE)
	public RouletteDTO closeRoulette(@PathVariable("id") Long idRoulette) {

		return rouletteService.closeRoulette(idRoulette);
	}

	@GetMapping(Constants.GET_ALL_ROULETTE)
	public List<RouletteDTO> getAllRoulette() {

		return rouletteService.getAllRoulette();
	}

}
