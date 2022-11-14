package com.blackjackproject.players;

import com.blackjackproject.cards.BlackJackHand;
import com.blackjackproject.cards.Card;

public class Player {

    private BlackJackHand playerHand;


    public BlackJackHand getPlayerHand() {
        return playerHand;
    }


    public Player() {
        playerHand = new BlackJackHand();
    }


    public void receiveCard(Card c){

        playerHand.addCard(c);
    }

    public int getHandValue(){

        return playerHand.getHandValue();
    }

    public void clearPlayerHand(){

        playerHand.clear();
    }



}

