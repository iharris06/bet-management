package com.zonabets.betmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zonabets.betmanagement.exception.EntityNotFoundException;
import com.zonabets.betmanagement.model.Contest;
import com.zonabets.betmanagement.repository.ContestRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ContestServiceDefault implements ContestService {

    private ContestRepository contestRepository;

    @Override
    public Contest createContest(Contest contest) {
        return contestRepository.save(contest);
    }

    @Override
    public void deleteContest(Long id) {
        contestRepository.deleteById(id);

    }

    @Override
    public Contest getContest(Long id) {
        Optional<Contest> contest = contestRepository.findById(id);
        return unwrapContest(contest, id);
    }

    @Override
    public List<Contest> getContests() {
        return (List<Contest>) contestRepository.findAll();
    }

    @Override
    public void updateContest(Contest contest, Long id) {
        // TODO: implement update
    }

    static Contest unwrapContest(Optional<Contest> contest, Long id) {
        if (contest.isPresent())
            return contest.get();
        else
            throw new EntityNotFoundException(id, Contest.class);

    }

}
