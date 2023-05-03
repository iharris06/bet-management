package com.zonabets.betmanagement.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zonabets.betmanagement.model.Bet;
import com.zonabets.betmanagement.service.BetService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/bet")
public class BetController {

    private BetService betService;

    @GetMapping("/bettor/{bettorId}/contest/{contestId}")
    public ResponseEntity<Bet> getBet(@PathVariable Long bettorId, @PathVariable Long contestId) {
        return new ResponseEntity<>(betService.getBet(bettorId, contestId), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Bet>> getBets() {
        return new ResponseEntity<>(betService.getBets(), HttpStatus.OK);
    }

    @GetMapping("/bettor/{id}")
    public ResponseEntity<List<Bet>> getBetsByBettorId(@PathVariable Long id) {
        return new ResponseEntity<>(betService.getBettorBets(id), HttpStatus.OK);
    }

    @GetMapping("/contest/{id}")
    public ResponseEntity<List<Bet>> getBetsByContestId(@PathVariable Long id) {
        return new ResponseEntity<>(betService.getContestBets(id), HttpStatus.OK);
    }

    @PostMapping("/bettor/{bettorId}/contest/{contestId}")
    public ResponseEntity<Bet> createBet(@RequestBody Bet bet, @PathVariable Long bettorId,
            @PathVariable Long contestId) {
        return new ResponseEntity<>(betService.saveBet(bettorId, contestId, bet), HttpStatus.CREATED);
    }

    @PutMapping("/bettor/{bettorId}/contest/{contestId}")
    public ResponseEntity<Bet> updateBet(@RequestBody Bet bet, @PathVariable Long bettorId,
            @PathVariable Long contestId) {
        return new ResponseEntity<>(betService.updateBet(bettorId, contestId, bet.getAmount()), HttpStatus.OK);
    }

    @DeleteMapping("/bettor/{bettorId}/contest/{contestId}")
    public ResponseEntity<Void> deleteBet(@PathVariable Long bettorId,
            @PathVariable Long contestId) {
        betService.deleteBet(bettorId, contestId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
