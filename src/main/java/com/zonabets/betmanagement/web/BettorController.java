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

import com.zonabets.betmanagement.model.Bettor;
import com.zonabets.betmanagement.service.BettorService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/bettor")
public class BettorController {

    private BettorService bettorService;

    @GetMapping("/{id}")
    public ResponseEntity<Bettor> getBettor(@PathVariable Long id) {
        return new ResponseEntity<Bettor>(bettorService.getBettor(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Bettor>> getBettors() {
        return new ResponseEntity<List<Bettor>>(bettorService.getBettors(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Bettor> createBettor(@RequestBody Bettor bettor) {
        return new ResponseEntity<Bettor>(bettorService.createBettor(bettor), HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Bettor> updateBettor(@PathVariable Long id, @RequestBody Bettor bettor) {
        bettorService.updateBettor(id, bettor);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Bettor> deleteBettor(Long id) {
        bettorService.deleteBettor(id);
        return new ResponseEntity<Bettor>(HttpStatus.NO_CONTENT);
    }
}
