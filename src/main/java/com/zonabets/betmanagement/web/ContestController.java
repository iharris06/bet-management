package com.zonabets.betmanagement.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.zonabets.betmanagement.model.Contest;
import com.zonabets.betmanagement.service.ContestService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/contest")
public class ContestController {

    private ContestService contestService;

    @GetMapping("/{id}")
    public ResponseEntity<Contest> getContest(@PathVariable Long id) {
        return new ResponseEntity<Contest>(HttpStatus.OK);
    }

    // Endpoint to create a new Contest
    @PostMapping
    public ResponseEntity<Contest> createContest(@RequestBody Contest contest) {
        Contest newContest = contestService.createContest(contest);
        return ResponseEntity.created(UriComponentsBuilder
                .fromPath("/contests/{id}")
                .buildAndExpand(newContest.getId()).toUri())
                .body(newContest);
    }

    // Endpoint to get a specific Contest by ID
    @GetMapping("/all")
    public ResponseEntity<List<Contest>> getContests() {
        return new ResponseEntity<List<Contest>>(contestService.getContests(), HttpStatus.OK);
    }

    // Endpoint to get all Contests
    @GetMapping
    public ResponseEntity<List<Contest>> getAllContests() {
        List<Contest> contests = contestService.getContests();
        return ResponseEntity.ok().body(contests);
    }

    // Endpoint to update an existing Contest
    @PutMapping("/{id}")
    public ResponseEntity<Contest> updateContest(@PathVariable Long id, @RequestBody Contest contest) {
        contestService.updateContest(contest, id);
        return new ResponseEntity<Contest>(HttpStatus.OK);
    }

}
