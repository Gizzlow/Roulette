package com.api.roulette.infrastructure;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.roulette.business.entities.Roulette;

@Repository
public interface RouletteRepo extends CrudRepository<Roulette, Long>, Serializable {

}
