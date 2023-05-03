package com.zonabets.betmanagement.service;

import java.util.List;

import com.zonabets.betmanagement.model.Bettor;

public interface BettorService {
    Bettor getBettor(Long id);

    // List<Bettor> getBettorsByContestId(Long contestId);

    List<Bettor> getBettors();

    void deleteBettor(Long id);

    Bettor createBettor(Bettor bettor);

    void updateBettor(Long id, Bettor bettor);
}
