package com.zonabets.betmanagement;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.zonabets.betmanagement.model.Bettor;

public class BettorRepositoryTest {

    private double expectedBank = 25.00;

    @Test
    public void testDefaultValuesSet() {
        Bettor bettor = new Bettor();

        assertEquals(expectedBank, bettor.getBank());
    }
}
