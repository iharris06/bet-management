package com.zonabets.betmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zonabets.betmanagement.exception.EntityNotFoundException;
import com.zonabets.betmanagement.model.Bet;
import com.zonabets.betmanagement.model.Bettor;
import com.zonabets.betmanagement.model.Contest;
import com.zonabets.betmanagement.repository.BetRepository;
import com.zonabets.betmanagement.repository.BettorRepository;
import com.zonabets.betmanagement.repository.ContestRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BetServiceDefault implements BetService {

    private BetRepository betRepository;
    private ContestRepository contestRepository;
    private BettorRepository bettorRepository;

    @Override
    public Bet saveBet(Long bettorId, Long contestId, Bet bet) {
        Contest contest = ContestServiceDefault.unwrapContest(contestRepository.findById(contestId), contestId);
        Bettor bettor = BettorServiceDefault.unwrapBettor(bettorRepository.findById(bettorId), bettorId);
        bet.setContest(contest);
        bet.setBettor(bettor);
        return betRepository.save(bet);
    }

    @Override
    public void deleteBet(Long bettorId, Long contestId) {
        betRepository.deleteByBettorIdAndContestId(bettorId, contestId);
    }

    @Override
    public Bet getBet(Long bettorId, Long contestId) {
        return unwrapBet(betRepository.findByBettorIdAndContestId(bettorId, contestId), bettorId, contestId);
    }

    @Override
    public List<Bet> getBets() {
        return (List<Bet>) betRepository.findAll();
    }

    @Override
    public List<Bet> getBettorBets(Long id) {
        return betRepository.findByBettorId(id);
    }

    @Override
    public List<Bet> getContestBets(Long id) {
        return betRepository.findByContestId(id);
    }

    @Override
    public Bet updateBet(Long bettorId, Long contestId, double amount) {
        Bet bet = unwrapBet(betRepository.findByBettorIdAndContestId(bettorId, contestId), bettorId, contestId);
        bet.setAmount(amount);
        return betRepository.save(bet);
    }

    static Bet unwrapBet(Optional<Bet> bet, Long bettorId, Long contestId) {
        if (bet.isPresent())
            return bet.get();
        else
            throw new EntityNotFoundException(bettorId, contestId, Bettor.class);
    }

}
