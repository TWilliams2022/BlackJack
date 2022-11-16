package TestCondition;

import com.blackjackproject.cards.Card;
import com.blackjackproject.cards.Rank;
import com.blackjackproject.cards.Suit;
import com.blackjackproject.players.Dealer;
import com.blackjackproject.players.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestCondition {

    private Card sevenDiamonds;
    private Card eightDiamonds;
    private Card twoDiamonds;
    private Card kingDiamonds;
    private Card queenDiamonds;
    private Card nineDiamonds;


    private Player player1;
    private Dealer dealer1;

    @Before
    public void setUp() throws Exception {
        twoDiamonds = new Card(Rank.TWO, Suit.Diamond);
        queenDiamonds = new Card(Rank.QUEEN, Suit.Diamond);
        kingDiamonds = new Card(Rank.KING, Suit.Diamond);
        sevenDiamonds = new Card(Rank.SEVEN, Suit.Diamond);
        eightDiamonds = new Card(Rank.EIGHT, Suit.Diamond);
        nineDiamonds = new Card(Rank.NINE, Suit.Diamond);
        player1 = new Player();
        dealer1 = new Dealer();
    }

    @Test
    public void playerBustCondition() {

        player1.receiveCard(kingDiamonds);
        player1.receiveCard(queenDiamonds);
        player1.receiveCard(twoDiamonds);
        dealer1.addACard(kingDiamonds);
        dealer1.addACard(nineDiamonds);
        dealer1.addACard(twoDiamonds);
        assertTrue("Player Bust: 22 or more!", player1.getPlayerHand().findHandValue() > dealer1.getDealerHand().findHandValue());
    }

    @Test
    public void dealerBustCondition() {

        dealer1.addACard(kingDiamonds);
        dealer1.addACard(queenDiamonds);
        dealer1.addACard(twoDiamonds);
        player1.receiveCard(kingDiamonds);
        player1.receiveCard(nineDiamonds);
        player1.receiveCard(twoDiamonds);
        assertTrue("Dealer Bust: 22 or more!", player1.getPlayerHand().findHandValue() < dealer1.getDealerHand().findHandValue());
    }

    @Test
    public void playerWinCondition() {
        player1.receiveCard(queenDiamonds);
        player1.receiveCard(nineDiamonds);
        dealer1.addACard(queenDiamonds);
        dealer1.addACard(twoDiamonds);
        assertTrue("player wins",player1.getPlayerHand().findHandValue() >= dealer1.getDealerHand().findHandValue());
    }
    @Test
    public void dealerWinCondition() {
        dealer1.addACard(nineDiamonds);
        dealer1.addACard(queenDiamonds);
        dealer1.addACard(twoDiamonds);
        player1.receiveCard(queenDiamonds);
        player1.receiveCard(nineDiamonds);
        assertTrue("Dealer wins",dealer1.getDealerHand().findHandValue() >= player1.getPlayerHand().findHandValue());
    }
}
