package com.zonabets.betmanagement.service;

import java.util.List;

import com.zonabets.betmanagement.model.Contest;

public interface ContestService {
    Contest getContest(Long id);

    List<Contest> getContests();

    Contest createContest(Contest contest);

    void updateContest(Contest contest, Long id);

    void deleteContest(Long id);
}
