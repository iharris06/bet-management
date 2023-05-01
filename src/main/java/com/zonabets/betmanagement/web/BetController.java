package com.zonabets.betmanagement.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zonabets.betmanagement.model.Bet;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/bet")
public class BetController {

    @GetMapping("/{id}")
    public ResponseEntity<Bet> getBet(@PathVariable Long id) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}   
