package com.blackjackproject;

import com.blackjackproject.cards.Card;
import com.blackjackproject.cards.Rank;
import com.blackjackproject.cards.Suit;
import com.blackjackproject.players.Dealer;
import com.blackjackproject.players.Player;

public class BlackJackLogic {



    public static void clearBothHandsAndDeal(Dealer dealer, Player player){
        dealer.clearHand();
        player.clearPlayerHand();

        // Deal player and Dealer cards at the beginning of the game

        player.receiveCard(dealer.dealACard());
        dealer.addACard(dealer.dealACard());
        player.receiveCard(dealer.dealACard());




    }


}
