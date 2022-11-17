package com.blackjackproject.players;

import com.blackjackproject.BlackJackGame;
import com.blackjackproject.cards.BlackJackHand;
import com.blackjackproject.cards.Card;
import com.blackjackproject.cards.Rank;
import com.blackjackproject.cards.Suit;
import com.blackjackproject.gui.BlackJackGUILogic;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    private Card sevenDiamonds;
    private Card eightDiamonds;
    private Player testPlayer;

    @Before
    public void setUp() throws Exception {
        sevenDiamonds = new Card(Rank.SEVEN, Suit.Diamond);
        eightDiamonds = new Card(Rank.EIGHT, Suit.Diamond);
        testPlayer = new Player();
    }

    @Test
    public void receiveCard() {
        testPlayer.receiveCard(sevenDiamonds);
        assertEquals(1,
                testPlayer.getPlayerHand().getCards().size());
    }

    @Test
    public void getHandValue() {
        testPlayer.receiveCard(sevenDiamonds);
        testPlayer.receiveCard(eightDiamonds);
        assertEquals(15, testPlayer.getPlayerHand().findHandValue());
    }

    @Test
    public void clearPlayerHand() {
        testPlayer.receiveCard(sevenDiamonds);
        testPlayer.receiveCard(eightDiamonds);
        testPlayer.clearPlayerHand();
        assertEquals(0,testPlayer.getPlayerHand().findHandValue());
    }

    @Test
    public void test_bust_condition() {
        testPlayer.receiveCard(sevenDiamonds);
        testPlayer.receiveCard(sevenDiamonds);
        testPlayer.receiveCard(sevenDiamonds);
        testPlayer.receiveCard(sevenDiamonds);
        Dealer dealer = new Dealer();
        BlackJackGUILogic bj = new BlackJackGUILogic();
        assertTrue(bj.testBustCondition());
    }
}