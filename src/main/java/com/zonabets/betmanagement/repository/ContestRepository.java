package com.zonabets.betmanagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zonabets.betmanagement.model.Contest;

@Repository
public interface ContestRepository extends CrudRepository<Contest, Long> {
}
