package com.zonabets.betmanagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zonabets.betmanagement.model.Bet;

@Repository
public interface BetRepository extends CrudRepository<Bet, Long> {
}
