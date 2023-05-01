package com.zonabets.betmanagement.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zonabets.betmanagement.model.Bettor;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/bettor")
public class BettorController {

    @GetMapping("/{id}")
    public ResponseEntity<Bettor> getBettor(@PathVariable Long id) {
        return new ResponseEntity<Bettor>(HttpStatus.OK);
    }
}
