package com.zonabets.betmanagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zonabets.betmanagement.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}