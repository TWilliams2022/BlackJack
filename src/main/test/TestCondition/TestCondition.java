package TestCondition;

import com.blackjackproject.cards.Card;
import com.blackjackproject.cards.Rank;
import com.blackjackproject.cards.Suit;
import com.blackjackproject.players.Dealer;
import com.blackjackproject.players.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCondition {

    private Card sevenDiamonds;
    private Card eightDiamonds;
    private Card twoDiamonds;
    private Card kingDiamonds;
    private Card queenDiamonds;
    private Card nineDiamonds;


    private Player player;
    private Dealer dealer;

    @Before
    public void setUp() throws Exception {
        twoDiamonds = new Card(Rank.TWO, Suit.Diamond);
        queenDiamonds = new Card(Rank.QUEEN, Suit.Diamond);
        kingDiamonds = new Card(Rank.KING, Suit.Diamond);
        sevenDiamonds = new Card(Rank.SEVEN, Suit.Diamond);
        eightDiamonds = new Card(Rank.EIGHT, Suit.Diamond);
        nineDiamonds = new Card(Rank.NINE, Suit.Diamond);

        player = new Player();
        dealer = new Dealer();
    }

    @Test
    public void playerBustCondition() {
        player.receiveCard(kingDiamonds);
        player.receiveCard(queenDiamonds);
        player.receiveCard(twoDiamonds);
        assertEquals(22, player.getPlayerHand().findHandValue());
    }

    @Test
    public void dealerBustCondition() {
        dealer.addACard(kingDiamonds);
        dealer.addACard(queenDiamonds);
        dealer.addACard(twoDiamonds);
        assertEquals(22, dealer.getDealerHand().findHandValue());
    }

    @Test
    public void playerWinCondition() {
        player.receiveCard(queenDiamonds);
        player.receiveCard(nineDiamonds);
        player.receiveCard(twoDiamonds);
        assertEquals(21,player.getPlayerHand().findHandValue());
    }
    @Test
    public void dealerWinCondition() {
        dealer.addACard(nineDiamonds);
        dealer.addACard(queenDiamonds);
        dealer.addACard(twoDiamonds);
        assertEquals(21, dealer.getDealerHand().findHandValue());
    }
}
