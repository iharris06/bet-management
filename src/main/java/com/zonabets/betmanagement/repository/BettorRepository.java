package com.zonabets.betmanagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zonabets.betmanagement.model.Bettor;

@Repository
public interface BettorRepository extends CrudRepository<Bettor, Long> {

}
