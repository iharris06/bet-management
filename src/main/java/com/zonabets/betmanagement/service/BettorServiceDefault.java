package com.zonabets.betmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zonabets.betmanagement.exception.EntityNotFoundException;
import com.zonabets.betmanagement.model.Bettor;
import com.zonabets.betmanagement.repository.BettorRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BettorServiceDefault implements BettorService {
    private BettorRepository bettorRepository;

    @Override
    public Bettor createBettor(Bettor bettor) {
        return bettorRepository.save(bettor);
    }

    @Override
    public void deleteBettor(Long id) {
        bettorRepository.deleteById(id);
    }

    @Override
    public Bettor getBettor(Long id) {
        Optional<Bettor> bettor = bettorRepository.findById(id);
        return unwrapBettor(bettor, id);
    }

    // @Override
    // public List<Bettor> getBettorsByContestId(Long contestId) {
    // return bettorRepository.findByContestId(contestId);
    // }

    @Override
    public List<Bettor> getBettors() {
        return (List<Bettor>) bettorRepository.findAll();
    }

    @Override
    public void updateBettor(Long id, Bettor bettor) {
        Bettor bettorToUpdate = getBettor(id);
        bettorToUpdate.setBank(bettor.getBank());
        bettorRepository.save(bettorToUpdate);
    }

    static Bettor unwrapBettor(Optional<Bettor> bettor, Long id) {
        if (bettor.isPresent())
            return bettor.get();
        else
            throw new EntityNotFoundException(id, Bettor.class);

    }

}
