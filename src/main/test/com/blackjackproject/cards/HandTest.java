package com.blackjackproject.cards;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HandTest {
    private Card sixHearts;
    private BlackJackHand hand;

    @Before
    public void setUp() throws Exception {
        sixHearts = new Card(Rank.SIX, Suit.Hearts);
        hand = new BlackJackHand();
    }

    @Test
    public void test_add_card() {
        hand.addCard(sixHearts);
        assertEquals(1,hand.getCards().size());

    }

    @Test
    public void test_find_hand_value() {
        hand.addCard(sixHearts);
        assertEquals(6, hand.findHandValue());

    }
}
