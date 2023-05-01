package com.zonabets.betmanagement.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zonabets.betmanagement.model.Contest;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/contest")
public class ContestController {

    @GetMapping("/{id}")
    public ResponseEntity<Contest> getContest(@PathVariable Long id){
        return new ResponseEntity<Contest>(HttpStatus.OK);
    }

}
