package com.blackjackproject.players;

import com.blackjackproject.cards.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DealerTest{

private Dealer dealerHand;
private Card eightHearts;

    @Before
    public void setUp() throws Exception {
        dealerHand = new Dealer();
        eightHearts = new Card(Rank.EIGHT, Suit.Hearts);

    }

    @Test
    public void clearDealerCard(){
        dealerHand.clearHand();
        assertEquals(0, dealerHand.showHandValue());
    }

   @Test
    public void checkDealerHandValue(){
    dealerHand.addACard(eightHearts);
    dealerHand.addACard(eightHearts);
    assertEquals(16, dealerHand.showHandValue());
    }

    @Test
    public void addDealerCard(){
        dealerHand.addACard(eightHearts);
        assertEquals(8, dealerHand.showHandValue());
    }

    @Test
    public void DealerCardReceived(){
        //52 cards in a deck
        dealerHand.dealACard();
        dealerHand.dealACard();
        dealerHand.dealACard();
        assertEquals(49, dealerHand.remainingCards());
    }

}