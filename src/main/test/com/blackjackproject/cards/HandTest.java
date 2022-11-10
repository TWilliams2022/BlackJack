package com.blackjackproject.cards;

import org.junit.Test;

import static org.junit.Assert.*;

public class HandTest {
    Card sixHearts = new Card(Rank.SIX, Suit.Hearts);
    Hand hand;

    @Test
    public void test_add_card() {
        hand.addCard(sixHearts);
        System.out.println(hand);
    }

    @Test
    public void test_find_hand_value() {

    }
}