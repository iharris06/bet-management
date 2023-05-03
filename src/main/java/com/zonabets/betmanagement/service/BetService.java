package com.zonabets.betmanagement.service;

import java.util.List;

import com.zonabets.betmanagement.model.Bet;

public interface BetService {
    Bet getBet(Long bettorId, Long contestId);

    Bet updateBet(Long bettorId, Long contestId, double amount);

    Bet saveBet(Long bettorId, Long contestId, Bet bet);

    void deleteBet(Long bettorId, Long contestId);

    List<Bet> getBets();

    List<Bet> getBettorBets(Long bettorId);

    List<Bet> getContestBets(Long contestId);

}
