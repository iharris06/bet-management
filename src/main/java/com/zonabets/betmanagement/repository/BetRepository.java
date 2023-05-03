package com.zonabets.betmanagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zonabets.betmanagement.model.Bet;

@Repository
public interface BetRepository extends CrudRepository<Bet, Long> {
    Optional<Bet> findByBettorIdAndContestId(Long bettorId, Long contestId);

    List<Bet> findByContestId(Long contestId);

    List<Bet> findByBettorId(Long bettorId);

    @Transactional
    void deleteByBettorIdAndContestId(Long bettorId, Long contestId);
}
