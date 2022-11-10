package com.blackjackproject.cards;

import junit.framework.TestCase;
import org.junit.Test;

public class DeckTest extends TestCase {

    private Deck deck;

    @Override
    public void setUp() throws Exception {
        deck = new Deck();

    }



    @Test
    public void testCheckDeckSize() {

       int fullDeck =  deck.checkDeckSize();
       assertEquals(52, fullDeck);

    }

    @Test
    public void testDeckNotNull(){
        assertNotNull(deck);
    }

    @Test
    public void testDeal() {
        deck.deal();

        assertEquals(51,deck.checkDeckSize());
    }



}