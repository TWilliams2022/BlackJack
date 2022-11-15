package com.blackjackproject;

import com.blackjackproject.cards.Card;
import com.blackjackproject.cards.Rank;
import com.blackjackproject.cards.Suit;
import com.blackjackproject.players.Dealer;
import com.blackjackproject.players.Player;

public class BlackJackLogic {



    public void clearBothHandsAndDeal(Dealer dealer, Player player){
        dealer.clearHand();
        player.clearPlayerHand();

        player.receiveCard(dealer.dealACard());
        player.receiveCard(dealer.dealACard());

        dealer.addACard(dealer.dealACard());
        dealer.addACard(new Card(Rank.valueOf("0"), Suit.valueOf("")));



    }
}
