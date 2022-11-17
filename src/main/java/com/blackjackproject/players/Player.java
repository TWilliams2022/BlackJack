package com.blackjackproject.players;

import com.blackjackproject.cards.BlackJackHand;
import com.blackjackproject.cards.Card;

public class Player {


    // Player Fields
    private final BlackJackHand playerHand;


    // Player Constructor
    public Player() {
        playerHand = new BlackJackHand();  // Creates new blackjack hand attached to player
    }


    // Player Business Methods

    public void receiveCard(Card c){        // add card to PLayer Hand
        playerHand.addCard(c);
    }

    public BlackJackHand getPlayerHand() {  // returns the players whole hand
        return playerHand;
    }

    public int getHandValue(){              // Calculate player hand value
        return playerHand.findHandValue();
    }

    public void clearPlayerHand(){          // Clear player hand
        playerHand.clear();
    }

    public void displayPlayerCards() {      // Display all cards in player hand by rank and suit
        playerHand.displayCards();
    }

    public int playerHandCount(){

        return playerHand.getCards().size();
    }

}

